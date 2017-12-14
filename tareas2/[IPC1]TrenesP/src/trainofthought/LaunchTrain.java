/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainofthought;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class LaunchTrain extends Thread{
    
    Tren tren;
    
    public LaunchTrain(Tren tren){
        this.tren = tren;
    }
    
    @Override
    public void run(){
        while(!tren.arrived){
        tren.move();
        tren.map.repaint();
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(LaunchTrain.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
}
