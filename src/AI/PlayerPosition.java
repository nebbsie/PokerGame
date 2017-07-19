package AI;

import org.newdawn.slick.geom.Vector2f;

public enum PlayerPosition {

    PLAYER_1(120, 350),
    PLAYER_2(1000, 350);


    private int x, y;

    PlayerPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Vector2f getPosition(){
        return new Vector2f(x, y);
    }

}
