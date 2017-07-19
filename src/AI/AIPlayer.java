package AI;

import org.newdawn.slick.Graphics;

public class AIPlayer extends Player {

    private int x, y;

    public AIPlayer(PlayerPosition position) {
        super();
        this.x = position.getX();
        this.y = position.getY();
        hand.setViewable(false);
    }

    // Updated the ai player.
    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        hand.renderHand(g, x, y);
    }

}
