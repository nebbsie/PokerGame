package AI;

import GUI.Button;
import GUI.OptionsGUI;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.tests.SoundTest;

public class UserPlayer extends Player {

    private int x, y;
    private Button b;
    private OptionsGUI options;

    public UserPlayer() {
        super();
        this.x = 555;
        this.y = 560;
        hand.setViewable(true);
        options = new OptionsGUI(500, 450);
    }

    private void drawButtons(Graphics g, int xx, int yy){
        options.render(g);
    }

    private void flop(){
        System.out.println("Flop");
    }

    private void raise(){
        System.out.println("Raise");
    }

    private void call(){
        System.out.println("Call");
    }

    @Override
    public void update() {
        super.update();
        options.update();

        if(playersTurn){
            if(options.isClicked("fold")){
                flop();
            }else if(options.isClicked("call")){
                call();
            }else if(options.isClicked("raise")){
                raise();
            }
        }

    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        hand.renderHand(g, x, y);

        if(playersTurn){
            drawButtons(g, 100, 100);
        }
    }
}
