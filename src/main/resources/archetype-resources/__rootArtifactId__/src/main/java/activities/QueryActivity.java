package ${package}.activities;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import de.akquinet.android.androlog.Log;
import de.akquinet.android.roboject.RobojectActivity;
import de.akquinet.android.roboject.annotations.InjectLayout;
import de.akquinet.android.roboject.annotations.InjectView;

@InjectLayout("query")
public class QueryActivity extends RobojectActivity {
    @InjectView private Button showResultButton;
    @InjectView private EditText number1Input;
    @InjectView private EditText number2Input;

    @Override
    public void onReady() {
        super.onReady();

        showResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int number1 = Integer.parseInt(number1Input.getText().toString());
                    int number2 = Integer.parseInt(number2Input.getText().toString());

                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("number1", number1);
                    intent.putExtra("number2", number2);
                    
                    Log.i("Starting activity ResultActivity");
                    startActivity(intent);
                } catch (NumberFormatException e) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter two integer values", 3);
                    toast.show();
                }
            }
        });
    }
}
