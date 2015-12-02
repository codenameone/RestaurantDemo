package com.mycompany.myapp;


import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 * This is the main class for the restaurant template, if you change the name/package name make sure
 * to update it in the projects settings and in the codenameone_settings.properties file
 */

public class RestaurantTemplate {

    private Form current;
    private Resources theme;

    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }
        new MainUI(theme).show();
    }

    public void stop() {
        current = Display.getInstance().getCurrent();
    }
    
    public void destroy() {
    }

}
