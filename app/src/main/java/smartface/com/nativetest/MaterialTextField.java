package smartface.com.nativetest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.lang.reflect.Field;

import smartface.com.nativetest.RootDetection.RootDetection;
import smartface.com.nativetest.RootDetection.SafetyNetAPI;


/**
 * Created by smartface on 27.07.2018.
 */

/*
1 - What causes in web view ?
2- How about changing all fragments context ?
3-
 */

public class MaterialTextField extends AppCompatActivity {
    Context parent;
    Context myContext;
    AppCompatActivity  instance;

    static int indexForText = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myContext = this;

        setContentView(R.layout.material_test);
        parent = this;

        instance = this;

        EditText mEditText = findViewById(R.id.mEditText);


        final String[] pathsThatShouldNotBeWrtiable = {
                "/system",
                "/system/bin",
                "/system/sbin",
                "/system/xbin",
                "/vendor/bin",
                "/sbin",
                "/etc",
                "/storage/self/primary"
        };

         final String[] suPaths ={
                "/data/local/",
                "/data/local/bin/",
                "/data/local/xbin/",
                "/sbin/",
                "/su/bin/",
                "/system/bin/",
                "/system/bin/.ext/",
                "/system/bin/failsafe/",
                "/system/sd/xbin/",
                "/system/usr/we-need-root/",
                "/system/xbin/",
                "/cache/",
                "/data/",
                "/dev/"
        };

         final String[] knownRootAppsPackages = {
                "com.noshufou.android.su",
                "com.noshufou.android.su.elite",
                "eu.chainfire.supersu",
                "com.koushikdutta.superuser",
                "com.thirdparty.superuser",
                "com.yellowes.su",
                "com.topjohnwu.magisk",
                 "kingoroot.supersu"
        };


        mEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean test1 = RootDetection.checkRootAccessGained(pathsThatShouldNotBeWrtiable);
                boolean test2 = RootDetection.checkSuBinaryExistance(suPaths);
                boolean test3 = RootDetection.checkAppPackages(knownRootAppsPackages, myContext);
//                boolean test4 = RootDetection.checkForRWPaths(pathsThatShouldNotBeWrtiable);

                Log.d("test1","test1 " + test1 +"  test 2  " + test2 + " test3 " + test3 );
            }
        });

        SafetyNetAPI safetyNetAPI  = new SafetyNetAPI("AIzaSyCeM-4bYIJx3bBSeKzCpk9X1ZZ_4CGMhkA",this);

        safetyNetAPI.sendAttestationRequest(safetyNetAPI.generateNonce());


        LinearLayout rtl = (LinearLayout) findViewById(R.id.rootLayout);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        TextInputLayout txtInputLayout = new TextInputLayout(this);
//        test.setHintTextAppearance(R.style.TextLabel);

        TextInputEditText editText = new TextInputEditText(txtInputLayout.getContext());
        txtInputLayout.addView(editText);

//        SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
//        stringBuilder.setSpan(new TypefaceSpan("SF",));
//        stringBuilder.append(new SpannableString())
        txtInputLayout.setHintTextAppearance(R.style.SFMaterialTextboxHint);

        txtInputLayout.setHint("Test Deneme");
//        txtInputLayout.setHintEnabled(true);

        rtl.addView(txtInputLayout);


//        setExpandedHintTextSize(txtInputLayout, );


//        Method[] methods = Class.class.getMethods();
//
//        for (Method method : methods) {
//            Log.d("method", " method " +  method.getName());
//        }

//        Class<?> editTextClass = editText.getClass();
//        Class<?>[] types = new Class<?>[0];
//        try {
//            Method[] testkkjp = editTextClass.getDeclaredMethods();
//        }catch (SecurityException e ){
//
//        }



//        EditText editText2 = new EditText(this);
//        test.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));


//        TextView textView  = new TextView(this);
//        textView.setLayoutParams(new ViewGroup.LayoutParams(200,500));
//        textView.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
//        textView.setEllipsize(TruncateAt.START);
//        textView.getEllipsize();


        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.create(null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * From aTable", null);
//        cursor.getString();


//        textView.setSingleLine(false);
//        textView.setMaxLines(0);

//        rtl.addView(textView);

//        Log.d("textViewTest", " textView getEllipsize  " + Integer.MAX_VALUE);
    }


    public void setExpandedHintTextSize(TextInputLayout textInputLayout, int textSize){
        try {
            Field filedCollapsingTextHelper = TextInputLayout.class.getDeclaredField("mCollapsingTextHelper");
            filedCollapsingTextHelper.setAccessible(true);

            Object helper = filedCollapsingTextHelper.get(textInputLayout);


            Field fieldExpandedTextSize = helper.getClass().getDeclaredField("mCollapsedTextSize");
            fieldExpandedTextSize.setAccessible(true);
            fieldExpandedTextSize.set(helper, textSize);
        }
        catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public class TestInputLayout extends  TextInputLayout{


        public TestInputLayout(Context context) {
            super(context);
        }
    }

}