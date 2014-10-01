package ca.ualberta.cs.lonelytwitter.test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.TweetListModel;
import android.test.ActivityInstrumentationTestCase2;
import android.text.format.DateFormat;


public class TweetListModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity>
{

	public TweetListModelTest()
	{

		super(LonelyTwitterActivity.class);
		// TODO Auto-generated constructor stub
	}

	public void testFiveIsFive(){
		assertEquals(5, 5);
		
	}
	public void testTweetListModel(){
		TweetListModel tlm = new TweetListModel();
	}
	
	public void testAddTweet(){
		LonelyTweetModel t1= new LonelyTweetModel("test");
		TweetListModel tlm = new TweetListModel();
		tlm.addTweet(t1);
		try{
			tlm.addTweet(t1);
			fail("No right!");
		}
		catch(IllegalArgumentException e){
			assertTrue(true);
		}

		assertTrue(tlm.getCount()==1);
		
	}
	public void testHasTweet(){
		TweetListModel tlm = new TweetListModel();
		tlm.addTweet(new LonelyTweetModel("test"));
		LonelyTweetModel temp = new LonelyTweetModel("test");
		assertTrue(tlm.hasTweet(temp));
	}
	public void testRemoveTweet(){
		TweetListModel tlm = new TweetListModel();
		tlm.addTweet(new LonelyTweetModel("test"));
		tlm.removeTweet(0);
		assertEquals(tlm.getCount(),0);
	}
	public void testGetTweets(){
		Calendar cal = Calendar.getInstance();
		cal.set(2013, Calendar.JANUARY, 9, 10, 11, 12); //Year, month, day of month, hours, minutes and seconds
		java.util.Date date = cal.getTime();
		TweetListModel tlm = new TweetListModel();
		tlm.addTweet(new LonelyTweetModel("test"));
		tlm.addTweet(new LonelyTweetModel("test1",date));
		//tlm.addTweet(new LonelyTweetModel("test2"));
		List<LonelyTweetModel> newlist = tlm.getTweets();
		//assertTrue(newlist.get(0).getTimestamp().before(newlist.get(1).getTimestamp()));
		int i;
		for (i=0;i<newlist.size()-1;i++){
			assertTrue(newlist.get(i).getTimestamp().before(newlist.get(i+1).getTimestamp()));
		}
	}
}
