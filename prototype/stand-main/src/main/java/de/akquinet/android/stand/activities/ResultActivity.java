package de.akquinet.android.stand.activities;

import android.widget.TextView;
import de.akquinet.android.androlog.Log;
import de.akquinet.android.roboject.RobojectActivity;
import de.akquinet.android.roboject.annotations.InjectExtra;
import de.akquinet.android.roboject.annotations.InjectLayout;
import de.akquinet.android.roboject.annotations.InjectService;
import de.akquinet.android.roboject.annotations.InjectView;
import de.akquinet.android.stand.services.TestService;

import static de.akquinet.android.stand.services.TestService.*;

@InjectLayout("result")
public class ResultActivity extends RobojectActivity {
    @InjectService(clazz = TestService.class)
    AdderService adderService;
    
    @InjectView TextView addResultText;
    
    @InjectExtra int number1;
    @InjectExtra int number2;
    
    long result;
    
    @Override
    public void onServicesConnected() {
        super.onServicesConnected();
        
        result = adderService.add(number1, number2);
    }

    @Override
    public void onReady() {
        super.onReady();
        addResultText.setText(String.valueOf(result));
        Log.i("Displayed result " + result + " to user");
    }
}
