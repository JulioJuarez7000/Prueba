/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainofthought;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Pablo
 */
public class Highscores extends JFrame{
    
    private JPanel ScorePanel;
    private JTable ScoreBoard;
    private Object[][] data = new Object[5][3];
    
    public Highscores(){
        Players players = new Players();
        Jugador[] datos = players.getJugadores();
        
        for(int i = 0; i < 5; i++){
            if(datos[i]!=null){
                data[i][0]=datos[i].name;
                data[i][1]=datos[i].nick;
                data[i][2]=datos[i].score;
            }
        } 
        /*
        for(int i = 0; i <= 4; i++){
            for(int j = 0; j <= (4-i); j++){
                if(data[j][2]!=null){
                    int a = (int) data[j][2];
                    int b = (int) data[j+1][2];
                    if(a>b){
                        String aux = (String) data[j][0];
                        String aux2 = (String) data[j][1];
                        int aux3 = (int) data[j][2];
                        
                        data[j][0] = data[j+1][0];
                        data[j+1][0] = aux;
                        
                        data[j][1] = data[j+1][1];
                        data[j+1][1] = aux2;
                        
                        data[j][2] = data[j+1][2];
                        data[j+1][2] = aux3;
                    }
                }
            }
        }
        */
        String[] names = new String[]{
        "NOMBRE","NICK","PUNTAJE"
        };
        
        ScoreBoard = new JTable(data,names);
        
        setSize(500,130);
        setResizable(false);
        setTitle("PUNTAJES");
        
        ScorePanel = (JPanel)this.getContentPane();
        ScorePanel.setLayout(new BorderLayout());
        
        ScorePanel.add(ScoreBoard.getTableHeader(),BorderLayout.PAGE_START);
        ScorePanel.add(ScoreBoard,BorderLayout.CENTER);
        
    }
    
}
