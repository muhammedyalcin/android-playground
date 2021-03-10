package smartface.com.nativetest.RecyclerViewSwipe;

import android.content.Context;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.HashMap;

import smartface.com.nativetest.R;
import smartface.com.nativetest.SnapAlignment.GridviewHolderAdapter;

public  class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {

    private String[] mDataset;
    private Context parentContext;
    private HashMap hashMap = new HashMap();

    public HashMap<View, Integer> cacheItemsWithPosition = new HashMap<>();
    HashMap<Integer, Parcelable> scrollPositionMap =  new HashMap<Integer, Parcelable>();
    private String[] mDataset2 = new String[50];
    Parcelable itemParcelable;

    private final int TYPE_IMAGE = 0 ;
    private final int TYPE_CARD= 1 ;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public  class MyViewHolder extends RecyclerView.ViewHolder{
        // each data item is just a string in this case
        public View myCardView;
        public RecyclerView recyclerView;
        public MyViewHolder(View v, RecyclerView recyclerView) {
            super(v);
            this.recyclerView = recyclerView;
            myCardView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        parentContext = parent.getContext();
        // create a new view

//        View myView = null;
//        switch (viewType){
//            case TYPE_IMAGE:
//                RelativeLayout relativeLayout = new RelativeLayout(parentContext);
//                relativeLayout.setLayoutParams( new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 800 ));
//                relativeLayout.setBackgroundColor(Color.GRAY);
//                myView = relativeLayout;
//                break;
//            default:
//                 myView = (CardView)  LayoutInflater.from(parentContext).inflate(R.layout.cardview_test,parent,false);
//                 break;
//        }

        ContextThemeWrapper themeWrapper = new ContextThemeWrapper(parentContext, R.style.ScrollBarRecyclerView);

        SwipeRefreshLayout swipeRefreshLayout = new SwipeRefreshLayout(parentContext);

        RecyclerView mRecyclerView = new RecyclerView(themeWrapper);

        for (int i = 0; i < mDataset2.length; i++) {
            mDataset2[i] = "https://picsum.photos/400/100?image=" + i;
        }

        mRecyclerView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setDrawingCacheEnabled(true);
        mRecyclerView.setClipToPadding(false);


        StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL){
            @Override
            public void onRestoreInstanceState(Parcelable state) {
                super.onRestoreInstanceState(state);
//                StaggeredGridLayoutManager linearLayoutManager = this;
//                int[] positionItem = linearLayoutManager.findFirstVisibleItemPositions(null);
//
//                View viewHolder = linearLayoutManager.findViewByPosition(positionItem[0]);
//                if(viewHolder != null) {
//                    int offsetOfItem = viewHolder.getLeft();
////                    this.scrollToPositionWithOffset(positionItem[0], offsetOfItem);
//                }
//                if(linearLayoutManager.findViewByPosition(positionItem[0] -1) != null){
//                    View viewHolder1 = linearLayoutManager.findViewByPosition(positionItem[0] -1);
//                    boolean prevVisibileItem = linearLayoutManager.isViewPartiallyVisible(viewHolder1, false, false);
//                    if(prevVisibileItem){
//                        int totalSpaceOfItem1 = orientationHelper.getDecoratedMeasurement(viewHolder1);
//                        int offsetOfItem1 = convertPixelsToDp(viewHolder1.getLeft());
//                        int ss = offsetOfItem1;
//                    }
//                }
            }
            @Override
            public Parcelable onSaveInstanceState() {
                Parcelable savedState = super.onSaveInstanceState();
//                StaggeredGridLayoutManager linearLayoutManager = this;
//                int[] positionItem = linearLayoutManager.findFirstVisibleItemPositions(null);
//
//                OrientationHelper orientationHelper = getVerticalHelper(linearLayoutManager);
//                View viewHolder = linearLayoutManager.findViewByPosition(positionItem[0]);
//
//                int totalSpaceOfItem = orientationHelper.getDecoratedMeasurement(viewHolder);
//                int offsetOfItem = convertPixelsToDp(viewHolder.getLeft());
//
//                if(linearLayoutManager.findViewByPosition(positionItem[0] -1) != null){
//                    View viewHolder1 = linearLayoutManager.findViewByPosition(positionItem[0] -1);
//                    boolean prevVisibileItem = linearLayoutManager.isViewPartiallyVisible(viewHolder1, false, false);
//                    if(prevVisibileItem){
//                        int totalSpaceOfItem1 = orientationHelper.getDecoratedMeasurement(viewHolder1);
//                        int offsetOfItem1 = convertPixelsToDp(viewHolder1.getLeft());
//                        int ss = offsetOfItem1;
//                    }
//                }
                return savedState;
            }
        };


        mRecyclerView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_INSET);
        mRecyclerView.setHorizontalScrollBarEnabled(false);
        mRecyclerView.setVerticalScrollBarEnabled(false);

