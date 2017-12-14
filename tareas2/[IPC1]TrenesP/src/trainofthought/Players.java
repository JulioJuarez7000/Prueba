/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainofthought;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Pablo
 */
public class Players extends JFrame{
    
    private static Jugador[] jugadores = new Jugador[5];
    private JPanel playerspanel;
    private boolean abletoadd;
    private boolean abletodelete;
    private JButton add = new JButton("ADD PLAYER");
    private JButton delete = new JButton("DELETE PLAYER");
    
    public Players(){
        
        setSize(300,120);
        setTitle("JUGADORES");
        setResizable(false);
        
        playerspanel = (JPanel) this.getContentPane();
        playerspanel.setLayout(new GridLayout(0,2));
                
        
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                for(int i = 0; i<5; i++){
                    if(jugadores[i]==null){
                        Jugador j = new Jugador();
                        jugadores[i] = j;
                        
                        addPlayer register = new addPlayer(j);
                        register.setVisible(true);
                        break;
                        
                    }
                }
            }
        });
        
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delPlayer del = new delPlayer(jugadores);
                del.setVisible(true);
            }
        });
        
        
        playerspanel.add(add);
        playerspanel.add(delete);
        
        
        
        
    }
    
    public void deletePlayer(String nick){
        for(int i = 0; i <5; i++){
            if(jugadores[i]!=null && nick.equals(jugadores[i].nick)){
                jugadores[i] = null;
            }
        }
    }
    
    public Jugador[] getJugadores(){
        return jugadores;
    }
    
    public Jugador getJugador(String nick){
        for(int i = 0; i < 5; i++){
            if(jugadores[i]!=null && nick.equals(jugadores[i].nick)){
                return jugadores[i];
            }
        }
        return jugadores[0];
    }
    
}
