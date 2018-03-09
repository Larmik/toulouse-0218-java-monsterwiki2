package fr.wcs.wikimobmonsterlegends;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
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
        final String[] names = {"Fire Lion", "Thunder Eagle", "Metalsaur", "Arch Knight", "Light Spirit", "Genie", "Tyrannoking", "Turtle", "Rockilla", "Panda"};
        final int[] types = {R.drawable.fire,R.drawable.thunder,R.drawable.metal,R.drawable.legend,R.drawable.light,R.drawable.magic,R.drawable.dark,R.drawable.water,R.drawable.earth,R.drawable.nature};
        final int[] pictures = {R.drawable.firelion0,R.drawable.thunder_eagle_0,R.drawable.metalsaur_0,R.drawable.arch_knight_0,R.drawable.light_spirit_0,R.drawable.genie_0,R.drawable.tyrannoking_0,R.drawable.turtle_0,R.drawable.rockilla_0,R.drawable.panda_0};
        final int[] weakness = {R.drawable.water,R.drawable.earth,R.drawable.magic,R.drawable.metal,R.drawable.metal,R.drawable.nature,R.drawable.light,R.drawable.thunder,R.drawable.dark,R.drawable.fire};

        // Création intent/extra pour envoi de données et implémentation onClick des items
        listMonsters.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg) {
                Intent intent = new Intent(MainActivity.this, MonsterShowActivity.class);
                intent.putExtra("name", names[position]);
                intent.putExtra("type", types[position]);
                intent.putExtra("picture", pictures[position]);
                intent.putExtra("weakness", weakness[position]);
                MainActivity.this.startActivity(intent);
            }
        });

    }
}

