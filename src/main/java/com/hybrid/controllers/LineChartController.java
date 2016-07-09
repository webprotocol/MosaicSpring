package com.hybrid.controllers;

import com.gluonhq.particle.application.Particle;
import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.view.ViewManager;

import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

import javax.inject.Inject;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionMap;
import org.controlsfx.control.action.ActionProxy;

public class LineChartController {

	
	@FXML
	Button btnSelect;
	
	@FXML
	LineChart<String, Number> lineChart;
	
    @FXML
    private ResourceBundle resources;
    

    public void initialize() {
    	
    	btnSelect.setOnAction(e -> {
    		System.out.println("btnSelect...");
    		
    		Random r = new Random();
    		
    		XYChart.Series<String, Number> series1 = new XYChart.Series<>();
            series1.setName("국어");       
            series1.getData().add(new XYChart.Data<String, Number>("2003", r.nextInt(100)));
            series1.getData().add(new XYChart.Data<String, Number>("2004", r.nextInt(100)));
            series1.getData().add(new XYChart.Data<String, Number>("2005", r.nextInt(100)));
            series1.getData().add(new XYChart.Data<String, Number>("2006", r.nextInt(100)));
            series1.getData().add(new XYChart.Data<String, Number>("2007", r.nextInt(100)));
            
            XYChart.Series<String, Number> series2 = new XYChart.Series<>();
            series2.setName("영어");       
            series2.getData().add(new XYChart.Data<String, Number>("2003", r.nextInt(100)));
            series2.getData().add(new XYChart.Data<String, Number>("2004", r.nextInt(100)));
            series2.getData().add(new XYChart.Data<String, Number>("2005", r.nextInt(100)));
            series2.getData().add(new XYChart.Data<String, Number>("2006", r.nextInt(100)));
            series2.getData().add(new XYChart.Data<String, Number>("2007", r.nextInt(100)));
            
            XYChart.Series<String, Number> series3 = new XYChart.Series<>();
            series3.setName("수학");       
            series3.getData().add(new XYChart.Data<String, Number>("2003", r.nextInt(100)));
            series3.getData().add(new XYChart.Data<String, Number>("2004", r.nextInt(100)));
            series3.getData().add(new XYChart.Data<String, Number>("2005", r.nextInt(100)));
            series3.getData().add(new XYChart.Data<String, Number>("2006", r.nextInt(100)));
            series3.getData().add(new XYChart.Data<String, Number>("2007", r.nextInt(100)));    
    		
            lineChart.getData().setAll(series1, series2, series3);
            
            
    		lineChart.setTitle("Line Chart");
    		
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
    	
    	particle.buildMenu("LineCharView -> [menu1, menu2]");

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
