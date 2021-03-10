package smartface.com.nativetest;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.transition.Transition;
import androidx.transition.TransitionInflater;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by smartface on 15.08.2018.
 */

public class FragmentOnDestroyTest extends AppCompatActivity  {
    static Context parentContext;
    static MutableContextWrappers mutableContextWrappers;

    public static ViewGroup rootViewFragments = null;
    public static Parcelable restoreInstance;

    static AppCompatActivity activity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.textviewsize_animate);

        Button btn  = (Button) findViewById(R.id.btnAnimate);
        TextView  tv = (TextView) findViewById(R.id.textV);

        activity = this;

        parentContext = this;

        CoordinatorLayout myCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.page_CoordinatorLayout);

        myCoordinatorLayout.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                Log.d("MyonKey", " myCoordinatorLayout  setOnKeyListener");
                return true;
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager  fg = getSupportFragmentManager();
                FragmentTransaction ft = fg.beginTransaction();

                FirstFragemnet firstFragemnet1 = new FirstFragemnet();
                ft.setCustomAnimations(R.anim.onshow_animation,R.anim.ondismiss_animation);

                ft.replace(R.id.page_layout , firstFragemnet1, "TEST77");
                // Complete the changes added above
                ft.commit();
            }
        });

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Log.d("MyonKey", "onBackPressed ");
    }



}
