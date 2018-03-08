package fr.wcs.wikimobmonsterlegends;


import android.graphics.drawable.Drawable;

public class MonsterPage {

    private String monsterName;
    private int health, power, speed, stamina, monsterImage, typeImage;


    //Constructor
    public MonsterPage(String monsterName, int health, int power, int speed, int stamina, int monsterImage, int typeImage) {
        this.monsterName = monsterName;
        this.health = health;
        this.power = power;
        this.speed = speed;
        this.stamina = stamina;
        this.monsterImage = monsterImage;
        this.typeImage = typeImage;
    }

    //Getter
    public String getMonsterName() {
        return monsterName;
    }

    public int getHealth() {
        return health;
    }

    public int getPower() {
        return power;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStamina() {
        return stamina;
    }

    public int getMonsterImage() {
        return monsterImage;
    }

    public int getTypeImage() {
        return typeImage;
    }
}

