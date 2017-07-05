package com.bartekbpk;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.bartekbpk.actors.ActorOwl;
import com.bartekbpk.actors.ActorSpikes;

/**
 * @author bpk  Bartłomiej Kulesa
 *
 */

public class MainGameScreen extends BaseScreen {

    private Stage stage;
    private ActorOwl actorOwl;
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

        actorOwl = new ActorOwl(textureOwl);
        actorSpikes = new ActorSpikes(textureRegionSpikes);

        stage.addActor(actorOwl);
        stage.addActor(actorSpikes);

        actorOwl.setPosition(20, 0);
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
        stage.draw();
    }

    @Override
    public void dispose() {
        textureOwl.dispose();
        textureSpikes.dispose();
    }
}
