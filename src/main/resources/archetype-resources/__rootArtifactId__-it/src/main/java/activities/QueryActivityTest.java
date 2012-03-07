package ${package}.activities;

import de.akquinet.android.marvin.ActivityTestCase;
import ${package}.R;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

public class QueryActivityTest extends ActivityTestCase<QueryActivity> {
    public QueryActivityTest() {
        super(QueryActivity.class);
    }

    public void testShowResultButtonStartsResultActivity() {
        activity().view().withId(R.id.number1Input).setText("42");
        activity().view().withId(R.id.number2Input).setText("47");
        activity().view().withId(R.id.showResultButton).click();

        ResultActivity resultActivity = await().activity(ResultActivity.class, 15, SECONDS);
        assertThat(resultActivity, is(not(nullValue())));
    }
}
