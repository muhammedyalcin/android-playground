package smartface.com.nativetest;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CropCameraTest extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        try {
//            InputStream assetManager  = getAssets().open("smartface.png");
//            File fl = new File("smartface.png");
//            FileOutputStream outputStream = new FileOutputStream(fl);
//            int readEnd = 0;
//            while((readEnd = assetManager.read()) != -1) {
//                outputStream.write(assetManager.read());
//            }
//            outputStream.flush();
//
//
//            CropImage.activity(Uri.fromFile(fl))
//                    .start(this);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .setCropShape(CropImageView.CropShape.OVAL)
                .start(this);


    }
}
