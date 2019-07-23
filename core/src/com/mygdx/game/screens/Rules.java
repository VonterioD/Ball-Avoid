package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.MyGame;

public class Rules implements Screen {

	private MyGame game;
	private Stage ruleStage;
	private Skin ruleSkin;
	private TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("ui/uiskin.atlas"));
	
	
	public Rules(MyGame game) {
		
		this.game = game;
		
		//Set the stage
		ruleStage = new Stage();
		Gdx.input.setInputProcessor(ruleStage);
		
		//Setting the skin
		ruleSkin = new Skin(Gdx.files.internal("ui/uiskin2.json"), atlas);
	}
	
	@Override
	public void show() {
		initImages();
		initButtons();
	}
	
	//Load images for this screen and add to stage
	public void initImages() {
		Texture rulesTexture = new Texture(Gdx.files.internal("rules.png"));
		Image rulesTitle = new Image(rulesTexture);
		rulesTitle.setBounds(125, 335, 400, 150);
		
		Texture howToPlayTexture = new Texture(Gdx.files.internal("rules and symbols.png"));
		Image howToPlay = new Image(howToPlayTexture);
		howToPlay.setPosition(0, -5);
		
		
		ruleStage.addActor(howToPlay);
		ruleStage.addActor(rulesTitle);
	}
	
	public void initButtons() {
		
		//Start Button
		TextButton start = new TextButton("Start", ruleSkin, "default");
		start.setSize(150, 40);
		start.setPosition(100, 0);
		
		//Go to game screen
		start.addListener(new ClickListener(){
			public void clicked(InputEvent e, float x, float y) {
				game.setScreen(new MainGameScreen(game));
			}		
		});
		
		
		//Main menu button
		TextButton mainMenu = new TextButton("Main Menu", ruleSkin, "default");
		mainMenu.setSize(150, 40);
		mainMenu.setPosition(400, 0);
		
		//Go back to main menu
		mainMenu.addListener(new ClickListener(){
			public void clicked(InputEvent e, float x, float y) {
				game.setScreen(new StartScreen(game));
			}		
		});
			
		ruleStage.addActor(start);
		ruleStage.addActor(mainMenu);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stageUpdate(delta);
		
		ruleStage.draw();
		
	}
	
	public void stageUpdate(float delta) {
		ruleStage.act(delta);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
