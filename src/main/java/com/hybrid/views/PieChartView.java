package com.hybrid.views;

import com.gluonhq.particle.annotation.ParticleView;
import com.gluonhq.particle.view.FXMLView;
import com.hybrid.controllers.PieChartController;

@ParticleView(name = "piechart", isDefault = false)
public class PieChartView extends FXMLView {
    
    public PieChartView() {
        super(PieChartView.class.getResource("piechart.fxml"));
    }
    
    
    @Override
    public void init() {
        ((PieChartController) getController()).init();
    }
    
    @Override
    public void start() {
        ((PieChartController) getController()).postInit();
    }
    
    @Override
    public void stop() {
        ((PieChartController) getController()).dispose();
    }
    
}