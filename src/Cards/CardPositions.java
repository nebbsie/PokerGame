package Cards;

import org.newdawn.slick.geom.Vector2f;

public enum CardPositions {
    FLOP1(415, 254+ 54),
    FLOP2(502, 254+ 54),
    FLOP3(589, 254+ 54),
    TURN(702, 254+ 54),
    RIVER(789, 254 + 54);

    private int x, y;

    CardPositions(int x, int y){
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
