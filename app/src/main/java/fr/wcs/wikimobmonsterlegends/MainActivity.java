package fr.wcs.wikimobmonsterlegends;


import android.content.ContentValues;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

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
                R.drawable.eggeagle, //TODO metal
                R.drawable.arch_knight_egg,
                R.drawable.light_spirit_egg,
                R.drawable.genie_egg,
                R.drawable.tyrannoking_egg ,
                R.drawable.turtle_egg ,
                R.drawable.roquillaegg ,
                R.drawable.panda_egg };


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

        // Création intent/extra pour envoi de données et implémentation onClick des items
        listMonsters.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg) {

                Intent intent = new Intent(MainActivity.this, MonsterShowActivity.class);
                intent.putExtra("name", names[position]);
                intent.putExtra("type", types[position]);
                intent.putExtra("picture", picturesEgg[position]);
                intent.putExtra("weakness", weakness[position]);
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



