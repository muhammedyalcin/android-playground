package smartface.com.nativetest.RecyclerViewSwipe;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.recyclerview.widget.ItemTouchHelper;

import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import smartface.com.nativetest.R;


public class PicassoTest  extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Dialog dialog;

    private Context cxt;
    String[] myDataset = new String[10];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.picassotest);
        cxt = this;

        RelativeLayout myRelativLayout = (RelativeLayout) findViewById(R.id.myRelativeLayout);

        SwipeRefreshLayout  swipeRefreshLayout = new SwipeRefreshLayout(this){
            @Override
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                onTouchEvent(ev);
                return super.onInterceptTouchEvent(ev);
            }

            @Override
            public boolean onTouchEvent(MotionEvent ev) {
                return super.onTouchEvent(ev);
            }
        };

//        applyRippleEffect(swipeRefreshLayout,true);

        ContextThemeWrapper themeWrapper = new ContextThemeWrapper(this ,R.style.ScrollBarRecyclerView);
        RecyclerView mRecyclerView = new RecyclerView(themeWrapper);

        mRecyclerView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

//        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.setDrawingCacheEnabled(true);
//        mRecyclerView.setItemViewCacheSize(0);
//        mRecyclerView.setClipToPadding(false);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        for(int i=0; i < 10 ; i++){
            myDataset[i] = "https://picsum.photos/300/100/?image=" + i + 10;
        }

//        mAdapter = new MyAdapter(myDataset);

        SwipeHelper swipeHelper =  new SwipeHelper(this , mRecyclerView );

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeHelper);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

        mAdapter = new SimpleAdapter(cxt , myDataset, itemTouchHelper, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);

        swipeHelper.setAdapater(mAdapter);


        swipeRefreshLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        swipeRefreshLayout.addView(mRecyclerView);

        myRelativLayout.addView(swipeRefreshLayout);

        Button btn = new Button(this);
        btn.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        btn.setText("Refresh BTN");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mRecyclerView.setAdapter(new SimpleAdapter( cxt, myDataset ,itemTouchHelper));
               //mAdapter.notifyDataSetChanged();
            }
        });

        myRelativLayout.addView(btn);
    }

    @Override
    protected void onPause() {
        super.onPause();

        dialog = new Dialog(this);
        View view = new View(this);
        view.setBackgroundColor(Color.WHITE);
        dialog.setContentView(view , new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        dialog.show();
    }


    @Override
    protected void onResume() {
        super.onResume();

        if(dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    void applyRippleEffect(View myView, boolean enableForeground){
//        myView.setClickable(true);
//        int[] colors  = new int[] {Color.argb(255,216,216,216)};
//        ColorStateList colorStateList = ColorStateList.valueOf(Color.BLUE);
//        RippleDrawable rippleDrawable = new RippleDrawable(colorStateList,null,null);
//
//        if(!enableForeground)
//            myView.setBackground(rippleDrawable);
//        else
//            myView.setForeground(rippleDrawable);

    }

}
