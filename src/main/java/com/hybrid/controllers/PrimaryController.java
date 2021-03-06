package com.hybrid.controllers;

import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.state.StateManager;
import com.gluonhq.particle.view.ViewManager;

import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.stage.WindowEvent;
import javafx.application.Platform;

import javax.inject.Inject;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionMap;
import org.controlsfx.control.action.ActionProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PrimaryController {

    
    private boolean first = true;
    
    @FXML
    private Label label;
    
    @FXML
    private Button button;
    
    @FXML
    private ResourceBundle resources;
    
    @Autowired
    ApplicationContext ctx;
    
    private Action actionSignin;
    

    public PrimaryController() {
    }
    
    public void initialize() {
        ActionMap.register(this);
        actionSignin =  ActionMap.action("signin");
        
        button.setOnAction(e -> { 
        	viewManager.switchView("secondary");
        
        });
        
        Platform.runLater(new Runnable() {
			public void run() {
				
			}
		});
        
        javafx.application.Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				app.getPrimaryStage().setOnCloseRequest(new EventHandler<WindowEvent>() {
					
					@Override
					public void handle(WindowEvent event) {
						exit();
						System.out.println("### close()...");
						
					}
				});
			}
		});
        

        System.out.println("PrimaryController.initialize()... " +  ctx.getBean(FXMLLoader.class).getControllerFactory());
        
        
    }
    
    @Inject private ParticleApplication app;
    @Inject private ViewManager viewManager;
    @Inject private StateManager stateManager;
    
    @Inject private FXMLLoader fxmlLoader;

    
    public void init() {
    	System.out.println("PrimaryController.init()... " +  fxmlLoader.getControllerFactory());
    }
    
    public void postInit() {

    	if (first) {
            stateManager.setPersistenceMode(StateManager.PersistenceMode.USER);
            addUser(stateManager.getProperty("UserName").orElse("").toString());
            first = false;
        }
        app.getParticle().getToolBarActions().add(actionSignin);
    }
    
    public void dispose() {
        app.getParticle().getToolBarActions().remove(actionSignin);
    }
    
    public void addUser(String userName) {
        label.setText(resources.getString("label.text") + (userName.isEmpty() ? "" :  ", " + userName) + "!");
        stateManager.setProperty("UserName", userName);
    }

    @ActionProxy(text="Sign In")
    private void signin() {
        TextInputDialog input = new TextInputDialog(stateManager.getProperty("UserName").orElse("").toString());
        input.setTitle("User name");
        input.setHeaderText(null);
        input.setContentText("Input your name:");
        input.showAndWait().ifPresent(this::addUser);
    }
 
  @ActionProxy(text="Exit", accelerator="alt+F4")
  private void exit() {
  	System.out.println("PrimaryControllor.exit()...");
  	AnnotationConfigEmbeddedWebApplicationContext actx = (AnnotationConfigEmbeddedWebApplicationContext) ctx;
  	actx.close();
  	System.out.println("ctx.close()...");
      app.exit();
  }


}