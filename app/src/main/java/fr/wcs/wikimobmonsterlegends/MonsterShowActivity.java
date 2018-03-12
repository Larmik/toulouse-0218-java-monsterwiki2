package fr.wcs.wikimobmonsterlegends;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class MonsterShowActivity extends MainActivity {

    int mLevel = 0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_show);

        Button previousEv = findViewById(R.id.btn_previous);
        Button nextEv = findViewById(R.id.btn_next);
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
        ImageView weaknessPicture = findViewById(R.id.weakness_picture);
        Button previousEv = findViewById(R.id.btn_previous);
        Button nextEv = findViewById(R.id.btn_next);

        final Intent fromMain = getIntent();
        final TextView monsterName = findViewById(R.id.monster_name);
        final ImageView monsterPicture = findViewById(R.id.monster_picture);
        final TextView healthStat = findViewById(R.id.stat_health);
        final TextView powerStat = findViewById(R.id.stat_power);
        final TextView speedStat = findViewById(R.id.stat_speed);
        final TextView staminaStat = findViewById(R.id.stat_stamina);
        final TextView monsterAge = findViewById(R.id.age);

        switch (mLevel) {
        case 0 :
            monsterName.setText(fromMain.getStringExtra("name"));
            typePicture.setImageResource(fromMain.getIntExtra("type", 0));
            monsterPicture.setImageResource(fromMain.getIntExtra("picture_egg", 0));
            weaknessPicture.setImageResource(fromMain.getIntExtra("weakness", 0));
            healthStat.setText(String.valueOf(fromMain.getIntExtra("health0", 0)));
            powerStat.setText(String.valueOf(fromMain.getIntExtra("power0", 0)));
            speedStat.setText(String.valueOf(fromMain.getIntExtra("speed0", 0)));
            staminaStat.setText(String.valueOf(fromMain.getIntExtra("stamina0", 0)));
            monsterAge.setText(R.string.egg);
            previousEv.setVisibility(View.INVISIBLE);
            nextEv.setVisibility(View.VISIBLE);
            break;
        case 1 :
            monsterName.setText(fromMain.getStringExtra("name"));
            typePicture.setImageResource(fromMain.getIntExtra("type", 0));
            monsterPicture.setImageResource(fromMain.getIntExtra("picture_child", 0));
            weaknessPicture.setImageResource(fromMain.getIntExtra("weakness", 0));
            healthStat.setText(String.valueOf(fromMain.getIntExtra("health1", 0)));
            powerStat.setText(String.valueOf(fromMain.getIntExtra("power1", 0)));
            speedStat.setText(String.valueOf(fromMain.getIntExtra("speed1", 0)));
            staminaStat.setText(String.valueOf(fromMain.getIntExtra("stamina1", 0)));
            monsterAge.setText(R.string.child);
            previousEv.setVisibility(View.VISIBLE);
            nextEv.setVisibility(View.VISIBLE);
            break;
        case 2 :
            monsterName.setText(fromMain.getStringExtra("name"));
            typePicture.setImageResource(fromMain.getIntExtra("type", 0));
            monsterPicture.setImageResource(fromMain.getIntExtra("picture_juv", 0));
            weaknessPicture.setImageResource(fromMain.getIntExtra("weakness", 0));
            healthStat.setText(String.valueOf(fromMain.getIntExtra("health4", 0)));
            powerStat.setText(String.valueOf(fromMain.getIntExtra("power4", 0)));
            speedStat.setText(String.valueOf(fromMain.getIntExtra("speed4", 0)));
            staminaStat.setText(String.valueOf(fromMain.getIntExtra("stamina4", 0)));
            monsterAge.setText(R.string.juv);
            previousEv.setVisibility(View.VISIBLE);
            nextEv.setVisibility(View.VISIBLE);
            break;
        case 3 :
            monsterName.setText(fromMain.getStringExtra("name"));
            typePicture.setImageResource(fromMain.getIntExtra("type", 0));
            monsterPicture.setImageResource(fromMain.getIntExtra("picture_adult", 0));
            weaknessPicture.setImageResource(fromMain.getIntExtra("weakness", 0));
            healthStat.setText(String.valueOf(fromMain.getIntExtra("health7", 0)));
            powerStat.setText(String.valueOf(fromMain.getIntExtra("power7", 0)));
            speedStat.setText(String.valueOf(fromMain.getIntExtra("speed7", 0)));
            staminaStat.setText(String.valueOf(fromMain.getIntExtra("stamina7", 0)));
            monsterAge.setText(R.string.adult);
            previousEv.setVisibility(View.VISIBLE);
            nextEv.setVisibility(View.INVISIBLE);
            break;
    }}
}







