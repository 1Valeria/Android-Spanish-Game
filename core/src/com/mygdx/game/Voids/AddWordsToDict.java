package com.mygdx.game.Voids;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.ActorClasses.Categories;
import com.mygdx.game.Screens.CategoriesScreen;
import com.mygdx.game.Screens.GameAssetManager;
import com.mygdx.game.WordsCollections.ABC;
import com.mygdx.game.WordsCollections.Data;

/**
 * Created by Valeria on 28.04.2016.
 */
public class AddWordsToDict {

    public static void Add(){
        CategoriesScreen.dictAbc.add("alphabet",
                GameAssetManager.getInstance().get("abc/alphabet_eng.png", Texture.class),
                GameAssetManager.getInstance().get("abc/alphabet_esp.png", Texture.class),
                GameAssetManager.getInstance().get("abc/alphabet_img.png", Texture.class));

        CategoriesScreen.dictAbc.add("a",
                GameAssetManager.getInstance().get("abc/a_eng.png", Texture.class),
                GameAssetManager.getInstance().get("abc/a_esp.png", Texture.class),
                GameAssetManager.getInstance().get("abc/a_img.png", Texture.class));
    }


}
