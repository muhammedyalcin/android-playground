package smartface.com.nativetest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.http.SslError;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BackButtonTest extends AppCompatActivity {
    WebView myWebView;
    Activity parentContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.backbuttonlayout);
        parentContext = this;

        LinearLayout mainLinearLayout = new LinearLayout(this);

//        test.setMovementMethod(new ScrollingMovementMethod());

        mainLinearLayout.setBackgroundColor(Color.BLUE);

        myWebView = new WebView(this);
        myWebView.setWebViewClient(new WebClient());

        myWebView.setBackgroundColor(Color.TRANSPARENT);
        myWebView.setBackground(getDrawable(R.drawable.icon));

//        myWebView.loadUrl("http://mobileapp.teknosa.com/");


        WebSettings settings = myWebView.getSettings();

        myWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);

//        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLoadsImagesAutomatically(true);

//        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);


//        settings.setMixedContentMode(0);

//        settings.setBlockNetworkIm/age(true);


        myWebView.setHorizontalScrollBarEnabled(true);
        myWebView.setVerticalScrollBarEnabled(true);

//        myWebView.postVisualStateCallback(7,
//                new WebView.VisualStateCallback() {
//            @Override
//            public void onComplete(long l) {
//                Toast.makeText(parentContext, " postVisualStateCallback ", Toast.LENGTH_SHORT).show();
//            }
//        });



//        myWebView.getSettings().setDomStorageEnabled(false);
//

//        myRelativeLayout.setFocusableInTouchMode(true);
//        myRelativeLayout.setFocusable(true);

//        myRelativeLayout.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View view, int i, KeyEvent keyEvent) {
//                Log.e("@@SMF", "" + "myRelativeLayout.setOnKeyListener ");
//                return false;
//            }
//        });

        mainLinearLayout.addView(myWebView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

//        myLinearLAyout.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View view, int i, KeyEvent keyEvent) {
//                Log.d("onKey", "myLinearLAyout.setOnKeyListener");
//                return false;
//            }
//        });

        setContentView(mainLinearLayout, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        myWebView.loadUrl("http://mobileapp.teknosa.com/apple-macbook-air-mqd32tua-intel-i5-18ghz-8gb-128gb-intel-hd-graphics-13-silver-notebook-p-125033479");
        Log.e("@@SMF", "" + "on BACK BUTTON ");
    }

    public class WebClient extends WebViewClient{

        @Nullable
        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
            return super.shouldInterceptRequest(view, url);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Toast.makeText(parentContext, " ONSHOW ONSHOW ONSHOW ONSHOW ", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            System.out.println("error " + error.toString()  );
            super.onReceivedSslError(view, handler, error);
        }

        @Override
        public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
            return super.onRenderProcessGone(view, detail);
        }
    }

}
