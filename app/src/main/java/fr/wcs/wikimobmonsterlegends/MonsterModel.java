package fr.wcs.wikimobmonsterlegends;


import android.graphics.drawable.Drawable;

public class MonsterModel {

    private int rank;
    private String name;
    private int image;

    public MonsterModel(int rank, String name, int image) {
        this.rank = rank;
        this.name = name;
        this.image = image;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
