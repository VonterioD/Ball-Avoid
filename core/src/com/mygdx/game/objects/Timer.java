package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.utils.Disposable;

public class Timer implements Disposable {
	
	private BitmapFont font;
	public FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("GRAYMALKINCOMPACADCON.TTF"));
	private FreeTypeFontParameter params = new FreeTypeFontParameter();
	public float dt = 0;
	CharSequence str;	
	
	private int increment = 0;
	private int increment2 = 0;
	private int AlertVal1 = 20;
	private int AlertVal2 = 10;
	
	public Timer() {
		
		params.size = 20;
		params.color = Color.GOLD;
		params.borderColor = Color.WHITE;
		params.borderWidth = .2f;
		font = gen.generateFont(params);		
	}
	
	public void drawTime(SpriteBatch batch) {
			
		dt += Gdx.graphics.getDeltaTime();
		str = Float.toString(dt);
		String counter = String.format("%.4s", str);
		font.draw(batch, counter, Gdx.graphics.getWidth()/2 - 30 , Gdx.graphics.getHeight() - 10);
		
	}
	
	//Relevant for ball spawning
	public boolean thirtySecPassed() {
		
		if ((int)dt % 30 == 0 && (int)dt != 0)
			
			return true;
		
		else
			return false;
	}

	//Relevant for displaying alert for ball spawn
	public boolean tenSecPrior() {
		
		while((int) dt == AlertVal1 + increment) {
			
			increment += 30;
			return true;
			
		}
			
		return false;	
	}
	
	//Relevant for changing speed and size of balls
	public boolean fifteenSecPassed() {
		
		if((int) dt % 15 == 0 && (int) dt != 0)
			
			return true;
			
		return false;	
	}
	
	//Relevant for displaying alert for speed and size of balls
	public boolean fiveSecPrior() {
		
		while((int) dt == (AlertVal2 + increment2)) {
			
			increment2 += 15;
			System.out.println(increment2);
			return true;
		}
			
		return false;	
	}

	@Override
	public void dispose() {
		
		gen.dispose();
		font.dispose();
		
	}

}
