package com.mygdx.game;

import com.badlogic.gdx.Game;
//import com.mygdx.game.screens.EndGameScreen;
import com.mygdx.game.screens.*;
import com.mygdx.game.sounds.BGMusic;


public class MyGame extends Game {
	
	//Create background music here so each time I go back to menu, new sound is not created
	public static BGMusic backgroundMusic = new BGMusic();
	
	@Override 
	public void create () {

		backgroundMusic.create();
		//this.setScreen(new MainGameScreen(this));
		this.setScreen(new StartScreen(this));
	}

	@Override
	public void render () {

		super.render();

	}
	
	@Override
	public void dispose () {

	}
	
}
