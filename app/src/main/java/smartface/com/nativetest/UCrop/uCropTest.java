package smartface.com.nativetest.UCrop;

import android.content.Intent;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.yalantis.ucrop.UCrop;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.net.QuotedPrintableCodec;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;

import smartface.com.nativetest.R;

public class uCropTest extends AppCompatActivity {

    static final int PICK_REQUEST_CODE = 1;
    static final int CROPPED_REQUEST_CODE = 3;
    static final int PERMISSION_REQUEST_CODE = 2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        QuotedPrintableCodec quotedPrintableCodec = new QuotedPrintableCodec();
        try {
            String text = "asdasdasd";
            String test = quotedPrintableCodec.encode(text, "UTF-8");
            boolean ascii =  StandardCharsets.US_ASCII.newEncoder().canEncode(text);
            String ss = test;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Button btn = new Button(this);
        btn.setText("Click to Crop!");

        ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, PERMISSION_REQUEST_CODE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");

                startActivityForResult(intent, PICK_REQUEST_CODE);
            }
        });
        setContentView(btn);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_REQUEST_CODE) {
            Uri uri = data.getData();

            UCrop.Options options = new UCrop.Options();
            options.setCircleDimmedLayer(true);
            options.setToolbarTitle("Bune nee!");
//            options.setHideBottomControls();
//            options.setFreeStyleCropEnabled(true);
//            options.setAllowedGestures();
//            options.setShowCropGrid(false);
//            options.setShowCropFrame(false);
//            options.setHideBottomControls(true);

            UCrop uCrop = UCrop.of(uri, Uri.fromFile(new File(getCacheDir() + "/crop.png")))
                    .withOptions(options);

            Intent intent = uCrop.getIntent(this);
            intent.setClass(this, SFUCropActivity.class);

            this.startActivityForResult(intent, CROPPED_REQUEST_CODE);

        } else if (requestCode == CROPPED_REQUEST_CODE) {

            Uri uri = UCrop.getOutput(data);
            String uriString = uri.toString();
        }
    }
}
