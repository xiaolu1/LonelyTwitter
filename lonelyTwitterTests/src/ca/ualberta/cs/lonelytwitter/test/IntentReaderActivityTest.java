package ca.ualberta.cs.lonelytwitter.test;

//import android.annotation.SuppressLint;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;

//@SuppressLint("NewApi") 
public class IntentReaderActivityTest extends
        ActivityInstrumentationTestCase2<IntentReaderActivity> {

    public IntentReaderActivityTest() {
        super(IntentReaderActivity.class);
    }

    public void testSendText() {
        Intent intent = new Intent();
        String text = "hello";
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, text);
        
        setActivityIntent(intent);
        IntentReaderActivity activity = getActivity();
        
        assertEquals("IntentReaderActivity should get text from intent!", text, activity.getText());
    }    
    
    public void testDisplayText() {
        Intent intent = new Intent();
        String str = "hello";
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, str);
        
        setActivityIntent(intent);
        IntentReaderActivity activity = getActivity();

        TextView textView = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
        assertEquals("Tex should be displayed.", str, textView.getText().toString());
    }
    
    public void testDoubleText() {
        Intent intent = new Intent();
        String text = "hello";
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, text);
        intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
        
        setActivityIntent(intent);
        IntentReaderActivity activity = getActivity();
        
        assertEquals("The text should be repeated.", "hellohello", activity.getText());
    }
    
//---------------------------------------------------------------------------
    public void testReverseText() {
        Intent intent = new Intent();
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "Hello");
        intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.REVERSE);
        
        setActivityIntent(intent);
        IntentReaderActivity activity = getActivity();
        
        assertEquals("IntentReaderActivity should reverse the text", "olleH", activity.getText());
    }
    
    public void testDefaultMessage() {
        Intent intent = new Intent();
        //if there is no extras, then the mode will be DEFAULT and the text will be "default text". So there is no need to the next line:
        //intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.NORMAL);
        setActivityIntent(intent);
        IntentReaderActivity activity = getActivity();
        
        TextView textView = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
        assertEquals("Text should be displayed", textView.getText().toString(), "default text");
    }
    
    public void testTextViewIsVisible() {
    	Intent intent = new Intent();
        String text = "hello";
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, text);
        intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.REVERSE);
        
        setActivityIntent(intent);
        IntentReaderActivity activity = getActivity();
        //To assert that the first parameter contains the second parameter 
        //(getDecorView() gives a view that contains anything on screen)   (the textView: "intentText")
        ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), 
        		activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText));
    }
       
}