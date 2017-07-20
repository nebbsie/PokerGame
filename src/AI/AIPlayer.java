package AI;

import PokerGame.GameManager;
import org.newdawn.slick.Graphics;

public class AIPlayer extends Player {



    public AIPlayer(PlayerPosition position, int id) {
        super(id, position.getX(), position.getY());
        hand.setViewable(false);
    }

    // Updated the ai player.
    @Override
    public void update() {
        super.update();

        if(GameManager.currentGo == playerID){

            int num = rand.nextInt(3 - 1 + 1) + 1;

            switch (num){
                case 1:
                    fold();
                    break;
                case 2:
                    call();
                    break;
                case 3:
                    raise(200);
                    break;
            }
        }

    }

    @Override
    public void render(Graphics g) {
        super.render(g);

        if(GameManager.currentGo == playerID){
            hand.setViewable(true);
        }   else{
            hand.setViewable(false);
        }

        hand.renderHand(g, x, y);
    }

}
