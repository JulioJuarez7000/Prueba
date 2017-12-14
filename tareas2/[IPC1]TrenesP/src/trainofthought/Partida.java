/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainofthought;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Pablo
 */
public class Partida extends JFrame{
    
    private easy niveleasy;
    private medium nivelmedium;
    private hard nivelhard;
    private Jugador jugador;
    private JPanel PanelPartida;
    private int time;
    private int score = 0;
    private JTextField puntaje;
    private JTextField contador;
    private JTextField nombre;
    private JTextField incorrectos;
    
    private JPanel PanelData = new JPanel();
    private JButton Pause;
    
    public Partida(Jugador player, int tiempo, String Nivel) throws IOException, InterruptedException{
        
        puntaje = new JTextField();
        contador = new JTextField();
        nombre = new JTextField();
        incorrectos = new JTextField();
        
        puntaje.setEditable(false);
        contador.setEditable(false);
        nombre.setEditable(false);
        incorrectos.setEditable(false);
        
        nombre.setText("Jugador: "+player.nick);
        
        PanelData.setLayout(new GridLayout(0,5));
        
        puntaje.setFont(new Font("Arial",Font.BOLD,20));
        contador.setFont(new Font("Arial",Font.BOLD,20));
        nombre.setFont(new Font("Arial",Font.BOLD,20));
        incorrectos.setFont(new Font("Arial",Font.BOLD,20));
        
        setSize(1000,750);
        setResizable(false);
        setTitle(Nivel);
        
        this.jugador = player;
        this.time = tiempo;
        if(Nivel.equals("Facil")){
            this.niveleasy = new easy(time);
            Frameeasy();
        }
        else if(Nivel.equals("Intermedio")){
            this.nivelmedium = new medium(time);
            Framemedium();
        }
        else if(Nivel.equals("Dificil")){
            this.nivelhard = new hard(time);
            Framehard();
        }
    }
    
    public void Frameeasy() throws InterruptedException, IOException{
        
        PanelPartida = (JPanel) this.getContentPane();
        PanelPartida.setLayout(new BorderLayout());
        PanelPartida.add(niveleasy,BorderLayout.CENTER);
        setVisible(true);
        
        niveleasy.go();
        
        Timer tiempo = new Timer();
        TimerTask getScore = new TimerTask(){
            @Override
            public void run(){
                    String Score = "Correctos: "+niveleasy.getScore();
                    puntaje.setText(Score);
                    String Wrong = "Incorrectos: "+niveleasy.getWrong();
                    incorrectos.setText(Wrong);
            }
        };
        
        tiempo.schedule(getScore, 10,20);
        
        TimerTask getTime = new TimerTask(){
            int num = 60;
            @Override
            public void run(){
                if(num>=0){
                    contador.setText("Tiempo: "+num);
                    num = num -1;
                }
                else if(num < 0){
                    jugador.setScore(niveleasy.getScore());
                    niveleasy.pause=true;
                    Highscores puntajes = new Highscores();
                    puntajes.setVisible(true);
                    dispose();
                    tiempo.cancel();
                    tiempo.purge();
                }
            }
        };
        tiempo.schedule(getTime, 10,1000);
        
        Pause = new JButton("Pause");
        Pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    niveleasy.pause();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        PanelData.add(puntaje);
        PanelData.add(nombre);
        PanelData.add(contador);
        PanelData.add(incorrectos);
        PanelData.add(Pause);
        
        PanelPartida.add(PanelData,BorderLayout.SOUTH);
    }
    
    public void Framemedium() throws InterruptedException, IOException{
        PanelPartida = (JPanel) this.getContentPane();
        PanelPartida.setLayout(new BorderLayout());
        PanelPartida.add(nivelmedium,BorderLayout.CENTER);
        setVisible(true);
        
        nivelmedium.go();
        
        Timer tiempo = new Timer();
        TimerTask getScore = new TimerTask(){
            @Override
            public void run(){
                //long startTime = System.currentTimeMillis();
                //while(System.currentTimeMillis()-startTime<80000){
                    String Score = "Correctos: "+nivelmedium.getScore();
                    puntaje.setText(Score);
                    String Wrong = "Incorrectos: "+nivelmedium.getWrong();
                    incorrectos.setText(Wrong);
                //}
            }
        };
        tiempo.schedule(getScore, 10,20);
        
        TimerTask getTime = new TimerTask(){
            int num = 60;
            @Override
            public void run(){
                if(num>=0){
                    contador.setText("Tiempo: "+num);
                    num = num -1;
                }
                else if(num < 0){
                    jugador.setScore(nivelmedium.getScore());
                    nivelmedium.pause=true;
                    Highscores puntajes = new Highscores();
                    puntajes.setVisible(true);
                    dispose();
                    tiempo.cancel();
                    tiempo.purge();
                }
            }
        };
        
        tiempo.schedule(getTime, 10,1000);
        
        Pause = new JButton("Pause");
        Pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    nivelmedium.pause();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        PanelData.add(puntaje);
        PanelData.add(nombre);
        PanelData.add(contador);
        PanelData.add(incorrectos);
        PanelData.add(Pause);
        
        PanelPartida.add(PanelData,BorderLayout.SOUTH);
        
    }
    public void Framehard() throws InterruptedException, IOException{
        PanelPartida = (JPanel) this.getContentPane();
        PanelPartida.setLayout(new BorderLayout());
        PanelPartida.add(nivelhard,BorderLayout.CENTER);
        setVisible(true);
        
        nivelhard.go();
        
        Timer tiempo = new Timer();
        TimerTask getScore = new TimerTask(){
            @Override
            public void run(){
                //long startTime = System.currentTimeMillis();
                //while(System.currentTimeMillis()-startTime<80000){
                    String Score = "Correctos: "+nivelhard.getScore();
                    puntaje.setText(Score);
                    String Wrong = "Incorrectos: "+nivelhard.getWrong();
                    incorrectos.setText(Wrong);
                //}
            }
        };
        tiempo.schedule(getScore, 10,20);
        
        TimerTask getTime = new TimerTask(){
            int num = 60;
            @Override
            public void run(){
                if(num>=0){
                    contador.setText("Tiempo: "+num);
                    num = num -1;
                }
                else if(num < 0){
                    jugador.setScore(nivelhard.getScore());
                    nivelhard.pause=true;
                    Highscores puntajes = new Highscores();
                    puntajes.setVisible(true);
                    dispose();
                    tiempo.cancel();
                    tiempo.purge();
                }
            }
        };
        
        tiempo.schedule(getTime, 10,1000);
        
        Pause = new JButton("Pause");
        Pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    nivelhard.pause();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        PanelData.add(puntaje);
        PanelData.add(nombre);
        PanelData.add(contador);
        PanelData.add(incorrectos);
        PanelData.add(Pause);
        
        PanelPartida.add(PanelData,BorderLayout.SOUTH);
        
    }
}
