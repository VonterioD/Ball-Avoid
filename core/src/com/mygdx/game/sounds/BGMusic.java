package com.mygdx.game.sounds;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
//import com.badlogic.gdx.audio.Sound;

public class BGMusic implements ApplicationListener {

	private Music music;
	//private Music music2;
	
	@Override
	public void create() {
		
		music = Gdx.audio.newMusic(Gdx.files.internal("BGM.mp3"));
		music.play();
		music.setVolume(1.0f);
		music.setLooping(true);
		
		/*music2 = Gdx.audio.newSound(Gdx.files.internal("HYPED.wav"));		
		long id = music2.play(1.0f);
		music2.setLooping(id, true); */
	
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
	
		music.dispose();
		
	}

}
