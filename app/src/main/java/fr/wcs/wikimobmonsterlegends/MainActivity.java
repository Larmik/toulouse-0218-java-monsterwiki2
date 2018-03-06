package fr.wcs.wikimobmonsterlegends;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listMonsters = findViewById(R.id.liste);
        ArrayList<MonsterModel> monsterInfo = new ArrayList<>();

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

        ListAdapter adapter = new ListAdapter(this, monsterInfo);
        listMonsters.setAdapter(adapter);



    }
}