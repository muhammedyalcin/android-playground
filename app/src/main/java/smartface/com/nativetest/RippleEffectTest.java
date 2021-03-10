package smartface.com.nativetest;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class RippleEffectTest extends AppCompatActivity {

    byte[] maxBytesadd = new byte[600000];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.rippletest);

        RelativeLayout rootLayout = (RelativeLayout) findViewById(R.id.rootLayout);
        FrameLayout myFrameLayout = (FrameLayout) rootLayout.findViewById(R.id.myFrameLayout);
        myFrameLayout.setBackgroundColor(Color.RED);

        applyRippleEffect(myFrameLayout, true);


        Handler handler = new Handler();

        myFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       new Handler().postDelayed(this,400);
                       for (int i = 0; i < 10; i++) {
                           System.out.println(" run on ui");
//                       maxBytesadd[i] = (byte) 0xd2;
                       }
                   }
               });
            }
        });
    }

    void applyRippleEffect(View myView, boolean enableForeground){
        myView.setClickable(true);
        int[] colors  = new int[] {Color.argb(255,216,216,216)};
        ColorStateList colorStateList = ColorStateList.valueOf(Color.BLUE);
        RippleDrawable rippleDrawable = new RippleDrawable(colorStateList,null,null);

        if(!enableForeground)
            myView.setBackground(rippleDrawable);
        else
            myView.setForeground(rippleDrawable);

    }
}
