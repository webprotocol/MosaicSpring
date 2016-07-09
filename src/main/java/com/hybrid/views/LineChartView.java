package com.hybrid.views;

import com.gluonhq.particle.annotation.ParticleView;
import com.gluonhq.particle.view.FXMLView;
import com.hybrid.controllers.BarChartController;
import com.hybrid.controllers.LineChartController;
import com.hybrid.controllers.PieChartController;

@ParticleView(name = "linechart", isDefault = false)
public class LineChartView extends FXMLView {
    
    public LineChartView() {
        super(LineChartView.class.getResource("linechart.fxml"));
    }
    
    
    @Override
    public void init() {
        ((LineChartController) getController()).init();
    }
    
    @Override
    public void start() {
        ((LineChartController) getController()).postInit();
    }
    
    @Override
    public void stop() {
        ((LineChartController) getController()).dispose();
    }
    
}