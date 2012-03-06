package de.akquinet.android.stand.activities;

import de.akquinet.android.marvin.ActivityTestCase;
import de.akquinet.android.stand.R;
import de.akquinet.android.stand.activities.QueryActivity;
import de.akquinet.android.stand.activities.ResultActivity;
import org.hamcrest.core.IsNull;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.*;

public class QueryActivityTest extends ActivityTestCase<QueryActivity> {
    public QueryActivityTest() {
        super(QueryActivity.class);
    }

    public void testShowResultButtonStartsResultActivity() {
        activity().view().withId(R.id.number1Input).setText("42");
        activity().view().withId(R.id.number2Input).setText("47");
        activity().view().withId(R.id.showResultButton).click();

        ResultActivity resultActivity = await().activity(ResultActivity.class, 15, TimeUnit.SECONDS);
        assertThat(resultActivity, is(not(nullValue())));
    }
}
