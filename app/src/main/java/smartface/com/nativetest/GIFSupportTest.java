package smartface.com.nativetest;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import java.io.ByteArrayOutputStream;
import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;

public class GIFSupportTest extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.gifsupport);

        ImageView myImageView = (ImageView) findViewById(R.id.myImageView);


        GifDrawable gifFromAssets = null;
        try {
             gifFromAssets = new GifDrawable(getAssets(), "testgif.gif");
            myImageView.setImageDrawable(gifFromAssets);
        }catch (IOException e){
            e.printStackTrace();

        }
        gifFromAssets.getCurrentFrame();
        gifFromAssets.getCurrentFrameIndex();
        gifFromAssets.getNumberOfFrames();

        System.out.println("Bitmap  " + bitmapConverter(gifFromAssets));
        Button speedUpBtn = (Button) findViewById(R.id.speedUpBtn);

        GifDrawable finalGifFromAssets = gifFromAssets;
        speedUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalGifFromAssets.setSpeed(2.0f);
            }
        });

        Button stopBtn = (Button) findViewById(R.id.stopBtn);

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalGifFromAssets.stop();
                finalGifFromAssets.getIntrinsicWidth();

            }
        });
        Button startBtn = (Button) findViewById(R.id.startBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalGifFromAssets.start();
            }
        });

        Button resetBtn = (Button) findViewById(R.id.resetBtn);

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalGifFromAssets.reset();
            }
        });
        Button seekToBtn = (Button) findViewById(R.id.seekToBtn);

        seekToBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap = bitmapConverter(finalGifFromAssets);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100 ,byteArrayOutputStream);

                GifDrawable bitmapDrawable = null;
                try {
                     bitmapDrawable = new GifDrawable(byteArrayOutputStream.toByteArray());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myImageView.setImageDrawable(bitmapDrawable);
                finalGifFromAssets.seekTo(3);
            }
        });


    }

    public Bitmap bitmapConverter(Drawable drawable){
        Bitmap bitmap = null;
        if(drawable.getIntrinsicHeight() <= 0 || drawable.getIntrinsicWidth() <= 0 ){
            bitmap = Bitmap.createBitmap(1,1,Bitmap.Config.ARGB_8888); //Creates 1x1 pixel bitmap
        }else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight() ,Bitmap.Config.ARGB_8888 );
        }
        Canvas canvas  = new Canvas(bitmap);
        drawable.setBounds(0,0, canvas.getWidth() , canvas.getHeight());
        drawable.draw(canvas);

        return  bitmap;

    }

}
