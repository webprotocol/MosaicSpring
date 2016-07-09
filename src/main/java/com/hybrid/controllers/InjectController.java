package com.hybrid.controllers;

import java.util.ResourceBundle;

import javax.inject.Inject;

import org.controlsfx.control.StatusBar;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionMap;
import org.controlsfx.control.action.ActionProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.gluonhq.particle.application.Particle;
import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.form.FormManager;
import com.gluonhq.particle.state.StateManager;
import com.gluonhq.particle.view.ViewManager;
import com.hybrid.mapper.DeptMapper;
import com.hybrid.service.Service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ToolBar;

public class InjectController {

	@FXML
	Button btnSelect;
	@FXML
	ListView<String> listResult;
	@FXML
	ProgressBar progress;
	@FXML
	Button btnIncrement;
	
    @FXML
    ResourceBundle resources;
    
    @Autowired
    ApplicationContext ctx;
    
//    @Autowired
//    DriverManagerDataSource dataSource;
    
    @Autowired
    DeptMapper deptMapper;

    public void initialize() {
    	
//    	ObservableList<String> items = FXCollections.observableArrayList ();

    	btnSelect.setOnAction(e -> {
    		System.out.println("btnSelect...");
    		addContent("btnSelect Clicked...");
//    		listResult.setItems(items);
    	});
    	
    	btnIncrement.setOnAction(e -> {
    		progress.setProgress(progress.getProgress() + 0.1);
    	});
    	
    	addContent("initialize()...");
    		
    }
    void addContent(String tag) {
    		listResult.getItems().add("#####################################");
    		listResult.getItems().add("### " + tag);
    		listResult.getItems().add("#####################################");
    		listResult.getItems().add("label.text = " + (resources != null ? resources.getString("label.text") : null));
    		listResult.getItems().add("Application ctx = " + ctx);
    		listResult.getItems().add("ResourceBundle = " + resources);
    		listResult.getItems().add("ParticleApplication = " + app);
    		listResult.getItems().add("Particle = " + particle);
    		listResult.getItems().add("ViewManager = " + viewManager);
    		listResult.getItems().add("FormManager = " + formManager);
    		listResult.getItems().add("StateManager = " + stateManager);
    		listResult.getItems().add("MenuBar = " + menuBar);
    		listResult.getItems().add("ToolBar = " + toolBar);
    		listResult.getItems().add("StatusBar = " + statusBar);
    		listResult.getItems().add("FXMLLoader = " + fxmlLoader);
    		listResult.getItems().add("FXMLLoader.getControllerFactory() = " + (fxmlLoader != null ? fxmlLoader.getControllerFactory() : null));
    		
//    		listResult.getItems().add("url = " + dataSource.getUrl());
//    		listResult.getItems().add("user = " + dataSource.getUsername());
//    		listResult.getItems().add("password = " + dataSource.getPassword());
    		
    		listResult.getItems().add("deptMapper = " + deptMapper.getTest());
//    		listResult.getItems().add("deptMapper = " + deptMapper.getDept(10));
//    		listResult.getItems().add("deptMapper = " + deptMapper.getDept(20));
//    		listResult.getItems().add("deptMapper = " + deptMapper.getDept(30));
    }
    
    
    /*
     * Life Cycle
     */
    
    @Autowired(required=false) @Inject ParticleApplication app;
    @Autowired(required=false) @Inject Particle particle;
    @Autowired(required=false) @Inject ViewManager viewManager;
    @Autowired(required=false) @Inject FormManager formManager;
    @Autowired(required=false) @Inject StateManager stateManager;
    @Autowired(required=false) @Inject MenuBar menuBar;
    @Autowired(required=false) @Inject ToolBar toolBar;
    @Autowired(required=false) @Inject StatusBar statusBar;
    @Autowired(required=false) @Inject FXMLLoader fxmlLoader;
    
    private Action actionHome;
    private Action menu1;
    
    private Menu menu;
    
    public void init() {

    	addContent("init()...");
    	
    	ActionMap.register(this);
    	actionHome =  ActionMap.action("goHome");
    	menu1 =  ActionMap.action("menu1");
    	
    	particle.buildMenu("Injection Test -> [menu1, menu2]");

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
