package fr.wcs.wikimobmonsterlegends;


import android.os.Parcel;
import android.os.Parcelable;

public class MonsterModel implements Parcelable{

    //Attributes
    private String name;
    private int type;
    private int type2;
    private int weakness;
    private int weakness2;
    private int image;
    private int statHealth;
    private int statPower;
    private int statSpeed;
    private int statStamina;


    //Constructor
    public MonsterModel(String name, int type, int type2, int weakness, int weakness2, int image,
                        int statHealth, int statPower, int statSpeed, int statStamina) {
        this.name = name;
        this.type = type;
        this.type2 = type2;
        this.weakness = weakness;
        this.weakness2 = weakness2;
        this.image = image;
        this.statHealth = statHealth;
        this.statSpeed = statSpeed;
        this.statPower = statPower;
        this.statStamina = statStamina;
    }

    protected MonsterModel(Parcel in) {
        name = in.readString();
        type = in.readInt();
        type2= in.readInt();
        weakness = in.readInt();
        weakness2 = in.readInt();
        image = in.readInt();
        statHealth = in.readInt();
        statPower = in.readInt();
        statSpeed = in.readInt();
        statStamina = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(type);
        dest.writeInt(type2);
        dest.writeInt(weakness);
        dest.writeInt(weakness2);
        dest.writeInt(image);
        dest.writeInt(statHealth);
        dest.writeInt(statPower);
        dest.writeInt(statSpeed);
        dest.writeInt(statStamina);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MonsterModel> CREATOR = new Creator<MonsterModel>() {
        @Override
        public MonsterModel createFromParcel(Parcel in) {
            return new MonsterModel(in);
        }

        @Override
        public MonsterModel[] newArray(int size) {
            return new MonsterModel[size];
        }
    };

    public String getName() {
        return name;
    }
    public int getType() {
        return type;
    }
    public int getType2() {
        return type2;
    }
    public int getWeakness() {
        return weakness;
    }
    public int getWeakness2() {
        return weakness2;
    }
    public int getImage() {
        return image;
    }
    public int getStatHealth() {
        return statHealth;
    }
    public int getStatPower() {
        return statPower;
    }
    public int getStatSpeed() {
        return statSpeed;
    }
    public int getStatStamina() {
        return statStamina;
    }


}
