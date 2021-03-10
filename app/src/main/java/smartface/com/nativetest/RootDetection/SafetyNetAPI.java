package smartface.com.nativetest.RootDetection;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public final class SafetyNetAPI {
    final String apiKey;
    final Context context;

    public SafetyNetAPI(String apiKey, Context cxt){
        this.apiKey = apiKey;
        this.context= cxt;
    }

    public void sendAttestationRequest(String nonce){
        SafetyNet.getClient(context).attest(nonce.getBytes(StandardCharsets.UTF_8), apiKey)
                .addOnSuccessListener(new OnSuccessListener<SafetyNetApi.AttestationResponse>() {
                    @Override
                    public void onSuccess(SafetyNetApi.AttestationResponse attestationResponse) {
                       String safetynetJws = attestationResponse.getJwsResult();

                        Log.d("SAFETYTEST", "onSuccess:  "+safetynetJws);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("SAFETYTEST", "onFailure:  "+e.getMessage());
                    }
                });
    }

    public String generateNonce(){
        byte[] rByte = new byte[17];
        new Random().nextBytes(rByte);
        return  new String(rByte, StandardCharsets.UTF_8);
    }

    public boolean isPlayServicesAvailable(){
       return (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == ConnectionResult.SUCCESS) ? true : false;
    }
}
