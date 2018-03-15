package fr.wcs.wikimobmonsterlegends;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Création ListView et adaptation du contenu pour chaque item via ListAdapter
        final ListView listMonsters = findViewById(R.id.liste);
        final ArrayList<MonsterModel> monsterInfo = new ArrayList<>();
        monsterInfo.add(new MonsterModel("Fire Lion", R.drawable.fire));
        monsterInfo.add(new MonsterModel("Thunder Eagle", R.drawable.thunder));
        monsterInfo.add(new MonsterModel("Metalsaur", R.drawable.metal));
        monsterInfo.add(new MonsterModel("Arch Knight", R.drawable.legend));
        monsterInfo.add(new MonsterModel("Light Spirit", R.drawable.light));
        monsterInfo.add(new MonsterModel("Genie", R.drawable.magic));
        monsterInfo.add(new MonsterModel("Tyrannoking", R.drawable.dark));
        monsterInfo.add(new MonsterModel("Turtle", R.drawable.water));
        monsterInfo.add(new MonsterModel("Rockilla", R.drawable.earth));
        monsterInfo.add(new MonsterModel("Panda", R.drawable.nature));
        final ListAdapter adapter = new ListAdapter(this, monsterInfo);
        listMonsters.setAdapter(adapter);

        //Database
        final String[] names = {"Fire Lion",
                "Thunder Eagle",
                "Metalsaur",
                "Arch Knight",
                "Light Spirit",
                "Genie",
                "Tyrannoking",
                "Turtle",
                "Rockilla",
                "Panda"};

        final int[] types = {R.drawable.fire,
                R.drawable.thunder,
                R.drawable.metal,
                R.drawable.legend,
                R.drawable.light,
                R.drawable.magic,
                R.drawable.dark,
                R.drawable.water,
                R.drawable.earth,
                R.drawable.nature};

        final int[] picturesEgg = {R.drawable.fire_lion_egg,
                R.drawable.eggeagle,
                R.drawable.metalsaur_huevo,
                R.drawable.arch_knight_egg,
                R.drawable.light_spirit_egg,
                R.drawable.genie_egg,
                R.drawable.tyrannoking_egg,
                R.drawable.turtle_egg,
                R.drawable.roquillaegg,
                R.drawable.panda_egg};

        final int[] picturesChild = {R.drawable.fire,
                R.drawable.thunder_eagle1,
                R.drawable.metalsaur_1,
                R.drawable.arch_knight_1,
                R.drawable.light_spirit_1,
                R.drawable.genie_1,
                R.drawable.tyrannoking_1,
                R.drawable.turtle_1,
                R.drawable.gorilla1,
                R.drawable.panda};

        final int[] picturesJuv = {R.drawable.firelion2,
                R.drawable.thunder_eagle_2,
                R.drawable.metalsaur_2,
                R.drawable.arch_knight_2,
                R.drawable.light_spirit_2,
                R.drawable.genie_2,
                R.drawable.tyrannoking_2,
                R.drawable.turtle_2,
                R.drawable.gorilla2,
                R.drawable.panda_2};

        final int[] picturesAdult = {R.drawable.fire_lion3,
                R.drawable.thunder_eagle_3,
                R.drawable.metalsaur3,
                R.drawable.arch_knight_3,
                R.drawable.light_spirit_3,
                R.drawable.genie_3,
                R.drawable.tyrannoking_3,
                R.drawable.turtle_3,
                R.drawable.gorilla3,
                R.drawable.panda3};

        final int[] weakness = {R.drawable.water,
                R.drawable.earth,
                R.drawable.magic,
                R.drawable.metal,
                R.drawable.metal,
                R.drawable.nature,
                R.drawable.light,
                R.drawable.thunder,
                R.drawable.dark,
                R.drawable.fire};

        final int[][] statsLvl0 = {{50, 220, 175, 100}, {50, 175, 250, 100},
                {60, 224, 220, 100}, {56, 200, 200, 140}, {71, 175, 175, 100},
                {50, 190, 250, 100}, {50, 230, 175, 100}, {56, 200, 200, 100},
                {71, 175, 175, 100}, {56, 190, 200, 100}};
        final int[][] statsLvl1 = {{81, 242, 192, 100}, {81, 192, 275, 100},
                {97, 246, 220, 100}, {127, 308, 308, 140}, {115, 192, 192, 100},
                {91, 220, 220, 100}, {81, 253, 192, 100}, {81, 209, 275, 100},
                {115, 192, 192, 100}, {91, 209, 220, 100}};
        final int[][] statsLvl4 = {{104, 308, 244, 100}, {104, 244, 350, 100},
                {124, 313, 280, 100}, {162, 392, 392, 140}, {147, 244, 244, 100},
                {116, 280, 280, 100}, {104, 322, 244, 100}, {104, 266, 350, 100},
                {147, 244, 244, 100}, {116, 266, 280, 100}};
        final int[][] statsLvl7 = {{153, 374, 297, 100}, {153, 297, 425, 100},
                {184, 380, 340, 100}, {239, 476, 476, 140}, {217, 297, 297, 100},
                {171, 340, 340, 100}, {153, 391, 297, 100}, {153, 323, 425, 100},
                {217, 297, 297, 100}, {171, 323, 340, 100}};
        //Fin database


        // Création intent/extra pour envoi de données et implémentation onClick des items
        listMonsters.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg) {

                Intent intent = new Intent(MainActivity.this, MonsterShowActivity.class);

                intent.putExtra("type", types[position]);
                intent.putExtra("name", names[position]);
                intent.putExtra("weakness", weakness[position]);

                intent.putExtra("picture_egg", picturesEgg[position]);
                intent.putExtra("health0", statsLvl0[position][0]);
                intent.putExtra("power0", statsLvl0[position][1]);
                intent.putExtra("speed0", statsLvl0[position][2]);
                intent.putExtra("stamina0", statsLvl0[position][3]);

                intent.putExtra("health1", statsLvl1[position][0]);
                intent.putExtra("power1", statsLvl1[position][1]);
                intent.putExtra("speed1", statsLvl1[position][2]);
                intent.putExtra("stamina1", statsLvl1[position][3]);
                intent.putExtra("picture_child", picturesChild[position]);

                intent.putExtra("picture_juv", picturesJuv[position]);
                intent.putExtra("health4", statsLvl4[position][0]);
                intent.putExtra("power4", statsLvl4[position][1]);
                intent.putExtra("speed4", statsLvl4[position][2]);
                intent.putExtra("stamina4", statsLvl4[position][3]);

                intent.putExtra("picture_adult", picturesAdult[position]);
                intent.putExtra("health7", statsLvl7[position][0]);
                intent.putExtra("power7", statsLvl7[position][1]);
                intent.putExtra("speed7", statsLvl7[position][2]);
                intent.putExtra("stamina7", statsLvl7[position][3]);

                MainActivity.this.startActivity(intent);



            }
        });

        final Spinner filtre1 = findViewById(R.id.type_list_1);

        final ArrayList<MonsterModel> filterList = new ArrayList<>();

        final ListAdapter filterAdapter = new ListAdapter(this, filterList);


        filtre1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0){

                    listMonsters.setAdapter(adapter);

                }
                else {

                    for (int i = 0; i < monsterInfo.size(); i++) {

                        if (getResources().getResourceEntryName(monsterInfo.get(i).getImage()).toLowerCase().contains(filtre1.getSelectedItem().toString().toLowerCase())) {

                            filterList.clear();
                            filterList.add(monsterInfo.get(i));

                        }
                    }

                    listMonsters.setAdapter(filterAdapter);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

    }
}

