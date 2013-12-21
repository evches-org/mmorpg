package com.elvin.mmorpg.client;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class SimpleSlickGame extends BasicGame {

	Image back;
	Image hero;
	Image shoe;
	Image eugene;
	float x = 100.0f;
	float y = 436.0f;
	float speed = 0.5f;
	float heroHeight = 24.0f;
	float heroWidth = 15.0f;
	boolean triedToKick = false;

	public SimpleSlickGame(String gamename) {
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		back = new Image("res/back.jpg");
		hero = new Image("res/blabla.PNG");
		eugene = new Image("res/eugene.png");
		shoe = new Image("res/shoe.png");
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		Input input = gc.getInput();
		triedToKick = false;
		if (input.isKeyDown(Input.KEY_RIGHT) && (x < 640 - speed * delta - heroWidth - eugene.getWidth())) {
			x += speed * delta;
		}
		if (input.isKeyDown(Input.KEY_LEFT) && (x > speed * delta)) {
			x -= speed * delta;
		}
		if (input.isKeyDown(Input.KEY_SPACE)) {
			triedToKick = true;
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.drawImage(back, 0, 0);
		g.setColor(new Color(20, 120, 220));
		g.fillRect(0, 460, 640, 20);
		g.drawImage(hero, x, y, x + heroWidth, y + heroHeight, 23, 37, 37, 60);
		g.drawImage(eugene,640 - eugene.getWidth(),480 - 20 - eugene.getHeight());
		if(triedToKick && (x > 640 - eugene.getWidth() - heroWidth - shoe.getWidth())) {
			g.drawImage(shoe,x + heroWidth,y + heroHeight - shoe.getHeight());
		}
	}
}