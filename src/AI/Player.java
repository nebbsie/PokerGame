package AI;

import Cards.Hand;
import org.newdawn.slick.Graphics;

public abstract class Player {

    protected boolean playersTurn;
    protected int money;
    protected Hand hand;

    public Player(){
        money = 2000;
        playersTurn = false;
        hand = new Hand();
        hand.startGame();
    }

    // Updates the player
    public void update(){
        hand.update();
    }

    public void render(Graphics g){}

}
