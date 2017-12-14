/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainofthought;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class delPlayer extends JFrame{
    
    private String[] nicks;
    private JPanel delPanel;
    public JComboBox <String> players;
    
        public delPlayer(Jugador[] registrados){
            nicks = new String[registrados.length];
            for(int i = 0; i < registrados.length;i++){
                if(registrados[i]!=null){
                    nicks[i]=registrados[i].nick;
                }
            }
            players = new JComboBox(nicks);
            
            setSize(300,80);
            setTitle("ELIMINAR JUGADOR");
            setResizable(false);
            
            
            delPanel = (JPanel) this.getContentPane();
            delPanel.setLayout(new BorderLayout());
                        
            delPanel.add(players,BorderLayout.CENTER);
            
            JButton del = new JButton("ELIMINAR");
            
            del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete();
                dispose();
            }
            });
            
            delPanel.add(del,BorderLayout.SOUTH);
            
        }
        
        private void delete(){
            Players todelete = new Players();
            String j = (String)players.getSelectedItem();
            todelete.deletePlayer(j);
        }
    
}
