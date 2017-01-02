package com.mygdx.game.ActorClasses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.mygdx.game.Screens.CategoriesScreen;

/**
 * Created by Valeria on 27.04.2016.
 */
public class BackArrow extends Actor {

    public Texture actorTexture;

    public BackArrow() {

        setTouchable(Touchable.enabled);
        setBounds(getX(), getY(), getWidth(), getHeight());

        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                if (CategoriesScreen.categorieGroup.getX() < Gdx.graphics.getWidth()){

                }

                if (CategoriesScreen.tasksGroup.getX() < Gdx.graphics.getWidth()){

                    // Move the categories right to main
                    MoveToAction moveToAction = new MoveToAction();
                    moveToAction.setPosition(0,
                            CategoriesScreen.categorieGroup.getY());
                    moveToAction.setDuration(0.25f);
                    CategoriesScreen.categorieGroup.addAction(moveToAction);

                    // Move the tasks right from main
                    MoveToAction moveToAction1 = new MoveToAction();
                    moveToAction1.setPosition(Gdx.graphics.getWidth(),
                            CategoriesScreen.tasksGroup.getY());
                    moveToAction1.setDuration(0.25f);
                    CategoriesScreen.tasksGroup.addAction(moveToAction1);
                }

                System.out.println("Last selected: " + CategoriesScreen.categorieName);
                System.out.println("Last selected: " + CategoriesScreen.taskName);

            }

        });

    }

    public void draw(Batch batch, float parentAlpha) {
        batch.draw(actorTexture, getX(), getY(), getWidth(), getHeight());
    }
}