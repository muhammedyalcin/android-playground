package smartface.com.nativetest;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by smartface on 13.08.2018.
 */

public class textSizeAnimator extends AppCompatActivity {

    ViewGroup rootLayout;
    TextView txtV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.textviewsize_animate);

        rootLayout = (ViewGroup) findViewById(R.id.animateRootLayout);

        txtV = (TextView) findViewById(R.id.textV);
        txtV.setText("hee");

        Button  btn = (Button) findViewById(R.id.btnAnimate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimator(15);
            }
        });

    }

    public void startAnimator(int textSize) {
        ValueTransition valueTransition = new ValueTransition();

        TransitionSet ts = new TransitionSet();
        ts.setDuration((long) 500);
        ts.addTransition(valueTransition);

        TransitionManager.beginDelayedTransition(rootLayout, ts
        );
        txtV.setTextSize(textSize);


    }

}
