/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainofthought;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class iniciarPartida extends JFrame{
    
    private JPanel startPartida;
    private JComboBox <Integer> time;
    private JComboBox <String> players;
    private JComboBox <String> levels;
    private Players jugadores = new Players();
    private String[] nicks;
    
    public iniciarPartida(){
            Jugador[] registrados = jugadores.getJugadores();
            
            nicks = new String[registrados.length];
            for(int i = 0; i < registrados.length;i++){
                if(registrados[i]!=null){
                    nicks[i]=registrados[i].nick;
                }
            }
            players = new JComboBox(nicks);
            
            setSize(300,150);
            setTitle("INICIAR PARTIDA");
            setResizable(false);
            
            startPartida = (JPanel) this.getContentPane();
            startPartida.setLayout(new GridLayout(4,1));
            
            startPartida.add(players);
            
            Integer[] seconds = new Integer[6];
            for(int i = 0; i < 6; i++){
                seconds[i] = 6-i;
            }
            
            time = new JComboBox(seconds);
            
            startPartida.add(time);
            
            String[] level = new String[]{
                "Facil","Intermedio","Dificil"
            };
            
            levels = new JComboBox(level);
            
            startPartida.add(levels);
            
            JButton Start = new JButton("INICIAR");
            
            Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    openWindow();
                } catch (IOException ex) {
                    Logger.getLogger(iniciarPartida.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(iniciarPartida.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
            
            startPartida.add(Start);
    }
    
    public void openWindow() throws IOException, InterruptedException{
        String nivel = (String)levels.getSelectedItem();
        int tiempo = (int) time.getSelectedItem();
        String nombre = (String) players.getSelectedItem();
        Partida nuevaPartida = new Partida(jugadores.getJugador(nombre),tiempo,nivel);
    }
    
}
