package PokerGame;

import AI.AIPlayer;
import AI.PlayerPosition;
import Cards.Deck;
import org.newdawn.slick.Graphics;
import java.util.ArrayList;

public class GameManager {
    private int playerCount;
    private ArrayList<AIPlayer> aiPlayers;
    public static Deck deck;

    public GameManager(int playerCount){
        this.playerCount = playerCount;
        this.aiPlayers = new ArrayList<>();
        this.deck = new Deck(1);

        setupPlayers();
    }

    public void update(){
        for(AIPlayer p : aiPlayers){
            p.update();
        }
    }

    public void render(Graphics g){
        g.drawString("Cards Left In Deck: " + Integer.toString(deck.getCardsLeft()), 10, 30);
        for(AIPlayer p : aiPlayers){
            p.render(g);
        }
    }


    // Creates players based on user input.
    private void setupPlayers(){
        for(int i = 0; i < playerCount; i++){
            aiPlayers.add(new AIPlayer(PlayerPosition.values()[i]));
        }
    }
}