        mRecyclerView.setPaddingRelative(25,0,25,0);
//        Parcelable parcelable = mLayoutManager.onSaveInstanceState();
//        mLayoutManager.onRestoreInstanceState(parcelable);
        mRecyclerView.setLayoutManager(mLayoutManager);

        GridviewHolderAdapter mAdapter = new GridviewHolderAdapter(mDataset2);
//        mAdapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        swipeRefreshLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 250));
        swipeRefreshLayout.addView(mRecyclerView);

        MyViewHolder vh = new MyViewHolder(swipeRefreshLayout, mRecyclerView);

        hashMap.put(vh.hashCode(),vh);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position) {
        RecyclerView item = (RecyclerView) holder.recyclerView;

        if(itemParcelable != null && position == 0)
            ((StaggeredGridLayoutManager) item.getLayoutManager()).onRestoreInstanceState(itemParcelable);

        item.setId(position);

        item.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(position == 0)
                    itemParcelable = item.getLayoutManager().onSaveInstanceState();
                return false;
            }
        });

        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) item.getLayoutManager();
//        item.post(new Runnable() {
//            @Override
//            public void run() {
//                item.scrollTo(550, 200);
//            }
//        });
//        staggeredGridLayoutManager.scrollHorizontallyBy(250, item ,null);
//        item.scrollTo(550, 200);

        if(scrollPositionMap.size() > 0 && scrollPositionMap.containsKey(position)) {
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    item.getLayoutManager().onRestoreInstanceState(scrollPositionMap.get(position));
//                    item.invalidate();
//                }
//            };
//            new Handler().postDelayed(runnable,650);

        }

//        item.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) item.getLayoutManager();
////
////                Parcelable parcelable = staggeredGridLayoutManager.onSaveInstanceState();
//                staggeredGridLayoutManager.scrollToPositionWithOffset(2, -180);
//                return false;
//            }
//        });
//
//            item.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
//                @Override
//                public void onViewAttachedToWindow(View view) {
//
//                }
//                @Override
//                public void onViewDetachedFromWindow(View view) {
//                    item.getLayoutManager().onSaveInstanceState();
////                    final int mPosition = own.getId();
////                    if(scrollPositionMap.containsKey(mPosition)){
////                        scrollPositionMap.replace(mPosition, own.getLayoutManager().onSaveInstanceState());
////                    }else{
////                        scrollPositionMap.put(mPosition, own.getLayoutManager().onSaveInstanceState());
////
//                }
//            });
//        MyViewHolder myViewHolder =(MyViewHolder) hashMap.get(holder.hashCode());
//
//        View myCardView = (View) myViewHolder.myCardView ;
//
//        myCardView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                return false;
//            }
//        });
//
//        if( myCardView.findViewById(R.id.myTextView) != null) {
//            TextView myTextView = (TextView) myCardView.findViewById(R.id.myTextView);
//            myTextView.setText("Swipe Left/Right Index " + position);
//        }
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return 8 ;
    }

    private OrientationHelper getVerticalHelper(@NonNull RecyclerView.LayoutManager layoutManager) {
        return OrientationHelper.createVerticalHelper(layoutManager);
    }


    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    public  int convertPixelsToDp(float px){
        return Math.round(px / parentContext.getResources().getDisplayMetrics().density);
    }
}
