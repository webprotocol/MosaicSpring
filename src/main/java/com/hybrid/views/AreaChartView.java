package com.hybrid.views;

import com.gluonhq.particle.annotation.ParticleView;
import com.gluonhq.particle.view.FXMLView;
import com.hybrid.controllers.AreaChartController;
import com.hybrid.controllers.BarChartController;
import com.hybrid.controllers.LineChartController;
import com.hybrid.controllers.PieChartController;

@ParticleView(name = "areachart", isDefault = false)
public class AreaChartView extends FXMLView {
    
    public AreaChartView() {
        super(AreaChartView.class.getResource("areachart.fxml"));
    }
    
    
    @Override
    public void init() {
        ((AreaChartController) getController()).init();
    }
    
    @Override
    public void start() {
        ((AreaChartController) getController()).postInit();
    }
    
    @Override
    public void stop() {
        ((AreaChartController) getController()).dispose();
    }
    
}