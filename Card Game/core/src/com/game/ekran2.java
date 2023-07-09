
//ekran2.java------------------------------------------------------------------------------------------------

package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


//menü ekrani tasarlanir.
public class ekran2 implements Screen {

    public MyGdxGame game;

    public ekran2(MyGdxGame game) {
        this.game = game;
    }

    BitmapFont font = new BitmapFont();
    SpriteBatch batch = new SpriteBatch();
    ShapeRenderer sr = new ShapeRenderer();
    Test test = new Test();
    boolean kartsec = false;
    Kullanici kullanici = new Kullanici();
    Bilgisayar bilgisayar = new Bilgisayar();
    Texture baslamaekrani = new Texture("baslamaekrani.png");

    @Override
    public void show() {

       
    }

    @Override
    public void render(float f) {
        Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isKeyJustPressed(Keys.R)) {
            game.create(1);
        }

        batch.begin();
        
       batch.draw(baslamaekrani,0,0,1500,1000);

        batch.end();

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

        batch.dispose();
        font.dispose();
    }

}
