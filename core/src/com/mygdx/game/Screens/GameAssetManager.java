package com.mygdx.game.Screens;

import com.badlogic.gdx.assets.AssetManager;

/**
 * Created by Valeria on 16.04.2016.
 */
public class GameAssetManager extends AssetManager{

    private static GameAssetManager instance;

    public static GameAssetManager getInstance(){
        if(null == instance){
            instance = new GameAssetManager();
        }
        return instance;
    }

    public void init(){

    }
}
