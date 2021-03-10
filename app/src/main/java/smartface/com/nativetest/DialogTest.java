package smartface.com.nativetest;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.AppCompatDrawableManager;

public class DialogTest extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_layout);

        @SuppressLint("ResourceType")
        Dialog dialog = new Dialog(this, 16974064);//16974064
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(Color.argb(58, 0, 0, 0)));
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.dialog_layout);
        dialog.show();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {


        return super.onCreateView(name, context, attrs);
    }
}
