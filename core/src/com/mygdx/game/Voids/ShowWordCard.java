package com.mygdx.game.Voids;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.mygdx.game.Screens.CategoriesScreen;
import com.mygdx.game.WordsCollections.Data;

import java.util.List;

/**
 * Created by Valeria on 28.04.2016.
 */
public class ShowWordCard {

    public static void showWordCard(Data d, Group group, Actor whiteBackActor,  Actor leftArrow,  Actor rightArrow){

        group.getChildren().clear();
        group.addActor(whiteBackActor);
        group.addActor(leftArrow);
        group.addActor(rightArrow);

        d.wordImgActor.setSize(group.getWidth() * 0.6f, group.getHeight() / 2);
        d.wordImgActor.setPosition(group.getWidth() / 2 - d.wordImgActor.getWidth() / 2, whiteBackActor.getY() + (Gdx.graphics.getHeight() / 10) * 2);

        d.wordEngActor.setSize(whiteBackActor.getWidth() / 2 - (Gdx.graphics.getHeight() / 10), (Gdx.graphics.getHeight() / 10) / 2);
        d.wordEngActor.setPosition((Gdx.graphics.getWidth() - d.wordEngActor.getWidth()) / 2, d.wordImgActor.getY() - d.wordEngActor.getHeight());

        d.wordEspActor.setSize(whiteBackActor.getWidth() - (Gdx.graphics.getHeight() / 10) * 2, (Gdx.graphics.getHeight() / 10) / 2);
        d.wordEspActor.setPosition(Gdx.graphics.getWidth() / 2 - d.wordEngActor.getWidth(), d.wordImgActor.getY() - d.wordEngActor.getHeight() - d.wordEngActor.getHeight() * 1.5f);

        group.addActor(d.wordImgActor);
        group.addActor(d.wordEngActor);
        group.addActor(d.wordEspActor);

    }
}
