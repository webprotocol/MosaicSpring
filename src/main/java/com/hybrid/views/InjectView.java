package com.hybrid.views;

import com.gluonhq.particle.annotation.ParticleView;
import com.gluonhq.particle.view.FXMLView;
import com.hybrid.controllers.InjectController;

@ParticleView(name = "inject", isDefault = false)
public class InjectView extends FXMLView {
    
    public InjectView() {
        super(InjectView.class.getResource("inject.fxml"));
    }
    
    
    @Override
    public void init() {
        ((InjectController) getController()).init();
    }
    
    @Override
    public void start() {
        ((InjectController) getController()).postInit();
    }
    
    @Override
    public void stop() {
        ((InjectController) getController()).dispose();
    }
    
}