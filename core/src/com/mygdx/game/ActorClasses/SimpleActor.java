package com.mygdx.game.ActorClasses;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.mygdx.game.Screens.CategoriesScreen;

/**
 * Created by Valeria on 26.04.2016.
 */
public class SimpleActor extends Actor {

    public Texture actorTexture;

    public SimpleActor(){

    }

    public void draw(Batch batch, float parentAlpha) {
        batch.draw(actorTexture, getX(), getY(), getWidth(), getHeight());
    }
}
