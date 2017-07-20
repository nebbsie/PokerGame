package PokerGame;

import AI.AIPlayer;
import AI.Player;
import AI.PlayerPosition;
import AI.UserPlayer;
import Cards.Deck;
import GUI.Table;
import org.newdawn.slick.Graphics;
import java.util.ArrayList;

public class GameManager {
    private int playerCount;
    private ArrayList<Player> players;
    public static Deck deck;
    private UserPlayer player;
    private Stages stage;
    private boolean playing;
    private int turn;



    public static double bet = 0;
    public static double pot = 0;
    public static boolean raise = false;
    public static boolean waiting = false;
    public static int currentGo = 0;
    public static int stillInRound;
    public boolean drawn = false;
    public Table table;

    public GameManager(int playerCount){
        this.playerCount = playerCount;
        this.players = new ArrayList<>();
        this.deck = new Deck(1);
        this.player = new UserPlayer();
        this.player.setPlayersTurn(true);
        this.stage = Stages.PRE_FLOP;
        this.playing = true;
        this.turn = 0;

        setupPlayers();
        this.stillInRound = players.size();
    }


    private Player getWinner(){
        for(Player p : players){
            if(!p.folded){
                return p;
            }
        }

        return null;
    }

    private void endRound(Player winner){
        System.out.println("WINNER WINNER CHICKEN DINNER: " + winner.playerID);
        winner.money += pot;
        pot = 0;
        turn++;

        if(turn >= players.size()){
            turn = 0;
        }
        currentGo = turn;
        bet = 0;
        raise = false;
        stillInRound = players.size();

        for(Player p : players){
            p.folded = false;
        }

    }

    private void validateRound(){
        if(stillInRound == 0){
            System.out.println("ROUND END");
        }else if(stillInRound == 1){
            endRound(getWinner());
        }else{
            if(currentGo >= stillInRound){
                currentGo = 0;
            }
        }
    }

    public void update(){

        validateRound();

        // Update AI and Players
        for(Player p : players){
            p.update();
        }

        if(!waiting){
            // If the game is being played.
            if(playing){
                switch (stage){
                    case PRE_FLOP:
                        break;
                    case FLOP:
                        break;
                    case TURN:
                        break;
                    case RIVER:
                        break;
                    case ROUND_END:
                        stillInRound = players.size();
                        break;
                    default:
                        System.out.println("Not A Valid Game Stage");
                        break;
                }
            }
        }



    }

    public void render(Graphics g){
        g.drawString("Cards Left In Deck: " + Integer.toString(deck.getCardsLeft()), 10, 30);
        g.drawString("Turn: " + Integer.toString(currentGo), 10, 60);
        g.drawString("Bet: " + Double.toString(bet), 10, 90);
        g.drawString("Pot: " + Double.toString(pot), 10, 120);

        for(Player p : players){
            p.render(g);
        }

    }


    // Creates players based on user input.
    private void setupPlayers(){
        for(int i = 0; i < playerCount; i++){
            players.add(new AIPlayer(PlayerPosition.values()[i], i + 1));
        }

        players.add(player);

    }
}
