package com.mygdx.game.objects;

import java.util.ArrayList;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Disposable;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Healthbar implements Disposable {
	
	public static ArrayList<Texture> textures = new ArrayList<Texture>();
	public static ArrayList<Sprite> health = new ArrayList<Sprite>();
	
	public void addTextures() {
		
		textures.add(new Texture(Gdx.files.internal("healthbar 100.png")));
		textures.add(new Texture(Gdx.files.internal("healthbar 75.png")));
		textures.add(new Texture(Gdx.files.internal("healthbar 50.png")));
		textures.add(new Texture(Gdx.files.internal("healthbar 25.png")));
		textures.add(new Texture(Gdx.files.internal("healthbar 0.png")));
		
		for (int i = 0; i < textures.size(); i++)			 
			health.add(new Sprite(textures.get(i)));
					
		
	}

	@Override
	public void dispose() {
		
		health.clear();
	}
	
	
}
