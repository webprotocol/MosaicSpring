package com.hybrid;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.WindowEvent;
import javafx.stage.Stage;

import static org.controlsfx.control.action.ActionMap.actions;

import org.controlsfx.tools.Platform;

import com.gluonhq.particle.application.ParticleApplication;

public class MainApplication extends ParticleApplication {

    public MainApplication() {
        super("Mosaic Spring Application");
    }

    
    @Override
    public void postInit(Scene scene) {
    	
    	setShowCloseConfirmation(false);

        scene.getStylesheets().add(MainApplication.class.getResource("style.css").toExternalForm());

        setTitle("Mosaic Spring Application");

        getParticle().buildMenu("File -> [exit]",
        						"Spring -> [inject]",
        						"Native -> [Chart -> [piechart, barchart, linechart, areachart], Widget -> [table, list] ]",
		        				"Webapp -> [cube]",
		        				"Hybrid -> [browser]",
        						"Help -> [about]");
        
        
        getParticle().getToolBarActions().addAll(0, actions("about", "exit", "---"));
        
        
        
    }

    public static void main(String[] args) {
		launch(args);
	}

}