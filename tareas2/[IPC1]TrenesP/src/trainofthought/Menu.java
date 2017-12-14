/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainofthought;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Pablo
 */
public class Menu extends JFrame{
    
    private JPanel mainpanel;
    private Players register = new Players();
    final JFXPanel fxPanel = new JFXPanel();
    private MediaPlayer mediaPlayer;
    
    public Menu() throws IOException{
        //-----------VENTANA PRINCIPAL
        setSize(400,600);
        setTitle("Tain of Thought");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
        music();
        //-----------MAIN PANEL
        mainpanel = (JPanel) this.getContentPane();
        mainpanel.setLayout(new BorderLayout());
        
        //------TITULO
        
        JLabel title = new JLabel("Trains of Thought",JLabel.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,30));
        mainpanel.add(title,BorderLayout.CENTER);
        
        //-----MENU
        
        JPanel PanelBotones = new JPanel();
        PanelBotones.setLayout(new GridLayout(4,1));
        PanelBotones.setPreferredSize(new Dimension(400,500));
        
        mainpanel.add(PanelBotones,BorderLayout.SOUTH);
        
        //INICIAR PARTIDA
        JButton iniciar = new JButton("INICIAR PARTIDA");
        iniciar.setEnabled(false);
        
        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarPartida iniciar = new iniciarPartida();
                iniciar.setVisible(true);
                //mediaPlayer.stop();
            }
        });
        
        PanelBotones.add(iniciar);
        
        //REGISTRAR 
        JButton registrar = new JButton("JUGADORES");
        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register.setVisible(true);
                iniciar.setEnabled(true);
            }
        });
        PanelBotones.add(registrar);
        
        //SCORES 
        JButton scores = new JButton("PUNTUACIONES");
        
        scores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Highscores puntajes = new Highscores();
                puntajes.setVisible(true);
            }
        });
        
        PanelBotones.add(scores);
        
        //EXIT 
        JButton exit = new JButton("SALIR");
        PanelBotones.add(exit);
        
    }
    private void music() throws IOException{
        File song = new File("mainsong.mp3");
        Media hit = new Media(song.toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }
}
