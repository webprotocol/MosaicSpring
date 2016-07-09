package com.gluonapplication.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.inject.Inject;

import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionMap;
import org.controlsfx.control.action.ActionProxy;

import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.view.ViewManager;
import com.sun.javafx.tk.Toolkit;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class SecondaryController {

    @Inject ParticleApplication app;
    
    @Inject private ViewManager viewManager;

    @FXML
    private Button button;
    
    @FXML
    private ResourceBundle resources;
    
    @FXML
    ImageView image;
    
    @FXML
    WebView browser;
    
    private Action actionHome;
    
    public void initialize() {
    	WebEngine engine = browser.getEngine();
    	
        ActionMap.register(this);
        actionHome =  ActionMap.action("goHome");
        
        button.setText(resources.getString("button.text"));
		button.setOnAction(e -> {
//			viewManager.switchView("primary");
//			Image im = new Image(getClass().getResourceAsStream("/icon.png"));
			Image im = new Image(getClass().getResource("/icon.png").toString());
			
			image.setImage(im);

			try {
				String[] list = getResourceListing(SecondaryController.class, "bundles/");
				
				for (String s : list)
					System.out.println("### " + s);
			} catch (URISyntaxException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			/*
			 * 
			 */
			System.out.println("####### " + getClass().getResource("/html/index.html").toString());
//			engine.load(SecondaryController.class.getResource("/html/index.html").toString());
			engine.load(getClass().getResource("/html/index.html").toString());
			System.out.println("####### " + engine.getLocation());
			
		});
    }
    
	String[] getResourceListing(Class clazz, String path) throws URISyntaxException, IOException {
		URL dirURL = clazz.getClassLoader().getResource(path);
		System.out.println("clazz name = " + clazz.getName());
		System.out.println("dirURL = " + dirURL.toString());
		if (dirURL != null && dirURL.getProtocol().equals("file")) {
			/* A file path: easy enough */
			System.out.println("### " + dirURL.getProtocol());
			System.out.println("### " + dirURL.getPath());
			System.out.println("dirURL.toURI() = " + dirURL.toURI().toString());
			return new File(dirURL.toURI()).list();
		}

//		if (dirURL == null) {
//			/*
//			 * In case of a jar file, we can't actually find a directory. Have
//			 * to assume the same jar as clazz.
//			 */
//			System.out.println("dirURL = " + null);
//			String me = clazz.getName().replace(".", "/") + ".class";
//			System.out.println("me = " + me);
//			
//			dirURL = clazz.getClassLoader().getResource(me);
//		}

		if (dirURL.getProtocol().equals("jar")) {
			System.out.println("### " + dirURL.getProtocol());
			System.out.println("### " + dirURL.getPath());
			/* A JAR path */
			String jarPath = dirURL.getPath().substring(5, dirURL.getPath().indexOf("!")); // strip
																							// out
																							// only
																							// the
																							// JAR
																							// file
			System.out.println("### " + URLDecoder.decode(jarPath, "UTF-8"));
			JarFile jar = new JarFile(URLDecoder.decode(jarPath, "UTF-8"));
			Enumeration<JarEntry> entries = jar.entries(); // gives ALL entries
															// in jar
			Set<String> result = new HashSet<String>(); // avoid duplicates in
														// case it is a
														// subdirectory
			while (entries.hasMoreElements()) {
				String name = entries.nextElement().getName();
				System.out.println("### name = " + name);
				if (name.startsWith(path)) { // filter according to the path
					String entry = name.substring(path.length());
					int checkSubdir = entry.indexOf("/");
					if (checkSubdir >= 0) {
						// if it is a subdirectory, we just return the directory
						// name
						entry = entry.substring(0, checkSubdir);
					}
					result.add(entry);
				}
			}
			return result.toArray(new String[result.size()]);
		}

		throw new UnsupportedOperationException("Cannot list files for URL " + dirURL);
	}
    
    public void postInit() {
        app.getParticle().getToolBarActions().add(0, actionHome);
    }
    
    public void dispose() {
        app.getParticle().getToolBarActions().remove(actionHome);
    }
    
    @ActionProxy(text = "Back")
    private void goHome() {
        viewManager.switchView("primary");
    }
    
}
