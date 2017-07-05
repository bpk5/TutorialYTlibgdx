package com.bartekbpk.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * @author bpk Bartłomiej Kulesa
 */

public class ActorOwl extends Actor {

    private Texture texture;

    public ActorOwl(Texture texture) {
        this.texture = texture;
    }

    @Override
    public void act(float delta) {

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY());
    }
}
