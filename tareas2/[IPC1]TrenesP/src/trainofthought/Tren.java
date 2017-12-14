/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainofthought;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class Tren {
    //posicion x y
    public int posx = 50;
    public int posy = 50;
    
    //direcion x y
    public int dirx = 1;
    public int diry = 0;
    
    //panel donde se ubica
    public JPanel map;
    
    //imagen
    private String color;
    public BufferedImage img;
    public File image; 
    
    //estado del tren
    public boolean arrived = false;
    
    //posibles bifurcaciones
    public Bifurcacion[] bifs;
    
    //posibles estaciones
    public Estacion ests[];
    
        
    public Tren(JPanel map,String color, Bifurcacion[] Bif, Estacion[] ests) throws IOException{
        this.ests = ests;
        this.bifs = Bif;
        this.map = map;
        this.color = color;
        this.image = new File("C:\\Users\\pablu\\Documents\\TAREAS\\IPC1\\PRACTICA 3\\TrainOfThought\\src\\trainofthought\\IMAGENES\\TRENES\\"+color+".png");
        getImage();
    }
    
    public void move(){
        
        if(posx + dirx < 0){
            dirx = 1;
        }
        if(posx + dirx > map.getWidth()-100){
            dirx = -1;
        }
        if(posy + diry < 0){
            diry = 1;
        }
        if(posy + diry > map.getHeight()-100){
            diry = -1;
        }
        //COLISION CON BIFURCACION
        colision();
        
        //LLEGADA A LA ESTACION
        estacion();
        
        posx+= dirx;
        posy+= diry;
    }
    
    public void paint(Graphics2D g){
        
        if(dirx<0)
        g.drawImage(img, posx, posy, null);
        else if(dirx>=0)
        g.drawImage(img, posx + 100, posy, -100, 100, null);
        
        //g.fill(new Rectangle(posx,posy,100,100));
    }
    
    public void getImage() throws IOException{
        if(image!=null){
        img = ImageIO.read(image);        
        }
    }
    
    public Rectangle getBounds(){
        return new Rectangle(posx,posy,100,100);
    }
    
    public void colision(){
        for(Bifurcacion bif:bifs){
            if(getBounds().intersects(bif.getBif())){
                if(bif.getDireccion().equals("IZQUIERDA A ABAJO")||bif.getDireccion().equals("DERECHA A ABAJO")||bif.getDireccion().equals("IZQUIERDA A ABAJO HARD")){
                    dirx = 0;
                    diry = 1;
                    return;
                }
                else if(bif.getDireccion().equals("ARRIBA A IZQUIERDA")||bif.getDireccion().equals("ABAJO A IZQUIERDA")){
                    dirx = -1;
                    diry = 0;
                    return;
                }
                else if(bif.getDireccion().equals("ARRIBA A DERECHA")||bif.getDireccion().equals("ABAJO A DERECHA")){
                    dirx = 1;
                    diry = 0;
                    return;
                }
                else if(bif.getDireccion().equals("IZQUIERDA A ARRIBA")||bif.getDireccion().equals("DERECHA A ARRIBA")){
                    dirx = 0;
                    diry = -1;
                    return;
                }
            }
        }
    }
    public void estacion(){
        for(Estacion est:ests){
            if(est!=null&&getBounds().intersects(est.getEstacion())){
                this.img = null;
                this.arrived=true;
                easy scoreifeasy = new easy();
                medium scoreifmedium = new medium();
                hard scorehard = new hard();
                if(est.color.equals(color)){
                    scoreifeasy.setScore();
                    scoreifmedium.setScore();
                    scorehard.setScore();
                }
                else{
                    scoreifmedium.setWrong();
                    scoreifeasy.setWrong();
                    scorehard.setWrong();
                }
            }
        }
    }
    
}
