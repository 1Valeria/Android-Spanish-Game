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
    Class for tasks Icons like Dictionary
     touchUp decreased the icon
     touchDown increased thу icon again and remembered the name of task
 */

public class TasksIcons extends Actor {
    public Texture actorTexture;

    public TasksIcons(){
        setTouchable(Touchable.enabled);
        setBounds(getX(), getY(), getWidth(), getHeight());

        ////////////////////////// Addded listener for increase categorie actors
        ////////////////////////// ?????? != instead of ==
        if(CategoriesScreen.tasksGroup != getParent()) {
            addListener(new InputListener() {


                @Override
                public boolean touchDown(InputEvent event, float x, float y,
                                         int pointer, int button) {
                    setSize(getWidth() - 10, getHeight() - 10);
                    setPosition(getX() + 5, getY() + 5);
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button)
                {
                    setSize(getWidth() + 10, getHeight() + 10);
                    setPosition(getX() - 5, getY() - 5);

                    if(getName() != null)
                        CategoriesScreen.taskName = getName();

                    // Move the tasks Screen left
                    MoveToAction moveToAction = new MoveToAction();
                    moveToAction.setPosition(-CategoriesScreen.tasksGroup.getWidth(),
                            CategoriesScreen.tasksGroup.getY());
                    moveToAction.setDuration(0.25f);
                    CategoriesScreen.tasksGroup.addAction(moveToAction);

                }
            });
        }

    }

    public void draw(Batch batch, float parentAlpha) {
        batch.draw(actorTexture, getX(), getY(), getWidth(), getHeight());
    }
}
