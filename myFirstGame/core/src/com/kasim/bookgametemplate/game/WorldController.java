package com.kasim.bookgametemplate.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Disposable;
import com.kasim.bookgametemplate.util.CameraHelper;

public class WorldController implements Disposable {
    private static final String TAG =
            WorldController.class.getName();

    public CameraHelper cameraHelper;
    public Level level;
    public World box2dWorld;

    public WorldController() {
        init();
    }

    private void init() {
        box2dWorld = new World(new Vector2(0, -10),true);
        level = new Level(box2dWorld);
        cameraHelper = new CameraHelper();
    }

    public void update(float deltaTime) {
        level.update(deltaTime);
        cameraHelper.update(deltaTime);
    }

    public void userRequest_resetGame(){
        Gdx.app.debug(TAG, "User request: " + "Game world reset");
    }

    @Override
    public void dispose() {
        box2dWorld.dispose();
    }
}
