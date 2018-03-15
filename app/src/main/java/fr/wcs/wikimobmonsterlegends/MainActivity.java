package fr.wcs.wikimobmonsterlegends;


import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
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

        final ArrayList<MonsterModel> eggInfo = new ArrayList<>();
        eggInfo.add(new MonsterModel("Fire Lion", R.drawable.fire, R.color.white, R.drawable.water,R.color.white, R.drawable.fire_lion_egg, 50, 220, 175, 100 ));
        eggInfo.add(new MonsterModel("Thunder Eagle", R.drawable.thunder,R.color.white, R.drawable.earth,R.color.white, R.drawable.eggeagle,50, 175, 250, 100));
        eggInfo.add(new MonsterModel("Metalsaur", R.drawable.metal, R.color.white,R.drawable.magic, R.color.white,R.drawable.metalsaur_huevo, 60, 224, 220, 100));
        eggInfo.add(new MonsterModel("Arch Knight", R.drawable.legend,R.color.white, R.drawable.metal,R.color.white, R.drawable.arch_knight_egg, 56, 200, 200, 140));
        eggInfo.add(new MonsterModel("Light Spirit", R.drawable.light,R.color.white, R.drawable.metal,R.color.white, R.drawable.light_spirit_egg, 71, 175, 175, 100));
        eggInfo.add(new MonsterModel("Genie", R.drawable.magic,R.color.white, R.drawable.nature,R.color.white, R.drawable.genie_egg, 50, 190, 250, 100));
        eggInfo.add(new MonsterModel("Tyrannoking", R.drawable.dark,R.color.white, R.drawable.light,R.color.white, R.drawable.tyrannoking_egg,50, 230, 175, 100));
        eggInfo.add(new MonsterModel("Turtle", R.drawable.water,R.color.white, R.drawable.thunder,R.color.white, R.drawable.turtle_egg, 56, 200, 200, 100));
        eggInfo.add(new MonsterModel("Rockilla", R.drawable.earth,R.color.white, R.drawable.dark,R.color.white, R.drawable.roquillaegg, 71, 175, 175, 100));
        eggInfo.add(new MonsterModel("Panda", R.drawable.nature,R.color.white, R.drawable.fire,R.color.white, R.drawable.panda_egg, 56, 190, 200, 100));
        eggInfo.add(new MonsterModel("Blesstle",R.drawable.water, R.drawable.light, R.drawable.thunder, R.drawable.metal, R.drawable.blesstle_egg, 63, 185, 190, 110 ));
        eggInfo.add(new MonsterModel("Firekong",R.drawable.fire, R.drawable.earth, R.drawable.water, R.drawable.dark, R.drawable.firekong_egg,63, 230, 160, 110));
        eggInfo.add(new MonsterModel("Firanda",R.drawable.fire, R.drawable.nature, R.drawable.water, R.color.white, R.drawable.firanda_egg, 50, 225, 200, 110));
        eggInfo.add(new MonsterModel("Electrex",R.drawable.earth, R.drawable.thunder, R.drawable.dark, R.color.white, R.drawable.electrex_egg, 63, 170, 225, 110));
        eggInfo.add(new MonsterModel("Gigram",R.drawable.fire, R.drawable.thunder, R.drawable.water, R.drawable.earth, R.drawable.gigram_egg, 42, 225, 225, 110));
        eggInfo.add(new MonsterModel("Gigarast",R.drawable.dark, R.drawable.magic, R.drawable.light, R.drawable.nature, R.drawable.giragast_eggb, 63, 223, 160, 110));
        eggInfo.add(new MonsterModel("Light Sphinx",R.drawable.earth, R.drawable.light, R.drawable.dark, R.drawable.metal, R.drawable.light_sphinx_egg, 77, 175, 160, 110));
        eggInfo.add(new MonsterModel("Obsidia",R.drawable.earth, R.drawable.dark, R.drawable.light, R.color.white, R.drawable.obsidia_egg,56, 200, 200, 110));
        eggInfo.add(new MonsterModel("Succuba",R.drawable.dark, R.drawable.light, R.drawable.metal, R.color.white, R.drawable.succuba_egg, 63, 225, 160, 110));
        eggInfo.add(new MonsterModel("Sheluke",R.drawable.nature, R.drawable.water, R.drawable.fire, R.drawable.thunder, R.drawable.sheluke_egg, 56, 200, 200, 110));
        eggInfo.add(new MonsterModel("Terror Dactyl",R.drawable.thunder, R.drawable.dark, R.drawable.earth, R.drawable.light, R.drawable.terror_dactyl_egg, 42, 225, 225, 110));
        eggInfo.add(new MonsterModel("Vixsun",R.drawable.nature, R.drawable.light, R.drawable.fire, R.drawable.metal, R.drawable.vixsun_egg, 63, 200, 175, 110));

        final ArrayList<MonsterModel> childInfo = new ArrayList<>();
        childInfo.add(new MonsterModel("Fire Lion", R.drawable.fire,R.color.white,  R.drawable.water, R.color.white,R.drawable.firelion, 81, 242, 192, 100 ));
        childInfo.add(new MonsterModel("Thunder Eagle", R.drawable.thunder,R.color.white, R.drawable.earth,R.color.white, R.drawable.thunder_eagle1,81, 192, 275, 100));
        childInfo.add(new MonsterModel("Metalsaur", R.drawable.metal,R.color.white, R.drawable.magic, R.color.white,R.drawable.metalsaur_1, 97, 246, 220, 100));
        childInfo.add(new MonsterModel("Arch Knight", R.drawable.legend,R.color.white, R.drawable.metal, R.color.white,R.drawable.arch_knight_1, 127, 308, 308, 140));
        childInfo.add(new MonsterModel("Light Spirit", R.drawable.light,R.color.white, R.drawable.metal,R.color.white, R.drawable.light_spirit_1, 115, 192, 192, 100));
        childInfo.add(new MonsterModel("Genie", R.drawable.magic,R.color.white, R.drawable.nature, R.color.white,R.drawable.genie_1, 91, 220, 220, 100));
        childInfo.add(new MonsterModel("Tyrannoking", R.drawable.dark,R.color.white, R.drawable.light,R.color.white, R.drawable.tyrannoking_1,81, 253, 192, 100));
        childInfo.add(new MonsterModel("Turtle", R.drawable.water, R.color.white,R.drawable.thunder, R.color.white,R.drawable.turtle_1, 81, 209, 275, 100));
        childInfo.add(new MonsterModel("Rockilla", R.drawable.earth,R.color.white, R.drawable.dark,R.color.white, R.drawable.gorilla1, 115, 192, 192, 100));
        childInfo.add(new MonsterModel("Panda", R.drawable.nature, R.color.white,R.drawable.fire,R.color.white, R.drawable.panda, 91, 209, 220, 100));
        childInfo.add(new MonsterModel("Blesstle",R.drawable.water, R.drawable.light, R.drawable.thunder, R.drawable.metal, R.drawable.blesstle_1b, 112, 224, 229, 110 ));
        childInfo.add(new MonsterModel("Firekong",R.drawable.fire, R.drawable.earth, R.drawable.water, R.drawable.dark, R.drawable.firekong_1,112, 278, 193, 110));
        childInfo.add(new MonsterModel("Firanda",R.drawable.fire, R.drawable.nature, R.drawable.water, R.color.white, R.drawable.firanda_fase1, 89, 272, 242, 110));
        childInfo.add(new MonsterModel("Electrex",R.drawable.earth, R.drawable.thunder, R.drawable.dark, R.color.white, R.drawable.electrex_1, 112, 205, 272, 110));
        childInfo.add(new MonsterModel("Gigram",R.drawable.fire, R.drawable.thunder, R.drawable.water, R.drawable.earth, R.drawable.gigram_1, 74, 272, 272, 110));
        childInfo.add(new MonsterModel("Gigarast",R.drawable.dark, R.drawable.magic, R.drawable.light, R.drawable.nature, R.drawable.giragast_1, 112, 269, 193, 110));
        childInfo.add(new MonsterModel("Light Sphinx",R.drawable.earth, R.drawable.light, R.drawable.dark, R.drawable.metal, R.drawable.light_sphinx_1, 138, 212, 193, 110));
        childInfo.add(new MonsterModel("Obsidia",R.drawable.earth, R.drawable.dark, R.drawable.light, R.color.white, R.drawable.obsidia_1,101, 242, 242, 110));
        childInfo.add(new MonsterModel("Succuba",R.drawable.dark, R.drawable.light, R.drawable.metal, R.color.white, R.drawable.succuba_1b, 112, 272, 193, 110));
        childInfo.add(new MonsterModel("Sheluke",R.drawable.nature, R.drawable.water, R.drawable.fire, R.drawable.thunder, R.drawable.sheluke_1, 101, 242, 242, 110));
        childInfo.add(new MonsterModel("Terror Dactyl",R.drawable.thunder, R.drawable.dark, R.drawable.earth, R.drawable.light, R.drawable.terror_dactyl_1, 74, 272, 272, 110));
        childInfo.add(new MonsterModel("Vixsun",R.drawable.nature, R.drawable.light, R.drawable.fire, R.drawable.metal, R.drawable.vixsun_1b, 112, 242, 212, 110));


        final ArrayList<MonsterModel> juvInfo = new ArrayList<>();
        juvInfo.add(new MonsterModel("Fire Lion", R.drawable.fire,R.color.white, R.drawable.water, R.color.white,R.drawable.firelion2, 104, 308, 244, 100 ));
        juvInfo.add(new MonsterModel("Thunder Eagle", R.drawable.thunder, R.color.white,R.drawable.earth,R.color.white, R.drawable.thunder_eagle_2,104, 244, 350, 100));
        juvInfo.add(new MonsterModel("Metalsaur", R.drawable.metal,R.color.white, R.drawable.magic, R.color.white,R.drawable.metalsaur_2, 124, 313, 280, 100));
        juvInfo.add(new MonsterModel("Arch Knight", R.drawable.legend,R.color.white, R.drawable.metal, R.color.white,R.drawable.arch_knight_2, 162, 392, 392, 140));
        juvInfo.add(new MonsterModel("Light Spirit", R.drawable.light,R.color.white, R.drawable.metal,R.color.white, R.drawable.light_spirit_2, 147, 244, 244, 100));
        juvInfo.add(new MonsterModel("Genie", R.drawable.magic,R.color.white, R.drawable.nature, R.color.white,R.drawable.genie_2, 116, 280, 280, 100));
        juvInfo.add(new MonsterModel("Tyrannoking", R.drawable.dark,R.color.white, R.drawable.light, R.color.white,R.drawable.tyrannoking_2,104, 322, 244, 100));
        juvInfo.add(new MonsterModel("Turtle", R.drawable.water,R.color.white, R.drawable.thunder,R.color.white, R.drawable.turtle_2, 104, 266, 350, 100));
        juvInfo.add(new MonsterModel("Rockilla", R.drawable.earth,R.color.white, R.drawable.dark,R.color.white, R.drawable.gorilla2, 147, 244, 244, 100));
        juvInfo.add(new MonsterModel("Panda", R.drawable.nature, R.color.white,R.drawable.fire,R.color.white, R.drawable.panda_2, 116, 266, 280, 100));
        juvInfo.add(new MonsterModel("Blesstle",R.drawable.water, R.drawable.light, R.drawable.thunder, R.drawable.metal, R.drawable.blesstle_2b, 143, 285, 292, 110 ));
        juvInfo.add(new MonsterModel("Firekong",R.drawable.fire, R.drawable.earth, R.drawable.water, R.drawable.dark, R.drawable.firekong_2,143, 354, 246, 110));
        juvInfo.add(new MonsterModel("Firanda",R.drawable.fire, R.drawable.nature, R.drawable.water, R.color.white, R.drawable.firanda_fase2, 114, 347, 308, 110));
        juvInfo.add(new MonsterModel("Electrex",R.drawable.earth, R.drawable.thunder, R.drawable.dark, R.color.white, R.drawable.electrex_2, 143, 261, 347, 110));
        juvInfo.add(new MonsterModel("Gigram",R.drawable.fire, R.drawable.thunder, R.drawable.water, R.drawable.earth, R.drawable.gigram_2, 95, 347, 347, 110));
        juvInfo.add(new MonsterModel("Gigarast",R.drawable.dark, R.drawable.magic, R.drawable.light, R.drawable.nature, R.drawable.giragast_2, 143, 343, 246, 110));
        juvInfo.add(new MonsterModel("Light Sphinx",R.drawable.earth, R.drawable.light, R.drawable.dark, R.drawable.metal, R.drawable.light_sphinx_2, 176, 270, 246, 110));
        juvInfo.add(new MonsterModel("Obsidia",R.drawable.earth, R.drawable.dark, R.drawable.light, R.color.white, R.drawable.obsidia_2,128, 308, 308, 110));
        juvInfo.add(new MonsterModel("Succuba",R.drawable.dark, R.drawable.light, R.drawable.metal, R.color.white, R.drawable.succuba_2b, 143, 347, 246, 110));
        juvInfo.add(new MonsterModel("Sheluke",R.drawable.nature, R.drawable.water, R.drawable.fire, R.drawable.thunder, R.drawable.sheluke_2, 128, 308, 308, 110));
        juvInfo.add(new MonsterModel("Terror Dactyl",R.drawable.thunder, R.drawable.dark, R.drawable.earth, R.drawable.light, R.drawable.terror_dactyl_2, 95, 347, 347, 110));
        juvInfo.add(new MonsterModel("Vixsun",R.drawable.nature, R.drawable.light, R.drawable.fire, R.drawable.metal, R.drawable.vixsun_2b, 143, 308, 270, 110));

        final ArrayList<MonsterModel> adultInfo = new ArrayList<>();
        adultInfo.add(new MonsterModel("Fire Lion", R.drawable.fire, R.color.white,R.drawable.water, R.color.white,R.drawable.fire_lion3, 153, 374, 297, 100 ));
        adultInfo.add(new MonsterModel("Thunder Eagle", R.drawable.thunder,R.color.white, R.drawable.earth,R.color.white, R.drawable.thunder_eagle_3,153, 297, 425, 100));
        adultInfo.add(new MonsterModel("Metalsaur", R.drawable.metal,R.color.white, R.drawable.magic, R.color.white,R.drawable.metalsaur3, 184, 380, 340, 100));
        adultInfo.add(new MonsterModel("Arch Knight", R.drawable.legend, R.color.white,R.drawable.metal, R.color.white,R.drawable.arch_knight_3, 239, 476, 476, 140));
        adultInfo.add(new MonsterModel("Light Spirit", R.drawable.light, R.color.white,R.drawable.metal, R.color.white,R.drawable.light_spirit_3, 217, 297, 297, 100));
        adultInfo.add(new MonsterModel("Genie", R.drawable.magic, R.color.white,R.drawable.nature, R.color.white,R.drawable.genie_3, 171, 340, 340, 100));
        adultInfo.add(new MonsterModel("Tyrannoking", R.drawable.dark,R.color.white, R.drawable.light,R.color.white, R.drawable.tyrannoking_3,153, 391, 297, 100));
        adultInfo.add(new MonsterModel("Turtle", R.drawable.water,R.color.white, R.drawable.thunder, R.color.white,R.drawable.turtle_3, 153, 323, 425, 100));
        adultInfo.add(new MonsterModel("Rockilla", R.drawable.earth,R.color.white, R.drawable.dark,R.color.white, R.drawable.gorilla3, 217, 297, 297, 100));
        adultInfo.add(new MonsterModel("Panda", R.drawable.nature, R.color.white,R.drawable.fire,R.color.white, R.drawable.panda3, 171, 323, 340, 100));
        adultInfo.add(new MonsterModel("Blesstle",R.drawable.water, R.drawable.light, R.drawable.thunder, R.drawable.metal, R.drawable.blesstle_3b, 317, 408, 418, 110 ));
        adultInfo.add(new MonsterModel("Firekong",R.drawable.fire, R.drawable.earth, R.drawable.water, R.drawable.dark, R.drawable.firekong_3,317, 506, 352, 110));
        adultInfo.add(new MonsterModel("Firanda",R.drawable.fire, R.drawable.nature, R.drawable.water, R.color.white, R.drawable.firanda, 252, 496, 440, 110));
        adultInfo.add(new MonsterModel("Electrex",R.drawable.earth, R.drawable.thunder, R.drawable.dark, R.color.white, R.drawable.electrex_3, 317, 374, 496, 110));
        adultInfo.add(new MonsterModel("Gigram",R.drawable.fire, R.drawable.thunder, R.drawable.water, R.drawable.earth, R.drawable.gigram_3, 211, 496, 496, 110));
        adultInfo.add(new MonsterModel("Giragast",R.drawable.dark, R.drawable.magic, R.drawable.light, R.drawable.nature, R.drawable.giragast_3, 317, 490, 352, 110));
        adultInfo.add(new MonsterModel("Light Sphinx",R.drawable.earth, R.drawable.light, R.drawable.dark, R.drawable.metal, R.drawable.light_sphinx_3, 390, 386, 352, 110));
        adultInfo.add(new MonsterModel("Obsidia",R.drawable.earth, R.drawable.dark, R.drawable.light, R.color.white, R.drawable.obsidia_3,285, 440, 440, 110));
        adultInfo.add(new MonsterModel("Succuba",R.drawable.dark, R.drawable.light, R.drawable.metal, R.color.white, R.drawable.succuba_3, 317, 496, 352, 110));
        adultInfo.add(new MonsterModel("Sheluke",R.drawable.nature, R.drawable.water, R.drawable.fire, R.drawable.thunder, R.drawable.sheluke_3, 285, 440, 440, 110));
        adultInfo.add(new MonsterModel("Terror Dactyl",R.drawable.thunder, R.drawable.dark, R.drawable.earth, R.drawable.light, R.drawable.terror_dactyl_3, 211, 496, 496, 110));
        adultInfo.add(new MonsterModel("Vixsun",R.drawable.nature, R.drawable.light, R.drawable.fire, R.drawable.metal, R.drawable.vixsun_3, 317, 440, 386, 110));
        //Fin database

        final Intent intent = new Intent(MainActivity.this, MonsterShowActivity.class);
        final ListView listMonsters = findViewById(R.id.liste);
        final ListAdapter adapter = new ListAdapter(this, eggInfo);
        final Spinner filter1 = findViewById(R.id.type_list_1);
        final ArrayList<MonsterModel> filterListEgg = new ArrayList<>();
        final ArrayList<MonsterModel> filterListChild = new ArrayList<>();
        final ArrayList<MonsterModel> filterListJuv = new ArrayList<>();
        final ArrayList<MonsterModel> filterListAdult = new ArrayList<>();

        filter1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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


            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Si "Choose an element", afficher liste entière, sinon appeler le filterAdapter
                if (position == 0){
                    listMonsters.setAdapter(adapter);
                    listMonsters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long arg) {
                            Parcelable eggModel = new MonsterModel(eggInfo.get(i).getName(),
                                    eggInfo.get(i).getType(), eggInfo.get(i).getWeakness(),
                                    eggInfo.get(i).getType2(), eggInfo.get(i).getWeakness2(),
                                    eggInfo.get(i).getImage(), eggInfo.get(i).getStatHealth(),
                                    eggInfo.get(i).getStatPower(), eggInfo.get(i).getStatSpeed(),
                                    eggInfo.get(i).getStatStamina());
                            Parcelable juvModel = new MonsterModel(juvInfo.get(i).getName(),
                                    juvInfo.get(i).getType(), juvInfo.get(i).getWeakness(),
                                    juvInfo.get(i).getType2(), juvInfo.get(i).getWeakness2(),
                                    juvInfo.get(i).getImage(), juvInfo.get(i).getStatHealth(),
                                    juvInfo.get(i).getStatPower(), juvInfo.get(i).getStatSpeed(),
                                    juvInfo.get(i).getStatStamina());
                            Parcelable childModel = new MonsterModel(childInfo.get(i).getName(),
                                    childInfo.get(i).getType(), childInfo.get(i).getWeakness(),
                                    childInfo.get(i).getType2(), childInfo.get(i).getWeakness2(),
                                    childInfo.get(i).getImage(), childInfo.get(i).getStatHealth(),
                                    childInfo.get(i).getStatPower(), childInfo.get(i).getStatSpeed(),
                                    childInfo.get(i).getStatStamina());
                            Parcelable adultModel = new MonsterModel(adultInfo.get(i).getName(),
                                    adultInfo.get(i).getType(), adultInfo.get(i).getWeakness(),
                                    adultInfo.get(i).getType2(), adultInfo.get(i).getWeakness2(),
                                    adultInfo.get(i).getImage(), adultInfo.get(i).getStatHealth(),
                                    adultInfo.get(i).getStatPower(), adultInfo.get(i).getStatSpeed(),
                                    adultInfo.get(i).getStatStamina());

                            intent.putExtra("EXTRA_PARCEL_EGG", eggModel);
                            intent.putExtra("EXTRA_PARCEL_CHILD", childModel);
                            intent.putExtra("EXTRA_PARCEL_JUV", juvModel);
                            intent.putExtra("EXTRA_PARCEL_ADULT", adultModel);
                            MainActivity.this.startActivity(intent);

                        }
                    });
                }
                else {
                    ListAdapter filterAdapter = new ListAdapter(MainActivity.this, filterListEgg);
                    filterListEgg.clear();
                    filterListChild.clear();
                    filterListJuv.clear();
                    filterListAdult.clear();
                    for (int i = 0; i < eggInfo.size(); i++) {
                        if (getResources().getResourceEntryName(eggInfo.get(i).getType()).toLowerCase()
                                .contains(filter1.getSelectedItem().toString().toLowerCase())) {
                            filterListEgg.add(eggInfo.get(i));
                            filterListChild.add(childInfo.get(i));
                            filterListJuv.add(juvInfo.get(i));
                            filterListAdult.add(adultInfo.get(i));

                        }
                    }

                    listMonsters.setAdapter(filterAdapter);


                }

                    listMonsters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long arg) {
                            Parcelable eggModel = new MonsterModel(filterListEgg.get(i).getName(),
                                    filterListEgg.get(i).getType(), filterListEgg.get(i).getWeakness(),
                                    filterListEgg.get(i).getType2(), filterListEgg.get(i).getWeakness2(),
                                    filterListEgg.get(i).getImage(), filterListEgg.get(i).getStatHealth(),
                                    filterListEgg.get(i).getStatPower(), filterListEgg.get(i).getStatSpeed(),
                                    filterListEgg.get(i).getStatStamina());
                            Parcelable juvModel = new MonsterModel(filterListJuv.get(i).getName(),
                                    filterListJuv.get(i).getType(), filterListJuv.get(i).getWeakness(),
                                    filterListJuv.get(i).getType2(), filterListJuv.get(i).getWeakness2(),
                                    filterListJuv.get(i).getImage(),filterListJuv.get(i).getStatHealth(),
                                    filterListJuv.get(i).getStatPower(),filterListJuv.get(i).getStatSpeed(),
                                    filterListJuv.get(i).getStatStamina());
                            Parcelable childModel = new MonsterModel(filterListChild.get(i).getName(),
                                    filterListChild.get(i).getType(), filterListChild.get(i).getWeakness(),
                                    filterListChild.get(i).getType2(), filterListChild.get(i).getWeakness2(),
                                    filterListChild.get(i).getImage(), filterListChild.get(i).getStatHealth(),
                                    filterListChild.get(i).getStatPower(),filterListChild.get(i).getStatSpeed(),
                                    filterListChild.get(i).getStatStamina());
                            Parcelable adultModel = new MonsterModel(filterListAdult.get(i).getName(),
                                    filterListAdult.get(i).getType(), filterListAdult.get(i).getWeakness(),
                                    filterListAdult.get(i).getType2(), filterListAdult.get(i).getWeakness2(),
                                    filterListAdult.get(i).getImage(), filterListAdult.get(i).getStatHealth(),
                                    filterListAdult.get(i).getStatPower(), filterListAdult.get(i).getStatSpeed(),
                                    filterListAdult.get(i).getStatStamina());
                            intent.putExtra("EXTRA_PARCEL_EGG", eggModel);
                            intent.putExtra("EXTRA_PARCEL_CHILD", childModel);
                            intent.putExtra("EXTRA_PARCEL_JUV", juvModel);
                            intent.putExtra("EXTRA_PARCEL_ADULT", adultModel);
                            MainActivity.this.startActivity(intent);
                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
    }
}

