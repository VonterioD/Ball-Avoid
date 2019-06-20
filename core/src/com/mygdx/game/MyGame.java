package com.mygdx.game;

import com.badlogic.gdx.Game;
//import com.mygdx.game.screens.EndGameScreen;
import com.mygdx.game.screens.*;


public class MyGame extends Game {
	
	
	@Override 
	public void create () {

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
