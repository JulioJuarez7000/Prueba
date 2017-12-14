/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainofthought;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Pablo
 */
public class addPlayer extends JFrame{
    
    private JPanel addPanel;
    private Jugador player;
    private JTextField name = new JTextField();
    private JTextField nick = new JTextField();
    private JButton add = new JButton("Añadir");
    
    public addPlayer(Jugador nuevo){
        this.player = nuevo;
        
        setSize(300,180);
        setTitle("ANADIR JUGADOR");
        setResizable(false);
        
        //-----------Panel Config
        addPanel = (JPanel) this.getContentPane();
        addPanel.setLayout(null);
        
        JLabel nombre = new JLabel("NOMBRE: ");
        JLabel user = new JLabel("NICK: ");
        
        nombre.setBounds(30,30,70,20);
        user.setBounds(30,60,70,20);
        
        name.setBounds(130,30,130,20);
        nick.setBounds(130,60,130,20);
        
        add.setBounds(120,100,80,20);
        
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addjugador();
            }
        });
        
        addPanel.add(nombre);
        addPanel.add(user);
        addPanel.add(name);
        addPanel.add(nick);
        addPanel.add(add);
        
    }
    
    public void addjugador(){
        String nuevonombre = name.getText();
        String nuevonick = nick.getText();
        
        player.setName(nuevonombre);
        player.setNick(nuevonick);
        
        dispose();
    }
    
}
