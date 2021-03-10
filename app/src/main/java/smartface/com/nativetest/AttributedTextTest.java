package smartface.com.nativetest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LineHeightSpan;
import android.text.style.TypefaceSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

import java.util.ArrayList;

public class AttributedTextTest extends AppCompatActivity {

    Context parentContext;

    int  TEXT_SIZE = 15;
    int  MAX_WIDTH = 650;
    String[] strs = new String[]{"ACTION_DOWN", "ACTION_UP", "ACTION_MOVE", "ACTION_CANCEL"};

    String DEBUG_TAG = "AttributedTextTestTAG";
    float x,y;

    Typeface FONT = Typeface.DEFAULT;

    String[] attributes = new String[]{
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>",
            "<p><span style=\"font-weight: bold\">1. Üniversite Öğrencilerine Dönemsel İndirim Kampanyası</span> <br>Tüm üniversite öğrencilerine, bahar ve güz dönemi başlangıç ve bitiş tarihlerinde birer ay (15 Ocak-15 Şubat, 1-30 Haziran ve 1-30 Eylül) süreyle, üniversite kimlik belgelerini ibraz etmek suretiyle, ticari gönderileri hariç (posta kargosu/kargo ve APS kuryelere) <span style=\"font-weight: bold\">%30 indirim</span> uygulaması bulunmaktadır.</p>"
    };

    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
    MovementMethod linkMovementMethod;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attributedtextest);

        float scale = getApplicationContext().getResources().getDisplayMetrics().density;

        parentContext = this;

        Intent intent = new Intent();

        Uri uri = new Uri.Builder().build();

        ArrayList arrayList = new ArrayList();

        RelativeLayout myRelativeLayout = (RelativeLayout)  findViewById(R.id.myRelativeLayout);

        TextView myTextView   = new TextView(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(300,150);
        layoutParams.topMargin = 50;
        myTextView.setLayoutParams(layoutParams);


//        myTextView.setWidth(MAX_WIDTH);
//        myTextView.setTypeface(FONT);
//        myTextView.setTextSize(TEXT_SIZE);

//        myTextView.setMaxLines(1000);


//        String[] attributedText = {"THIS IS LINKED TEXT "};

//        myTextView.setLinksClickable(true);
        myTextView.setGravity(17);


        spannableStringBuilder.setSpan(new LineSpacing(), 0, spannableStringBuilder.length(),33);

        myTextView.setHighlightColor(0);

//        myTextView.setMaxLines(1);
        MovementMethod scrollingMovementMethod = new MovementMethodCustom();

        myTextView.setMovementMethod(scrollingMovementMethod);

        myTextView.setText(attributes[0]);


        myTextView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d(DEBUG_TAG, " motionEvent " + strs[motionEvent.getAction()] + "X " + ( x -  motionEvent.getX()) + " Y " + (y - motionEvent.getY()));
                return false;
            }
        });

        myRelativeLayout.addView(myTextView);


//        LinearLayout myLinearLayout = new LinearLayout(this);
//        myLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

//        Button actualSizeBtn = new Button(this);
//
//        actualSizeBtn.setText("Take Actual Size");
//        actualSizeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.println("Actual height " + myTextView.getHeight() + " width " + myTextView.getWidth());
//            }
//        });
//
//
//
//
//        Button  measuredSizeBtn = new Button(this);
//        measuredSizeBtn.setText("Take Measured Size");
//        measuredSizeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(parentContext, " screen width height " + (parentContext.getResources().getDisplayMetrics().heightPixels  - getSupportActionBar().getHeight()), Toast.LENGTH_LONG).show();
//                int measuredSize =getMeasuredSize(parentContext,spannableStringBuilder,TEXT_SIZE,MAX_WIDTH, FONT, 0 );
//
//                System.out.println("meuasure height " + measuredSize );
//            }
//        });


//        TextView equalTextView = new TextView(this);
//        equalTextView.setHeight(getMeasuredSize(parentContext,spannableStringBuilder,TEXT_SIZE,MAX_WIDTH, FONT, 0 ));
//        equalTextView.setWidth(50);
//        equalTextView.setBackgroundColor(Color.BLUE);

//        myLinearLayout.addView(actualSizeBtn);
//        myLinearLayout.addView(measuredSizeBtn);
//        myLinearLayout.addView(equalTextView);
//
//
//        myRelativeLayout.addView(myLinearLayout);


    }


    public SpannableStringBuilder createAttributedText(String[] text) {
        spannableStringBuilder.clear();

        for (String s : text) {
            createSpannyText(s);
        }

        return spannableStringBuilder;
    }

    public void createSpannyText(String text) {
        spannableStringBuilder.append(text);

        int start = spannableStringBuilder.length() - text.length();
        int end = spannableStringBuilder.length();

            spannableStringBuilder.setSpan(new ClickableSpanText(text) , start,end, 33);
            Typeface myTypeface = Typeface.create("monospace",Typeface.BOLD);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.BLUE), start, end, 33);
//            spannableStringBuilder.setSpan(new BackgroundColorSpan(Color.GRAY), start, end, 33);
            spannableStringBuilder.setSpan(new SFTypeFaceSpan("SF"), start, end, 33);
//            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(15, true), start, end, 33);
//            spannableStringBuilder.setSpan(new UnderlineSpan(), start, end, 33);
    }

    public class SFTypeFaceSpan extends TypefaceSpan{

        public SFTypeFaceSpan(@Nullable String family) {
            super(family);
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            applyCustomTypeFace(ds, Typeface.create("monospace",Typeface.BOLD));
        }

        @Override
        public void updateMeasureState(TextPaint paint) {
            applyCustomTypeFace(paint,Typeface.create("monospace",Typeface.BOLD));
        }
    }

    public class ClickableSpanText  extends ClickableSpan{
        String text ;
        ClickableSpanText(String text) {
            super();
            this.text = text;
        }

        @Override
        public void onClick(@NonNull View view) {
            Toast.makeText(parentContext, text  + "  ClickableSpanText onClick " + view.getId(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void updateDrawState(@NonNull TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(true);
        }
    }

    public class LineSpacing implements LineHeightSpan{
        @Override
        public void chooseHeight(CharSequence charSequence, int i, int i1, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
            fontMetricsInt.ascent -= 0;
            fontMetricsInt.descent += 0;
        }
    }


    public void applyCustomTypeFace(Paint paint, Typeface tf) {
        int oldStyle;
        Typeface old = paint.getTypeface();
        if (old == null) {
            oldStyle = 0;
        }
        else {
            oldStyle = old.getStyle();
        }
        int fake = oldStyle & ~tf.getStyle();
        if ((fake & Typeface.BOLD) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((fake & Typeface.ITALIC) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(tf);
    }


    public int getMeasuredSize(Context context, SpannableStringBuilder text, int textSize, int deviceWidth, Typeface typeface, int padding){

        TextView textView = new TextView(context);
        textView.setPadding(padding,0,padding,padding);
//        textView.setTypeface(typeface);
        textView.setText(text, TextView.BufferType.SPANNABLE);
        textView.setMaxLines(1000);
        textView.setSingleLine(false);
//        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(deviceWidth, View.MeasureSpec.AT_MOST);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        textView.measure(widthMeasureSpec, heightMeasureSpec);
        return textView.getMeasuredHeight();
    }


    public class MovementMethodCustom extends  ScrollingMovementMethod {
        @Override
        public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
            Log.d(DEBUG_TAG , "ScrollingMovementMethod motionEvent " + strs[event.getAction()]);
            return super.onTouchEvent(widget, buffer, event);
        }
    }

}



