package smartface.com.nativetest;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class PermissionChecker extends AppCompatActivity {

    final int PERMISSION_CODE = 17;
    Activity parentCotnext = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fcm_notification_test);

        parentCotnext = this;

        Button btn = (Button) findViewById(R.id.tokenBtn);
        btn.setText("Take Permission");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(parentCotnext, "android.permission.WRITE_EXTERNAL_STORAGE") != PackageManager.PERMISSION_GRANTED) {

                    if(ActivityCompat.shouldShowRequestPermissionRationale(parentCotnext,"android.permission.WRITE_EXTERNAL_STORAGE")){

                    }else {
                        ActivityCompat.requestPermissions(parentCotnext, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, PERMISSION_CODE);
                    }
                }else
                    Toast.makeText(parentCotnext, "ALREADY PERMISSION THERE", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(PERMISSION_CODE == requestCode){

        }
    }
}
