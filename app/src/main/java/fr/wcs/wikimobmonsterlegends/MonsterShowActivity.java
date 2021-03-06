package fr.wcs.wikimobmonsterlegends;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;



public class MonsterShowActivity extends MainActivity {

    int mLevel = 0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_show);

        ImageButton previousEv = findViewById(R.id.btn_previous);
        ImageButton nextEv = findViewById(R.id.btn_next);
        updateData(mLevel);

        //Clic sur les boutons
        nextEv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData(++mLevel);
            }
        });
        previousEv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData(--mLevel);
            }
        });

    }

    public void updateData(int mLevel) {
        ImageView typePicture = findViewById(R.id.type_picture);
        ImageView typePicture2 = findViewById(R.id.type_picture_2);
        ImageView weaknessPicture = findViewById(R.id.weakness_picture);
        ImageView weaknessPicture2 = findViewById(R.id.weakness_picture_2);
        ImageButton previousEv = findViewById(R.id.btn_previous);
        ImageButton nextEv = findViewById(R.id.btn_next);

        final TextView monsterName = findViewById(R.id.monster_name);
        final ImageView monsterPicture = findViewById(R.id.monster_picture);
        final TextView healthStat = findViewById(R.id.stat_health);
        final TextView powerStat = findViewById(R.id.stat_power);
        final TextView speedStat = findViewById(R.id.stat_speed);
        final TextView staminaStat = findViewById(R.id.stat_stamina);
        final TextView monsterAge = findViewById(R.id.age);
        final TextView lvlStat = findViewById(R.id.base_stat);

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500); //You can manage the blinking time with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        lvlStat.startAnimation(anim);

        switch (mLevel) {
        case 0 :
            MonsterModel toEgg = getIntent().getParcelableExtra("EXTRA_PARCEL_EGG");
            monsterName.setText(toEgg.getName());
            typePicture.setImageResource(toEgg.getType());
            typePicture2.setImageResource(toEgg.getType2());
            monsterPicture.setImageResource(toEgg.getImage());
            weaknessPicture.setImageResource(toEgg.getWeakness());
            weaknessPicture2.setImageResource(toEgg.getWeakness2());
            healthStat.setText(String.valueOf(toEgg.getStatHealth()));
            powerStat.setText(String.valueOf(toEgg.getStatPower()));
            speedStat.setText(String.valueOf(toEgg.getStatSpeed()));
            staminaStat.setText(String.valueOf(toEgg.getStatStamina()));
            monsterAge.setText(R.string.egg);
            lvlStat.setText(R.string.lvl0);
            previousEv.setVisibility(View.INVISIBLE);
            nextEv.setVisibility(View.VISIBLE);
            break;
        case 1 :
            MonsterModel toChild = getIntent().getParcelableExtra("EXTRA_PARCEL_CHILD");
            monsterName.setText(toChild.getName());
            typePicture.setImageResource(toChild.getType());
            typePicture2.setImageResource(toChild.getType2());
            monsterPicture.setImageResource(toChild.getImage());
            weaknessPicture.setImageResource(toChild.getWeakness());
            weaknessPicture2.setImageResource(toChild.getWeakness2());
            healthStat.setText(String.valueOf(toChild.getStatHealth()));
            powerStat.setText(String.valueOf(toChild.getStatPower()));
            speedStat.setText(String.valueOf(toChild.getStatSpeed()));
            staminaStat.setText(String.valueOf(toChild.getStatStamina()));
            monsterAge.setText(R.string.child);
            lvlStat.setText(R.string.lvl1);
            previousEv.setVisibility(View.VISIBLE);
            nextEv.setVisibility(View.VISIBLE);
            break;
        case 2 :
            MonsterModel toJuv = getIntent().getParcelableExtra("EXTRA_PARCEL_JUV");
            monsterName.setText(toJuv.getName());
            typePicture.setImageResource(toJuv.getType());
            typePicture2.setImageResource(toJuv.getType2());
            monsterPicture.setImageResource(toJuv.getImage());
            weaknessPicture.setImageResource(toJuv.getWeakness());
            weaknessPicture2.setImageResource(toJuv.getWeakness2());
            healthStat.setText(String.valueOf(toJuv.getStatHealth()));
            powerStat.setText(String.valueOf(toJuv.getStatPower()));
            speedStat.setText(String.valueOf(toJuv.getStatSpeed()));
            staminaStat.setText(String.valueOf(toJuv.getStatStamina()));
            monsterAge.setText(R.string.juv);
            lvlStat.setText(R.string.lvl4);
            previousEv.setVisibility(View.VISIBLE);
            nextEv.setVisibility(View.VISIBLE);
            break;
        case 3 :
            MonsterModel toAdult = getIntent().getParcelableExtra("EXTRA_PARCEL_ADULT");
            monsterName.setText(toAdult.getName());
            typePicture.setImageResource(toAdult.getType());
            typePicture2.setImageResource(toAdult.getType2());
            monsterPicture.setImageResource(toAdult.getImage());
            weaknessPicture.setImageResource(toAdult.getWeakness());
            weaknessPicture2.setImageResource(toAdult.getWeakness2());
            healthStat.setText(String.valueOf(toAdult.getStatHealth()));
            powerStat.setText(String.valueOf(toAdult.getStatPower()));
            speedStat.setText(String.valueOf(toAdult.getStatSpeed()));
            staminaStat.setText(String.valueOf(toAdult.getStatStamina()));
            monsterAge.setText(R.string.adult);
            if (toAdult.getType2() == R.color.white)
                lvlStat.setText(R.string.lvl7);
            else if (toAdult.getType() == R.drawable.legend)
                lvlStat.setText(R.string.lvl25);
            else
                lvlStat.setText(R.string.lvl10);
            previousEv.setVisibility(View.VISIBLE);
            nextEv.setVisibility(View.INVISIBLE);
            break;
    }}
}







