package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.LocalGame;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    PigGameState myPigGame;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        myPigGame=new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        return (myPigGame.playerid==playerIdx) ? true : false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if(action instanceof PigHoldAction){
            if(myPigGame.getPlayerid()==0){
                myPigGame.setPlayer1score(myPigGame.player1score+myPigGame.getRunTotal());
            }
            else{
                myPigGame.setPlayer2score(myPigGame.player2score+myPigGame.getRunTotal());
            }
            myPigGame.setRunTotal(0);
            if(players.length!=1)myPigGame.setPlayerid((myPigGame.getPlayerid()==1)? 0:1);
            return true;
        }
        else if(action instanceof PigRollAction){
            Random rnd = new Random();
            myPigGame.setDieValue(rnd.nextInt(6)+1);
            if(myPigGame.getDieValue()==1){
                myPigGame.setRunTotal(0);
                if(players.length!=1)myPigGame.setPlayerid((myPigGame.getPlayerid()==1)? 0:1);
            }
            else{
                myPigGame.setRunTotal(myPigGame.getRunTotal()+myPigGame.getDieValue());
            }
            return true;
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        GameState gs = myPigGame;
        p.sendInfo(gs);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(myPigGame.getPlayer1score()>=50)return "Player 1 Wins!";
        else if(myPigGame.getPlayer2score()>=50)return "Player 2 Wins!";
        return null;
    }

}// class PigLocalGame
