package com.mygdx.game.objects;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.objects.Ball;



public class Controller extends Game {
	
	public float x = 30;
	public float y = 30;
	public int radius = 25;
	final int SPEED = 550;
	public Color color = Color.CYAN;
  	
	@Override
	public void create() {
			
	}
	
	public void draw(ShapeRenderer control) {

		control.setColor(color);
		control.circle(x, y, radius);
				
	}
	
	public void update () {
		
		//Left and Right Movement
		if (Gdx.input.isKeyPressed(Keys.LEFT))
			x -= SPEED * Gdx.graphics.getDeltaTime();
		
		if (Gdx.input.isKeyPressed(Keys.RIGHT))
			x += SPEED * Gdx.graphics.getDeltaTime();
		
		//Up and Down Movement
		if (Gdx.input.isKeyPressed(Keys.DOWN))
			y -= SPEED * Gdx.graphics.getDeltaTime();
		
		if (Gdx.input.isKeyPressed(Keys.UP))
			y += SPEED * Gdx.graphics.getDeltaTime();
		
	    //X bounds		
		if (x <= radius)
			x = radius + 1;
		
		if (x > Gdx.graphics.getWidth() - radius)
			x = Gdx.graphics.getWidth() - radius - 1;
		
	    //Y bounds		
		if (y <= radius)
			y = radius + 1;
		
		if (y > Gdx.graphics.getHeight() - radius)
			y = Gdx.graphics.getHeight() - radius - 1;
					
	    			
	}
	
	//Check for collision with ball object
	public boolean overlaps (Ball ball) {
		float dx = x - ball.x;
		float dy = y - ball.y;
		float distance = dx * dx + dy * dy;
		float radiusSum = radius + ball.size;
		return distance < radiusSum * radiusSum;
	}
	
	public void dispose() {
		
		
	}
	
	

}
