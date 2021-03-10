package smartface.com.nativetest;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ViewBorderTest extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.view_border_layout);

        View myFrameLayout  = (View) findViewById(R.id.myFrameLayout);
        myFrameLayout.setBackgroundColor(Color.RED);
//        myFrameLayout.setClipChildren(false);
//
//        myFrameLayout.setClipToOutline(false);

//        GradientDrawable gradientDrawable = new GradientDrawable();
//        gradientDrawable.setStroke(20, Color.RED);
//        gradientDrawable.setCornerRadius(50);

//        myFrameLayout.setClipToOutline(true);
//        myFrameLayout.setClipChildren(true);
//        gradientDrawable.setCornerRadii();

//        myFrameLayout.setBackground(gradientDrawable);
//        myFrameLayout.setClipChildren(true);
//        myFrameLayout.setClipToOutline(true);
//        myFrameLayout.setClipToPadding(true);

//        View aView = new View(this);
//        aView.setBackgroundColor(Color.BLUE);

//        myFrameLayout.addView(aView);

//        View textView = new View(this);
//        textView.setLayoutParams(new FrameLayout.LayoutParams(2000, 100));
//        textView.setBackgroundColor(Color.BLUE);
//        textView.setClipChildren(false);
//        textView.setPaddingRelative(35,15,5,5);

//        textView.setText("TESTTESTESTEST");

//        GradientDrawable gradientDrawable1  = new GradientDrawable();
//        gradientDrawable1.setStroke(5, Color.BLUE);
//        textView.setBackground(gradientDrawable1);

//        myFrameLayout.addView(textView);
    }
}
