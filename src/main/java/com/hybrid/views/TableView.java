package com.hybrid.views;

import com.gluonhq.particle.annotation.ParticleView;
import com.gluonhq.particle.view.FXMLView;
import com.hybrid.controllers.ListController;
import com.hybrid.controllers.SecondaryController;
import com.hybrid.controllers.TableController;

@ParticleView(name = "table", isDefault = false)
public class TableView extends FXMLView {
    
    public TableView() {
        super(TableView.class.getResource("table.fxml"));
    }
    
    
    @Override
    public void init() {
        ((TableController) getController()).init();
    }
    
    @Override
    public void start() {
        ((TableController) getController()).postInit();
    }
    
    @Override
    public void stop() {
        ((TableController) getController()).dispose();
    }
    
}