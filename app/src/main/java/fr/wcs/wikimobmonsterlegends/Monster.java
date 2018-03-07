package fr.wcs.wikimobmonsterlegends;

/**
 * Created by wilder on 06/03/18.
 */

public class Monster {

    private String name;
    private int[] stats;
    private String description;
    private int monsterPicture;

    public Monster(String name, int[] stats, String description, int monsterPicture) {
        this.name = name;
        this.stats = stats;
        this.description = description;
        this.monsterPicture = monsterPicture;
    }

    public String getName() {
        return name;
    }
    public int[] getStats() {
        return stats;
    }
    public String getDescription() {
        return description;
    }
    public int getMonsterPicture() {
        return monsterPicture;
    }

}
