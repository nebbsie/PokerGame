package PokerGame;


import AI.Player;
import Cards.Deck;

import java.util.ArrayList;

public class GameManager {
    private int playerCount;
    private ArrayList<Player> players;
    private Deck deck;

    public GameManager(int playerCount){
        this.playerCount = playerCount;
        this.players = new ArrayList<>();
        this.deck = new Deck(1);

        setupPlayers();
    }

    private void setupPlayers(){
        for(int i = 0; i < playerCount; i++){
            players.add(new Player());
        }
    }

    public void update(){

    }
}
