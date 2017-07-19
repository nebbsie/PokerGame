package AI;

import org.newdawn.slick.Graphics;

public class UserPlayer extends Player {

    private int x, y;

    public UserPlayer(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        hand.setViewable(true);
    }

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
