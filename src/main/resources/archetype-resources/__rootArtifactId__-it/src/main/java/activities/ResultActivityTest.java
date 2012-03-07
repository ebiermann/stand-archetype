package ${package}.activities;

import android.content.Intent;
import de.akquinet.android.marvin.AndroidTestCase;

import java.util.concurrent.TimeoutException;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.CoreMatchers.*;

public class ResultActivityTest extends AndroidTestCase {
    
    public void testResultIsComputedFromIntent() throws TimeoutException {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClass(getInstrumentation().getTargetContext(), ResultActivity.class);
        intent.putExtra("number1", 42);
        intent.putExtra("number2", 47);

        ResultActivity activity = (ResultActivity) perform().startActivity(intent);

        assertThat(activity, is(not(nullValue())));
        await().condition(activity.result, is(89L), 15, SECONDS);
    }
}
