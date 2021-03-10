package smartface.com.nativetest.FCMNotificationTest;


import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import android.util.Log;

public class FcmBgService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d("onMessageReceived", "onMessageReceived");
        super.onMessageReceived(remoteMessage);
    }
}
