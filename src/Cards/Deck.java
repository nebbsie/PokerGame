package Cards;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private int amount;
    private ArrayList<Card> deck;
    private Random rand;

    public Deck(int amount){
        this.amount = amount;
        this.rand = new Random();
        setupDeck();
    }

    // Creates a deck.
    private void setupDeck(){
        deck = new ArrayList<>();
        int counter = 0;

        for(int d = 0; d < amount; d++){
            for(int y = 0; y < 4; y++){
                for(int x = 1; x <= 13; x++){
                    deck.add(new Card(y, x, 0, 0, false));
                    counter++;
                    System.out.println(counter);
                }
            }
        }
    }

    // Returns a random card and removes from the deck.
    public Card takeCard(){
        int num = rand.nextInt(deck.size() - 1 + 1) + 1;
        Card c = deck.get(num);
        deck.remove(num);
        return c;
    }
}
