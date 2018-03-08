package fr.wcs.wikimobmonsterlegends;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MonsterShowActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_show);

        TextView monsterName = findViewById(R.id.monster_name);
        ImageView typePicture = findViewById(R.id.type_picture);
        ImageView monsterPicture = findViewById(R.id.monster_picture);
        ImageView weaknessPicture = findViewById(R.id.weakness_picture);

        ArrayList<MonsterPage> datas = new ArrayList<>();
        datas.add(new MonsterPage("Fire Lion", 50, 220, 175, 100, R.drawable.firelion0, R.drawable.fire));
        datas.add(new MonsterPage("Thunder Eagle", 50, 175, 250, 100, R.drawable.thunder_eagle_0, R.drawable.thunder));
        datas.add(new MonsterPage("Metalsaur", 60, 224, 200, 100, R.drawable.metalsaur_0, R.drawable.metal));
        datas.add(new MonsterPage("Arch Knight", 56, 200, 200, 140, R.drawable.arch_knight_0, R.drawable.legend));
        datas.add(new MonsterPage("Light Spirit", 71, 175, 175, 100, R.drawable.light_spirit_0, R.drawable.light));
        datas.add(new MonsterPage("Genie", 50, 190, 250, 100, R.drawable.genie_0, R.drawable.magic));
        datas.add(new MonsterPage("Tyrannoking", 50, 230, 175, 100, R.drawable.tyrannoking_0, R.drawable.dark));
        datas.add(new MonsterPage("Turtle", 56, 200, 200, 100, R.drawable.turtle_0, R.drawable.water));
        datas.add(new MonsterPage("Rockilla", 71, 175, 175, 100, R.drawable.rockilla_0, R.drawable.earth));
        datas.add(new MonsterPage("Panda", 56, 190, 200, 100, R.drawable.panda_0, R.drawable.nature));


        Intent fromMain = getIntent();
        monsterName.setText(fromMain.getStringExtra("name"));
        typePicture.setImageResource(fromMain.getIntExtra("type", 0));
        monsterPicture.setImageResource(fromMain.getIntExtra("picture", 0));
        weaknessPicture.setImageResource(fromMain.getIntExtra("weakness", 0));




















        


    }
}
