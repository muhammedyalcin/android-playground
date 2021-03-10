package smartface.com.nativetest;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class TextviewHtmlTest  extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.htmltexttest);

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.htmlLayout);

        EditText editText = (EditText) findViewById(R.id.editText);

//      textView.setSingleLine(true);
        editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD |InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS );
        Log.d("inputType" , " " + editText.getInputType());


        Button addBtn = (Button) findViewById(R.id.addBtn);
        Button removeBtn = (Button) findViewById(R.id.removeBtn);
        Button resetBtn = (Button) findViewById(R.id.resetBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int combined = setAndUnsetFlags(editText.getInputType(), 0 , Integer.valueOf(editText.getText().toString()));
                editText.setInputType(combined);
            }
        });

        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int combined = setAndUnsetFlags(editText.getInputType(), Integer.valueOf(editText.getText().toString()) , 0);
                editText.setInputType(combined);
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
            }
        });


    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(this, "on back button pressed " , Toast.LENGTH_SHORT).show();
    }
//
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Toast.makeText(this, "  onConfigurationChanged " , Toast.LENGTH_SHORT).show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                textView.setTransformationMethod(null);
//                textView.setTransformationMethod(new PasswordTransformationMethod());
            }
        },1000);
        super.onConfigurationChanged(newConfig);
    }

    int setAndUnsetFlags(int current, int unsetFlags, int setFlags){
        int combined = ( (current & ~unsetFlags) | setFlags);
        return combined;
    }
}
