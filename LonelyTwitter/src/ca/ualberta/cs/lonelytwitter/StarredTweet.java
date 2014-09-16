package ca.ualberta.cs.lonelytwitter;

import java.io.Serializable;
import java.util.Date;

public class StarredTweet extends AbstractTweet implements Serializable{

	private Date tweetDate;
	private String tweetBody;


	public StarredTweet(Date tweetDate, String tweetBody) {
		super();
		this.tweetDate = tweetDate;
		this.tweetBody = tweetBody;
	}

	public Date getTweetDate() {
		return tweetDate;
	}

	public void setTweetDate(Date tweetDate) {
		this.tweetDate = tweetDate;
	}

	public String getTweetBody() {
		return  "\u2605 "+tweetBody;
	}

	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}

	public String toString() {
		return getTweetBody();
	}
}
