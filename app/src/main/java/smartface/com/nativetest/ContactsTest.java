package smartface.com.nativetest;

import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContentResolverCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.widget.TextViewCompat;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class ContactsTest extends AppCompatActivity {


    int SELECT_PHONE_NUMBER = 7;
    AppCompatActivity cxt;

    public static Uri createImageFile(Context context) {
        File getImage = context.getExternalCacheDir();
        if (getImage != null) {
            String authority = BuildConfig.APPLICATION_ID + ".provider";
            File outputFile = new File(getImage.getPath(), "imageResult.jpeg");
            return FileProvider.getUriForFile(context, authority, outputFile);
        }
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cxt = this;

        Button btn = new Button(this);
        btn.setText("Select Contact");

//        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration()

        AppCompatTextView textView = new AppCompatTextView(this);
        textView.setText("Unit Size AppCompatTextView");

//        EditText editText = new EditText(this);
//        editText.setText("Unit Size Test");


        ActivityCompat.requestPermissions(cxt, new String[]{"android.permission.CAMERA", "android.permission.READ_CONTACTS", "4"}, 7);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                //READ&WRITE Permission file
//                intent.addCategory(Intent.CATEGORY_OPENABLE);


//                intent.setType("vnd.android.cursor.dir/phone_v2");

//                startActivityForResult(intent, SELECT_PHONE_NUMBER);


                if (ContextCompat.checkSelfPermission(cxt, "android.permission.READ_CONTACTS") == PackageManager.PERMISSION_GRANTED) {


                    String[] contactIds = getContactIdsByPhoneNumber("5541922267");
//
////                    if (ActivityCompat.shouldShowRequestPermissionRationale(cxt, "android.permission.READ_CONTACTS")) {
////
////                    } else {
//                        ActivityCompat.requestPermissions(cxt, new String[]{"android.permission.READ_CONTACTS"}, 7);
////                    }
//                } else {
////                    Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
////                    intent.setType("vnd.android.cursor.dir/phone_v2");
////                    startActivityForResult(intent, SELECT_PHONE_NUMBER);
//
                    Intent intents = new Intent();
//                    intent.setAction(Intent.ACTION_GET_CONTENT);
//                    intent.setType("application/pdf");
//                    startActivity(intent);
////                }
//
            }
//        });
            }
        });

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.addView(btn);
//        linearLayout.addView(editText);
//        linearLayout.addView(textView);

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        alertDialog.setTitle("Alert");
        alertDialog.setMessage("Alert message to be shown");

        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();


        TextView message = alertDialog.findViewById(android.R.id.message);
        message.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);

        Button button1 = alertDialog.findViewById(android.R.id.button1);
        button1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        //For negative button:
        Button button2 = alertDialog.findViewById(android.R.id.button2);
        button2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);

        Button button3 = alertDialog.findViewById(android.R.id.button3);
        button3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);

        setContentView(textView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_PHONE_NUMBER && resultCode == RESULT_OK) {
            // Get the URI and query the content provider for the phone number
            Uri contactUri = data.getData();
//            File myFile = new File(contactUri.toString());
//            String path = myFile.getAbsolutePath();
//            String aa = path;

            ContactQueryHelper.getUrlAddresses(cxt, ContactQueryHelper.getContactId(cxt, contactUri));


            //Check Scheme !!@#!@#!@#!
//            try {
//
//                InputStream inputStream = getContentResolver().openInputStream(contactUri);
//
//                String fileName = getFileName(contactUri);
//
//                File file = new File(getExternalCacheDir(), fileName);
//                if (!file.exists())
//                    file.createNewFile();
//                //Optimize here with buffer
//                OutputStream outputStream = new FileOutputStream(file);
//                outputStream.write(inputStream.read());
//                outputStream.flush();
//
//                String fileExtension = getFileExtension(contactUri);
//
//                String path1 = file.getAbsolutePath();
//
//                String aaa = path1;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

//            ContactQueryHelper.getEmailAddresses(cxt, ContactQueryHelper.getContactId(cxt, contactUri));
        }
    }



    public String[] getContactIdsByPhoneNumber(String phoneNumber) {

        final String[] projection = {ContactsContract.Data.CONTACT_ID};
        String selection = ContactsContract.CommonDataKinds.Phone.NUMBER + " LIKE " + "'%" + phoneNumber + "%'";

        final Cursor phoneNumberCursor = this.getContentResolver().query(ContactsContract.Data.CONTENT_URI, projection, selection, null, null);

        List<String> contactIds = new ArrayList<>();
        if (phoneNumberCursor.moveToFirst()) {
            do {
                int phoneNumberCursorColumnIndex = phoneNumberCursor.getColumnIndex(ContactsContract.Data.CONTACT_ID);

                if (phoneNumberCursorColumnIndex != -1 && !phoneNumberCursor.isNull(phoneNumberCursorColumnIndex)) {
                    String contactId = phoneNumberCursor.getString(phoneNumberCursorColumnIndex);
                    contactIds.add(contactId);
                }

            } while (phoneNumberCursor.moveToNext());
        }
        phoneNumberCursor.close();

        String[] result = contactIds.toArray(new String[contactIds.size()]);

        return result;
    }


    public String getFileName(Uri uri) {
        String fileName = getFileNameFromCursor(uri);
        if (fileName == null) {
            String fileExtension = getFileExtension(uri);
            fileName = "temp_file." + fileExtension;
        } else if (!fileName.contains(".")) {
            String fileExtension = getFileExtension(uri);
            fileName = fileName +"."+ fileExtension;
        }
        return fileName;
    }

    public String getFileNameFromCursor(Uri uri) {
        Cursor fileCursor = getContentResolver().query(uri, new String[]{OpenableColumns.DISPLAY_NAME}, null, null, null);
        String fileName = null;
        if (fileCursor != null && fileCursor.moveToFirst()) {
            int cIndex = fileCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
            if (cIndex != -1) {
                fileName = fileCursor.getString(cIndex);
            }
        }
        return fileName;
    }

    public String getFileExtension(Uri uri) {
        String fileType = getContentResolver().getType(uri);
        return MimeTypeMap.getSingleton().getExtensionFromMimeType(fileType);
    }

    public  int convertDpToPixel(int dp){
        Resources resources = getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        int px = Math.round(dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;

    }

}
