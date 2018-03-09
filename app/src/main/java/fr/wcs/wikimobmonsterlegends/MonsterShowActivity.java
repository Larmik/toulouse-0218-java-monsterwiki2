package fr.wcs.wikimobmonsterlegends;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MonsterShowActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_show);

        //Récupération des vues
        TextView monsterName = findViewById(R.id.monster_name);
        TextView monsterAge = findViewById(R.id.age);
        ImageView typePicture = findViewById(R.id.type_picture);
        ImageView monsterPicture = findViewById(R.id.monster_picture);
        ImageView weaknessPicture = findViewById(R.id.weakness_picture);
        TextView healthStat = findViewById(R.id.stat_health);
        TextView powerStat = findViewById(R.id.stat_power);
        TextView speedStat = findViewById(R.id.stat_speed);
        TextView staminaStat = findViewById(R.id.stat_stamina);

        Button nextEv = findViewById(R.id.btn_next);
        Button previousEv = findViewById(R.id.btn_previous);

        //Database

        final int[][] statsLvl1 = {{81,242,192,100},{81,192,275,100},{97,246,220,100},{127,308,308,140},{115,192,192,100},{91,220,220,100},{81,253,192,100}, {81,209,275,100},{115,192,192,100}, {91,209,220,100}};
        final int[][] statsLvl4 = {{104,308,244,100}, {104,244,350,100},{124,313,280,100}, {162,392,392,140},{147,244,244,100},{116,280,280,100},{104,322,244,100},{104,266,350,100},{147,244,244,100},{116,266,280,100}};
        final int[][] statsLvl7 = {{153,374,297,100},{153,297,425,100},{184,380,340,100},{239,476,476,140},{217,297,297,100},{171,340,340,100},{153,391,297,100},{153,323,425,100},{217,297,297,100},{171,323,340,100}};


        // Intent/Extra sur MonsterShowActivity
        Intent fromMain = getIntent();
        monsterName.setText(fromMain.getStringExtra("name"));
        typePicture.setImageResource(fromMain.getIntExtra("types", 0 ));
        monsterPicture.setImageResource(fromMain.getIntExtra("picture", 0));
        weaknessPicture.setImageResource(fromMain.getIntExtra("weakness", 0));























    }
}
