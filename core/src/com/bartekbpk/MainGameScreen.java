package com.bartekbpk;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.bartekbpk.actors.ActorPlayer;
import com.bartekbpk.actors.ActorSpikes;

/**
 * @author bpk  Bartłomiej Kulesa
 *
 */

public class MainGameScreen extends BaseScreen {

    private Stage stage;
    private ActorPlayer actorPlayer;
    private ActorSpikes actorSpikes;
    private Texture textureOwl;
    private Texture textureSpikes;
    private TextureRegion textureRegionSpikes;

    public MainGameScreen(MainGame game) {
        super(game);
        textureOwl = new Texture("owl.png");
        textureSpikes = new Texture("spikes.png");
        textureRegionSpikes = new TextureRegion(textureSpikes, 0, 90, 256, 166);
    }

    @Override
    public void show() {
        stage = new Stage();
        stage.setDebugAll(true);

        actorPlayer = new ActorPlayer(textureOwl);
        actorSpikes = new ActorSpikes(textureRegionSpikes);

        stage.addActor(actorPlayer);
        stage.addActor(actorSpikes);

        actorPlayer.setPosition(20, 0);
        actorSpikes.setPosition(960, 0);

    }

    @Override
    public void hide() {
        stage.dispose();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act();
        collisionDetection();
        stage.draw();
    }

    private void collisionDetection() {
        if (actorPlayer.isAlive() &&
                (actorPlayer.getX() + actorPlayer.getWidth() > actorSpikes.getX())) {
            System.out.println("collision");
            actorPlayer.setAlive(false);
        }
    }

    @Override
    public void dispose() {
        textureOwl.dispose();
        textureSpikes.dispose();
    }
}
