package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


public class StartedTweet extends AbstractTweet
{
	public StartedTweet(Date tweetDate, String tweetBody) {
		super();
		this.tweetDate = tweetDate;
		this.tweetBody = tweetBody;
	}

	public String getTweetBody() {
		return "\u2605" + tweetBody;
	}

	public String toString() {
		return getTweetBody();
	}

}
