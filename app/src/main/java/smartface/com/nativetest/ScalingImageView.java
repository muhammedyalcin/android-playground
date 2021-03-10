package smartface.com.nativetest;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.view.ScaleGestureDetector;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.util.Log;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ScalingImageView extends AppCompatActivity {

    ScaleGestureDetector scaleLister;
    FusedLocationProviderClient flClient;
    LocationRequest locationRequest;
    LocationCallback callback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        FirebaseApp app = FirebaseApp.getInstance();
//        String apiKey = app.getOptions().getApiKey();
//
//        FirebaseApp app1 = FirebaseApp.getInstance();
//        String apiKey1 = app.getOptions().getApiKey();
        try {
            FirebaseApp.getInstance();
        }catch (IllegalStateException e){
            /*Initialize firebase to enable the perfomance sdk (firebase-perf)*/
            FirebaseOptions.Builder builder = new FirebaseOptions.Builder()
                    .setApplicationId("DUMMYID");
            FirebaseApp.initializeApp(this, builder.build());
        }
        super.onCreate(savedInstanceState);

        setContentView(R.layout.scalingimageview);

        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        ActivityCompat.requestPermissions(this,
                new String[]{ Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                2);

        flClient = LocationServices.getFusedLocationProviderClient(this);
        locationRequest = LocationRequest.create();
        locationRequest.setInterval(1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        callback = new LocationCallback(){
            @Override
            public void onLocationResult(LocationResult locationResult) {
                Log.d("LOCATIONTAG", "LOCATION GELDII " + locationResult.getLastLocation().getLatitude());
                super.onLocationResult(locationResult);
            }
        };

//        if (telephonyManager != null) {
//            if (ActivityCompat.checkSelfPermission(this, "android.Manifest.permission.ACCESS_FINE_LOCATION") != PackageManager.PERMISSION_GRANTED) {
//                // TODO: Consider calling
//                //    ActivityCompat#requestPermissions
//                // here to request the missing permissions, and then overriding
//                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                //                                          int[] grantResults)
//                // to handle the case where the user grants the permission. See the documentation
//                // for ActivityCompat#requestPermissions for more details.
//                return;
//            }
//            telephonyManager.getDeviceId();
//        }

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_top);

        setSupportActionBar(myToolbar);

        PhotoView photoView = findViewById(R.id.scalingImageView);


        Drawable arrowDrawable = getResources().getDrawable(R.drawable.com_mixpanel_android_arrowleft);
        arrowDrawable.setAutoMirrored(true);


        photoView.setImageDrawable(arrowDrawable);
        photoView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        photoView.setMaximumScale(999999999);

//        photoView.setImageDrawable(photoView.getDrawable());

//      ImageView imageView  = findViewById(R.id.imageView);

        String url = "https://cdn.hipwallpaper.com/m/1/52/FgML96.jpg";
        EditText editText = new EditText(this);
        editText.setText(url);

        ((LinearLayout) findViewById(R.id.myLinear)).addView(editText);

        ImageView imageView = findViewById(R.id.imageView);

//        try {
//            InputStream inputStream = this.getAssets().open("48_px.9.png");
//
//            imageView.setImageDrawable(Drawable.createFromStream(inputStream, "48_px.9.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        int cacheSize = 50 * 1024 * 1024; // 50 MiB
//        File cacheDir = new File(this.getCacheDir(), "HttpCache");
//        if (!cacheDir.exists()) {
//            try {
//                cacheDir.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        Cache cache = new Cache(cacheDir, cacheSize);
//        OkHttpClient client = new OkHttpClient.Builder()
//                .cache(cache)
//                .build();

//        sendHttpRequest(client);

//
//        Picasso.get().load(Uri.parse(url))
//                .into(imageView);

        int w = 200, h = 300;
//        photoView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                sendHttpRequest(client);
////                imageView.setLayoutParams(new LinearLayout.LayoutParams(w,h));
//                Picasso.get().load(Uri.parse(url))
//                        .memoryPolicy(MemoryPolicy.NO_STORE)
//                        .into(imageView, new Callback() {
//                            @Override
//                            public void onSuccess() {
//                            }
//
//                            @Override
//                            public void onError(Exception e) {
//                            }
//                        });
//            }
//        });


        Picasso.get().load(Uri.parse(url))
                .placeholder(R.drawable.com_mixpanel_android_arrowleft)
                .into(photoView, new Callback() {
                    @Override
                    public void onSuccess() {

                    }
                    @Override
                    public void onError(Exception e) {

                    }
                });

//        Drawable arrowDrawable1 = getResources().getDrawable(R.drawable.com_mixpanel_android_arrowleft);
//        arrowDrawable1.setAutoMirrored(true);
//
//        imageView.setImageDrawable(arrowDrawable1);
//        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override
    protected void onResume() {
        Log.d("TESLOCK", "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("TESLOCK", "onPause");
        super.onPause();
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 2: {
               if(!ArrayUtils.toArrayList(ArrayUtils.toWrapperArray(grantResults)).contains(new Integer(-1))){
                   flClient.requestLocationUpdates(locationRequest,callback, null);
                   Toast.makeText(this, "LOCATION TAKEN ", Toast.LENGTH_LONG).show();
               }
           }
       }
    }

    public Call sendHttpRequest(OkHttpClient client) {

        OkHttpCallbackClass callback = new OkHttpCallbackClass(){
            @Override
            public void onFailure(Call call, IOException e) {
                super.onFailure(call, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                response.code();
                CacheControl control = response.cacheControl();
                boolean isFromCache = isFromCache(response);
                super.onResponse(call, response);
            }
        };

        Request rs = createRequest();
        Call newCall = client.newCall(rs);
        newCall.enqueue(callback);

        return newCall;

    }

    public Request createRequest( ) {

        Request.Builder request = new Request.Builder();
//        request.cacheControl(CacheControl.FORCE_NETWORK);
        request.url("https://uatapclite.upskwt.com:5050/Pictures/Profile/03503603.png");
        request.method("GET",null);

        return request.build();
    }

    public class OkHttpCallbackClass implements okhttp3.Callback {

        @Override
        public void onFailure(Call call, IOException e) {
            System.out.println("onFailure " +  e.getMessage());
            e.printStackTrace();
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            System.out.println("response " +  response.body().string() + "  message   " + response.headers().toString() + response);
        }
    }


    public boolean isFromCache(Response response) {
        return response.cacheResponse() != null;
    }

}
