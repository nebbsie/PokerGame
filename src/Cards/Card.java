package Cards;

import AI.Player;
import PokerGame.PokerGame;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;

public class Card {

    private Type suit;
    private int suitNum;
    private int number;
    private int x, y;
    private int height, width;
    private int fontWidth;
    private Image img;
    private boolean render;


    public Card(int suitNum, int number, int x, int y, boolean render) {
        this.suitNum = suitNum;
        this.render = render;
        this.number = number;
        this.x = x;
        this.y = y;
        this.width = 95;
        this.height = 135;
        getSuit();
    }

    // Gets the suit type from the parameter passed in.
    private void getSuit(){
        if(suitNum == 0){
            suit = Type.SPADE;
        }else if(suitNum == 1){
            suit = Type.DIAMOND;
        }else if(suitNum == 2){
            suit = Type.CLUB;
        }else if(suitNum == 3){
            suit = Type.HEART;
        }

        try {
            img = new Image(suit.getImageLocation());
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    // Gets the string to print on the screen for the card.
    public String getCardNumberString(){
        if(number > 1 && number < 11){
            return Integer.toString(number);
        }else if (number == 1){
            return "A";
        }else if (number == 11){
            return "J";
        }else if (number == 12){
            return "Q";
        }else{
            return "K";
        }
    }

    // Updates the card.
    public void update(){
        fontWidth = PokerGame.app.getGraphics().getFont().getWidth(getCardNumberString());
    }

    // Renders the card to the screen.
    public void render(Graphics g){

        if(render){
            g.setColor(Color.white);
            g.fillRoundRect(x, y, width, height, 7);

            g.setColor(suit.getCardColour());
            //TODO: Do this better!
            // Draw center image
            img.draw((x + width) - (int)(50 * 1.5) + 3, (y + height) - (50 * 2) + 10,50, 50);

            // Draw bottom right icon/number
            g.rotate(x + width - fontWidth - 2, y + height - fontWidth - 2, -180);
            g.drawString(getCardNumberString(), x + width - fontWidth - 7, y + height - fontWidth - 10);
            img.draw(x + width - fontWidth - 9, y + height - fontWidth + 8, fontWidth + 6, fontWidth + 6);

            // Draw top left icon/number
            g.rotate(x + width - fontWidth - 2, y + height - fontWidth - 2, +180);
            g.drawString(getCardNumberString(), x + 6, y + 6);
            img.draw(x + 4, y + 6 + fontWidth * 2 , fontWidth + 6, fontWidth + 6);
        }
    }
}
