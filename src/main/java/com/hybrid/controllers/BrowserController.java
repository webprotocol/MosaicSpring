package com.hybrid.controllers;

import com.gluonhq.particle.application.Particle;
import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.view.ViewManager;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.inject.Inject;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionMap;
import org.controlsfx.control.action.ActionProxy;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public class BrowserController {

	@FXML
	Button btnSelect;
	
	@FXML
	WebView browser;
	WebEngine engine;

    @FXML
    private ResourceBundle resources;
    

    public void initialize() {
    	engine = browser.getEngine();
    	
    	btnSelect.setOnAction(e -> {
    		System.out.println("btnSelect...");
    		
//    		engine.load(getClass().getResource("/webapp/index.html").toString());
    		engine.load("http://localhost:8080");
    		
    		PathMatchingResourcePatternResolver search = new PathMatchingResourcePatternResolver();
    		try {
				Resource[] rs =  search.getResources("classpath:com/hybrid/*");
				for (Resource r : rs) {
					System.out.println(r.getFilename());
				}
				System.out.println("#################");
				
				rs =  search.getResources("file:*");
				
				for (Resource r : rs)
					System.out.println(r.getFilename());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		
    	});
        
    }
    
    
    /*
     * Life Cycle
     */

    @Inject Particle particle;
    @Inject ParticleApplication app;
    
    @Inject MenuBar menuBar;
    
    @Inject private ViewManager viewManager;
    
    private Action actionHome;
    private Action menu1;
    
    private Menu menu;
    
    public void init() {

    	ActionMap.register(this);
    	actionHome =  ActionMap.action("goHome");
    	menu1 =  ActionMap.action("menu1");
    	
    	particle.buildMenu("Browser -> [menu1, menu2]");

		menu =  menuBar.getMenus().remove(menuBar.getMenus().size() - 1);
    }
    
    public void postInit() {
        app.getParticle().getToolBarActions().addAll(actionHome, menu1);

        removeMenu();
        
        menuBar.getMenus().add(menu);
       	
    }
    
    public void dispose() {
        app.getParticle().getToolBarActions().removeAll(actionHome, menu1);

        removeMenu();
    }
    
    private void removeMenu() {
    	
		for (int i=0; i<menuBar.getMenus().size(); i++) {
			if (menuBar.getMenus().get(i).getText().equals(menu.getText())) {
				menuBar.getMenus().remove(i);
				i--;
			}
		}
    }

    /*
     * ActionProxy
     */
    
    @ActionProxy(text = "Home")
    private void goHome() {
        viewManager.switchView("primary");
    }
    
    @ActionProxy(text = "Menu1")
    private void menu1() {
    	System.out.println("menu1...");
    }
    
    @ActionProxy(text = "Menu2")
    private void menu2() {
    	System.out.println("menu2...");
    }
    
}
