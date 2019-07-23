package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.MyGame;
import com.mygdx.game.objects.*;
import com.mygdx.game.sounds.BGMusic;
import com.mygdx.game.sounds.BallsColliding;
import com.mygdx.game.actions.Alert;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;



public class MainGameScreen implements Screen {
	
	MyGame game;
	//private Ball ball;
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	private ShapeRenderer shape;
	private SpriteBatch batch;
	private Timer time;
	private Controller control = new Controller();
	private BallsColliding collideSound = new BallsColliding();
	private Alert alert = new Alert();
	private Healthbar healthbar = new Healthbar();
	
	Random gen = new Random();
	DecimalFormat df = new DecimalFormat("#.00");
	
	private int size = gen.nextInt(25) + 5;
	private int ball_x = gen.nextInt(100) + size;
	private int ball_y = gen.nextInt(100) + size;
	private int speed_x = gen.nextInt(15) + 1;
	private int speed_y = gen.nextInt(15) + 1;
	private int hasThirty = 0, hasCollided = 0, tenPrior = 0, fivePrior = 0, healthcounter = 0;
	double score;
	public String actualScore; 
	
	
	
	public MainGameScreen(MyGame game) {

		this.game = game;
	}



	@Override
	public void show() {
				
		shape = new ShapeRenderer();
		batch = new SpriteBatch();
		time = new Timer();
		//alert = new Alert();
		balls.add(new Ball(ball_x, ball_y, size, speed_x, speed_y));
		collideSound.create();
		healthbar.addTextures();
	
	}

	@Override
	public void render(float delta) {
		
		
		//Clear the screen
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//Controlled ball
		control.color = Color.CYAN;
		control.update();
		shape.begin(ShapeRenderer.ShapeType.Filled);
		control.draw(shape);
		shape.end(); 		
		
		//Create bouncing balls
		for (Ball ball : balls) {
			
			ball.update();
			shape.begin(ShapeRenderer.ShapeType.Filled);
			ball.draw(shape);
			shape.end();
			
			//When ball and controller collide make collision sound effect and flash to Red
			if (control.overlaps(ball) == true) {
				
				collideSound.render();
				control.color = Color.RED;
				shape.begin(ShapeRenderer.ShapeType.Filled);
				control.draw(shape);
				shape.end();
				hasCollided = 1;								
			}
			
			if (control.overlaps(ball) == false && hasCollided == 1) {
				healthcounter++;
				hasCollided = 0;
			}
			
		}
				
		//Drawing the timer
		batch.begin();
		time.drawTime(batch);
		batch.end();
		
		//Adding Balls Every 30 seconds
		if (time.thirtySecPassed() == true && hasThirty == 0) {
			
			balls.add(new Ball(gen.nextInt(100) + size, gen.nextInt(100) + size, 
					gen.nextInt(25) + 5, gen.nextInt(15) + 1, gen.nextInt(15) + 1));
			
			hasThirty = 1;
		}
		
		if ((int)time.dt % 30 != 0)
			hasThirty = 0;
		
		//Setting T or F Var for Ball Spawn
		if (time.tenSecPrior())
			tenPrior = 1;
		
		if (time.thirtySecPassed())
			tenPrior = 0;
		
		//Setting T or F Var for speed and size change
		if (time.fiveSecPrior())
			fivePrior = 1;
		
		if (time.fifteenSecPassed())
			fivePrior = 0;
		
		if (tenPrior == 1) {
			
			batch.begin();
			alert.showAlertTwenty(batch);				
			batch.end();
			
		}
		
		if (fivePrior == 1) {
			
			batch.begin();
			alert.showAlertTen(batch);				
			batch.end();			
		}
		
		
		//Draw the healthbar
		batch.begin();
		Healthbar.health.get(healthcounter).setSize(180f, 30f);
		Healthbar.health.get(healthcounter).setPosition(2, 450);
		Healthbar.health.get(healthcounter).draw(batch);;
		batch.end();
		
		if (healthcounter >= 4) {
			
			score = time.dt;
			actualScore = df.format(score);
			System.out.println(actualScore);
			dispose();
			goToEndScreen();			
		}

		
		
	}
	
	public void goToEndScreen() {
		
		game.setScreen(new EndGameScreen(game, actualScore));
		MyGame.backgroundMusic.dispose();
		
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {

		
	}

	@Override
	public void resume() {

		
	}

	@Override
	public void hide() {

		
	}

	@Override
	public void dispose() {
		
		//collideSound.dispose();
		//time.dispose();
		healthbar.dispose();
		control.dispose();
		shape.dispose();
		batch.dispose();
		
		
	}

}
