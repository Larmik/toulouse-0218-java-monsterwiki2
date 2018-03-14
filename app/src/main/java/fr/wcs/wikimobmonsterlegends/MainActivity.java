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
        final ArrayList<MonsterModel> eggInfo = new ArrayList<>();
        eggInfo.add(new MonsterModel("Fire Lion", R.drawable.fire, R.drawable.water, R.drawable.fire_lion_egg, 50, 220, 175, 100 ));
        eggInfo.add(new MonsterModel("Thunder Eagle", R.drawable.thunder, R.drawable.earth, R.drawable.eggeagle,50, 175, 250, 100));
        eggInfo.add(new MonsterModel("Metalsaur", R.drawable.metal, R.drawable.magic, R.drawable.metalsaur_huevo, 60, 224, 220, 100));
        eggInfo.add(new MonsterModel("Arch Knight", R.drawable.legend, R.drawable.metal, R.drawable.arch_knight_egg, 56, 200, 200, 140));
        eggInfo.add(new MonsterModel("Light Spirit", R.drawable.light, R.drawable.metal, R.drawable.light_spirit_egg, 71, 175, 175, 100));
        eggInfo.add(new MonsterModel("Genie", R.drawable.magic, R.drawable.nature, R.drawable.genie_egg, 50, 190, 250, 100));
        eggInfo.add(new MonsterModel("Tyrannoking", R.drawable.dark, R.drawable.light, R.drawable.tyrannoking_egg,50, 230, 175, 100));
        eggInfo.add(new MonsterModel("Turtle", R.drawable.water, R.drawable.thunder, R.drawable.turtle_egg, 56, 200, 200, 100));
        eggInfo.add(new MonsterModel("Rockilla", R.drawable.earth, R.drawable.dark, R.drawable.roquillaegg, 71, 175, 175, 100));
        eggInfo.add(new MonsterModel("Panda", R.drawable.nature, R.drawable.fire, R.drawable.panda_egg, 56, 190, 200, 100));

        final ArrayList<MonsterModel> childInfo = new ArrayList<>();
        childInfo.add(new MonsterModel("Fire Lion", R.drawable.fire, R.drawable.water, R.drawable.firelion, 81, 242, 192, 100 ));
        childInfo.add(new MonsterModel("Thunder Eagle", R.drawable.thunder, R.drawable.earth, R.drawable.thunder_eagle1,81, 192, 275, 100));
        childInfo.add(new MonsterModel("Metalsaur", R.drawable.metal, R.drawable.magic, R.drawable.metalsaur_1, 97, 246, 220, 100));
        childInfo.add(new MonsterModel("Arch Knight", R.drawable.legend, R.drawable.metal, R.drawable.arch_knight_1, 127, 308, 308, 140));
        childInfo.add(new MonsterModel("Light Spirit", R.drawable.light, R.drawable.metal, R.drawable.light_spirit_1, 115, 192, 192, 100));
        childInfo.add(new MonsterModel("Genie", R.drawable.magic, R.drawable.nature, R.drawable.genie_1, 91, 220, 220, 100));
        childInfo.add(new MonsterModel("Tyrannoking", R.drawable.dark, R.drawable.light, R.drawable.tyrannoking_1,81, 253, 192, 100));
        childInfo.add(new MonsterModel("Turtle", R.drawable.water, R.drawable.thunder, R.drawable.turtle_1, 81, 209, 275, 100));
        childInfo.add(new MonsterModel("Rockilla", R.drawable.earth, R.drawable.dark, R.drawable.gorilla1, 115, 192, 192, 100));
        childInfo.add(new MonsterModel("Panda", R.drawable.nature, R.drawable.fire, R.drawable.panda, 91, 209, 220, 100));

        final ArrayList<MonsterModel> juvInfo = new ArrayList<>();
        juvInfo.add(new MonsterModel("Fire Lion", R.drawable.fire, R.drawable.water, R.drawable.firelion2, 104, 308, 244, 100 ));
        juvInfo.add(new MonsterModel("Thunder Eagle", R.drawable.thunder, R.drawable.earth, R.drawable.thunder_eagle_2,104, 244, 350, 100));
        juvInfo.add(new MonsterModel("Metalsaur", R.drawable.metal, R.drawable.magic, R.drawable.metalsaur_2, 124, 313, 280, 100));
        juvInfo.add(new MonsterModel("Arch Knight", R.drawable.legend, R.drawable.metal, R.drawable.arch_knight_2, 162, 392, 392, 140));
        juvInfo.add(new MonsterModel("Light Spirit", R.drawable.light, R.drawable.metal, R.drawable.light_spirit_2, 147, 244, 244, 100));
        juvInfo.add(new MonsterModel("Genie", R.drawable.magic, R.drawable.nature, R.drawable.genie_2, 116, 280, 280, 100));
        juvInfo.add(new MonsterModel("Tyrannoking", R.drawable.dark, R.drawable.light, R.drawable.tyrannoking_2,104, 322, 244, 100));
        juvInfo.add(new MonsterModel("Turtle", R.drawable.water, R.drawable.thunder, R.drawable.turtle_2, 104, 266, 350, 100));
        juvInfo.add(new MonsterModel("Rockilla", R.drawable.earth, R.drawable.dark, R.drawable.gorilla2, 147, 244, 244, 100));
        juvInfo.add(new MonsterModel("Panda", R.drawable.nature, R.drawable.fire, R.drawable.panda_2, 116, 266, 280, 100));

        final ArrayList<MonsterModel> adultInfo = new ArrayList<>();
        adultInfo.add(new MonsterModel("Fire Lion", R.drawable.fire, R.drawable.water, R.drawable.fire_lion3, 153, 374, 297, 100 ));
        adultInfo.add(new MonsterModel("Thunder Eagle", R.drawable.thunder, R.drawable.earth, R.drawable.thunder_eagle_3,153, 297, 425, 100));
        adultInfo.add(new MonsterModel("Metalsaur", R.drawable.metal, R.drawable.magic, R.drawable.metalsaur3, 184, 380, 340, 100));
        adultInfo.add(new MonsterModel("Arch Knight", R.drawable.legend, R.drawable.metal, R.drawable.arch_knight_3, 239, 476, 476, 140));
        adultInfo.add(new MonsterModel("Light Spirit", R.drawable.light, R.drawable.metal, R.drawable.light_spirit_3, 217, 297, 297, 100));
        adultInfo.add(new MonsterModel("Genie", R.drawable.magic, R.drawable.nature, R.drawable.genie_3, 171, 340, 340, 100));
        adultInfo.add(new MonsterModel("Tyrannoking", R.drawable.dark, R.drawable.light, R.drawable.tyrannoking_3,153, 391, 297, 100));
        adultInfo.add(new MonsterModel("Turtle", R.drawable.water, R.drawable.thunder, R.drawable.turtle_3, 153, 323, 425, 100));
        adultInfo.add(new MonsterModel("Rockilla", R.drawable.earth, R.drawable.dark, R.drawable.gorilla3, 217, 297, 297, 100));
        adultInfo.add(new MonsterModel("Panda", R.drawable.nature, R.drawable.fire, R.drawable.panda3, 171, 323, 340, 100));
        //Fin database

        final Intent intent = new Intent(MainActivity.this, MonsterShowActivity.class);
        final ListView listMonsters = findViewById(R.id.liste);
        final ListAdapter adapter = new ListAdapter(this, eggInfo);
        final Spinner filter1 = findViewById(R.id.type_list_1);

        final ArrayList<MonsterModel> filterListEgg = new ArrayList<>();
        final ArrayList<MonsterModel> filterListChild = new ArrayList<>();
        final ArrayList<MonsterModel> filterListJuv = new ArrayList<>();
        final ArrayList<MonsterModel> filterListAdult = new ArrayList<>();



        //Lors de la sélection du filtre
        filter1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Si "Choose an element", afficher liste entière, sinon appeler le filterAdapter
                if (position == 0){
                    listMonsters.setAdapter(adapter);
                    listMonsters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg) {
                            Parcelable eggModel = new MonsterModel(eggInfo.get(position).getName(),
                                    eggInfo.get(position).getType(), eggInfo.get(position).getWeakness(),
                                    eggInfo.get(position).getImage(), eggInfo.get(position).getStatHealth(),
                                    eggInfo.get(position).getStatPower(), eggInfo.get(position).getStatSpeed(),
                                    eggInfo.get(position).getStatStamina());
                            Parcelable juvModel = new MonsterModel(juvInfo.get(position).getName(),juvInfo.get(position).getType(),
                                    juvInfo.get(position).getWeakness(), juvInfo.get(position).getImage(),
                                    juvInfo.get(position).getStatHealth(), juvInfo.get(position).getStatPower(),
                                    juvInfo.get(position).getStatSpeed(), juvInfo.get(position).getStatStamina());
                            Parcelable childModel = new MonsterModel(childInfo.get(position).getName(),childInfo.get(position).getType(),
                                    childInfo.get(position).getWeakness(), childInfo.get(position).getImage(),
                                    childInfo.get(position).getStatHealth(), childInfo.get(position).getStatPower(),
                                    childInfo.get(position).getStatSpeed(), childInfo.get(position).getStatStamina());
                            Parcelable adultModel = new MonsterModel(adultInfo.get(position).getName(),adultInfo.get(position).getType(),
                                    adultInfo.get(position).getWeakness(), adultInfo.get(position).getImage(),
                                    adultInfo.get(position).getStatHealth(), adultInfo.get(position).getStatPower(),
                                    adultInfo.get(position).getStatSpeed(), adultInfo.get(position).getStatStamina());

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

                    /*
                    Pour chaque item, si l'image type correspond à la ressource attendue
                    alors implémenter la vue en cours sur la filterList
                     */
                    for (int i = 0; i < eggInfo.size(); i++) {

                        if (getResources().getResourceEntryName(eggInfo.get(i).getType()).toLowerCase().contains(filter1.getSelectedItem().toString().toLowerCase())) {



                            filterListEgg.clear();
                            filterListChild.clear();
                            filterListJuv.clear();
                            filterListAdult.clear();
                            filterListEgg.add(eggInfo.get(i));
                            filterListChild.add(childInfo.get(i));
                            filterListJuv.add(juvInfo.get(i));
                            filterListAdult.add(adultInfo.get(i));
                        }
                    }

                    listMonsters.setAdapter(filterAdapter);

                    listMonsters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long arg) {
                            Parcelable eggModel = new MonsterModel(filterListEgg.get(i).getName(),
                                    filterListEgg.get(i).getType(), filterListEgg.get(i).getWeakness(),
                                    filterListEgg.get(i).getImage(), filterListEgg.get(i).getStatHealth(),
                                    filterListEgg.get(i).getStatPower(), filterListEgg.get(i).getStatSpeed(),
                                    filterListEgg.get(i).getStatStamina());
                            Parcelable juvModel = new MonsterModel(filterListJuv.get(i).getName(),filterListJuv.get(i).getType(),
                                    filterListJuv.get(i).getWeakness(), filterListJuv.get(i).getImage(),
                                    filterListJuv.get(i).getStatHealth(), filterListJuv.get(i).getStatPower(),
                                    filterListJuv.get(i).getStatSpeed(), filterListJuv.get(i).getStatStamina());
                            Parcelable childModel = new MonsterModel(filterListChild.get(i).getName(),filterListChild.get(i).getType(),
                                    filterListChild.get(i).getWeakness(), filterListChild.get(i).getImage(),
                                    filterListChild.get(i).getStatHealth(), filterListChild.get(i).getStatPower(),
                                    filterListChild.get(i).getStatSpeed(), filterListChild.get(i).getStatStamina());
                            Parcelable adultModel = new MonsterModel(filterListAdult.get(i).getName(),filterListAdult.get(i).getType(),
                                    filterListAdult.get(i).getWeakness(), filterListAdult.get(i).getImage(),
                                    filterListAdult.get(i).getStatHealth(), filterListAdult.get(i).getStatPower(),
                                    filterListAdult.get(i).getStatSpeed(), filterListAdult.get(i).getStatStamina());

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

        });









    }
}

