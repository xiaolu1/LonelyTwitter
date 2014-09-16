package ca.ualberta.cs.lonelytwitter.managers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import android.util.Log;

import ca.ualberta.cs.lonelytwitter.AbstractTweet;

public class TweetFileManager implements TweetManager{
	
	private static final String FILENAME = "file.sav";

	public ArrayList<AbstractTweet> loadTweets() {
		ArrayList<AbstractTweet> lts = new ArrayList<AbstractTweet>();

		try {
			FileInputStream fis = new FileInputStream(FILENAME);
			ObjectInputStream ois = new ObjectInputStream(fis);

			lts = (ArrayList<AbstractTweet>) ois.readObject();

		} catch (Exception e) {
			Log.i("LonelyTwitter", "Error casting");
			e.printStackTrace();
		} 

		return lts;
	}
	
	public void saveTweets(ArrayList<AbstractTweet> lts) {
		try {
			FileOutputStream fos = new FileOutputStream(FILENAME);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(lts);
			fos.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
