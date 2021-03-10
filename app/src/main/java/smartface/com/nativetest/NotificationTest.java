package smartface.com.nativetest;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class NotificationTest extends AppCompatActivity {

    String NOTIFICATION_TITLE = "Nofication Test";
    int  EMULATOR_NOTIFICATION_CODE = 987;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.notification_layout);

        Button btn = (Button) findViewById(R.id.btnNotify);
        Context context = this;

        Button cBtn = findViewById(R.id.cancelBtn);
        cBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.cancelAll();
            }
        });

        try {
            JSONObject jsonObject = new JSONObject("{\n" +
                    "    \"glossary\": {\n" +
                    "        \"title\": \"example glossary\",\n" +
                    "\t\t\"GlossDiv\": {\n" +
                    "            \"title\": \"S\",\n" +
                    "\t\t\t\"GlossList\": {\n" +
                    "                \"GlossEntry\": {\n" +
                    "                    \"ID\": \"SGML\",\n" +
                    "\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
                    "\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
                    "\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
                    "\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
                    "\t\t\t\t\t\"GlossDef\": {\n" +
                    "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
                    "\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
                    "                    },\n" +
                    "\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
                    "                }\n" +
                    "            }\n" +
                    "        }\n" +
                    "    }\n" +
                    "}");

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((TextView) findViewById(R.id.textViewTest)).setText(jsonObject.toString());
                   createNotification();
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    public void createNotification(){

        String ns = Context.NOTIFICATION_SERVICE;
        final String defaultSmarfaceId = "7";

        NotificationManager mNotificationManager = (NotificationManager) getSystemService (ns);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            final String defaultSmarfaceTitle = NOTIFICATION_TITLE;
            int importance  = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel = new NotificationChannel(defaultSmarfaceId,defaultSmarfaceTitle,importance);
            mNotificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder notiBuilder = new NotificationCompat.Builder (this,defaultSmarfaceId);
        Notification emulatorNotification = notiBuilder.setContentTitle(NOTIFICATION_TITLE)
                .setSmallIcon(R.drawable.com_mixpanel_android_ic_megaphone)
                .build();

        emulatorNotification.flags |= Notification.FLAG_ONGOING_EVENT;
        mNotificationManager.notify(EMULATOR_NOTIFICATION_CODE,emulatorNotification);
    }
}
