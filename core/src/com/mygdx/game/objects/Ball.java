package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
//import com.mygdx.game.screens.MainGameScreen;
import com.mygdx.game.sounds.WallCollide;
import java.util.Random;

public class Ball {
	
	private int xSpeed, ySpeed;
	public int x, y, size;
	private WallCollide collide = new WallCollide();
	float time = 0;
	int hasGone;
	Random speedGen = new Random();
	
	public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
		
		this.x = x;
		this.y = y;
		this.size = size;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		
	}
	
	public void update() {
		
		//Moving the ball
		x += xSpeed;
		y += ySpeed;
		
		//Checking Border Collision
		if (x < size || x > Gdx.graphics.getWidth() - size) {
		
			xSpeed = -xSpeed;
			collide.create();
		}
			
		if (y < size || y > Gdx.graphics.getHeight() - size) {
			
			ySpeed = -ySpeed;
			collide.create();	

		}
		
		//Incrementing time variable (game clock)
		time += Gdx.graphics.getDeltaTime();
		
		//Checking if timer has hit a multiple of 15 and if so call change speed function
		if ((int)time % 15 == 0 && (int)time != 0 && hasGone == 0 ) {
				
				changeSpeed();
				changeSize();
				hasGone = 1;
				
		}
		
		//Make sure change speed function is only called once per multiple 
		if ((int)time % 15 != 0)
			hasGone = 0;
		
	}
	
	public void draw(ShapeRenderer shape) {
		
		//Draw lime color ball at specific parameters
		shape.setColor(Color.LIME);
		shape.circle(x, y, size);		
	}
	
	public void changeSpeed() {
		
		//Change speed of the ball				
		xSpeed = speedGen.nextInt(20) + 1;
		ySpeed = speedGen.nextInt(20) + 1;
				
		System.out.println("method called speed changed");

		System.out.println(time);
	}
	
	public void changeSize() {
		
		System.out.println("Ball size has changed");
		size = speedGen.nextInt(35) + 5;
	}
		
	public void dispose() {
		
		collide.dispose();
	}

}
