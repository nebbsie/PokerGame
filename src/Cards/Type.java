package Cards;

import org.newdawn.slick.Color;

public enum Type {

    SPADE("Cards/res/spade.png", Color.black),
    CLUB("Cards/res/club.png", Color.black),
    DIAMOND("Cards/res/diamond.png", Color.red),
    HEART("Cards/res/heart.png", Color.red);

    private String imgLoc;
    private Color cardColour;

    Type(String imgLoc, Color colour){
        this.imgLoc = imgLoc;
        this.cardColour = colour;
    }

    public Color getCardColour(){
        return cardColour;
    }

    public String getImageLocation(){
        return imgLoc;
    }


}
