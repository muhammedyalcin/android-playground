package smartface.com.nativetest;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TimeDialogTest extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this ,getResources().getIdentifier("SpinnerTimePickerDialog", "style", getPackageName()), (timePicker, i ,i1) -> {

        }, 10,10,false);

        timePickerDialog.show();

        setContentView(new View(this));
    }
}
