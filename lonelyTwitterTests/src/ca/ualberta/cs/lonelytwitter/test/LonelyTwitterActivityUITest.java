package ca.ualberta.cs.lonelytwitter.test;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;

public class LonelyTwitterActivityUITest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	Instrumentation instrumentation;
	Activity activity;
	EditText textInput;
	
	public LonelyTwitterActivityUITest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		instrumentation = getInstrumentation();
		activity = getActivity();
		textInput = ((EditText) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.body));
	}
	
	 //makeTweet(text) fills in the input text field and clicks the 'save' button for the activity under test:
	private void makeTweet(String text) {
		assertNotNull(activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save));
		textInput.setText(text);
		((Button) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save)).performClick();
	}
	
	//To avoid error: "CalledFromWrongThreadException: Only the original thread that created a view hierarchy can touch its views."
	//That's because "Activities" run on the UI thread. Using this annotation, all the method statements will run on the UI thread:
	@UiThreadTest
	public void testMakeTweet(){
		LonelyTwitterActivity activity = getActivity(); //Get the Activity under test, starting it if necessary. For each test method invocation, the Activity will not actually be created until the first time this method is called
		int old_length = activity.getAdapter().getCount();

		makeTweet("Hello...");
		ArrayAdapter<NormalTweetModel> adapter = activity.getAdapter();
		assertEquals("Length of array adapter is not right!", old_length+1, adapter.getCount());
		
		assertEquals("Did you add NormalTweetModel? It's not that!", true, (adapter.getItem(adapter.getCount() - 1) instanceof NormalTweetModel));
		
		NormalTweetModel tweet = adapter.getItem(adapter.getCount() - 1);
		assertEquals("This is not the text we expected!", tweet.getText(), "Hello...");		
	}
}
