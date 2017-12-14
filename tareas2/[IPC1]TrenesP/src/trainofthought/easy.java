/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainofthought;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class easy extends JPanel{
    private int time;
    
    private static Integer wrong;
    private static Integer score;
    
  //  public Tren topaint;
    /*
    public Tren rojo;
    public Tren azul;
    public Tren verde;
    public Tren amarillo;
    */
    public Tren[] trenes;
        
    public Bifurcacion[] bifs = new Bifurcacion[6];
    public Bifurcacion bif1;
    public Bifurcacion bif2;
    public Bifurcacion bif3;
    
    public Bifurcacion bif4;
    public Bifurcacion bif5;
    public Bifurcacion bif6;
    
    public Estacion[] ests = new Estacion[4];
    public Estacion rojo;
    public Estacion verde;
    public Estacion azul;
    public Estacion amarillo;
    
    public boolean pause;
    
    private JLabel background;
    
        @Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
                
                bif1.paint(g2d);
                bif2.paint(g2d);
                bif3.paint(g2d);
                bif4.paint(g2d);
                bif5.paint(g2d);
                bif6.paint(g2d);
                
                for(int i = 0; i < 60; i++){
                    if(trenes[i]!=null){
                        trenes[i].paint(g2d);
                    }
                }
                //Tren topaint 
                //topaint.paint(g2d);
                /*
		rojo.paint(g2d);
                azul.paint(g2d);
                verde.paint(g2d);
                amarillo.paint(g2d);
                */
	}
    
    public easy(){
    }
        
    public easy(int time) throws IOException, InterruptedException{
        /*
        rojo = new Tren(this, "ROJO");
        azul = new Tren(this, "AZUL");
        verde = new Tren(this,"VERDE");
        amarillo = new Tren(this,"AMARILLO");
        */
        trenes = new Tren[60];
        this.time = time*1000;
        this.score = 0;
        this.wrong = 0;
        
        setLayout(null);
        
        File easy = new File("C:\\Users\\pablu\\Documents\\TAREAS\\IPC1\\PRACTICA 3\\TrainOfThought\\src\\trainofthought\\IMAGENES\\MAPAS\\easy.png");
        background = new JLabel(new ImageIcon(ImageIO.read(easy)));
        background.setBounds(0,0,1000,700);
        add(background);
        
        //setBackground(Color.GREEN);
        bif1 = new Bifurcacion(600,50,this);
        bif1.setDireccion("IZQUIERDA A ABAJO");
        bif2 = new Bifurcacion(80,400,this);
        bif2.setDireccion("DERECHA A ABAJO");
        bif3 = new Bifurcacion(775,400,this);
        bif3.setDireccion("IZQUIERDA A ABAJO");
        
        //BIFURCACION 4
        
        bif4 = new Bifurcacion(260,400,this);
        
        JButton changebif4 = new JButton("4");
        changebif4.setBounds(230, 370, 30, 30);        
        changebif4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                if(bif4.getDireccion().equals("RECTO HORIZONTAL")){
                    try {
                        bif4.setDireccion("DERECHA A ABAJO");
                    } catch (IOException ex) {
                        Logger.getLogger(easy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(bif4.getDireccion().equals("DERECHA A ABAJO")){
                    try {
                        bif4.setDireccion("RECTO HORIZONTAL");
                    } catch (IOException ex) {
                        Logger.getLogger(easy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        add(changebif4);
        
        //BIFURCACION 5
        bif5 = new Bifurcacion(421,400,this);
        
        JButton changebif5 = new JButton("5");
        changebif5.setBounds(391, 370, 30, 30);        
        changebif5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                if(bif5.getDireccion().equals("RECTO HORIZONTAL")){
                    try {
                        bif5.setDireccion("DERECHA A ABAJO");
                    } catch (IOException ex) {
                        Logger.getLogger(easy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(bif5.getDireccion().equals("DERECHA A ABAJO")){
                    try {
                        bif5.setDireccion("RECTO HORIZONTAL");
                    } catch (IOException ex) {
                        Logger.getLogger(easy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        add(changebif5);
        
        //BIFURCACION 6
        bif6 = new Bifurcacion(601,400,this);
        bif6.setDireccion("ARRIBA A IZQUIERDA");
        
        JButton changebif6 = new JButton("6");
        changebif6.setBounds(571, 370, 30, 30);        
        changebif6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                if(bif6.getDireccion().equals("ARRIBA A IZQUIERDA")){
                    try {
                        bif6.setDireccion("ARRIBA A DERECHA");
                    } catch (IOException ex) {
                        Logger.getLogger(easy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(bif6.getDireccion().equals("ARRIBA A DERECHA")){
                    try {
                        bif6.setDireccion("ARRIBA A IZQUIERDA");
                    } catch (IOException ex) {
                        Logger.getLogger(easy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        add(changebif6);
        
        bifs[0]=bif1;
        bifs[1]=bif2;
        bifs[2]=bif3;
        bifs[3]=bif4;
        bifs[4]=bif5;
        bifs[5]=bif6;
        
        //ESTACIONES
        rojo = new Estacion("ROJO",70,600);
        azul = new Estacion("AZUL",410,600);
        verde = new Estacion("VERDE",240,600);
        amarillo = new Estacion("AMARILLO",766,600);
        
        ests[0] = rojo;
        ests[1] = verde;
        ests[2] = azul;
        ests[3] = amarillo;
    }
    
    public void go() throws InterruptedException, IOException{
        Timer launcher = new Timer();
        TimerTask letsgo = new TimerTask(){
            @Override
            public void run(){
                long startTime = System.currentTimeMillis();
                while(/*System.currentTimeMillis()-startTime<60000&&*/!pause){
                    LaunchTrain tren = null;
                    try {
                        tren = new LaunchTrain(getTren());
                    } catch (IOException ex) {
                        Logger.getLogger(easy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    tren.start();
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(easy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                launcher.cancel();
                launcher.purge();
            }
        };
        launcher.schedule(letsgo, 0);        
    }
    
    private Tren getTren() throws IOException{
        int choose = (int)(Math.random()*4)+1;
        if(choose==1){
            Tren rojo = new Tren(this, "ROJO",bifs,ests);
        //    this.topaint = rojo;
            for(int i = 0; i < 60; i++){
                if(trenes[i]==null){
                    trenes[i]=rojo;
                    break;
                }
            }
            return rojo;
        }
        else if(choose==2){
            Tren azul = new Tren(this, "AZUL",bifs,ests);
        //    this.topaint = azul;
            for(int i = 0; i < 60; i++){
                if(trenes[i]==null){
                    trenes[i]=azul;
                    break;
                }
            }
            return azul;
        }
        else if(choose==3){
            Tren verde = new Tren(this,"VERDE",bifs,ests);
        //    this.topaint = verde;
            for(int i = 0; i < 60; i++){
                if(trenes[i]==null){
                    trenes[i]=verde;
                    break;
                }
            }
            return verde;
        }
        else if(choose==4){
            Tren amarillo = new Tren(this,"AMARILLO",bifs,ests);
        //    this.topaint = amarillo;
            for(int i = 0; i < 60; i++){
                if(trenes[i]==null){
                    trenes[i]=amarillo;
                    break;
                }
            }
            return amarillo;
        }
        return null;
    }
    
    public int getScore(){
        if(score == null){
            score = 0;
        }
        return score;
    }
    
    public void setScore(){
        if(score == null){
            score = 0;
        }
        this.score = this.score + 1;
    }
    
    public int getWrong(){
        if(wrong == null){
            wrong = 0;
        }
        return wrong;
    }
    
    public void setWrong(){
        if(wrong == null){
            wrong = 0;
        }
        this.wrong = this.wrong + 1;
    }
    
    public void pause() throws InterruptedException, IOException{
    if(pause==false){
        for(Tren tren: trenes){
            if(tren!=null){
            tren.arrived = true;
            }
        }
        pause = true;
    }
    else if(pause==true){
        for(Tren tren: trenes){
            if(tren!=null){
            tren.arrived = false;
            LaunchTrain train = new LaunchTrain(tren);
            train.start();
            }
        }
        go();
        pause = false;
    }
    }
    
}
