package smartface.com.nativetest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ContactShareTest extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String lookupKey = "1";
//        Uri vcardUri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_TYPE, lookupKey);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
//        intent.putExtra(Intent.EXTRA_STREAM, vcardUri);
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Bob Dylan");
        intent.putExtra(Intent.EXTRA_TEXT, "TESTTEXT \n +9014141412312");

//        intent.setData()
        startActivity(Intent.createChooser(intent, "Uygulama Secin"));
    }
}
