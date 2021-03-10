package smartface.com.nativetest;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import androidx.core.view.ViewCompat;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public class SwitchTest extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.attributedtextest);

        Toast.makeText(this, "onCreate "  + getResources().getConfiguration().getLayoutDirection() , Toast.LENGTH_SHORT).show();

        RelativeLayout rootLayout = (RelativeLayout) findViewById(R.id.myRelativeLayout);

        Switch mySwitch = new Switch(this);

//        mySwitch.getTrackDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
        mySwitch.getTrackDrawable().setAlpha(255);
//        ColorDrawable colorDrawable = new ColorDrawable();
//        colorDrawable.setColor(Color.RED);
//        colorDrawable.setAlpha(50);
//        mySwitch.setTrackDrawable(colorDrawable);

//        mySwitch.getThumbDrawable().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_ATOP);
//
//        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//
//            }
//        });
        rootLayout.addView(mySwitch);

        ImageView imageView = new ImageView(this);

//        TextView badge = new TextView(this);
//        badge.setPaddingRelative(10,2,10,2);
//        GradientDrawable gradientDrawable = new GradientDrawable();
//        gradientDrawable.setStroke(5, Color.RED);
//        gradientDrawable.setColor(Color.RED);
//        badge.setBackground(gradientDrawable);
//
//        badge.setText("5");

//        AutoTransition mSet = new AutoTransition();
//        mSet.setOrdering(TransitionSet.ORDERING_TOGETHER);
//        mSet.setDurationBottomNavigationView
//        (115l);
//        mSet.setInterpolator(new FastOutSlowInInterpolator());
//        mSet.addTransition(new TextScale());



//        FrameLayout textViewTest = findViewById(R.id.animatedFrameLayout);
//
//
//        TransitionManager.beginDelayedTransition(textViewTest, mSet);
//        animateBtn.setOnClickListener((click) -> {
//            TransitionManager.beginDelayedTransition(textViewTest,mSet);
//        });


//        View testView =  findViewById(R.id.myTestView);
//
        BottomNavigationView bottomNavigationView = new BottomNavigationView(new ContextThemeWrapper(this,R.style.Theme_MaterialComponents_Light));
        bottomNavigationView.setBackgroundColor(Color.WHITE);

        Menu menu = bottomNavigationView.getMenu();
        menu.add(0, 0, 0, "TEST1");
        menu.add(0, 1, 0, "TEST2");
        menu.add(0, 2, 0, "TEST3");


        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(1);
        badgeDrawable.setNumber(15);
        badgeDrawable.setBackgroundColor(Color.BLUE);
        badgeDrawable.setBadgeTextColor(Color.RED);
        badgeDrawable.setAlpha(255);
//        badgeDrawable.setBadgeGravity(BadgeDrawable.TOP_START);
//        badgeDrawable.setHorizontalOffset(90);
//        badgeDrawable.setVerticalOffset(70);

        ByteArrayOutputStream byteArrayOutputStream  = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        bottomNavigationView.setItemTextColor(stateList);

//        bottomNavigationView.setLayoutAnimation(null);
//        bottomNavigationView.setSelected(false);
//        bottomNavigationView.setItemIconTintList(null);

//        BottomNavigationMenuView bottomNavigationMenuView =
//                (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
//        View v = bottomNavigationMenuView.getChildAt(0);
//        BottomNavigationItemView itemView = (BottomNavigationItemView) v;

//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                return false;
//            }
//        });


//        AppCompatImageView menuItemView =(AppCompatImageView) itemView.getChildAt(0);
//
//        BaselineLayout baselineLayout =(BaselineLayout) itemView.getChildAt(1);
//
////        itemView.addView(badge, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
////                ViewGroup.LayoutParams.WRAP_CONTENT,  1 | 48));
//
//        mySwitch.getTrackDrawable().setColorFilter(Color.MAGENTA, PorterDuff.Mode.SRC_IN);
//        mySwitch.getTrackDrawable().setAlpha(255);

        rootLayout.addView(bottomNavigationView);

    }

    public static void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //noinspection RestrictedApi
//                item.setShiftingMode(false);
//                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }

    public void inflateNewView() {
        View inflatedLinear = getLayoutInflater().inflate(R.layout.attributedtextest , null);

        setContentView(inflatedLinear);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        boolean isChanged = newConfig.getLayoutDirection() == getResources().getConfiguration().getLayoutDirection();
        Toast.makeText(this, " Configuration is changed  ? === > " + isChanged  , Toast.LENGTH_SHORT).show();
//        if(isChanged){
//            Intent intent = getIntent();
//            finish();
//            startActivity(intent);
//        }
    }


    public class TextScale extends Transition {
        private static final String PROPNAME_SCALE = "android:textscale:scale";

        @Override
        public void captureStartValues(TransitionValues transitionValues) {
            captureValues(transitionValues);
        }

        @Override
        public void captureEndValues(TransitionValues transitionValues) {
            captureValues(transitionValues);
        }

        private void captureValues(TransitionValues transitionValues) {
            if (transitionValues.view instanceof TextView) {
                TextView textview = (TextView) transitionValues.view;
                transitionValues.values.put(PROPNAME_SCALE, textview.getScaleX());
            }
        }

        @Override
        public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues,
                                       TransitionValues endValues) {
            if (startValues == null || endValues == null || !(startValues.view instanceof TextView)
                    || !(endValues.view instanceof TextView)) {
                return null;
            }
            final TextView view = (TextView) endValues.view;
            Map<String, Object> startVals = startValues.values;
            Map<String, Object> endVals = endValues.values;
            final float startSize = startVals.get(PROPNAME_SCALE) != null ? (float) startVals.get(
                    PROPNAME_SCALE) : 1f;
            final float endSize = endVals.get(PROPNAME_SCALE) != null ? (float) endVals.get(
                    PROPNAME_SCALE) : 1f;
            if (startSize == endSize) {
                return null;
            }

            ValueAnimator animator = ValueAnimator.ofFloat(startSize, endSize);

            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedValue = (float) valueAnimator.getAnimatedValue();
                    view.setScaleX(animatedValue);
                    view.setScaleY(animatedValue);
                }
            });
            return animator;
        }
    }
}
