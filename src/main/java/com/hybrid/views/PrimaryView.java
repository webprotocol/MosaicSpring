package com.hybrid.views;

import javax.inject.Inject;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.gluonhq.particle.annotation.ParticleView;
import com.gluonhq.particle.view.FXMLView;
import com.hybrid.Application;
import com.hybrid.controllers.PrimaryController;

import javafx.fxml.FXMLLoader;

@ParticleView(name = "primary", isDefault = true)
public class PrimaryView extends FXMLView {
	
	@Inject
	FXMLLoader fxmlLoader;
	
	PrimaryController controller;
    
    public PrimaryView() {
        super(PrimaryView.class.getResource("primary.fxml"));
    }
    
    @Override
    public void init() {
    	/***************
    	 * Spring Boot
    	 ***************/
    	ApplicationContext ctx = SpringApplication.run(Application.class, new String[] {"xxx"});
    	fxmlLoader.setControllerFactory(ctx.getBean(FXMLLoader.class).getControllerFactory());
    	
        controller = (PrimaryController) getController();
        controller.init();
        
//        super.init();
    }
    
    @Override
    public void start() {
        controller.postInit();
    }
    
    @Override
    public void stop() {
    	controller.dispose();
    }
    
}
