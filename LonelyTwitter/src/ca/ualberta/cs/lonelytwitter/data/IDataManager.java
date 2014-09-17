package ca.ualberta.cs.lonelytwitter.data;

import java.util.ArrayList;
import java.util.List;

import ca.ualberta.cs.lonelytwitter.AbstractTweet;
import ca.ualberta.cs.lonelytwitter.Tweet;


public interface IDataManager
{
	public ArrayList<AbstractTweet> loadTweets();
	public void saveTweets(List<AbstractTweet> lts);


	
}
