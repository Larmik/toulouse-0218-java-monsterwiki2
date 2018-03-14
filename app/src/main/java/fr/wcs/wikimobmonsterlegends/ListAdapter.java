package fr.wcs.wikimobmonsterlegends;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<MonsterModel> {

    ListAdapter(Context context, ArrayList<MonsterModel> monsters) {
        super(context, 0, monsters);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        MonsterModel monster = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list, parent, false);
        }

        TextView monsterName = convertView.findViewById(R.id.monster_name);
        ImageView monsterImage = convertView.findViewById(R.id.monster_picture);

        monsterName.setText(monster.getName());
        monsterImage.setImageResource(monster.getType());

        return convertView;

    }
}
