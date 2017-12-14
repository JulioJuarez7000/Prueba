/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainofthought;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
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
 * @author pablu
 */
public class medium extends JPanel{
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
    
    public Estacion[] ests = new Estacion[8];
    public Estacion rojo;
    public Estacion verde;
    public Estacion azul;
    public Estacion amarillo;
    public Estacion celeste;
    public Estacion fucsia;
    public Estacion negro;
    public Estacion emetra;
    
    JLabel background;
    
    public boolean pause;
    
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
    
    public medium(){
        
    }
        
    public medium(int time) throws IOException, InterruptedException{
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
        
        File easy = new File("C:\\Users\\pablu\\Documents\\TAREAS\\IPC1\\PRACTICA 3\\TrainOfThought\\src\\trainofthought\\IMAGENES\\MAPAS\\medium.png");
        background = new JLabel(new ImageIcon(ImageIO.read(easy)));
        background.setBounds(0,0,1000,700);
        add(background);
        
        //setBackground(Color.GREEN);
        
        //BIFURCACION 1
        bif1 = new Bifurcacion(450,50,this);
        
        JButton changebif1 = new JButton("1");
        changebif1.setBounds(420, 20, 30, 30);        
        changebif1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                if(bif1.getDireccion().equals("RECTO HORIZONTAL")){
                    try {
                        bif1.setDireccion("IZQUIERDA A ABAJO");
                    } catch (IOException ex) {
                        Logger.getLogger(easy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(bif1.getDireccion().equals("IZQUIERDA A ABAJO")){
                    try {
                        bif1.setDireccion("RECTO HORIZONTAL");
                    } catch (IOException ex) {
                        Logger.getLogger(easy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        add(changebif1);
        
        //BIFURCACION 2
        bif2 = new Bifurcacion(450,200,this);
        bif2.setDireccion("ARRIBA A IZQUIERDA");
        
        JButton changebif2 = new JButton("2");
        changebif2.setBounds(420, 170, 30, 30);        
        changebif2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                if(bif2.getDireccion().equals("ARRIBA A IZQUIERDA")){
                    try {
                        bif2.setDireccion("RECTO VERTICAL");
                    } catch (IOException ex) {
                        Logger.getLogger(easy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(bif2.getDireccion().equals("RECTO VERTICAL")){
                    try {
                        bif2.setDireccion("ARRIBA A DERECHA");
                    } catch (IOException ex) {
                        Logger.getLogger(easy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(bif2.getDireccion().equals("ARRIBA A DERECHA")){
                    try {
                        bif2.setDireccion("ARRIBA A IZQUIERDA");
                    } catch (IOException ex) {
                        Logger.getLogger(easy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        add(changebif2);
        
        //BIFURCACION 3
        bif3 = new Bifurcacion(240,200,this);
        bif3.setDireccion("RECTO HORIZONTAL");
        
        JButton changebif3 = new JButton("3");
        changebif3.setBounds(210, 170, 30, 30);        
        changebif3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                if(bif3.getDireccion().equals("RECTO HORIZONTAL")){
                    try {
                        bif3.setDireccion("DERECHA A ABAJO");
                    } catch (IOException ex) {
                        Logger.getLogger(easy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(bif3.getDireccion().equals("DERECHA A ABAJO")){
                    try {
                        bif3.setDireccion("RECTO HORIZONTAL");
                    } catch (IOException ex) {
                        Logger.getLogger(easy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        add(changebif3);
        
        //BIFURCACION 4
        
        bif4 = new Bifurcacion(240,350,this);
        bif4.setDireccion("RECTO VERTICAL");
        
        JButton changebif4 = new JButton("4");
        changebif4.setBounds(210, 320, 30, 30);        
        changebif4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                if(bif4.getDireccion().equals("RECTO VERTICAL")){
                    try {
                        bif4.setDireccion("ARRIBA A IZQUIERDA");
                    } catch (IOException ex) {
                        Logger.getLogger(easy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(bif4.getDireccion().equals("ARRIBA A IZQUIERDA")){
                    try {
                        bif4.setDireccion("RECTO VERTICAL");
                    } catch (IOException ex) {
                        Logger.getLogger(easy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        add(changebif4);
        
        //BIFURCACION 5
        bif5 = new Bifurcacion(240,550,this);
        bif5.setDireccion("ARRIBA A DERECHA");
        
        JButton changebif5 = new JButton("5");
        changebif5.setBounds(210, 520, 30, 30);        
        changebif5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                if(bif5.getDireccion().equals("ARRIBA A DERECHA")){
                    try {
                        bif5.setDireccion("ARRIBA A IZQUIERDA");
                    } catch (IOException ex) {
                        Logger.getLogger(easy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(bif5.getDireccion().equals("ARRIBA A IZQUIERDA")){
                    try {
                        bif5.setDireccion("ARRIBA A DERECHA");
                    } catch (IOException ex) {
                        Logger.getLogger(easy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        add(changebif5);
        
        //BIFURCACION 6
        bif6 = new Bifurcacion(650,550,this);
        bif6.setDireccion("IZQUIERDA A ARRIBA");
        
        JButton changebif6 = new JButton("6");
        changebif6.setBounds(620, 520, 30, 30);        
        changebif6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                if(bif6.getDireccion().equals("IZQUIERDA A ARRIBA")){
                    try {
                        bif6.setDireccion("RECTO HORIZONTAL");
                    } catch (IOException ex) {
                        Logger.getLogger(easy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(bif6.getDireccion().equals("RECTO HORIZONTAL")){
                    try {
                        bif6.setDireccion("IZQUIERDA A ARRIBA");
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
        rojo = new Estacion("ROJO",850,50);
        azul = new Estacion("AZUL",50,350);
        verde = new Estacion("VERDE",650,350);
        amarillo = new Estacion("AMARILLO",50,200);
        celeste = new Estacion("CELESTE",450,350);
        emetra = new Estacion("EMETRA",50,550);
        negro = new Estacion("NEGRO",850,550);
        fucsia = new Estacion("FUCSIA",850,200);
        
        ests[0] = rojo;
        ests[1] = verde;
        ests[2] = azul;
        ests[3] = amarillo;
        ests[4] = celeste;
        ests[5] = emetra;
        ests[6] = negro;
        ests[7] = fucsia;
    }
    
    public void go() throws InterruptedException, IOException{
        Timer launcher = new Timer();
        TimerTask letsgo = new TimerTask(){
            @Override
            public void run(){
                long startTime = System.currentTimeMillis();
                while(!pause){
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
        int choose = (int)(Math.random()*8)+1;
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
        else if(choose==5){
            Tren celeste = new Tren(this,"CELESTE",bifs,ests);
        //    this.topaint = amarillo;
            for(int i = 0; i < 60; i++){
                if(trenes[i]==null){
                    trenes[i]=celeste;
                    break;
                }
            }
            return celeste;
        }
        else if(choose==6){
            Tren emetra = new Tren(this,"EMETRA",bifs,ests);
        //    this.topaint = amarillo;
            for(int i = 0; i < 60; i++){
                if(trenes[i]==null){
                    trenes[i]=emetra;
                    break;
                }
            }
            return emetra;
        }
        else if(choose==7){
            Tren fucsia = new Tren(this,"FUCSIA",bifs,ests);
        //    this.topaint = amarillo;
            for(int i = 0; i < 60; i++){
                if(trenes[i]==null){
                    trenes[i]=fucsia;
                    break;
                }
            }
            return fucsia;
        }
        else if(choose==8){
            Tren negro = new Tren(this,"NEGRO",bifs,ests);
        //    this.topaint = amarillo;
            for(int i = 0; i < 60; i++){
                if(trenes[i]==null){
                    trenes[i]=negro;
                    break;
                }
            }
            return negro;
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
