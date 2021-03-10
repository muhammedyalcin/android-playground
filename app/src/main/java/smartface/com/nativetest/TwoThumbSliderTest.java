package smartface.com.nativetest;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.util.Log;
import android.widget.SeekBar;

//import com.google.android.material.slider.Slider;

//import com.appyvet.materialrangebar.RangeBar;Log

import com.smartface.materialrangebar.RangeBar;


/*
Slider with 2 thump;

- thumbColor
- thumbBorderColor
- disabled/enabled slider move
- range enabled for 2 thump
- line width
- thumbRadius
- thumbBorderWidth
- min
- max
- onValueChanged

 */

public class TwoThumbSliderTest extends AppCompatActivity {

    Context parentCxt;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        parentCxt = this;
        LinearLayout linearLayout = new LinearLayout(this);
        setContentView(R.layout.twothumb_slider);


//        MultiSlider multiSlider = new MultiSlider(this);
////        multiSlider.setTrackDrawable(getDrawable(R.drawable.com_mixpanel_android_logo));
//        multiSlider.setMin(0);
//        multiSlider.setMax(100);


//
////        multiSlider.addThumb(1);
//        multiSlider.setDrawThumbsApart(true);// Avoids overlapping the thumbs
//        multiSlider.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
//
//
//        MultiSlider.Thumb thumb = multiSlider.getThumb(0);
//        thumb.setMin(25);
//        thumb.setMax(75);
//
//
//        multiSlider.setOnThumbValueChangeListener(new MultiSlider.OnThumbValueChangeListener() {
//            @Override
//            public void onValueChanged(MultiSlider multiSlider, MultiSlider.Thumb thumb, int thumbIndex, int value) {
//                Toast.makeText(parentCxt, "On Value Changed " + value , Toast.LENGTH_SHORT).show();
//            }
//        });
//        linearLayout.addView(multiSlider);

//        RangeBar rangeBar = new RangeBar(this, null);

        RangeBar rangeBar = new RangeBar(this, null);

        //thumbSize  --> DP!
        rangeBar.setSelectorSize(47);

        //thumbBorderWidth --> DP!
//        rangeBar.setSelectorBoundarySize((int)(8 * getResources().getDisplayMetrics().density));

//        rangeBar.setBarWeight((int)(50 * getResources().getDisplayMetrics().density));

        //thumbBorderColor
        rangeBar.setSelectorBoundaryColor(Color.BLUE);

        rangeBar.setSelectorColor(Color.argb(255,176,176,176));


        SeekBar seekBar = new SeekBar(this);

        int height = seekBar.getThumb().getIntrinsicHeight();
        int width = seekBar.getThumb().getIntrinsicWidth();

//        rangeBar.setBarWeight();

//        rangeBar.setTickInterval();


        //Mix  & Max
        rangeBar.setTickEnd(100);
        rangeBar.setTickStart(30);

        //snapStepSize
        rangeBar.setTickInterval(5);

//        rangeBar.setRangePinsByValue(70,77);
//

        //thumbColor
//        rangeBar.setSelectorColor(Color.GRAY);

        //trackColor
        rangeBar.setConnectingLineColor(Color.BLUE);

//        rangeBar.setBarColor();

        //OuterTrackColor
        rangeBar.setBarColor(Color.GRAY);

        //Range enabled
        rangeBar.setRangeBarEnabled(true);

        //leftThumbValue
        rangeBar.getLeftPinValue();


        //rightThumbValue
        rangeBar.getRightPinValue();


        //mixValue
//        rangeBar.setTickStart(0);
//
//        //maxValue
//        rangeBar.setTickEnd(100);

//
//        rangeBar.getTickInterval();


        //Default
        rangeBar.setDrawTicks(false);
        rangeBar.setPinColor(Color.TRANSPARENT);
        rangeBar.setPinTextColor(Color.TRANSPARENT);
        rangeBar.setDrawTicks(false);

        rangeBar.setRangePinsByIndices( (( int)(rangeBar.getTickStart() - 30) / (int) rangeBar.getTickInterval()), (( int)( 50 - rangeBar.getTickStart()) / (int) rangeBar.getTickInterval()));

//        rangeBar.setRangePinsByIndices(10, 40);


        //onValueChange
        rangeBar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex, int rightPinIndex, String leftPinValue, String rightPinValue) {

                Log.d("RANGEBAR", "  left pin value " + leftPinValue + "       right pin value " + rightPinValue);

                Log.d("RANGEBAR", "  left pin value  ==>  " + rangeBar.getLeftPinValue() + "       right  pin  value " + rangeBar.getRightPinValue());
            }
            @Override
            public void onTouchStarted(RangeBar rangeBar) {

            }
            @Override
            public void onTouchEnded(RangeBar rangeBar) {

            }
        });

        Button btn = new Button(this);
        btn.setText("ChangeSize");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value = Integer.valueOf(rangeBar.getRightPinValue());
                rangeBar.setRangePinsByIndices( (( int)(rangeBar.getTickStart() - 30) / (int) rangeBar.getTickInterval()), (( int)( 50 - rangeBar.getTickStart()) / (int) rangeBar.getTickInterval()));
            }
        });

        linearLayout.addView(btn, new LinearLayout.LayoutParams(150,150));

        View testView = new View(this);
        testView.setBackgroundColor(Color.RED);

        linearLayout.addView(testView, new LinearLayout.LayoutParams((int) (50 * getResources().getDisplayMetrics().density),(int) (50 * getResources().getDisplayMetrics().density)));

//        rangeBar.setDrawTicks(false);
        rangeBar.setBarRounded(false);
//        rangeBar.setPinColor(Color.TRANSPARENT);
//        rangeBar.setPinTextColor(Color.TRANSPARENT);
//
//        rangeBar.setSelectorColor(Color.RED);
//        rangeBar.setSelectorBoundaryColor(Color.GRAY);
//        rangeBar.setSelectorBoundarySize(150);
//
//        rangeBar.setBarWeight(35);

//        rangeBar.setConnectingLineWeight(35);
//
//        rangeBar.setDrawTicks(false);
//
//        rangeBar.setPinColor(Color.TRANSPARENT);
//
//        rangeBar.setTickHeight(50);

        linearLayout.addView(rangeBar);

//        com.edmodo.rangebar.RangeBar rangeBaEdmode = new com.edmodo.rangebar.RangeBar(this);

//        linearLayout.addView(rangeBaEdmode);

        setContentView(linearLayout, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

    }
}
