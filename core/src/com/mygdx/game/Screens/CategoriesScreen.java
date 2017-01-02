package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.ActorClasses.BackArrow;
import com.mygdx.game.ActorClasses.Categories;
import com.mygdx.game.ActorClasses.SimpleActor;
import com.mygdx.game.ActorClasses.TasksIcons;
import com.mygdx.game.Voids.AddWordsToDict;
import com.mygdx.game.Voids.ShowWordCard;
import com.mygdx.game.WordsCollections.ABC;
import com.mygdx.game.WordsCollections.Data;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Valeria on 12.04.2016.
 */
public class CategoriesScreen implements Screen {

    private SpriteBatch batch;
    private Stage stage;
    public static Group categorieGroup;
    public static Group tasksGroup;
    public static String categorieName;
    public static String taskName;
    public static ABC dictAbc = new ABC();
    public int i;

    public CategoriesScreen(){

    }

    @Override
    public void show() {

        stage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));

        Gdx.input.setInputProcessor(stage);

        AddWordsToDict.Add();

        ///////////////// Background actor /////////////////////////////
        SimpleActor backgroundActor = new SimpleActor();
        backgroundActor.actorTexture = GameAssetManager.getInstance().get("background.png");
        backgroundActor.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        backgroundActor.setPosition(0, Gdx.graphics.getHeight() - backgroundActor.getHeight());

        ///////////////// Settings button actor /////////////////////////////
        final SimpleActor settingsBtnActor = new SimpleActor();
        settingsBtnActor.actorTexture = GameAssetManager.getInstance().get("settingsBtn.png");
        settingsBtnActor.setSize(Gdx.graphics.getHeight() / 10, Gdx.graphics.getHeight() / 10);
        settingsBtnActor.setPosition(0, Gdx.graphics.getHeight() - (Gdx.graphics.getHeight() / 10));
        settingsBtnActor.setBounds(0, Gdx.graphics.getHeight() - settingsBtnActor.getHeight(),
                settingsBtnActor.getWidth(), settingsBtnActor.getHeight());

        ///////////////// Group for categories actors /////////////////////////////
        categorieGroup = new Group();
        categorieGroup.setSize(Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight() - (settingsBtnActor.getHeight() * 2));
        categorieGroup.setPosition(0, settingsBtnActor.getHeight());

        ///////////////// ABC Categorie actor /////////////////////////////
        Categories abcActor = new Categories();
        abcActor.actorTexture = GameAssetManager.getInstance().get("ABC_Categorie.png");
        abcActor.setSize(Gdx.graphics.getWidth() / 2 - 50, Gdx.graphics.getWidth() / 2 - 50);
        abcActor.setPosition(25,
                (Gdx.graphics.getHeight() - settingsBtnActor.getHeight() * 2) -
                        ((Gdx.graphics.getHeight() - settingsBtnActor.getHeight() * 2)) / 2 + 25);

        ///////////////// Numbers Categorie actor /////////////////////////////
        Categories numActor = new Categories();
        numActor.actorTexture = GameAssetManager.getInstance().get("numbers_Categorie.png");
        numActor.setSize(Gdx.graphics.getWidth() / 2 - 50, Gdx.graphics.getWidth() / 2 - 50);
        numActor.setPosition(Gdx.graphics.getWidth() / 2 + 25,
                (Gdx.graphics.getHeight() - settingsBtnActor.getHeight() * 2) -
                        ((Gdx.graphics.getHeight() - settingsBtnActor.getHeight() * 2)) / 2 + 25);

        ///////////////// Colors Categorie actor /////////////////////////////
        Categories colorsActor = new Categories();
        colorsActor.actorTexture = GameAssetManager.getInstance().get("colors_Categorie.png");
        colorsActor.setSize(Gdx.graphics.getWidth() / 2 - 50, Gdx.graphics.getWidth() / 2 - 50);
        colorsActor.setPosition(25, abcActor.getY() - 50 - colorsActor.getHeight());


        ///////////////// Animals Categorie actor /////////////////////////////
        Categories animalsActor = new Categories();
        animalsActor.actorTexture = GameAssetManager.getInstance().get("animals_Categorie.png");
        animalsActor.setSize(Gdx.graphics.getWidth() / 2 - 50, Gdx.graphics.getWidth() / 2 - 50);
        animalsActor.setPosition(Gdx.graphics.getWidth() / 2 + 25, abcActor.getY() - 50 - animalsActor.getHeight());

        //////////////// Back arrow //////////////////////////////////
        final BackArrow backA = new BackArrow();
        backA.actorTexture = GameAssetManager.getInstance().get("back.png");
        backA.setSize(Gdx.graphics.getHeight() / 10, Gdx.graphics.getHeight() / 10);
        backA.setPosition(Gdx.graphics.getWidth() - backA.getWidth(),
                Gdx.graphics.getHeight() - (Gdx.graphics.getHeight() / 10));
        backA.setTouchable(Touchable.enabled);
        backA.setBounds(backA.getX(), backA.getY(), backA.getWidth(), backA.getHeight());

        // Describing the new group og tasks, new "Screen"
        tasksGroup = new Group();
        tasksGroup.setSize(Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight() - (settingsBtnActor.getHeight() * 2));
        tasksGroup.setPosition(Gdx.graphics.getWidth(), settingsBtnActor.getHeight());

        final SimpleActor leftArrow = new SimpleActor();
        leftArrow.actorTexture = GameAssetManager.getInstance().get("leftArrow.png");
        leftArrow.setSize(Gdx.graphics.getHeight() / 10, Gdx.graphics.getHeight() - (settingsBtnActor.getHeight() * 3.5f));
        leftArrow.setPosition(0, Gdx.graphics.getHeight() / 10);

        final SimpleActor rightArrow = new SimpleActor();
        rightArrow.actorTexture = GameAssetManager.getInstance().get("rightArrow.png");
        rightArrow.setSize(Gdx.graphics.getHeight() / 10, Gdx.graphics.getHeight() - (settingsBtnActor.getHeight() * 3.5f));
        rightArrow.setPosition(Gdx.graphics.getWidth() - (Gdx.graphics.getHeight() / 10), Gdx.graphics.getHeight() / 10);

        final TasksIcons dictionaryActor = new TasksIcons();
        dictionaryActor.actorTexture = GameAssetManager.getInstance().get("dictionary.png");
        dictionaryActor.setSize(Gdx.graphics.getWidth() - (settingsBtnActor.getHeight() * 2),
                Gdx.graphics.getHeight() / 6);
        dictionaryActor.setPosition(tasksGroup.getWidth() / 2 - (dictionaryActor.getWidth() / 2),
                tasksGroup.getHeight() - dictionaryActor.getHeight() - 50);

        final Group group = new Group();
        group.setSize(Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight() - (settingsBtnActor.getHeight() * 2));
        group.setPosition(Gdx.graphics.getWidth(), settingsBtnActor.getHeight());

