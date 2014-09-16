package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class AbstractTweet {

	public abstract Date getTweetDate();

	public abstract void setTweetDate(Date tweetDate) ;
	
	public abstract String getTweetBody();

	public abstract void setTweetBody(String tweetBody);

	public abstract String toString() ;
}
