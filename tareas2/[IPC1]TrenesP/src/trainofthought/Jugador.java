/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainofthought;

/**
 *
 * @author Pablo
 */
public class Jugador {
    
    public String name;
    public String nick;
    public int score = 0;
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setNick(String nick){
        this.nick = nick;
    }
    
    public void setScore(int score){
        this.score = this.score+score;
    }
    
}
