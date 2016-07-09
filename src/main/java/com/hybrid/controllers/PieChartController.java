package com.hybrid.controllers;

import com.gluonhq.particle.application.Particle;
import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.view.ViewManager;
import com.hybrid.MainApplication;
import com.hybrid.model.Dept;

import java.util.Random;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

import javax.inject.Inject;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionMap;
import org.controlsfx.control.action.ActionProxy;

public class PieChartController {

	
	@FXML
	Button btnSelect;
	
	@FXML
	PieChart pieChart;
	
    @FXML
    private ResourceBundle resources;
    

    public void initialize() {
    	
    	btnSelect.setOnAction(e -> {
    		System.out.println("btnSelect...");
    		
    		Random r = new Random();
    		ObservableList<PieChart.Data> data = FXCollections.observableArrayList(new PieChart.Data("수학", r.nextInt(100)), new PieChart.Data("영어", r.nextInt(100)));
    		
    		pieChart.setData(data);
    		
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
    	
    	particle.buildMenu("PieCharView -> [menu1, menu2]");

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
    
    public void removeMenu() {
    	
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
    	System.out.println("piechart menu1...");
    }
    
    @ActionProxy(text = "Menu2")
    private void menu2() {
    	System.out.println("piechart menu2...");
    }
    
}
