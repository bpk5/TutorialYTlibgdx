package com.bartekbpk;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * @author bpk Bartłomiej Kulesa
 */

public class Box2DScreen extends BaseScreen {

    private World world;

    private Box2DDebugRenderer renderer;

    private OrthographicCamera camera;

    private Body playerBody;
    private Body landBody;

    private Fixture playerFixture;
    private Fixture landFixture;

    public Box2DScreen(MainGame game) {
        super(game);
    }

    @Override
    public void show() {
        world = new World(new Vector2(0, -10), true);
        renderer = new Box2DDebugRenderer();
        camera = new OrthographicCamera(Gdx.graphics.getWidth() / 60, Gdx.graphics.getHeight() / 60);
        camera.translate(0, 3);


        playerBody = world.createBody(createPlayerBodyDef());
        landBody = world.createBody(createLandBodyDef());

        PolygonShape playerShape = new PolygonShape();
        playerShape.setAsBox(1, 1);
        playerFixture = playerBody.createFixture(playerShape, 1);
        playerShape.dispose();

        PolygonShape landShape = new PolygonShape();
        landShape.setAsBox(500, 1);
        landFixture = landBody.createFixture(landShape, 1);
        landShape.dispose();
    }

    private BodyDef createLandBodyDef() {
        BodyDef def = new BodyDef();
        def.position.set(0, -1);
        return def;
    }

    private BodyDef createPlayerBodyDef() {
        BodyDef def = new BodyDef();
        def.position.set(0, 10);
        def.type = BodyDef.BodyType.DynamicBody;
        return def;
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
        playerBody.destroyFixture(playerFixture);
        landBody.destroyFixture(landFixture);
        world.destroyBody(playerBody);
        world.dispose();
        renderer.dispose();
    }
}
