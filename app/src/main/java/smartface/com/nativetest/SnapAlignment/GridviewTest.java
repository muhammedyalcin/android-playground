package smartface.com.nativetest.SnapAlignment;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Arrays;

import smartface.com.nativetest.R;

public class GridviewTest extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private StaggeredGridLayoutManager mLayoutManager;
    static boolean  scrollEnable = false;
    String[] myDataset = new String[50];

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.gridviewtest);


//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);

//        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);

        CoordinatorLayout myRelativLayout = (CoordinatorLayout) findViewById(R.id.page_container);

        SwipeRefreshLayout swipeRefreshLayout = new SwipeRefreshLayout(this);

        ContextThemeWrapper themeWrapper = new ContextThemeWrapper(this ,R.style.ScrollBarRecyclerView);

        final RecyclerView constRecyclerview = mRecyclerView;
        RecyclerView mRecyclerView = new RecyclerView(themeWrapper);

        mRecyclerView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setDrawingCacheEnabled(true);
        mRecyclerView.setClipToPadding(false);

        mLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL){
            @Override
            public void onAttachedToWindow(RecyclerView view) {
                super.onAttachedToWindow(view);
            }
        };

        Parcelable parcelable= mLayoutManager.onSaveInstanceState();
        mLayoutManager.onRestoreInstanceState(parcelable);

        mRecyclerView.setLayoutManager(mLayoutManager);

        for(int i=0; i < myDataset.length ; i++){
            myDataset[i] = "https://picsum.photos/400/100?image=" + i;
        }

        mAdapter = new GridviewHolderAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        swipeRefreshLayout.addView(mRecyclerView);

        myRelativLayout.addView(swipeRefreshLayout);

        Button btn = new Button(this);
        btn.setText("TEST");

        PagerSnapHelper snapHelper = new PagerSnapHelper();

        snapHelper.attachToRecyclerView(mRecyclerView);

        Context ctx = this;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx, "ONCLICK",Toast.LENGTH_SHORT).show();
                snapHelper.attachToRecyclerView(null);
            }
        });

        btn.setLayoutParams(new ViewGroup.LayoutParams(250, 90));

        myRelativLayout.addView(btn);

    }

//    public static Drawable getAdaptiveRippleDrawable(int normalColor, int pressedColor) {
////        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            return new RippleDrawable(ColorStateList.valueOf(pressedColor),
//                    getColorDrawableFromColor(normalColor), null);
////        } else {
////            return getStateListDrawable(normalColor, pressedColor);
////        }
//    }

    public static ColorDrawable getColorDrawableFromColor(int color)
    {
        return new ColorDrawable(color);
    }

    private static Drawable getRippleMask(int color) {
        float[] outerRadii = new float[8];
        // 3 is radius of final ripple,
        // instead of 3 you can give required final radius
        Arrays.fill(outerRadii, 3);

        RoundRectShape r = new RoundRectShape(outerRadii, null, null);
        ShapeDrawable shapeDrawable = new ShapeDrawable(r);
        shapeDrawable.getPaint().setColor(color);
        return shapeDrawable;
    }



    public static StateListDrawable getStateListDrawable(
            int normalColor, int pressedColor) {
        StateListDrawable states = new StateListDrawable();
        states.addState(new int[]{android.R.attr.state_pressed},
                new ColorDrawable(pressedColor));
        states.addState(new int[]{android.R.attr.state_focused},
                new ColorDrawable(pressedColor));
        states.addState(new int[]{android.R.attr.state_activated},
                new ColorDrawable(pressedColor));
        states.addState(new int[]{},
                new ColorDrawable(normalColor));
        return states;
    }
    public static ColorStateList getPressedColorSelector(int normalColor, int pressedColor)
    {
        return new ColorStateList(
                new int[][]
                        {
                                new int[]{android.R.attr.state_pressed},
                                new int[]{android.R.attr.state_focused},
                                new int[]{android.R.attr.state_activated},
                                new int[]{}
                        },
                new int[]
                        {
                                pressedColor,
                                pressedColor,
                                pressedColor,
                                normalColor
                        }
        );
    }


}
