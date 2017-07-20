package AI;

import Cards.Hand;
import PokerGame.GameManager;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.Random;

public abstract class Player {

    protected boolean playersTurn;
    public int money;
    public Hand hand;
    public int playerID;
    protected int x, y;
    public boolean folded;
    protected Random rand;

    public Player(int id, int x, int y){
        money = 2000;
        playersTurn = false;
        hand = new Hand();
        hand.startGame();
        playerID = id;
        this.x = x;
        this.y = y;
        this.folded = false;
        this.rand = new Random();
    }

    // Updates the player
    public void update(){
        hand.update();
        if(folded && GameManager.currentGo == playerID){
            GameManager.currentGo++;
        }
    }

    public void render(Graphics g){
        g.setColor(Color.white);
        g.drawString("ID: " + playerID, x + 57 ,y + 67);
        g.drawString("Money: " + money, x + 57 ,y + 97);

    }

    public void setPlayersTurn(boolean b){
        playersTurn = b;
    }

    public boolean getPlayersTurn(){
        return playersTurn;
    }

    protected void fold(){
        System.out.println("Player " + playerID + "==> Fold");
        folded = true;
        GameManager.waiting = false;
        GameManager.currentGo++;
        GameManager.stillInRound--;
    }

    protected void raise(double bet){
        System.out.println("Player " + playerID + "==> Raise");
        GameManager.bet = bet;
        GameManager.pot += bet;
        money -= bet;
        GameManager.raise = true;
        GameManager.waiting = false;
        GameManager.currentGo++;
    }

    protected void call(){
        System.out.println("Player " + playerID + "==> Call");
        GameManager.pot += GameManager.bet;
        money -= GameManager.bet;
        GameManager.waiting = false;
        GameManager.currentGo++;
    }

}
