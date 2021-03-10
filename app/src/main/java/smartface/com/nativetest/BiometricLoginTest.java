package smartface.com.nativetest;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;


import com.google.android.exoplayer2.util.Log;

import java.util.concurrent.Executor;

public class BiometricLoginTest extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_test);

        Context ctx = this;
        Executor executor = ContextCompat.getMainExecutor(this);
        BiometricPrompt biometricPrompt = new BiometricPrompt(this, executor, new BiometricPrompt.AuthenticationCallback() {
                    @Override
                    public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                        Toast.makeText(ctx, "SUCCESS " , Toast.LENGTH_SHORT).show();
                        super.onAuthenticationSucceeded(result);
                    }

                    @Override
                    public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                        super.onAuthenticationError(errorCode, errString);
                        Toast.makeText(ctx, "Error " + errString, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAuthenticationFailed() {
                        super.onAuthenticationFailed();
                        Toast.makeText(ctx, "FAILED !! " , Toast.LENGTH_SHORT).show();
                    }
                });

        BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Title")
                .setNegativeButtonText("NegativeButton")
                .setConfirmationRequired(true)
                .build();

        Button btn = findViewById(R.id.biometricLoginBtn);

        btn.setOnClickListener((view) -> {

            BiometricManager biometricManager = BiometricManager.from(this);
            int authenticateType = biometricManager.canAuthenticate();
            switch (authenticateType) {
                case BiometricManager.BIOMETRIC_SUCCESS:
                    Toast.makeText(this, "App can authenticate using biometrics.", Toast.LENGTH_SHORT).show();
                    break;
                case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                    Toast.makeText(this, "No biometric features available on this device.", Toast.LENGTH_SHORT).show();
                    break;
                case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                    Toast.makeText(this, "Biometric features are currently unavailable.", Toast.LENGTH_SHORT).show();
                    break;
                case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                    Toast.makeText(this, "BIOMETRIC_ERROR_NONE_ENROLLED", Toast.LENGTH_SHORT).show();
                    break;
            }

            biometricPrompt.authenticate(promptInfo);
        });
    }
}
