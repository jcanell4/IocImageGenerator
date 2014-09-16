/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ioc.wiki.processingmanager;

import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.MemoryImageSource;
import processing.core.PApplet;

/**
 *
 * @author Daniel Criado Casas<dani.criado.casas@gmail.com>
 */
public class ImageGenerator extends PApplet {
    public ImageObserver imageObserver=null;
    
    /**
     * És la variable llavor
     */
    private String seed;

    /**
     * Constructor de la classe
     */
    public ImageGenerator(){
        this.seed = null;
    }
    
    /**
     * Especifica quina es la llavor en el metode randomSeed() de PApplet.
     * @param seed Llavor que es pasa en forma de string.
     */
    public void setSeed(String seed) {
        this.seed = seed;
        this.randomSeed(seed.hashCode());
    }
    
    /**
     * Funcio que et dona la llavor.
     *
     * @return Retorna un string amb la llavor.
     */
    public String getSeed() {
        return this.seed;
    }
    
    public void generateAwtImage(ImageObserver observer){
        imageObserver=observer;
        this.registerMethod("post", this);
        this.init();
    }
    
    private void generateAwtImage(){
        if(imageObserver==null){
            return;
        }
        loadPixels();
        MemoryImageSource source = new MemoryImageSource(width, height, pixels, 0, width);
        Image imag = createImage(source);   
        imageObserver.imageUpdate(imag, ImageObserver.ALLBITS, 0, 0, width, height);
    }
    
    public void post(){
        generateAwtImage();
    }

    /*
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("IsActive: ");
        ret.append(isActive());
        ret.append(" Loop: ");
        ret.append(looping);
        ret.append(" Def: ");
        ret.append(defaultSize);
        ret.append(" fin: ");
        ret.append(finished);
        ret.append(" insideDraw: ");
        ret.append(insideDraw);
        ret.append(" canDraw: ");
        ret.append(canDraw());
        ret.append(" redraw: ");
        ret.append(redraw);
        ret.append(" w: ");
        ret.append(width);
        ret.append(" h: ");
        ret.append(height);
        ret.append(" g.w: ");
        if(g==null){
            ret.append("g is null");
        }else{
            ret.append(g.width);
        }
        ret.append("g.h: ");
        if(g==null){
            ret.append("g is null");
        }else{
            ret.append(g.height);
        }
        ret.append("time: ");
        ret.append(System.currentTimeMillis());
        return ret.toString(); 
    }
    */
    
}
