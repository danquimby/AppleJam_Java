package com.danquimby.apple_jam;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.danquimby.apple_jam.Screens.MenuScreen;

public class AppleJamGame extends Game {

    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
    @Override
    public void dispose()
    {
        super.dispose();
    }
}
