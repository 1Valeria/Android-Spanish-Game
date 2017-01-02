package com.mygdx.game.WordsCollections;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.ActorClasses.SimpleActor;
import com.mygdx.game.Screens.GameAssetManager;

/**
 * Created by Valeria on 25.04.2016.
 */
public class Data {

    public Data(String wN, Texture wEngA, Texture wEspA, Texture wImgA) {
        this.nameWord = wN;
        this.wordEngActor.actorTexture = wEngA;
        this.wordEspActor.actorTexture = wEspA;
        this.wordImgActor.actorTexture = wImgA;
    }

    public final SimpleActor wordImgActor = new SimpleActor();
    public final SimpleActor wordEngActor = new SimpleActor();
    public final SimpleActor wordEspActor = new SimpleActor();
    public final String nameWord;

}
