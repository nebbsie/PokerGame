package PokerGame;

import States.GameState;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class PokerGame extends StateBasedGame {

    // Game parameters
    public static int SCREEN_WIDTH = 1280;
    public static int SCREEN_HEIGHT = 720;
    public static String GAME_NAME = "Poker Game";
    public static int FPS = 60;
    public static boolean VSYNC = true;

    // Game modules
    public static AppGameContainer app;

    // Game states
    public static final int play_state = 1;

    public PokerGame(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        this.addState(new GameState(play_state));
        this.getState(play_state).init(container, this);
        enterState(play_state);
    }

    public static void main(String[] args) {
        try {
            app = new AppGameContainer(new PokerGame(GAME_NAME));
            app.setDisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT, false);
            app.setShowFPS(true);
            app.setTargetFrameRate(FPS);
            app.setAlwaysRender(true);
            app.setUpdateOnlyWhenVisible(false);
            app.setVSync(VSYNC);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
