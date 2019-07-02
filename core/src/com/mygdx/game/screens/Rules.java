package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
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
		// TODO Auto-generated method stub
		initButtons();
		
	}
	
	public void initButtons() {
		
		TextButton start = new TextButton("Start", ruleSkin, "default");
		start.setSize(150, 50);
		start.setPosition(0, 0);
		
		TextButton mainMenu = new TextButton("Main Menu", ruleSkin, "default");
		mainMenu.setSize(150, 50);
		mainMenu.setPosition(151, 0);
		
		
		ruleStage.addActor(start);
		ruleStage.addActor(mainMenu);
	}
	
	public void createImages() {
		
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
