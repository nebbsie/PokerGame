package States;

import PokerGame.GameManager;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameState extends BasicGameState {

    private int state;
    private GameManager gm;
    private Image background;

    public GameState(int state){
        this.state = state;
        this.gm = new GameManager(2);
        try {
            background = new Image("Graphics/table.png");
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        background.draw(0, 0);
        gm.render(g);

        g.setColor(Color.black);

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        gm.update();

    }

    @Override
    public int getID() {
        return state;
    }
}
