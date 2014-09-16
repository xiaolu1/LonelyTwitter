package ca.ualberta.cs.lonelytwitter.managers;

import java.util.ArrayList;

import ca.ualberta.cs.lonelytwitter.AbstractTweet;

public interface TweetManager {
	
	public ArrayList<AbstractTweet> loadTweets();
	
	public void saveTweets(ArrayList<AbstractTweet> lts) ;

}
