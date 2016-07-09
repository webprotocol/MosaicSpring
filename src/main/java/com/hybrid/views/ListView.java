package com.hybrid.views;

import com.gluonhq.particle.annotation.ParticleView;
import com.gluonhq.particle.view.FXMLView;
import com.hybrid.controllers.ListController;
import com.hybrid.controllers.SecondaryController;

@ParticleView(name = "list", isDefault = false)
public class ListView extends FXMLView {
    
    public ListView() {
        super(ListView.class.getResource("list.fxml"));
    }
    
    
    @Override
    public void init() {
        ((ListController) getController()).init();
    }
    
    @Override
    public void start() {
        ((ListController) getController()).postInit();
    }
    
    @Override
    public void stop() {
        ((ListController) getController()).dispose();
    }
    
}