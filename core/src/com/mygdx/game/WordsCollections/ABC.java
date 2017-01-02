package com.mygdx.game.WordsCollections;


import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.ActorClasses.SimpleActor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valeria on 26.04.2016.
 */
public class ABC {

    public List<Data> words = new ArrayList<Data>();

    public ABC(){
    }

    public void add(final String name, final Texture eng, final Texture esp, final Texture img){

        words.add(new Data(name, eng, esp, img) );
    }

}
