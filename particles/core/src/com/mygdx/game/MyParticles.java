package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyParticles extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	ParticleEffect pe;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		pe = new ParticleEffect();
		pe.load(Gdx.files.internal("particles.p"), Gdx.files.internal(""));
		pe.getEmitters().first().setPosition(Gdx.graphics.getWidth()*0,Gdx.graphics.getHeight()/2);
		pe.start();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		float pex = pe.getEmitters().first().getX();
		float pey = pe.getEmitters().first().getY();
		pe.getEmitters().first().setPosition(pex+5, pey);
		pe.update(Gdx.graphics.getDeltaTime());
		batch.begin();
		pe.draw(batch);
		batch.end();
		if (pe.isComplete()){
			pe.reset();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
