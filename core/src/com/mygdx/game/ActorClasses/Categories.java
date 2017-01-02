package com.mygdx.game.ActorClasses;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.mygdx.game.Screens.CategoriesScreen;

/**
 * Created by Valeria on 18.04.2016.
 */

/*
    Actor class for Categories Icons  and for arrow Btn(temporary)
    touchDown decreases the Texture
    touchUp increased again Texture and remembered the names of categorie and task and moves the groups
*/

public class Categories extends Actor {

    public Texture actorTexture;

    public Categories() {

        setTouchable(Touchable.enabled);
        setBounds(getX(), getY(), getWidth(), getHeight());

            addListener(new InputListener() {

                @Override
                public boolean touchDown(InputEvent event, float x, float y,
                                         int pointer, int button) {
                    setSize(getWidth() - 10, getHeight() - 10);
                    setPosition(getX() + 5, getY() + 5);
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    setSize(getWidth() + 10, getHeight() + 10);
                    setPosition(getX() - 5, getY() - 5);

                    if (getName() != null)
                        CategoriesScreen.categorieName = getName();

                    // Move the categories left
                    MoveToAction moveToAction2 = new MoveToAction();
                    moveToAction2.setPosition(-CategoriesScreen.categorieGroup.getWidth(),
                            CategoriesScreen.categorieGroup.getY());
                    moveToAction2.setDuration(0.25f);
                    CategoriesScreen.categorieGroup.addAction(moveToAction2);

                    // Move tasks to the stage
                    MoveToAction moveToAction3 = new MoveToAction();
                    moveToAction3.setPosition(0, CategoriesScreen.tasksGroup.getY());
                    moveToAction3.setDuration(0.25f);
                    CategoriesScreen.tasksGroup.addAction(moveToAction3);

                }
            });
    }

    public void draw(Batch batch, float parentAlpha) {
        batch.draw(actorTexture, getX(), getY(), getWidth(), getHeight());
    }
}

