
//DesktopLauncher.java------------------------------------------------------------------------------------------------

package com.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.game.MyGdxGame;

//ekrani olusturdugumuz ve boyut verdigimiz class.
public class DesktopLauncher {
	 
    public static void main(String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height=1000;
        config.width=1500;
        new LwjglApplication(new MyGdxGame(),config);
    }
   
}

