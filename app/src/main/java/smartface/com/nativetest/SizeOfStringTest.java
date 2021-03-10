package smartface.com.nativetest;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.ImageViewCompat;
import androidx.core.widget.TextViewCompat;

import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SizeOfStringTest extends AppCompatActivity {

    AppCompatTextView myTextView;
    Context parentContext;

    int TEXT_SIZE = 25;
    int MAX_WIDTH = 250;
    Typeface FONT = Typeface.DEFAULT;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.attributedtextest);

        parentContext = this;

        RelativeLayout rootLayout = (RelativeLayout) findViewById(R.id.myRelativeLayout);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.myLinear);

        String dummyString = "Hello There How are you guys ? ";

        myTextView = new AppCompatTextView(this);
        TextViewCompat.setAutoSizeTextTypeWithDefaults( myTextView,TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);;

//        myTextView.setAutoSizeTextTypeUniformWithConfiguration(
//                1, 50, 2, TypedValue.COMPLEX_UNIT_DIP);

        myTextView.setHeight(500);
        myTextView.setWidth(500);
        myTextView.setTextSize(TEXT_SIZE);
        myTextView.setText(dummyString);

//        myTextView.setTypeface(FONT);


        Button  actualSizeBtn = new Button(this);

        actualSizeBtn.setText("Take Actual Size");
        actualSizeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myTextView.setText(myTextView.getText() + dummyString);
                System.out.println("Actual height " + myTextView.getHeight() + " width " + myTextView.getWidth());
            }
        });

        Button  measuredSizeBtn = new Button(this);
        measuredSizeBtn.setText("Take Measured Size");
        measuredSizeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int measuredSize =getMeasuredSize(parentContext,dummyString,TEXT_SIZE,MAX_WIDTH, FONT, 0 );

                System.out.println("meuasure height " + measuredSize );
            }
        });

        rootLayout.addView(myTextView);

        rootLayout.addView(actualSizeBtn);
//        rootLayout.addView(measuredSizeBtn);
    }

    @Override
    protected void onStart() {
        super.onStart();

//        Toast.makeText(this, "on Create View  height " + myTextView.getHeight() + " width " + myTextView.getWidth(), Toast.LENGTH_LONG).show();
    }

    @Override
    public View onCreatePanelView(int featureId) {

        return super.onCreatePanelView(featureId);
    }

    public int getMeasuredSize(Context context, CharSequence text, int textSize, int deviceWidth, Typeface typeface, int padding){

            TextView textView = new TextView(context);
            textView.setPadding(padding,0,padding,padding);
            textView.setTypeface(typeface);
            textView.setText(text, TextView.BufferType.SPANNABLE);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
            int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(deviceWidth, View.MeasureSpec.AT_MOST);
            int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            textView.measure(widthMeasureSpec, heightMeasureSpec);
            return textView.getMeasuredHeight();
    }

    public  int convertDpToPixel(int dp){
        Resources resources = parentContext.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        int px = Math.round(dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }
}
