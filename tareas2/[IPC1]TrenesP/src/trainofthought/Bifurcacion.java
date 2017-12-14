/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainofthought;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class Bifurcacion {
    
    int x;
    int y;
    
    //private int ALTO = 100, LARGO = 100;
    
    private String direccion;
    
    //public JPanel map;
    
    //imagen
    public BufferedImage img;
    public File image; 
    
    public Bifurcacion(int x, int y, JPanel map) throws IOException{
        this.x = x;
        this.y = y;
        //this.map = map;
        direccion = "RECTO HORIZONTAL";
        getImage();
    }
    
    public void setDireccion(String nueva) throws IOException{
        this.direccion = nueva;
        getImage();
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public Rectangle getBif(){
        if(direccion.equals("ABAJO A DERECHA")||direccion.equals("ABAJO A IZQUIERDA")){
            return new Rectangle(x,y,100,1);
        }
        else if(direccion.equals("DERECHA A ABAJO")||direccion.equals("DERECHA A ARRIBA")){
            return new Rectangle(x-10,y,1,100);    
        }
        else if(direccion.equals("ARRIBA A IZQUIERDA")||direccion.equals("ARRIBA A DERECHA")){
            return new Rectangle(x,y+100,100,1);    
        }
        else if(direccion.equals("IZQUIERDA A ARRIBA")||direccion.equals("IZQUIERDA A ABAJO")||direccion.equals("IZQUIERDA A ABAJO HARD")){
            return new Rectangle(x+100,y,1,100);    
        }
        return new Rectangle(0,0,1,1);        
    }
    
    public void paint(Graphics2D g){
        g.drawImage(img, x, y, null);
    }
    
    public void getImage() throws IOException{
        
        this.image = new File("C:\\Users\\pablu\\Documents\\TAREAS\\IPC1\\PRACTICA 3\\TrainOfThought\\src\\trainofthought\\IMAGENES\\BIFURCACIONES\\"+direccion+".png");
        //if(image!=null){
        img = ImageIO.read(image);        
        //}
    }

}
