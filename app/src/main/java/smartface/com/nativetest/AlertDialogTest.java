package smartface.com.nativetest;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.OrientationEventListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AlertDialogTest extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.htmltexttest);

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .create();

        alertDialog.setTitle("Heeyyy");
        alertDialog.setMessage("Body");

        LinearLayout relativeLayout = new LinearLayout(this);

        EditText text1 = new EditText(this);
//        text1.setId(15);
        relativeLayout.addView(text1);

        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//
//        InputStream assetManager = null;
//        try {
//            assetManager = getAssets().open("splash_imagetest.9.png");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        InputStream stream = assetManager ; //whatever
//        Bitmap bitmap = BitmapFactory.decodeStream(stream);
//        byte[] chunk = bitmap.getNinePatchChunk();
//        boolean result = NinePatch.isNinePatchChunk(chunk);
//        Log.d("DEBUGTHECHUNK", " RESULT is " + result);
//        NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(bitmap, chunk, new Rect(), null);


//        Bitmap bitmapDrawable = BitmapFactory.decodeStream(assetManager);
//        Drawable ninePatchDrawable =  NinePatchDrawable.createFromStream(assetManager,null);
//        imageView.setImageDrawable(ninePatchDrawable);
//        imageView.setBackgroundColor(Color.BLUE);

//        View view  = new View(this);
//        view.setBackground(ninePatchDrawable);
//        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


//        setContentView(view);





//        relativeLayout.setFocusable();
//        relativeLayout.setFocusableInTouchMode();

        relativeLayout.setOrientation(LinearLayout.VERTICAL);

        EditText editText = new EditText(this);
        editText.setText("Hii");
//        editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(250, 350);
        layoutParams.setMargins(0,0,0,0);

        editText.setLayoutParams(layoutParams);

//        EditText editText1 = new EditText(this);
//        editText1.setText("Hii12");


//        relativeLayout.addView(editText);
//        relativeLayout.addView(editText1);

//        alertDialog.setView(relativeLayout);

//        alertDialog.show();

        this.setRequestedOrientation(1);

        new OrientationEventListener(this) {

            @Override
            public void onOrientationChanged(int i) {
                int i1 = i;
            }
        }.enable();
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
