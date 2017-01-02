package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.viewport.StretchViewport;


/**
 * Created by Valeria on 12.04.2016.
 */
public class IntroScreen implements Screen {

    private Music corazion;
    private Texture sunTexture;
    private Sprite sprite;
    private Stage stage;

    public IntroScreen(){
    }

    @Override
    public void show() {

        class menuActors extends Actor{
            public Texture actorTexture;

            public menuActors(){
                setTouchable(Touchable.enabled);
                setBounds(getX(), getY(), getWidth(), getHeight());

                addListener(new InputListener() {

                    @Override
                    public boolean touchDown(InputEvent event, float x, float y,
                                             int pointer, int button) {
                        return true;
                    }

                    @Override
                    public void touchUp(InputEvent event, float x, float y, int pointer, int button)
                    {
                        ScreenManager.getInstance().show(CustomScreen.GAME);
                        corazion.stop();
                    }
                });
            }

            public void draw(Batch batch, float parentAlpha) {
                batch.draw(actorTexture, getX(), getY(), getWidth(), getHeight());
            }
        }

        stage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        Gdx.input.setInputProcessor(stage);

        menuActors background = new menuActors();
        background.actorTexture = GameAssetManager.getInstance().get("sunrise.jpg");
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        background.setPosition(0, 0);


        stage.addActor(background);

        corazion = GameAssetManager.getInstance().get("corazion.mp3", Music.class);
        corazion.setLooping(true);

        corazion.play();

        sunTexture = GameAssetManager.getInstance().get("sun.png");

        sprite = new Sprite(sunTexture);
        sprite.setSize(Gdx.graphics.getHeight() / 4, Gdx.graphics.getHeight() / 4);
        sprite.setPosition(sprite.getWidth() / 4, Gdx.graphics.getHeight() - (sprite.getHeight() * 1.5f));
        sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
    }

    int i = 0;
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0.5f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        sprite.setRotation(i--);

        Batch batch = new SpriteBatch();

        stage.draw();
        stage.act(Gdx.graphics.getDeltaTime());

        batch.begin();
        sprite.draw(batch);
        batch.end();
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
        corazion.dispose();
    }
}
