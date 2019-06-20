package com.mygdx.game.actions;

//import com.mygdx.game.objects.Timer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Alert {
	
	private BitmapFont alertFont;
	//private Timer time;
	public FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("GRAYMALKINCOMPACADCON.TTF"));
	public FreeTypeFontParameter params = new FreeTypeFontParameter(); 
	public String alert;
	
	public Alert() {
		
		params.size = 20;
		params.color = Color.GOLD;
		params.borderColor = Color.WHITE;
		params.borderWidth = .2f;
		alertFont = gen.generateFont(params);				
	}
	
	public void showAlertTwenty(SpriteBatch batch) {
		
			//Alert for ball spawn		
			alert = "BALL INCOMING!!!";
			alertFont.draw(batch, alert,  Gdx.graphics.getWidth()/2 - 125, 25);
		}
	
	public void showAlertTen(SpriteBatch batch) {
		
		//Alert for speed and ball change
		alert = "SPEED AND SIZE CHANGE INCOMING!";
		alertFont.draw(batch, alert,  Gdx.graphics.getWidth()/2 - 275, 85);
		
	}

}
