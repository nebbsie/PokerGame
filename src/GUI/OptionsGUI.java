package GUI;


import org.newdawn.slick.Graphics;

import java.util.ArrayList;

public class OptionsGUI {

    private ArrayList<Button> buttons;

    public OptionsGUI(int x, int y){
        buttons = new ArrayList<>();
        buttons.add(new Button(x, y, 80, 50, "Fold"));
        buttons.add(new Button(x + 85, y, 80, 50, "Raise"));
        buttons.add(new Button(x + 85 + 85, y, 80, 50, "Call"));
    }

    public void update(){
        for(Button b : buttons){
            b.update();
        }
    }

    public void render(Graphics g){
        for(Button b : buttons){
            b.render(g);
        }
    }

}
