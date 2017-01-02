package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Valeria on 16.04.2016.
 */
public class LoadScreen implements Screen {

    Texture loading = new Texture("loading.png");
    Sprite sprite = new Sprite(loading);

    public LoadScreen() {
    }

    private void loadAssets(){
        GameAssetManager.getInstance().load("sunrise.jpg", Texture.class);
        GameAssetManager.getInstance().load("corazion.mp3", Music.class);
        GameAssetManager.getInstance().load("sun.png", Texture.class);
        GameAssetManager.getInstance().load("ABC_Categorie.png", Texture.class);
        GameAssetManager.getInstance().load("animals_Categorie.png", Texture.class);
        GameAssetManager.getInstance().load("background.png", Texture.class);
        GameAssetManager.getInstance().load("colors_Categorie.png", Texture.class);
        GameAssetManager.getInstance().load("numbers_Categorie.png", Texture.class);
        GameAssetManager.getInstance().load("settingsBtn.png", Texture.class);
        GameAssetManager.getInstance().load("back.png", Texture.class);
        GameAssetManager.getInstance().load("dictionary.png", Texture.class);
        GameAssetManager.getInstance().load("white.png", Texture.class);
        GameAssetManager.getInstance().load("leftArrow.png", Texture.class);
        GameAssetManager.getInstance().load("rightArrow.png", Texture.class);
        GameAssetManager.getInstance().load("abc/alphabet_eng.png", Texture.class);
        GameAssetManager.getInstance().load("abc/alphabet_esp.png", Texture.class);
        GameAssetManager.getInstance().load("abc/alphabet_img.png", Texture.class);
        GameAssetManager.getInstance().load("abc/a_eng.png", Texture.class);
        GameAssetManager.getInstance().load("abc/a_esp.png", Texture.class);
        GameAssetManager.getInstance().load("abc/a_img.png", Texture.class);


        GameAssetManager.getInstance().finishLoading();
    }

    @Override
    public void show() {
        sprite.setSize(Gdx.graphics.getWidth() / 4, Gdx.graphics.getWidth() / 4);
        sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
        sprite.setPosition(Gdx.graphics.getWidth() / 2 - (sprite.getHeight() / 2),
                Gdx.graphics.getHeight() / 2 - (sprite.getHeight() / 2));

        GameAssetManager.getInstance().init();
        loadAssets();
    }

    int i = 0;
    @Override
    public void render(float delta) {

        sprite.setRotation(i++);
        SpriteBatch batch = new SpriteBatch();
        batch.begin();
        sprite.draw(batch);
        batch.end();
        if(GameAssetManager.getInstance().update()){
            ScreenManager.getInstance().show(CustomScreen.MAIN_MENU);
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
