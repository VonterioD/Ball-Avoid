package com.mygdx.game.sounds;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class BallsColliding implements ApplicationListener {
	
	private Sound ballCollide;

	@Override
	public void create() {
	
		ballCollide = Gdx.audio.newSound(Gdx.files.internal("Ball_collide.wav"));
		
	}

	@Override
	public void resize(int width, int height) {
	
	}

	@Override
	public void render() {
		ballCollide.play(.1f);
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		
		ballCollide.dispose();
		
	}

}
