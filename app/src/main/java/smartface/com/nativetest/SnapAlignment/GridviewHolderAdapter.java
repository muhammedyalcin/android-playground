package smartface.com.nativetest.SnapAlignment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class GridviewHolderAdapter  extends  RecyclerView.Adapter {

    private String[] mDataset;
    private Context parentContext;
    private AppCompatActivity activity;
    private HashMap hashMap = new HashMap();

    int[] fullRowIndexes = new int[]{0,3,6,9,11,16,19};

    final  int TYPE_IMAGE = 1;
    final  int TYPE_STATICVIEW = 5;

    public  class MyViewHolder extends RecyclerView.ViewHolder {
        public View mFrameLayout;

        public MyViewHolder(View v) {
            super(v);
            mFrameLayout = (FrameLayout) v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public GridviewHolderAdapter(String[] myDataset) {
        mDataset = myDataset;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public GridviewHolderAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        parentContext = parent.getContext();
        // create a new view
        FrameLayout frameLayout = new FrameLayout(parentContext);

        MyViewHolder vh = new MyViewHolder(frameLayout);

        switch (viewType){
            case TYPE_STATICVIEW:
                TextView myView = new TextView(parentContext);
                myView.setText("This is Text for implementing static row item");
                myView.setBackgroundColor(Color.GRAY);
                frameLayout.addView(myView , new StaggeredGridLayoutManager.LayoutParams(StaggeredGridLayoutManager.LayoutParams.MATCH_PARENT,250));
                frameLayout.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
//                ((StaggeredGridLayoutManager.LayoutParams) vh.itemView.getLayoutParams()).setFullSpan(true);
                break;

                default:
                    ImageView myImageView = new ImageView(parent.getContext());
                    TextView mIdetifier = new TextView(parentContext);
                    mIdetifier.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,Gravity.CENTER));
                    myImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    myImageView.setLayoutParams( new StaggeredGridLayoutManager.LayoutParams(convertDpToPixel(145),convertDpToPixel(200)));
                    frameLayout.addView(myImageView);
                    frameLayout.addView(mIdetifier);
                    frameLayout.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        }

        hashMap.put(vh.hashCode(),vh);

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder =(MyViewHolder) hashMap.get(holder.hashCode());
        FrameLayout mineRelativeLayout = (FrameLayout)  myViewHolder.mFrameLayout;

        int withd = myViewHolder.itemView.getWidth();

        boolean found = false;
        for (int i  : fullRowIndexes ) {
            if(i == position) {
                StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) myViewHolder.itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.setFullSpan(true);
                    layoutParams.height = 60;
                    myViewHolder.itemView.setBackgroundColor(Color.GRAY);
                }
                found = true;
            }
        }
        if(found == false) {
            ImageView myImageView = (ImageView) mineRelativeLayout.getChildAt(0);
            TextView mIdentifier = (TextView) mineRelativeLayout.getChildAt(1);
            mIdentifier.setText("" + position);
            mineRelativeLayout.setId(position);

            Picasso.get().load(mDataset[position]).fit().centerInside().into(myImageView, new Callback() {
                @Override
                public void onSuccess() {

                }
                @Override
                public void onError(Exception e) {
                    e.printStackTrace();
                }
            });
        }
//        holder.itemView.getLayoutParams().height = 50;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    @Override
    public int getItemViewType(int position) {
        int choosenType = 0;
        for (int i = 0; i < fullRowIndexes.length ; i++) {
            if (fullRowIndexes[i] == position){
                choosenType = TYPE_STATICVIEW;
                break;
            }else {
                choosenType = TYPE_IMAGE;
            }
        }
        return  choosenType;
    }

    public  int convertPixelsToDp(float px){
        return Math.round(px / ((float) parentContext.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    private Drawable resize(Drawable image , int w , int h) {
        Bitmap b = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, w, h, false);
        return new BitmapDrawable(parentContext.getResources(), bitmapResized);
    }

    public  int convertDpToPixel(int dp){
        Resources resources = parentContext.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        int px = Math.round(dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;

    }
}
