package com.cards.game;

import network.Networking;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class CardsMain extends ApplicationAdapter {
	SpriteBatch batch;
	Sprite sprite;
	Texture img;
	World world;
	Body body;

	@Override
	public void create() {

		this.batch = new SpriteBatch();
		this.img = new Texture("badlogic.jpg");
		this.sprite = new Sprite(this.img);
		this.sprite.setPosition(Gdx.graphics.getWidth() / 2 - this.sprite.getWidth() / 2, Gdx.graphics.getHeight() / 2);

		this.world = new World(new Vector2(0, -98f), true);
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set(this.sprite.getX(), this.sprite.getY());
		this.body = this.world.createBody(bodyDef);
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(this.sprite.getWidth() / 2, this.sprite.getHeight() / 2);
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = 1f;

		Fixture fixture = this.body.createFixture(fixtureDef);

		shape.dispose();
	}

	@Override
	public void render() {

		this.world.step(Gdx.graphics.getDeltaTime(), 6, 2);

		this.sprite.setPosition(this.body.getPosition().x, this.body.getPosition().y);

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.batch.begin();
		this.batch.draw(this.sprite, this.sprite.getX(), this.sprite.getY());
		this.batch.end();
	}

	@Override
	public void dispose() {
		this.img.dispose();
		this.world.dispose();
	}
}