/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainofthought;

import java.awt.Rectangle;

/**
 *
 * @author Pablo
 */
public class Estacion {
    
    int x;
    int y;
    
    public String color;
    
    public Estacion(String color, int x, int y){
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    public Rectangle getEstacion(){
        return new Rectangle(x,y,100,100);
    }
    
}
