package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Screens.CustomScreen;
import com.mygdx.game.Screens.ScreenManager;

public class MainClass extends Game {
	
	@Override
	public void create () {

		ScreenManager.getInstance().init(this);
		ScreenManager.getInstance().show(CustomScreen.LOAD_SCREEN);
	}

	@Override
	public void render () {
		super.render();
	}

	public void dispose() {

	}

}
