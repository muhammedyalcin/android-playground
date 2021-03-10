package smartface.com.nativetest;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class SwipeViewTest extends AppCompatActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 10;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;


    Context ctx;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.viewpagerlayout);


        Button btn = findViewById(R.id.btnn);


//        applyRippleEffect(btn, true);

        ctx = this;

        mPager = (ViewPager) findViewById(R.id.pager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.myTablayout);
//        tabLayout.setTabMode(TabLayout.MODE_FIXED);
//        tabLayout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        LinearLayout mTabStrip =(LinearLayout) tabLayout.getChildAt(0);
//        mTabStrip.setGravity(Gravity.RIGHT);
//        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)tabLayout.getLayoutParams();
//        params.resolveLayoutDirection(View.LAYOUT_DIRECTION_RTL);
//        tabLayout.setLayoutParams(params);
//        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());

        mPager.setAdapter(mPagerAdapter);

        tabLayout.setupWithViewPager(mPager);

        tabLayout.getTabAt(0).setText("TEST");

        mPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ctx.getExternalCacheDir().listFiles().length == 0) {
                    File fl = new File(ctx.getExternalCacheDir(), "test.txt");
                    fl.exists();
                }else {
                    for (File file : ctx.getExternalCacheDir().listFiles()) {
                        file.delete();
                    }
                }

            }
        });

        String str = "TEST";
        byte[] strByts1= str.getBytes(StandardCharsets.UTF_8);
        byte[] strByts2= str.getBytes(StandardCharsets.UTF_16);
        byte[] strByts3= str.getBytes(StandardCharsets.US_ASCII);


        Toast.makeText(this, " str utf8 " + strByts1.length + "  str utf16 " + strByts2.length + " ascii " + strByts3.length, Toast.LENGTH_LONG).show();

//        mPager.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

//        mPager.setRotationY(180);

    }

    void applyRippleEffect(View myView, boolean enableForeground){
        myView.setClickable(true);

        int[][] state = new int[][]{
                new int[]{}
//                new int[android.R.attr.state_checked]
        };

        int[] colors  = new int[] {Color.argb(255,216,216,216)};
        ColorStateList colorStateList = new ColorStateList(state,colors);

        Drawable backgroundDrawable = myView.getBackground();

        RippleDrawable rippleDrawable = new RippleDrawable(colorStateList,null,null);

        if(!enableForeground)
            myView.setBackground(rippleDrawable);
        else
            myView.setForeground(rippleDrawable);

    }

    public static StateListDrawable getStateListDrawable(
            int normalColor, int pressedColor) {
        StateListDrawable states = new StateListDrawable();
        states.addState(new int[]{android.R.attr.state_selected},
                new ColorDrawable(pressedColor));
        states.addState(new int[]{},
                new ColorDrawable(normalColor));
        return states;
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            ScreenSlidePageFragment fg = new ScreenSlidePageFragment();
            fg.setText(String.valueOf(position));
            return fg;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return "TEST " + position;
        }
    }
}
