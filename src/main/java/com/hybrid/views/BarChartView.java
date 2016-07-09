package com.hybrid.views;

import com.gluonhq.particle.annotation.ParticleView;
import com.gluonhq.particle.view.FXMLView;
import com.hybrid.controllers.BarChartController;
import com.hybrid.controllers.PieChartController;

@ParticleView(name = "barchart", isDefault = false)
public class BarChartView extends FXMLView {
    
    public BarChartView() {
        super(BarChartView.class.getResource("barchart.fxml"));
    }
    
    
    @Override
    public void init() {
        ((BarChartController) getController()).init();
    }
    
    @Override
    public void start() {
        ((BarChartController) getController()).postInit();
    }
    
    @Override
    public void stop() {
        ((BarChartController) getController()).dispose();
    }
    
}