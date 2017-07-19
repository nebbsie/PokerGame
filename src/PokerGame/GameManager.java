package PokerGame;

import AI.AIPlayer;
import AI.Player;
import AI.PlayerPosition;
import AI.UserPlayer;
import Cards.Deck;
import org.newdawn.slick.Graphics;
import java.util.ArrayList;

public class GameManager {
    private int playerCount;
    private ArrayList<Player> players;
    public static Deck deck;
    private UserPlayer player;

    public GameManager(int playerCount){
        this.playerCount = playerCount;
        this.players = new ArrayList<>();
        this.deck = new Deck(1);
        this.player = new UserPlayer();
        this.player.setPlayersTurn(true);

        setupPlayers();
    }

    public void update(){
        for(Player p : players){
            p.update();
        }
        player.update();



    }

    public void render(Graphics g){
        g.drawString("Cards Left In Deck: " + Integer.toString(deck.getCardsLeft()), 10, 30);
        for(Player p : players){
            p.render(g);
        }

        player.render(g);
    }


    // Creates players based on user input.
    private void setupPlayers(){
        for(int i = 0; i < playerCount; i++){
            players.add(new AIPlayer(PlayerPosition.values()[i]));
        }

    }
}
