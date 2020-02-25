package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.infoMessage.GameState;

public class PigGameState extends GameState {
    int playerid;
    int player1score;
    int player2score;
    int runTotal;
    int dieValue;

    public PigGameState(){
        playerid=0;
        player1score=0;
        player2score=0;
        runTotal=0;
        dieValue=1;
    }
    public PigGameState(int player, int score1, int score2, int runTot, int die){
        playerid=player;
        player1score=score1;
        player2score=score2;
        runTotal=runTot;
        dieValue=die;
    }

    public int getPlayerid() {return playerid;}
    public int getPlayer1score(){return player1score;}
    public int getPlayer2score(){return player2score;}
    public int getRunTotal(){return runTotal;}
    public int getDieValue(){return dieValue;}

    public void setPlayerid(int playerid) {
        this.playerid = playerid;
    }

    public void setPlayer1score(int player1score) {
        this.player1score = player1score;
    }

    public void setPlayer2score(int player2score) {
        this.player2score = player2score;
    }

    public void setRunTotal(int runTotal) {
        this.runTotal = runTotal;
    }

    public void setDieValue(int dieValue) {
        this.dieValue = dieValue;
    }
}
