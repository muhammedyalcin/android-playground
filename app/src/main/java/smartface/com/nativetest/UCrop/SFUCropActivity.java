package smartface.com.nativetest.UCrop;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yalantis.ucrop.UCropActivity;

import smartface.com.nativetest.R;


public class SFUCropActivity extends UCropActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = findViewById(R.id.wrapper_states);
        TextView mTextViewScalePercent = linearLayout.findViewById(R.id.text_view_rotate);
        mTextViewScalePercent.setText("blahh");
        mTextViewScalePercent.setBackgroundColor(Color.BLUE);

//        TextView mTextViewrotatePercent = findViewById(R.id.text_view_rotate);
//        mTextViewrotatePercent.setText("blahh");

    }
}
