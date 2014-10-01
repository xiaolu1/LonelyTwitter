package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class TweetListModel 
{

	private ArrayList<LonelyTweetModel> tweets;
	
	public void addTweet(LonelyTweetModel lonelyTweetModel)
	{
		if (tweets.contains(lonelyTweetModel))
			throw new IllegalArgumentException();
		else{
			tweets.add(lonelyTweetModel);
		}
		// TODO Auto-generated method stub
	}

	public TweetListModel()
	{

		super();
		tweets=new ArrayList<LonelyTweetModel>();
		// TODO Auto-generated constructor stub
	}

	public int getCount()
	{

		// TODO Auto-generated method stub
		return tweets.size();
	}

	public boolean hasTweet(LonelyTweetModel temp)
	{
		return tweets.contains(temp);

	}

	public void removeTweet(int i)
	{

		tweets.remove(i);
		
	}

	public List<LonelyTweetModel> getTweets()
	{
		List<LonelyTweetModel> otherTweets= new ArrayList<LonelyTweetModel>();

		//LonelyTweetModel tweet;
		for(int i=0;i<tweets.size();i++)
		{
			otherTweets.add(tweets.get(i));
		}
		Collections.sort(otherTweets, new Comparator<LonelyTweetModel>(){
			public int compare(LonelyTweetModel tweet1, LonelyTweetModel tweet2){
				return tweet1.getTimestamp().compareTo(tweet2.getTimestamp());
			}
			
		});
		// TODO Auto-generated method stub
		return otherTweets;
	}

}
