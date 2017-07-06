package com.bartekbpk.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * @author bpk Bartłomiej Kulesa
 */

public class ActorPlayer extends Actor {

    private Texture textureOwl;
    private boolean alive;

    public ActorPlayer(Texture textureOwl) {
        this.textureOwl = textureOwl;
        this.alive = true;
        setSize(textureOwl.getWidth(), textureOwl.getHeight());
    }

    @Override
    public void act(float delta) {

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textureOwl, getX(), getY());
    }

    /**
     * Get Set ------------------------------------------------------
     */

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
