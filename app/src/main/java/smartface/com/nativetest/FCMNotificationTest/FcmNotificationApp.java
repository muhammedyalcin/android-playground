package smartface.com.nativetest.FCMNotificationTest;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import java.io.IOException;

import smartface.com.nativetest.R;

public class FcmNotificationApp extends AppCompatActivity {

    Context parentContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fcm_notification_test);

        parentContext = this;

        Button btn  = findViewById(R.id.tokenBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncTask<Void, Void, String>(){
                    @Override
                    protected String doInBackground(Void[] params) {
                        String token = null;
                        try {
                            token =  FirebaseInstanceId.getInstance().getInstance().getToken("262065735993",FirebaseMessaging.INSTANCE_ID_SCOPE);
                            Log.d("onMessageReceived", " token  is  " + token);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return token;
                    }
                    @Override
                    protected void onPostExecute(String token) {
                    }
                }.execute();
            }
        });
    }
}
