package edu.up.cs301.pig;

import java.util.Random;

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
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
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
            Random rnd = new Random();
            GameAction act = (rnd.nextBoolean()? new PigRollAction(this) :new PigHoldAction(this));
            super.game.sendAction(act);
        }
        return;
    }//receiveInfo

}
