package com.mygdx.game.Screens;

/**
 * Created by Valeria on 16.04.2016.
 */
public enum CustomScreen {

    LOAD_SCREEN {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
            return new LoadScreen();
        }
    },

    MAIN_MENU {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
            return new IntroScreen();
        }
    },

    GAME {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
            return new CategoriesScreen();
        }
    };

    protected abstract com.badlogic.gdx.Screen getScreenInstance();

}
