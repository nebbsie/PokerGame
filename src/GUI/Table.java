package GUI;

import Cards.Card;
import Cards.CardPositions;
import PokerGame.GameManager;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

public class Table {
    public ArrayList<Card> cards;

    public Table(){
        cards = new ArrayList<>();
    }

    public void flop(){
        cards.add(GameManager.deck.takeCard());
        cards.add(GameManager.deck.takeCard());
        cards.add(GameManager.deck.takeCard());
    }

    public void turn(){
        cards.add(GameManager.deck.takeCard());
    }

    public void river(){
        cards.add(GameManager.deck.takeCard());

    }

    public void update(){
        for(Card c : cards){
            c.update();
        }
    }



    public void render(Graphics g){
        if(cards.size() == 3) {
            cards.get(0).renderAt(g, CardPositions.FLOP1.getX(), CardPositions.FLOP1.getY());
            cards.get(1).renderAt(g, CardPositions.FLOP2.getX(), CardPositions.FLOP2.getY());
            cards.get(2).renderAt(g, CardPositions.FLOP3.getX(), CardPositions.FLOP3.getY());
        }

        if(cards.size() == 4){
            cards.get(3).renderAt(g, CardPositions.TURN.getX(), CardPositions.TURN.getY());
        }

        if(cards.size() == 5){
            cards.get(4).renderAt(g, CardPositions.RIVER.getX(), CardPositions.RIVER.getY());
        }
    }

}
