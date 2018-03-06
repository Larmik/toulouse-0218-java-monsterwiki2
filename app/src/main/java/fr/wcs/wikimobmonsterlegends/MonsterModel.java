package fr.wcs.wikimobmonsterlegends;


import android.graphics.drawable.Drawable;

public class MonsterModel {

    private String name;
    private int image;

    //Constructor
    MonsterModel(String name, int image) {
        this.name = name;
        this.image = image;
    }

    //Getters
    public int getImage() {
        return image;
    }
    public String getName() {
        return name;
    }
}
