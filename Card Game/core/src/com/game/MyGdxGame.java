
//MyGdxGame.java------------------------------------------------------------------------------------------------

package com.game;

import com.badlogic.gdx.Game;

//ekranlar arasi gecisi saglayan class.

public class MyGdxGame extends Game{
	 
    public static void main(String[] args) {
        
    }
    @Override
    public void create() {
        setScreen( new ekran2(this));
    }
    
    public void create(int i) {
        setScreen(new TestScreen(this));
    }
}
