package com.bartekbpk.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * @author bpk Bartłomiej Kulesa
 */

public class ActorSpikes extends Actor {

    private TextureRegion textureSpikes;

    public ActorSpikes(TextureRegion textureSpikes) {
        this.textureSpikes = textureSpikes;
        setSize(textureSpikes.getRegionWidth(), textureSpikes.getRegionHeight());
        
    }

    @Override
    public void act(float delta) {
        setX(getX() - 250 * delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textureSpikes, getX(), getY());
    }
}
