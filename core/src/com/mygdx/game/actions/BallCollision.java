package com.mygdx.game.actions;

import com.mygdx.game.objects.*;
//import com.badlogic.gdx.math.Intersector;
//import com.mygdx.game.screens.MainGameScreen;
//import com.mygdx.game.sounds.BallsColliding;

public class BallCollision {
	
	private Controller control;
	private Ball ball;
	//private BallsColliding soundEffect = new BallsColliding();
		
	public boolean isColliding() {
		
		float xDist = ball.x - control.x;
		float yDist = ball.y - control.y;
		float sqDist = (xDist * xDist) + (yDist * yDist);
		float sqRad = (ball.size + control.radius) * (ball.size + control.radius);
		
		if (sqDist <= sqRad)
			return true;
	
		return false;
	}
	
		
	public void dispose() {
		
		
	}

}
