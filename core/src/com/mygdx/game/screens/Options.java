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

public class Options implements Screen {

	private MyGame game;
	private Stage optionsStage;
	private Skin optionsSkin;
	private TextureAtlas optionsAtlas = new TextureAtlas(Gdx.files.internal("ui/uiskin.atlas"));
	public static boolean isFxOn = true;
	
	public Options(MyGame game){
		this.game = game;
		
		//Setting stage
		optionsStage = new Stage();
		Gdx.input.setInputProcessor(optionsStage);
		
		//Creating the skin
		optionsSkin = new Skin(Gdx.files.internal("ui/uiskin2.json"), optionsAtlas);
	}
	
	@Override
	public void show() {
		//Create buttons
		initImages();
		initButtons();

	}
	
	//Create images on screen
	public void initImages() {
		//Options title image
		Texture optionsTxt = new Texture(Gdx.files.internal("options.png"));
		Image optionsTitle = new Image(optionsTxt);
		optionsTitle.setBounds(125, 335, 400, 150);
		
		//Options text
		Texture soundAndMusicTxt = new Texture(Gdx.files.internal("options screen text.png"));
		Image soundAndMusic = new Image(soundAndMusicTxt);
		soundAndMusic.setPosition(45, 150);
		
		optionsStage.addActor(soundAndMusic);
		optionsStage.addActor(optionsTitle);
	}
	
	public void initButtons() {
		
		//Start button
		TextButton start = new TextButton("Start", optionsSkin, "default");
		start.setSize(150, 50);
		start.setPosition(100, 50);
		
		//Go to game screen
		start.addListener(new ClickListener(){
			public void clicked(InputEvent e, float x, float y) {
				game.setScreen(new MainGameScreen(game));
			}		
		});
		
		TextButton menu = new TextButton("Menu", optionsSkin, "default");
		menu.setSize(150, 50);
		menu.setPosition(400, 50);
		
		//Go to main menu
		menu.addListener(new ClickListener(){
			public void clicked(InputEvent e, float x, float y) {
				game.setScreen(new StartScreen(game));
			}		
		});
		
		//Creating on off buttons for both music and soundFX
		
		TextButton soundOn = new TextButton("On", optionsSkin, "default");
		soundOn.setSize(130, 45);
		soundOn.setPosition(275, 245);
		
		//Turn music on
		soundOn.addListener(new ClickListener(){
			public void clicked(InputEvent e, float x, float y) {
				MyGame.backgroundMusic.setVolume();
			}		
		});
		
		TextButton soundOff = new TextButton("Off", optionsSkin, "default");
		soundOff.setSize(130, 45);
		soundOff.setPosition(430, 245);
		
		//Turn music off
		soundOff.addListener(new ClickListener(){
			public void clicked(InputEvent e, float x, float y) {
				MyGame.backgroundMusic.mute();
			}		
		});
		
		TextButton fxOn = new TextButton("On", optionsSkin, "default");
		fxOn.setSize(130, 45);
		fxOn.setPosition(275, 155);
		
		//Turn sound fx on 
		fxOn.addListener(new ClickListener(){
			public void clicked(InputEvent e, float x, float y) {
				isFxOn = true;
			}		
		});
		
		TextButton fxOff = new TextButton("Off", optionsSkin, "default");
		fxOff.setSize(130, 45);
		fxOff.setPosition(430, 155);
		
		//Turn sound fx off
		fxOff.addListener(new ClickListener(){
			public void clicked(InputEvent e, float x, float y) {
				isFxOn = false;
			}		
		});
		
		//Add buttons to stage
		optionsStage.addActor(soundOn);
		optionsStage.addActor(soundOff);
		optionsStage.addActor(fxOn);
		optionsStage.addActor(fxOff);
		optionsStage.addActor(start);
		optionsStage.addActor(menu);
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
