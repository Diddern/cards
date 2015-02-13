package com.cards.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CardsMain extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	String applicationName;

	@Override
	public void create() {
		this.batch = new SpriteBatch();
		this.img = new Texture("badlogic.jpg");
		this.applicationName = "Cards";
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.batch.begin();
		this.batch.draw(this.img, 0, 0);
		this.batch.end();
	}
}
