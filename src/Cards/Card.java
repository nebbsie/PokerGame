package Cards;

import PokerGame.PokerGame;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;

public class Card {

    private Type suit;
    private int number;
    private int x, y;
    private int height, width;
    private int fontWidth;
    private Image img;

    // ACE, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, JACK, QUEEN, KING
    //   0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,   11,    12,   13

    public Card(Type suit, int number, int x, int y){
        this.suit = suit;
        this.number = number;
        this.x = x;
        this.y = y;
        this.width = 95;
        this.height = 135;
        try {
            this.img = new Image(suit.getImageLocation());
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

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

    public void update(){
        fontWidth = PokerGame.app.getGraphics().getFont().getWidth(getCardNumberString());
    }

    public void render(Graphics g){
        g.setColor(Color.white);
        g.fillRoundRect(x, y, width, height, 7);
        g.setColor(suit.getCardColour());

        int w = 50;
        int h = 50;

        //TODO: Do this better!
        // Draw center image
        img.draw((x + width) - (int)(w * 1.5) + 3, (y + height) - (w * 2) + 10,w, h );

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
