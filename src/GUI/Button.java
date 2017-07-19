package GUI;

import PokerGame.PokerGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Button {

    private int x, y, width, height;
    private String label;
    private Color normalColour;
    private Color mouseOverColour;
    private boolean hovering;

    public Button(int x, int y, int width, int height, String str) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.label = str;
        this.normalColour = new Color(70, 70, 70, 200);
        this.mouseOverColour = new Color(70, 70, 70, 255);
        this.hovering = false;
    }

    public void update(){
        int xx = PokerGame.app.getInput().getMouseX();
        int yy = PokerGame.app.getInput().getMouseY();

        if(xx > x && xx < x + width && yy > y && yy < y + height){
            hovering = true;
        }else{
            hovering = false;
        }

    }

    public void render(Graphics g){

        if(!hovering){
            g.setColor(normalColour);
        }else{
            g.setColor(mouseOverColour);
        }


        g.fillRect(x, y, width, height);

        int strW = PokerGame.app.getGraphics().getFont().getWidth(label);
        int strH = PokerGame.app.getGraphics().getFont().getHeight(label);


        g.setColor(Color.white);
        g.drawString(label,(x + width/2) - strW/2,(y + height/2) - strH / 2);
    }
}
