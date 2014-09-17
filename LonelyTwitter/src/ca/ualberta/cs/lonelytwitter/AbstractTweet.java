package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


public abstract class AbstractTweet
{
	public Date tweetDate;
	public String tweetBody;
	
	public abstract String getTweetBody();
	public abstract String toString();
	
	public Date getTweetDate() {
		return tweetDate;
	}

	public void setTweetDate(Date tweetDate) {
		this.tweetDate = tweetDate;
	}


	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}
	
	public int getLength(){
		return tweetBody.length();
	}
	
}
