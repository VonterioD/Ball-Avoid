package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.MyGame;
import com.mygdx.game.sounds.BGMusic;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;


public class StartScreen implements Screen {
	
	private Texture startImage = new Texture(Gdx.files.internal("Title2.png"));
	private SpriteBatch batch;
	private Sprite titlePic;
	private Image titleImage;
	private Stage stage;
	private Skin skin;
	private TextureAtlas atlas;
	private MyGame game;
	
	public BGMusic backgroundMusic;
	
	public StartScreen(MyGame game) {
		
		this.game = game;
		//Set the stage
		this.stage = new Stage();	
		Gdx.input.setInputProcessor(stage);	
		
		//Create title image and add to stage
		titleImage = new Image(startImage);
		stage.addActor(titleImage);
		
		//Create skin
		atlas = new TextureAtlas(Gdx.files.internal("ui/uiskin.atlas"));
		this.skin = new Skin(Gdx.files.internal("ui/uiskin2.json"), atlas);

		
		
	}
	
	private void initButtons() {
		
		//Start Button
		TextButton start = new TextButton("Start", skin, "default");
		start.setSize(150, 50);
		start.setPosition(250, 200); //height divided by 2 = 240 height = 480
		start.addAction(alpha(0));
		start.addAction(fadeIn(5f));
		
		//When clicked go to main game screen
		start.addListener(new ClickListener() {
			public void clicked(InputEvent e, float x, float y) {
				game.setScreen(new MainGameScreen(game));
			}
		});
		
		//How to play button
		TextButton howTo = new TextButton("How To Play", skin, "default");
		howTo.setSize(150, 50);
		howTo.setPosition(250, 150);
		howTo.addAction(alpha(0));
		howTo.addAction(fadeIn(5f));
			
		//Options Button
		TextButton options = new TextButton("Options", skin, "default");
		options.setSize(150, 50);
		options.setPosition(250, 100);
		options.addAction(alpha(0));
		options.addAction(fadeIn(5f));
		
		//Add all buttons to stage
		stage.addActor(start);
		stage.addActor(howTo);
		stage.addActor(options);
	}

	@Override
	public void show() {
		titleImage.setBounds(125, 315, 400, 150);
		titleImage.addAction(alpha(0));
		titleImage.addAction(fadeIn(5f));
		batch = new SpriteBatch();
		
		initButtons();
		startMusic();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		/*batch.begin();
		titlePic.draw(batch);
		batch.end();*/
		
		stageUpdate(delta);
		
		stage.draw();
		
		
	}
	
	private void startMusic() {
		backgroundMusic = new BGMusic();
		backgroundMusic.create();
	}
	
	public void stageUpdate (float delta) {
		stage.act(delta);
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
		stage.dispose();
		skin.dispose();
		backgroundMusic.dispose();
	}

}
