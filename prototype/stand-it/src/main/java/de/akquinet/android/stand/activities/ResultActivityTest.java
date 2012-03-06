package de.akquinet.android.stand.activities;

import android.app.Activity;
import android.content.Intent;
import de.akquinet.android.marvin.ActivityTestCase;
import de.akquinet.android.marvin.AndroidTestCase;
import de.akquinet.android.stand.activities.ResultActivity;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;

public class ResultActivityTest extends AndroidTestCase {
    
    public void testResultIsComputedFromIntent() throws TimeoutException {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClass(getInstrumentation().getTargetContext(), ResultActivity.class);
        intent.putExtra("number1", 42);
        intent.putExtra("number2", 47);

        ResultActivity activity = (ResultActivity) perform().startActivity(intent);

        assertThat(activity, is(not(nullValue())));
        await().condition(activity.result, is(89L), 15, TimeUnit.SECONDS);
    }
}
