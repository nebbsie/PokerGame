package AI;

import GUI.Button;
import GUI.OptionsGUI;
import PokerGame.GameManager;
import org.newdawn.slick.Graphics;

public class UserPlayer extends Player {

    private Button b;
    private OptionsGUI options;

    public UserPlayer() {
        super(0, 555, 560);

        hand.setViewable(true);
        options = new OptionsGUI(500, 450);
    }

    private void drawButtons(Graphics g, int xx, int yy){
        options.render(g);
    }


    @Override
    protected void fold() {
        super.fold();
        hand.setViewable(false);
    }


    @Override
    protected void raise(double bet) {
        super.raise(bet);
    }

    @Override
    protected void call() {
        super.call();
    }


    @Override
    public void update() {
        super.update();
        options.update();

        if(GameManager.currentGo == playerID){

            if(folded){

            }

            if(options.isClicked("fold")){
                fold();
            }else if(options.isClicked("call")){
                call();
            }else if(options.isClicked("raise")){
                raise(100);
            }

        }

    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        hand.renderHand(g, x, y);

        if(GameManager.currentGo == playerID){
            drawButtons(g, 100, 100);
        }
    }
}