/////////////////////////////////////////////////////////////////////////////////////////////////////
        dictionaryActor.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dictionaryActor.setSize(dictionaryActor.getWidth() - 10, dictionaryActor.getHeight() - 10);
                dictionaryActor.setPosition(dictionaryActor.getX() + 5, dictionaryActor.getY() + 5);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                dictionaryActor.setSize(dictionaryActor.getWidth() + 10, dictionaryActor.getHeight() + 10);
                dictionaryActor.setPosition(dictionaryActor.getX() - 5, dictionaryActor.getY() - 5);

                MoveToAction moveToAction1 = new MoveToAction();
                moveToAction1.setPosition(0, settingsBtnActor.getHeight());
                moveToAction1.setDuration(0.25f);
                group.addAction(moveToAction1);

                if (categorieName.equals("abc")) {
                    System.out.println("catch abc");

                    final SimpleActor whiteBackActor = new SimpleActor();
                    whiteBackActor.actorTexture = GameAssetManager.getInstance().get("white.png");
                    whiteBackActor.setSize(Gdx.graphics.getWidth() - (settingsBtnActor.getWidth() * 2),
                            Gdx.graphics.getHeight() - (settingsBtnActor.getHeight() * 3.5f));
                    whiteBackActor.setPosition(settingsBtnActor.getWidth(), settingsBtnActor.getHeight());

                    group.addActor(whiteBackActor);
                    group.addActor(leftArrow);
                    group.addActor(rightArrow);
                    stage.addActor(group);

/////////////////////////////////
                    final List<Data> dct = dictAbc.words;

                    i = 0;
                    while(i < dct.size()) {

                     //   ShowWordCard.showWordCard(dct.get(i), group, whiteBackActor, leftArrow, rightArrow);

                        rightArrow.addListener(new InputListener() {
                            @Override
                            public boolean touchDown(InputEvent e, float x, float y, int pointer, int button) {

                                rightArrow.setSize(rightArrow.getWidth() - 3, rightArrow.getHeight() - 3);
                                rightArrow.setPosition(rightArrow.getX() + 1.5f, rightArrow.getY() + 1.5f);

                                return true;
                            }

                            @Override
                            public void touchUp(InputEvent e, float x, float y, int pointer, int button) {

                                rightArrow.setSize(rightArrow.getWidth() + 3, rightArrow.getHeight() + 3);
                                rightArrow.setPosition(rightArrow.getX() - 1.5f, rightArrow.getY() - 1.5f);

                                if (++i <= dct.size())
                                    ShowWordCard.showWordCard(dct.get(i++), group, whiteBackActor, leftArrow, rightArrow);
                            }

                        });

                        leftArrow.addListener(new InputListener() {
                            @Override
                            public boolean touchDown(InputEvent e, float x, float y, int pointer, int button) {

                                leftArrow.setSize(leftArrow.getWidth() - 3, leftArrow.getHeight() - 3);
                                leftArrow.setPosition(leftArrow.getX() + 1.5f, leftArrow.getY() + 1.5f);

                                return true;
                            }

                            @Override
                            public void touchUp(InputEvent e, float x, float y, int pointer, int button) {

                                if (--i >= 0)
                                    ShowWordCard.showWordCard(dct.get(i--), group, whiteBackActor, leftArrow, rightArrow);

                                leftArrow.setSize(leftArrow.getWidth() + 3, leftArrow.getHeight() + 3);
                                leftArrow.setPosition(leftArrow.getX() - 1.5f, leftArrow.getY() - 1.5f);
                            }

                        });
                    }
                    //////////// arrow ///////////
                    backA.addListener(new InputListener() {

                        @Override
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            return true;
                        }

                        @Override
                        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                            if (group.getX() < Gdx.graphics.getWidth()) {

                                // Move the words cards right to main
                                MoveToAction moveToAction = new MoveToAction();
                                moveToAction.setPosition(Gdx.graphics.getWidth(),
                                        group.getY());
                                moveToAction.setDuration(0.25f);
                                group.addAction(moveToAction);

                                // Move the tasks from main
                                MoveToAction moveToAction1 = new MoveToAction();
                                moveToAction1.setPosition(0, tasksGroup.getY());
                                moveToAction1.setDuration(0.25f);
                                tasksGroup.addAction(moveToAction1);

                                MoveToAction moveToAction2 = new MoveToAction();
                                moveToAction2.setPosition(-categorieGroup.getWidth() * 1.5f, categorieGroup.getY());
                                moveToAction2.setDuration(0.25f);
                                categorieGroup.addAction(moveToAction2);
                            }

                            whiteBackActor.remove();
                            group.getChildren().clear();

                        }
                    });
                }
            }
        });
///////////////////////////////////

        tasksGroup.addActor(dictionaryActor);

        // Setting names for input checking
        abcActor.setName("abc");
        numActor.setName("numbers");
        colorsActor.setName("colors");
        animalsActor.setName("animals");

        // Setting names for tasks
        dictionaryActor.setName("dictionary");

        categorieGroup.addActor(abcActor);
        categorieGroup.addActor(numActor);
        categorieGroup.addActor(colorsActor);
        categorieGroup.addActor(animalsActor);

        stage.addActor(backgroundActor);
        stage.addActor(settingsBtnActor);
        stage.addActor(backA);
        stage.addActor(categorieGroup);
        stage.addActor(tasksGroup);

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        stage.act(Gdx.graphics.getDeltaTime());

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
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

}
