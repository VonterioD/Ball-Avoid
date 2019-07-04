package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.game.MyGame;

public class Options implements Screen {

	private MyGame game;
	private Stage optionsStage;
	private Skin optionsSkin;
	private TextureAtlas optionsAtlas = new TextureAtlas(Gdx.files.internal("ui/uiskin.atlas"));
	
	public Options(MyGame game){
		this.game = game;
		
		optionsStage = new Stage();
		Gdx.input.setInputProcessor(optionsStage);
		
		optionsSkin = new Skin(Gdx.files.internal("ui/uiskin2.json"), optionsAtlas);
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		initButtons();

	}
	
	public void initButtons() {
		System.out.println("yah");
		
		TextButton start = new TextButton("Start", optionsSkin, "default");
		start.setSize(150, 50);
		start.setPosition(0, 0);
		
		optionsStage.addActor(start);
	}
	
	public void stageUpdate(float delta) {
		optionsStage.act(delta);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stageUpdate(delta);
		
		optionsStage.draw();

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
