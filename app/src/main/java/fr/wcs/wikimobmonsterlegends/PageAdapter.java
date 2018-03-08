package fr.wcs.wikimobmonsterlegends;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PageAdapter extends ArrayAdapter<MonsterPage> {

    private Context context;
    private List<MonsterPage> datas;

    public PageAdapter (Context context, int resource, ArrayList<MonsterPage> monsters) {
        super(context, resource, monsters);
        this.context = context;
        this.datas = monsters;
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        MonsterPage monster = datas.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_monster_show, parent, false);
        }

        TextView monsterName = convertView.findViewById(R.id.monster_name);
        TextView healthStat = convertView.findViewById(R.id.stat_health);
        TextView powerStat = convertView.findViewById(R.id.stat_power);
        TextView speedStat = convertView.findViewById(R.id.stat_speed);
        TextView staminaStat = convertView.findViewById(R.id.stat_stamina);

        ImageView monsterImage = convertView.findViewById(R.id.monster_picture);
        ImageView typeImage = convertView.findViewById(R.id.type_picture);

        monsterName.setText(monster.getMonsterName());
        healthStat.setText(monster.getHealth());
        powerStat.setText(monster.getPower());
        speedStat.setText(monster.getSpeed());
        staminaStat.setText(monster.getStamina());
        monsterImage.setImageResource(monster.getMonsterImage());
        typeImage.setImageResource(monster.getTypeImage());

        return convertView;

    }
}
