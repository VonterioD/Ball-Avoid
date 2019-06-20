package com.mygdx.game.sounds;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class WallCollide implements ApplicationListener {

	private Sound wallCollide;
	
	@Override
	public void create() {
		
		wallCollide = Gdx.audio.newSound(Gdx.files.internal("Collision.wav"));
		wallCollide.play(0.5f);
	}

	@Override
	public void resize(int width, int height) {

		
	}

	@Override
	public void render() {

		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {

		
	}

	@Override
	public void dispose() {
		
		wallCollide.dispose();
		
	}

}
