package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.GameComputerPlayer;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.game.GameFramework.utilities.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class SmartPigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public SmartPigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        PigGameState myPig = (PigGameState)info;
        if(myPig.getPlayerid()==super.playerNum){
            int myScore = (super.playerNum==1)? myPig.player2score : myPig.player1score;
            int theirScore = (super.playerNum==1)? myPig.player1score : myPig.player2score;
            GameAction act = (myPig.runTotal<10 || myScore+myPig.runTotal<theirScore-10? new PigRollAction(this) :new PigHoldAction(this));
            super.game.sendAction(act);
        }
        return;
    }//receiveInfo

}
