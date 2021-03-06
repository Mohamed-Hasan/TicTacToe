/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.util.Arrays;
import Models.Player;

/**
 *
 * @author MHassan
 */
public class Game {

    public Player player1;
    public Player player2;
    public boolean myTurn = true;
    public Player gameOn;
    public Player draw;
    private int move = 0;
    public int[][] gridboard = new int[3][3];
    public int[] xpositons = new int[9];
    public int[] ypositions = new int[9];
    public int i = 0 ;
    public int j = 0;

    public Game(Player play1, Player play2) {
        this.player1 = play1;
        this.player2 = play2;
          for (int[] array : gridboard) {
            Arrays.fill(array, -1);
        }
    }

    public boolean validateMove(Integer xpos, Integer ypos) {
        if (gridboard[xpos][ypos] == -1 && myTurn) 
        {
//            gridboard[xpos][ypos] = flip;
            myTurn = false;
            return true;
        }
        else  {
            //myTurn = true;
            return false;
        }
    }

 public String play(int xpos, int ypos , int flip)
    {
        if(gridboard[xpos][ypos]== -1)
        {
            gridboard[xpos][ypos] = flip;//move%2 == 0 ? 0:1;
            xpositons [i] =  xpos;
            ypositions[i++] = ypos;
            String p = checkWinner();

            if(move < 4)
            {
                move++;
               
                return p;
            }
            else
            {
//                move = 0;
                return "draw";
            }
            
        }
        return null;
        
    }
    
    public String checkWinner()
    {
        if((gridboard[0][0]==0&&gridboard[0][1]==0&&gridboard[0][2]==0)
          ||(gridboard[1][0]==0&&gridboard[1][1]==0&&gridboard[1][2]==0 )   
          ||(gridboard[2][0]==0&&gridboard[2][1]==0&&gridboard[2][2]==0 )
          ||(gridboard[0][0]==0&&gridboard[1][0]==0&&gridboard[2][0]==0 )   
          ||(gridboard[0][1]==0&&gridboard[1][1]==0&&gridboard[2][1]==0 )   
          ||(gridboard[0][2]==0&&gridboard[1][2]==0&&gridboard[2][2]==0 )   
          ||(gridboard[0][0]==0&&gridboard[1][1]==0&&gridboard[2][2]==0 )   
          ||(gridboard[0][2]==0&&gridboard[1][1]==0&&gridboard[2][0]==0 )   
          )
        {

//            move = 0;
            System.out.println("player o win");
            return "o";
        }
        if ((gridboard[0][0] == 1 && gridboard[0][1] == 1 && gridboard[0][2] == 1)
                || (gridboard[1][0] == 1 && gridboard[1][1] == 1 && gridboard[1][2] == 1)
                || (gridboard[2][0] == 1 && gridboard[2][1] == 1 && gridboard[2][2] == 1)
                || (gridboard[0][0] == 1 && gridboard[1][0] == 1 && gridboard[2][0] == 1)
                || (gridboard[0][1] == 1 && gridboard[1][1] == 1 && gridboard[2][1] == 1)
                || (gridboard[0][2] == 1 && gridboard[1][2] == 1 && gridboard[2][2] == 1)
                || (gridboard[0][0] == 1 && gridboard[1][1] == 1 && gridboard[2][2] == 1)
                || (gridboard[0][2] == 1 && gridboard[1][1] == 1 && gridboard[2][0] == 1)) {
//             move = 0;
            System.out.println("player x win");
            return "x";
        }
        return "gameOn";
    }
    
    
}
