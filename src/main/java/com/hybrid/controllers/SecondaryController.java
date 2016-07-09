package com.hybrid.controllers;

import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.view.ViewManager;
import com.hybrid.service.Service;

import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javax.inject.Inject;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionMap;
import org.controlsfx.control.action.ActionProxy;
import org.springframework.context.ApplicationContext;

public class SecondaryController {

    @Inject ParticleApplication app;
    
    @Inject private ViewManager viewManager;

    @FXML
    private Button button;
    
    @FXML
    private ResourceBundle resources;
    
    @Inject
    ApplicationContext ctx;
    
    private Action actionHome;
    
    public void initialize() {
    			
        ActionMap.register(this);
        actionHome =  ActionMap.action("goHome");
        
        button.setText(resources.getString("button.text"));
        button.setOnAction(e -> { 
        	viewManager.switchView("primary");
        	System.out.println("### Spring Injection");
        });
        System.out.println("SecondaryController.initialize()... " +  ctx);
    }
    
    public void postInit() {
    	System.out.println("postInit()... " + viewManager);
        app.getParticle().getToolBarActions().add(actionHome);
    }
    
    public void dispose() {
        app.getParticle().getToolBarActions().remove(actionHome);
    }
    
    @ActionProxy(text = "Back")
    private void goHome() {
        viewManager.switchView("primary");
    }
    
}
