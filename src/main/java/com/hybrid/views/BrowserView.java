package com.hybrid.views;

import com.gluonhq.particle.annotation.ParticleView;
import com.gluonhq.particle.view.FXMLView;
import com.hybrid.controllers.BrowserController;
import com.hybrid.controllers.ListController;
import com.hybrid.controllers.SecondaryController;

@ParticleView(name = "browser", isDefault = false)
public class BrowserView extends FXMLView {
    
    public BrowserView() {
        super(BrowserView.class.getResource("browser.fxml"));
    }
    
    
    BrowserController controller;
    @Override
    public void init() {
        controller = (BrowserController) getController();
        controller.init();
    }
    
    @Override
    public void start() {
        controller.postInit();
    }
    
    @Override
    public void stop() {
        controller.dispose();
    }
    
}