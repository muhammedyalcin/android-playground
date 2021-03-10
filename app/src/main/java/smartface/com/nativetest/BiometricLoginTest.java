package smartface.com.nativetest;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;


import java.util.concurrent.Executor;

public class BiometricLoginTest extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_test);

        EditText editText = findViewById(R.id.editText);

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                EditText editText1 = (EditText) view;
                Editable text = editText.getText();
                System.out.println(text.toString());
            }
        });

        Executor executor = ContextCompat.getMainExecutor(this);
        BiometricPrompt biometricPrompt = new BiometricPrompt(this, executor, new BiometricPrompt.AuthenticationCallback() {
                    @Override
                    public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                        super.onAuthenticationSucceeded(result);
                    }

                    @Override
                    public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                        super.onAuthenticationError(errorCode, errString);
                    }

                    @Override
                    public void onAuthenticationFailed() {
                        super.onAuthenticationFailed();
                    }
                });

        BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Title")
                .setNegativeButtonText("NegativeButton")
                .setConfirmationRequired(true)
                .build();

        Button btn = findViewById(R.id.biometricLoginBtn);

        btn.setOnClickListener((view) -> {
            editText.setSelection(0, 0);
            editText.clearFocus();

//            BiometricManager biometricManager = BiometricManager.from(this);
//            int authenticateType = biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG);
//            switch (authenticateType) {
//                case BiometricManager.BIOMETRIC_SUCCESS:
//                    Log.d("MY_APP_TAG", "App can authenticate using biometrics.");
//                    break;
//                case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
//                    Log.e("MY_APP_TAG", "No biometric features available on this device.");
//                    break;
//                case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
//                    Log.e("MY_APP_TAG", "Biometric features are currently unavailable.");
//                    break;
//                case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
//                    // Prompts the user to create credentials that your app accepts.
////                    final Intent enrollIntent = new Intent(Settings.ACTION_BIOMETRIC_ENROLL);
////                    enrollIntent.putExtra(Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED,
////                            BIOMETRIC_STRONG | DEVICE_CREDENTIAL);
////                    startActivityForResult(enrollIntent, REQUEST_CODE);
//                    break;
//            }

            biometricPrompt.authenticate(promptInfo);
        });
    }
}
