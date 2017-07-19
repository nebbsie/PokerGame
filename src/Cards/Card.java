package Cards;

import AI.PlayerPosition;
import PokerGame.PokerGame;
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
    private boolean viewable;
    private Image background;


    public Card(int suitNum, int number, int x, int y, boolean render) {
        this.suitNum = suitNum;
        this.render = render;
        this.number = number;
        this.x = x;
        this.y = y;
        this.width = 75;
        this.height = 105;
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
            background = new Image("Cards/res/background.png");
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public void setViewable(boolean view){
        viewable = view;
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

    // Render the cards at specific locations.
    public void renderAt(Graphics g, int xx, int yy){

        g.setColor(Color.white);
        g.fillRoundRect(xx, yy, width, height, 7);
        if(viewable){
            g.setColor(suit.getCardColour());

            // Draw bottom right icon/number
            g.rotate(xx + width - fontWidth - 2, yy + height - fontWidth - 2, -180);
            g.drawString(getCardNumberString(), xx + width - fontWidth - 7, yy + height - fontWidth - 10);
            img.draw(xx + width - fontWidth - 9, yy + height - fontWidth + 8, fontWidth + 6, fontWidth + 6);

            // Draw top left icon/number
            g.rotate(xx + width - fontWidth - 2, yy + height - fontWidth - 2, +180);
            g.drawString(getCardNumberString(), xx + 6, yy + 6);
            img.draw(xx + 4, yy + 6 + fontWidth * 2 , fontWidth + 6, fontWidth + 6);
        }else{
            background.draw(xx, yy, width, height);
        }

    }

}
