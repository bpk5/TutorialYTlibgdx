package com.bartekbpk;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

/**
 * @author bpk Bartłomiej Kulesa
 */

public class Box2DScreen extends BaseScreen {

    private World world;

    private Box2DDebugRenderer renderer;

    private OrthographicCamera camera;

    public Box2DScreen(MainGame game) {
        super(game);
    }

    @Override
    public void show() {
        world = new World(new Vector2(0, -10), true);
        renderer = new Box2DDebugRenderer();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        world.step(delta, 6, 2);
        camera.update();
        renderer.render(world, camera.combined);
    }

    @Override
    public void dispose() {
        world.dispose();
        renderer.dispose();
    }
}