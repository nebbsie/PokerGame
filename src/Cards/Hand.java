package Cards;

import PokerGame.GameManager;
import org.newdawn.slick.Graphics;
import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;

    public Hand(){
        hand = new ArrayList<>();
    }

    // Updates the hand.
    public void update(){
        for(Card c : hand){
            c.update();
        }
    }

    // Renders the hand.
    public void renderHand(Graphics g, int x, int y){
        hand.get(0).renderAt(g, x,y - 40);
        hand.get(1).renderAt(g, x + 85, y - 40);
    }


    // Starts the game by taking two cards and removing from deck.
    public void startGame(){
        hand.add(GameManager.deck.takeCard());
        hand.add(GameManager.deck.takeCard());
    }

    // Sets the hand as viewable
    public void setViewable(boolean b){
        hand.get(0).setViewable(b);
        hand.get(1).setViewable(b);
    }


}
