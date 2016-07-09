package com.hybrid.actions;

import com.gluonhq.particle.annotation.ParticleActions;
import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.view.ViewManager;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.inject.Inject;
import org.controlsfx.control.action.ActionProxy;

@ParticleActions
public class MenuActions {

    @Inject ParticleApplication app;
    @Inject ViewManager viewManager;
    @Inject FXMLLoader fxmlLoader;	// Gluon FXMLLoader
    
//    public MenuActions() {
//    	Platform.runLater(new Runnable() {
//			
//			@Override
//			public void run() {
//				
//				/*
//				 * Gluon FXMLLoader ==> Spring FXMLLoader 濡� 援먯껜
//				 */
//				fxmlLoader.setControllerFactory(SpringParticleApplication.ctx.getBean(FXMLLoader.class).getControllerFactory());
//			}
//		});
//	}
    
    @ActionProxy(text="Exit", accelerator="alt+F4")
    private void exit() {
        app.exit();
    }
    
    @ActionProxy(text="Injection Test")
    private void inject() {
    	System.out.println("Injection Test...");
    	viewManager.switchView("inject");
    }
    
    
    
    @ActionProxy(text="Pie Chart")
    private void piechart() {
    	System.out.println("Pie Chart...");
    	viewManager.switchView("piechart");
    }
    
    @ActionProxy(text="Bar Chart")
    private void barchart() {
    	System.out.println("Bar Chart...");
    	viewManager.switchView("barchart");
    }
    
    @ActionProxy(text="Line Chart")
    private void linechart() {
    	System.out.println("Line Chart...");
    	viewManager.switchView("linechart");
    }
    
    @ActionProxy(text="Area Chart")
    private void areachart() {
    	System.out.println("Area Chart...");
    	viewManager.switchView("areachart");
    }    
    
    @ActionProxy(text="Table")
    private void table() {
    	System.out.println("Table...");
    	viewManager.switchView("table");
    }
    
    @ActionProxy(text="List")
    private void list() {
    	System.out.println("List...");
    	viewManager.switchView("list");
    }   
    
    @ActionProxy(text="Borwser")
    private void browser() {
    	System.out.println("Borwser...");
    	viewManager.switchView("browser");
    }       
    
    @ActionProxy(text="About")
    private void about() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Gluon Desktop");
        alert.setHeaderText("About Gluon Desktop");
        alert.setGraphic(new ImageView(new Image(MenuActions.class.getResource("/icon.png").toExternalForm(), 48, 48, true, true)));
        alert.setContentText("This is a basic Gluon Desktop Application");
        alert.showAndWait();
    }
        
}