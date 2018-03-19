package fr.wcs.wikimobmonsterlegends;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
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
        final ArrayList<MonsterModel> eggInfo = getEggInfos();
        final ArrayList<MonsterModel> childInfo = getChildInfos();
        final ArrayList<MonsterModel> juvInfo = getJuvInfos();
        final ArrayList<MonsterModel> adultInfo = getAdultInfos();

        final Intent intent = new Intent(MainActivity.this, MonsterShowActivity.class);
        final ListView listMonsters = findViewById(R.id.liste);
        final ListAdapter adapter = new ListAdapter(this, eggInfo);
        final Spinner filter1 = findViewById(R.id.type_list_1);
        final Spinner filter2 = findViewById(R.id.type_list_2);
        final ArrayList<MonsterModel> filterListEgg = new ArrayList<>();
        final ArrayList<MonsterModel> filterListChild = new ArrayList<>();
        final ArrayList<MonsterModel> filterListJuv = new ArrayList<>();
        final ArrayList<MonsterModel> filterListAdult = new ArrayList<>();
        final ArrayList<MonsterModel> filterListEgg2 = new ArrayList<>();
        final ArrayList<MonsterModel> filterListChild2 = new ArrayList<>();
        final ArrayList<MonsterModel> filterListJuv2 = new ArrayList<>();
        final ArrayList<MonsterModel> filterListAdult2 = new ArrayList<>();
        final ListAdapter filterAdapter = new ListAdapter(MainActivity.this, filterListEgg);
        final ListAdapter filterAdapter2 = new ListAdapter(MainActivity.this, filterListEgg2);
        //Fin database


        filter1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                if (position == 0) {
                    filter2.setVisibility(View.GONE);
                    listMonsters.setAdapter(adapter);
                    listMonsters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long arg) {
                            Parcelable eggModel = new MonsterModel(eggInfo.get(i).getName(),
                                    eggInfo.get(i).getType(), eggInfo.get(i).getType2(),
                                    eggInfo.get(i).getWeakness(), eggInfo.get(i).getWeakness2(),
                                    eggInfo.get(i).getImage(), eggInfo.get(i).getStatHealth(),
                                    eggInfo.get(i).getStatPower(), eggInfo.get(i).getStatSpeed(),
                                    eggInfo.get(i).getStatStamina());
                            Parcelable juvModel = new MonsterModel(juvInfo.get(i).getName(),
                                    juvInfo.get(i).getType(), juvInfo.get(i).getType2(),
                                    juvInfo.get(i).getWeakness(), juvInfo.get(i).getWeakness2(),
                                    juvInfo.get(i).getImage(), juvInfo.get(i).getStatHealth(),
                                    juvInfo.get(i).getStatPower(), juvInfo.get(i).getStatSpeed(),
                                    juvInfo.get(i).getStatStamina());
                            Parcelable childModel = new MonsterModel(childInfo.get(i).getName(),
                                    childInfo.get(i).getType(), childInfo.get(i).getType2(),
                                    childInfo.get(i).getWeakness(), childInfo.get(i).getWeakness2(),
                                    childInfo.get(i).getImage(), childInfo.get(i).getStatHealth(),
                                    childInfo.get(i).getStatPower(), childInfo.get(i).getStatSpeed(),
                                    childInfo.get(i).getStatStamina());
                            Parcelable adultModel = new MonsterModel(adultInfo.get(i).getName(),
                                    adultInfo.get(i).getType(), adultInfo.get(i).getType2(),
                                    adultInfo.get(i).getWeakness(), adultInfo.get(i).getWeakness2(),
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

                } else {
                    filter2.setVisibility(View.VISIBLE);
                    filter2.setSelection(0);
                    filterListEgg.clear();
                    filterListChild.clear();
                    filterListJuv.clear();
                    filterListAdult.clear();
                    for (int i = 0; i < eggInfo.size(); i++) {
                        if (getResources().getResourceEntryName(eggInfo.get(i).getType()).toLowerCase()
                                .contains(filter1.getSelectedItem().toString().toLowerCase()) ||
                                getResources().getResourceEntryName(eggInfo.get(i).getType2()).toLowerCase()
                                        .contains(filter1.getSelectedItem().toString().toLowerCase())) {
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
                                    filterListEgg.get(i).getType(), filterListEgg.get(i).getType2(),
                                    filterListEgg.get(i).getWeakness(), filterListEgg.get(i).getWeakness2(),
                                    filterListEgg.get(i).getImage(), filterListEgg.get(i).getStatHealth(),
                                    filterListEgg.get(i).getStatPower(), filterListEgg.get(i).getStatSpeed(),
                                    filterListEgg.get(i).getStatStamina());
                            Parcelable juvModel = new MonsterModel(filterListJuv.get(i).getName(),
                                    filterListJuv.get(i).getType(), filterListJuv.get(i).getType2(),
                                    filterListJuv.get(i).getWeakness(), filterListJuv.get(i).getWeakness2(),
                                    filterListJuv.get(i).getImage(), filterListJuv.get(i).getStatHealth(),
                                    filterListJuv.get(i).getStatPower(), filterListJuv.get(i).getStatSpeed(),
                                    filterListJuv.get(i).getStatStamina());
                            Parcelable childModel = new MonsterModel(filterListChild.get(i).getName(),
                                    filterListChild.get(i).getType(), filterListChild.get(i).getType2(),
                                    filterListChild.get(i).getWeakness(), filterListChild.get(i).getWeakness2(),
                                    filterListChild.get(i).getImage(), filterListChild.get(i).getStatHealth(),
                                    filterListChild.get(i).getStatPower(), filterListChild.get(i).getStatSpeed(),
                                    filterListChild.get(i).getStatStamina());
                            Parcelable adultModel = new MonsterModel(filterListAdult.get(i).getName(),
                                    filterListAdult.get(i).getType(), filterListAdult.get(i).getType2(),
                                    filterListAdult.get(i).getWeakness(), filterListAdult.get(i).getWeakness2(),
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
        });

        filter2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, final int position, long l) {
                if (position == 0) {
                    listMonsters.setAdapter(filterAdapter);
                    listMonsters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long arg) {
                            Parcelable eggModel = new MonsterModel(filterListEgg.get(i).getName(),
                                    filterListEgg.get(i).getType(), filterListEgg.get(i).getType2(),
                                    filterListEgg.get(i).getWeakness(), filterListEgg.get(i).getWeakness2(),
                                    filterListEgg.get(i).getImage(), filterListEgg.get(i).getStatHealth(),
                                    filterListEgg.get(i).getStatPower(), filterListEgg.get(i).getStatSpeed(),
                                    filterListEgg.get(i).getStatStamina());
                            Parcelable juvModel = new MonsterModel(filterListJuv.get(i).getName(),
                                    filterListJuv.get(i).getType(), filterListJuv.get(i).getType2(),
                                    filterListJuv.get(i).getWeakness(), filterListJuv.get(i).getWeakness2(),
                                    filterListJuv.get(i).getImage(), filterListJuv.get(i).getStatHealth(),
                                    filterListJuv.get(i).getStatPower(), filterListJuv.get(i).getStatSpeed(),
                                    filterListJuv.get(i).getStatStamina());
                            Parcelable childModel = new MonsterModel(filterListChild.get(i).getName(),
                                    filterListChild.get(i).getType(), filterListChild.get(i).getType2(),
                                    filterListChild.get(i).getWeakness(), filterListChild.get(i).getWeakness2(),
                                    filterListChild.get(i).getImage(), filterListChild.get(i).getStatHealth(),
                                    filterListChild.get(i).getStatPower(), filterListChild.get(i).getStatSpeed(),
                                    filterListChild.get(i).getStatStamina());
                            Parcelable adultModel = new MonsterModel(filterListAdult.get(i).getName(),
                                    filterListAdult.get(i).getType(), filterListAdult.get(i).getType2(),
                                    filterListAdult.get(i).getWeakness(), filterListAdult.get(i).getWeakness2(),
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
                } else {
                    filterListEgg2.clear();
                    filterListChild2.clear();
                    filterListJuv2.clear();
                    filterListAdult2.clear();
                    for (int i = 0; i < filterListEgg.size(); i++) {
                        if (getResources().getResourceEntryName(filterListEgg.get(i).getType()).
                                toLowerCase().contains(filter2.getSelectedItem().toString().toLowerCase()) ||
                                getResources().getResourceEntryName(filterListEgg.get(i).getType2()).
                                        toLowerCase().contains(filter2.getSelectedItem().toString().toLowerCase())) {
                            filterListEgg2.add(filterListEgg.get(i));
                            filterListChild2.add(filterListChild.get(i));
                            filterListJuv2.add(filterListJuv.get(i));
                            filterListAdult2.add(filterListAdult.get(i));
                        }
                    }
                    listMonsters.setAdapter(filterAdapter2);
                    listMonsters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long arg) {
                            Parcelable eggModel = new MonsterModel(filterListEgg2.get(i).getName(),
                                    filterListEgg2.get(i).getType(), filterListEgg2.get(i).getType2(),
                                    filterListEgg2.get(i).getWeakness(), filterListEgg2.get(i).getWeakness2(),
                                    filterListEgg2.get(i).getImage(), filterListEgg2.get(i).getStatHealth(),
                                    filterListEgg2.get(i).getStatPower(), filterListEgg2.get(i).getStatSpeed(),
                                    filterListEgg2.get(i).getStatStamina());
                            Parcelable juvModel = new MonsterModel(filterListJuv2.get(i).getName(),
                                    filterListJuv2.get(i).getType(), filterListJuv2.get(i).getType2(),
                                    filterListJuv2.get(i).getWeakness(), filterListJuv2.get(i).getWeakness2(),
                                    filterListJuv2.get(i).getImage(), filterListJuv2.get(i).getStatHealth(),
                                    filterListJuv2.get(i).getStatPower(), filterListJuv2.get(i).getStatSpeed(),
                                    filterListJuv2.get(i).getStatStamina());
                            Parcelable childModel = new MonsterModel(filterListChild2.get(i).getName(),
                                    filterListChild2.get(i).getType(), filterListChild2.get(i).getType2(),
                                    filterListChild2.get(i).getWeakness(), filterListChild2.get(i).getWeakness2(),
                                    filterListChild2.get(i).getImage(), filterListChild2.get(i).getStatHealth(),
                                    filterListChild2.get(i).getStatPower(), filterListChild2.get(i).getStatSpeed(),
                                    filterListChild2.get(i).getStatStamina());
                            Parcelable adultModel = new MonsterModel(filterListAdult2.get(i).getName(),
                                    filterListAdult2.get(i).getType(), filterListAdult2.get(i).getType2(),
                                    filterListAdult2.get(i).getWeakness(), filterListAdult2.get(i).getWeakness2(),
                                    filterListAdult2.get(i).getImage(), filterListAdult2.get(i).getStatHealth(),
                                    filterListAdult2.get(i).getStatPower(), filterListAdult2.get(i).getStatSpeed(),
                                    filterListAdult2.get(i).getStatStamina());
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

    private ArrayList<MonsterModel> getEggInfos() {
        ArrayList<MonsterModel> eggInfo = new ArrayList<>();
        eggInfo.add(new MonsterModel("Fire Lion", R.drawable.fire, R.color.white, R.drawable.water, R.color.white, R.drawable.fire_lion_egg, 50, 220, 175, 100));
        eggInfo.add(new MonsterModel("Thunder Eagle", R.drawable.thunder, R.color.white, R.drawable.earth, R.color.white, R.drawable.eggeagle, 50, 175, 250, 100));
        eggInfo.add(new MonsterModel("Metalsaur", R.drawable.metal, R.color.white, R.drawable.magic, R.color.white, R.drawable.metalsaur_huevo, 60, 224, 220, 100));
        eggInfo.add(new MonsterModel("Arch Knight", R.drawable.legend, R.color.white, R.drawable.metal, R.color.white, R.drawable.arch_knight_egg, 56, 200, 200, 140));
        eggInfo.add(new MonsterModel("Light Spirit", R.drawable.light, R.color.white, R.drawable.metal, R.color.white, R.drawable.light_spirit_egg, 71, 175, 175, 100));
        eggInfo.add(new MonsterModel("Genie", R.drawable.magic, R.color.white, R.drawable.nature, R.color.white, R.drawable.genie_egg, 50, 190, 250, 100));
        eggInfo.add(new MonsterModel("Tyrannoking", R.drawable.dark, R.color.white, R.drawable.light, R.color.white, R.drawable.tyrannoking_egg, 50, 230, 175, 100));
        eggInfo.add(new MonsterModel("Turtle", R.drawable.water, R.color.white, R.drawable.thunder, R.color.white, R.drawable.turtle_egg, 56, 200, 200, 100));
        eggInfo.add(new MonsterModel("Rockilla", R.drawable.earth, R.color.white, R.drawable.dark, R.color.white, R.drawable.roquillaegg, 71, 175, 175, 100));
        eggInfo.add(new MonsterModel("Panda", R.drawable.nature, R.color.white, R.drawable.fire, R.color.white, R.drawable.panda_egg, 56, 190, 200, 100));
        eggInfo.add(new MonsterModel("Blesstle", R.drawable.water, R.drawable.light, R.drawable.thunder, R.drawable.metal, R.drawable.blesstle_egg, 63, 185, 190, 110));
        eggInfo.add(new MonsterModel("Firekong", R.drawable.fire, R.drawable.earth, R.drawable.water, R.drawable.dark, R.drawable.firekong_egg, 63, 230, 160, 110));
        eggInfo.add(new MonsterModel("Firanda", R.drawable.fire, R.drawable.nature, R.drawable.water, R.color.white, R.drawable.firanda_egg, 50, 225, 200, 110));
        eggInfo.add(new MonsterModel("Electrex", R.drawable.earth, R.drawable.thunder, R.drawable.dark, R.color.white, R.drawable.electrex_egg, 63, 170, 225, 110));
        eggInfo.add(new MonsterModel("Gigram", R.drawable.fire, R.drawable.thunder, R.drawable.water, R.drawable.earth, R.drawable.gigram_egg, 42, 225, 225, 110));
        eggInfo.add(new MonsterModel("Gigarast", R.drawable.dark, R.drawable.water, R.drawable.light, R.drawable.nature, R.drawable.giragast_eggb, 63, 223, 160, 110));
        eggInfo.add(new MonsterModel("Light Sphinx", R.drawable.earth, R.drawable.light, R.drawable.dark, R.drawable.metal, R.drawable.light_sphinx_egg, 77, 175, 160, 110));
        eggInfo.add(new MonsterModel("Obsidia", R.drawable.earth, R.drawable.dark, R.drawable.light, R.color.white, R.drawable.obsidia_egg, 56, 200, 200, 110));
        eggInfo.add(new MonsterModel("Succuba", R.drawable.dark, R.drawable.light, R.drawable.metal, R.color.white, R.drawable.succuba_egg, 63, 225, 160, 110));
        eggInfo.add(new MonsterModel("Sheluke", R.drawable.nature, R.drawable.water, R.drawable.fire, R.drawable.thunder, R.drawable.sheluke_egg, 56, 200, 200, 110));
        eggInfo.add(new MonsterModel("Terror Dactyl", R.drawable.thunder, R.drawable.dark, R.drawable.earth, R.drawable.light, R.drawable.terror_dactyl_egg, 42, 225, 225, 110));
        eggInfo.add(new MonsterModel("Vixsun", R.drawable.nature, R.drawable.light, R.drawable.fire, R.drawable.metal, R.drawable.vixsun_egg, 63, 200, 175, 110));
        eggInfo.add(new MonsterModel("Sealion", R.drawable.fire, R.drawable.water, R.drawable.thunder, R.color.white, R.drawable.sealion_huevo, 50, 225, 200, 110));
        eggInfo.add(new MonsterModel("Gastosquish", R.drawable.earth, R.drawable.water, R.drawable.dark, R.drawable.thunder, R.drawable.gastosquish_huevo, 63, 175, 200, 110));
        eggInfo.add(new MonsterModel("Shock Turtle", R.drawable.thunder, R.drawable.water, R.drawable.earth, R.color.white, R.drawable.shock_turtle_huevo, 50, 200, 225, 110));
        eggInfo.add(new MonsterModel("Dolphchamp", R.drawable.water, R.drawable.magic, R.drawable.thunder, R.drawable.nature, R.drawable.dolphchamp_huevo, 56, 175, 225, 110));
        eggInfo.add(new MonsterModel("Rarawr", R.drawable.nature, R.drawable.earth, R.drawable.fire, R.drawable.dark, R.drawable.rarawr_huevo, 63, 175, 200, 110));
        eggInfo.add(new MonsterModel("Pelitwirl", R.drawable.thunder, R.drawable.light, R.drawable.earth, R.drawable.metal, R.drawable.pelitwirl_huevo, 63, 170, 225, 110));
        eggInfo.add(new MonsterModel("Raydex", R.drawable.thunder, R.drawable.magic, R.drawable.earth, R.drawable.nature, R.drawable.raydex_huevo, 42, 175, 275, 110));
        eggInfo.add(new MonsterModel("Flickie", R.drawable.fire, R.drawable.dark, R.drawable.water, R.drawable.light, R.drawable.flickie_huevo, 42, 250, 175, 110));
        eggInfo.add(new MonsterModel("Utochomp", R.drawable.nature, R.drawable.dark, R.drawable.fire, R.drawable.light, R.drawable.utochomp_huevo, 56, 220, 180, 110));
        eggInfo.add(new MonsterModel("Bloomskips", R.drawable.nature, R.drawable.magic, R.drawable.fire, R.color.white, R.drawable.bloomskips_huevo, 56, 174, 226, 110));
        eggInfo.add(new MonsterModel("Greenasaur", R.drawable.fire, R.drawable.nature, R.drawable.thunder, R.drawable.metal, R.drawable.greenasaur_huevo, 50, 225, 200, 110));
        eggInfo.add(new MonsterModel("Esmelter", R.drawable.metal, R.drawable.fire, R.drawable.magic, R.drawable.water, R.drawable.esmelter_huevo, 54, 190, 205, 110));
        eggInfo.add(new MonsterModel("Jonskeer", R.drawable.metal, R.drawable.nature, R.drawable.magic, R.drawable.fire, R.drawable.jonskeer_huevo, 61, 210, 200, 110));
        eggInfo.add(new MonsterModel("Omethyst", R.drawable.metal, R.drawable.dark, R.drawable.magic, R.drawable.light, R.drawable.omethyst_huevo, 66, 190, 195, 110));
        eggInfo.add(new MonsterModel("Rockneto", R.drawable.metal, R.drawable.earth, R.drawable.magic, R.drawable.dark, R.drawable.rockneto_huevo, 64, 175, 205, 110));
        eggInfo.add(new MonsterModel("Metanephrops", R.drawable.metal, R.drawable.water, R.drawable.magic, R.drawable.thunder, R.drawable.metanephrops_huevo, 65, 224, 200, 110));
        eggInfo.add(new MonsterModel("Lesaki", R.drawable.metal, R.drawable.thunder, R.drawable.magic, R.drawable.earth, R.drawable.lesaki_huevo, 51, 235, 224, 110));
        eggInfo.add(new MonsterModel("Heimdal", R.drawable.metal, R.drawable.light, R.drawable.magic, R.color.white, R.drawable.heimdal_huevo, 64, 200, 204, 110));
        eggInfo.add(new MonsterModel("Pyrook", R.drawable.fire, R.drawable.magic, R.drawable.water, R.drawable.nature, R.drawable.pyrook_huevo, 41, 225, 228, 110));
        eggInfo.add(new MonsterModel("Manolyth", R.drawable.metal, R.drawable.magic, R.drawable.nature, R.color.white, R.drawable.manolyth_huevo, 51, 234, 200, 110));
        eggInfo.add(new MonsterModel("Vadamagma", R.drawable.legend, R.drawable.fire, R.drawable.water, R.color.white, R.drawable.vadamagma_huevo, 59, 215, 199, 140));
        eggInfo.add(new MonsterModel("Nebotus", R.drawable.legend, R.drawable.dark, R.drawable.light, R.color.white, R.drawable.nebotus_huevo, 59, 190, 210, 140));
        eggInfo.add(new MonsterModel("Lord of Atlantis", R.drawable.legend, R.drawable.water, R.drawable.thunder, R.color.white, R.drawable.lord_of_atlantis_huevo, 63, 190, 220, 140));
        eggInfo.add(new MonsterModel("Nemestrinus", R.drawable.legend, R.drawable.nature, R.drawable.fire, R.color.white, R.drawable.nemestrinus_huevo, 70, 187, 220, 140));
        eggInfo.add(new MonsterModel("Tempest", R.drawable.legend, R.drawable.thunder, R.drawable.earth, R.color.white, R.drawable.tempest_huevo, 226, 70, 225, 140));
        eggInfo.add(new MonsterModel("Super Tomato", R.drawable.legend, R.drawable.magic, R.drawable.nature, R.color.white, R.drawable.super_tomato_huevo, 57, 208, 225, 140));
        eggInfo.add(new MonsterModel("Cloud", R.drawable.legend, R.drawable.light, R.drawable.metal, R.color.white, R.drawable.cloud_huevo, 87, 224, 210, 140));

        return eggInfo;
    }

    private ArrayList<MonsterModel> getChildInfos() {
        final ArrayList<MonsterModel> childInfo = new ArrayList<>();
        childInfo.add(new MonsterModel("Fire Lion", R.drawable.fire, R.color.white, R.drawable.water, R.color.white, R.drawable.firelion, 81, 242, 192, 100));
        childInfo.add(new MonsterModel("Thunder Eagle", R.drawable.thunder, R.color.white, R.drawable.earth, R.color.white, R.drawable.thunder_eagle1, 81, 192, 275, 100));
        childInfo.add(new MonsterModel("Metalsaur", R.drawable.metal, R.color.white, R.drawable.magic, R.color.white, R.drawable.metalsaur_1, 97, 246, 220, 100));
        childInfo.add(new MonsterModel("Arch Knight", R.drawable.legend, R.color.white, R.drawable.metal, R.color.white, R.drawable.arch_knight_1, 127, 308, 308, 140));
        childInfo.add(new MonsterModel("Light Spirit", R.drawable.light, R.color.white, R.drawable.metal, R.color.white, R.drawable.light_spirit_1, 115, 192, 192, 100));
        childInfo.add(new MonsterModel("Genie", R.drawable.magic, R.color.white, R.drawable.nature, R.color.white, R.drawable.genie_1, 91, 220, 220, 100));
        childInfo.add(new MonsterModel("Tyrannoking", R.drawable.dark, R.color.white, R.drawable.light, R.color.white, R.drawable.tyrannoking_1, 81, 253, 192, 100));
        childInfo.add(new MonsterModel("Turtle", R.drawable.water, R.color.white, R.drawable.thunder, R.color.white, R.drawable.turtle_1, 81, 209, 275, 100));
        childInfo.add(new MonsterModel("Rockilla", R.drawable.earth, R.color.white, R.drawable.dark, R.color.white, R.drawable.gorilla1, 115, 192, 192, 100));
        childInfo.add(new MonsterModel("Panda", R.drawable.nature, R.color.white, R.drawable.fire, R.color.white, R.drawable.panda, 91, 209, 220, 100));
        childInfo.add(new MonsterModel("Blesstle", R.drawable.water, R.drawable.light, R.drawable.thunder, R.drawable.metal, R.drawable.blesstle_1b, 112, 224, 229, 110));
        childInfo.add(new MonsterModel("Firekong", R.drawable.fire, R.drawable.earth, R.drawable.water, R.drawable.dark, R.drawable.firekong_1, 112, 278, 193, 110));
        childInfo.add(new MonsterModel("Firanda", R.drawable.fire, R.drawable.nature, R.drawable.water, R.color.white, R.drawable.firanda_fase1, 89, 272, 242, 110));
        childInfo.add(new MonsterModel("Electrex", R.drawable.earth, R.drawable.thunder, R.drawable.dark, R.color.white, R.drawable.electrex_1, 112, 205, 272, 110));
        childInfo.add(new MonsterModel("Gigram", R.drawable.fire, R.drawable.thunder, R.drawable.water, R.drawable.earth, R.drawable.gigram_1, 74, 272, 272, 110));
        childInfo.add(new MonsterModel("Giragast", R.drawable.dark, R.drawable.magic, R.drawable.light, R.drawable.nature, R.drawable.giragast_1, 112, 269, 193, 110));
        childInfo.add(new MonsterModel("Light Sphinx", R.drawable.earth, R.drawable.light, R.drawable.dark, R.drawable.metal, R.drawable.light_sphinx_1, 138, 212, 193, 110));
        childInfo.add(new MonsterModel("Obsidia", R.drawable.earth, R.drawable.dark, R.drawable.light, R.color.white, R.drawable.obsidia_1, 101, 242, 242, 110));
        childInfo.add(new MonsterModel("Succuba", R.drawable.dark, R.drawable.light, R.drawable.metal, R.color.white, R.drawable.succuba_1b, 112, 272, 193, 110));
        childInfo.add(new MonsterModel("Sheluke", R.drawable.nature, R.drawable.water, R.drawable.fire, R.drawable.thunder, R.drawable.sheluke_1, 101, 242, 242, 110));
        childInfo.add(new MonsterModel("Terror Dactyl", R.drawable.thunder, R.drawable.dark, R.drawable.earth, R.drawable.light, R.drawable.terror_dactyl_1, 74, 272, 272, 110));
        childInfo.add(new MonsterModel("Vixsun", R.drawable.nature, R.drawable.light, R.drawable.fire, R.drawable.metal, R.drawable.vixsun_1b, 112, 242, 212, 110));
        childInfo.add(new MonsterModel("Sealion", R.drawable.fire, R.drawable.water, R.drawable.thunder, R.color.white, R.drawable.sealion_fase1, 89, 272, 242, 110));
        childInfo.add(new MonsterModel("Gastosquish", R.drawable.earth, R.drawable.water, R.drawable.dark, R.drawable.thunder, R.drawable.gastosquish_fase1, 112, 212, 242, 110));
        childInfo.add(new MonsterModel("Shock Turtle", R.drawable.thunder, R.drawable.water, R.drawable.earth, R.color.white, R.drawable.shock_turtle_fase1, 89, 242, 272, 110));
        childInfo.add(new MonsterModel("Dolphchamp", R.drawable.water, R.drawable.magic, R.drawable.thunder, R.drawable.nature, R.drawable.dolphchamp_fase1, 101, 212, 272, 110));
        childInfo.add(new MonsterModel("Rarawr", R.drawable.nature, R.drawable.earth, R.drawable.fire, R.drawable.dark, R.drawable.rarawr_fase1, 112, 212, 242, 110));
        childInfo.add(new MonsterModel("Pelitwirl", R.drawable.thunder, R.drawable.light, R.drawable.earth, R.drawable.metal, R.drawable.pelitwirl_fase1, 112, 205, 272, 110));
        childInfo.add(new MonsterModel("Raydex", R.drawable.thunder, R.drawable.magic, R.drawable.earth, R.drawable.nature, R.drawable.raydex_fase1, 74, 212, 333, 110));
        childInfo.add(new MonsterModel("Flickie", R.drawable.fire, R.drawable.dark, R.drawable.water, R.drawable.light, R.drawable.flickie_fase1, 74, 302, 212, 110));
        childInfo.add(new MonsterModel("Utochomp", R.drawable.nature, R.drawable.dark, R.drawable.fire, R.drawable.light, R.drawable.utochomp_fase1, 101, 266, 217, 110));
        childInfo.add(new MonsterModel("Bloomskips", R.drawable.nature, R.drawable.magic, R.drawable.fire, R.color.white, R.drawable.bloomskips_fase1, 101, 210, 273, 110));
        childInfo.add(new MonsterModel("Greenasaur", R.drawable.fire, R.drawable.nature, R.drawable.thunder, R.drawable.metal, R.drawable.greenasaur_fase1, 89, 272, 242, 110));
        childInfo.add(new MonsterModel("Esmelter", R.drawable.metal, R.drawable.fire, R.drawable.magic, R.drawable.water, R.drawable.esmelter_fase1, 96, 229, 248, 110));
        childInfo.add(new MonsterModel("Jonskeer", R.drawable.metal, R.drawable.nature, R.drawable.magic, R.drawable.fire, R.drawable.jonskeer_fase1, 109, 254, 242, 110));
        childInfo.add(new MonsterModel("Omethyst", R.drawable.metal, R.drawable.dark, R.drawable.magic, R.drawable.light, R.drawable.omethyst_fase1, 118, 229, 236, 110));
        childInfo.add(new MonsterModel("Rockneto", R.drawable.metal, R.drawable.earth, R.drawable.magic, R.drawable.dark, R.drawable.rockneto_fase1, 114, 212, 248, 110));
        childInfo.add(new MonsterModel("Metanephrops", R.drawable.metal, R.drawable.water, R.drawable.magic, R.drawable.thunder, R.drawable.metanephrops_fase1, 117, 270, 242, 110));
        childInfo.add(new MonsterModel("Lesaki", R.drawable.metal, R.drawable.thunder, R.drawable.magic, R.drawable.earth, R.drawable.lesaki_fase1, 91, 284, 270, 110));
        childInfo.add(new MonsterModel("Heimdal", R.drawable.metal, R.drawable.light, R.drawable.magic, R.color.white, R.drawable.heimdal_fase1, 114, 242, 246, 110));
        childInfo.add(new MonsterModel("Pyrook", R.drawable.fire, R.drawable.magic, R.drawable.water, R.drawable.nature, R.drawable.pyrook_fase1, 73, 272, 276, 110));
        childInfo.add(new MonsterModel("Manolyth", R.drawable.metal, R.drawable.magic, R.drawable.nature, R.color.white, R.drawable.manolyth_fase1, 91, 282, 242, 110));
        childInfo.add(new MonsterModel("Vadamagma", R.drawable.legend, R.drawable.fire, R.drawable.water, R.color.white, R.drawable.vadamagma_fase1, 135, 331, 306, 140));
        childInfo.add(new MonsterModel("Nebotus", R.drawable.legend, R.drawable.dark, R.drawable.light, R.color.white, R.drawable.nebotus_fase1, 135, 292, 323, 140));
        childInfo.add(new MonsterModel("Lord of Atlantis", R.drawable.legend, R.drawable.water, R.drawable.thunder, R.color.white, R.drawable.lord_of_atlantis_fase1, 143, 292, 338, 140));
        childInfo.add(new MonsterModel("Nemestrinus", R.drawable.legend, R.drawable.nature, R.drawable.fire, R.color.white, R.drawable.nemestrinus_fase1, 159, 288, 338, 140));
        childInfo.add(new MonsterModel("Tempest", R.drawable.legend, R.drawable.thunder, R.drawable.earth, R.color.white, R.drawable.tempest_fase1, 159, 347, 346, 140));
        childInfo.add(new MonsterModel("Super Tomato", R.drawable.legend, R.drawable.magic, R.drawable.nature, R.color.white, R.drawable.super_tomato_fase1, 130, 320, 346, 140));
        childInfo.add(new MonsterModel("Cloud", R.drawable.legend, R.drawable.light, R.drawable.metal, R.color.white, R.drawable.cloud_fase1, 198, 345, 323, 140));

        return childInfo;
    }

    private ArrayList<MonsterModel> getJuvInfos() {
        final ArrayList<MonsterModel> juvInfo = new ArrayList<>();
        juvInfo.add(new MonsterModel("Fire Lion", R.drawable.fire, R.color.white, R.drawable.water, R.color.white, R.drawable.firelion2, 104, 308, 244, 100));
        juvInfo.add(new MonsterModel("Thunder Eagle", R.drawable.thunder, R.color.white, R.drawable.earth, R.color.white, R.drawable.thunder_eagle_2, 104, 244, 350, 100));
        juvInfo.add(new MonsterModel("Metalsaur", R.drawable.metal, R.color.white, R.drawable.magic, R.color.white, R.drawable.metalsaur_2, 124, 313, 280, 100));
        juvInfo.add(new MonsterModel("Arch Knight", R.drawable.legend, R.color.white, R.drawable.metal, R.color.white, R.drawable.arch_knight_2, 162, 392, 392, 140));
        juvInfo.add(new MonsterModel("Light Spirit", R.drawable.light, R.color.white, R.drawable.metal, R.color.white, R.drawable.light_spirit_2, 147, 244, 244, 100));
        juvInfo.add(new MonsterModel("Genie", R.drawable.magic, R.color.white, R.drawable.nature, R.color.white, R.drawable.genie_2, 116, 280, 280, 100));
        juvInfo.add(new MonsterModel("Tyrannoking", R.drawable.dark, R.color.white, R.drawable.light, R.color.white, R.drawable.tyrannoking_2, 104, 322, 244, 100));
        juvInfo.add(new MonsterModel("Turtle", R.drawable.water, R.color.white, R.drawable.thunder, R.color.white, R.drawable.turtle_2, 104, 266, 350, 100));
        juvInfo.add(new MonsterModel("Rockilla", R.drawable.earth, R.color.white, R.drawable.dark, R.color.white, R.drawable.gorilla2, 147, 244, 244, 100));
        juvInfo.add(new MonsterModel("Panda", R.drawable.nature, R.color.white, R.drawable.fire, R.color.white, R.drawable.panda_2, 116, 266, 280, 100));
        juvInfo.add(new MonsterModel("Blesstle", R.drawable.water, R.drawable.light, R.drawable.thunder, R.drawable.metal, R.drawable.blesstle_2b, 143, 285, 292, 110));
        juvInfo.add(new MonsterModel("Firekong", R.drawable.fire, R.drawable.earth, R.drawable.water, R.drawable.dark, R.drawable.firekong_2, 143, 354, 246, 110));
        juvInfo.add(new MonsterModel("Firanda", R.drawable.fire, R.drawable.nature, R.drawable.water, R.color.white, R.drawable.firanda_fase2, 114, 347, 308, 110));
        juvInfo.add(new MonsterModel("Electrex", R.drawable.earth, R.drawable.thunder, R.drawable.dark, R.color.white, R.drawable.electrex_2, 143, 261, 347, 110));
        juvInfo.add(new MonsterModel("Gigram", R.drawable.fire, R.drawable.thunder, R.drawable.water, R.drawable.earth, R.drawable.gigram_2, 95, 347, 347, 110));
        juvInfo.add(new MonsterModel("Giragast", R.drawable.dark, R.drawable.magic, R.drawable.light, R.drawable.nature, R.drawable.giragast_2, 143, 343, 246, 110));
        juvInfo.add(new MonsterModel("Light Sphinx", R.drawable.earth, R.drawable.light, R.drawable.dark, R.drawable.metal, R.drawable.light_sphinx_2, 176, 270, 246, 110));
        juvInfo.add(new MonsterModel("Obsidia", R.drawable.earth, R.drawable.dark, R.drawable.light, R.color.white, R.drawable.obsidia_2, 128, 308, 308, 110));
        juvInfo.add(new MonsterModel("Succuba", R.drawable.dark, R.drawable.light, R.drawable.metal, R.color.white, R.drawable.succuba_2b, 143, 347, 246, 110));
        juvInfo.add(new MonsterModel("Sheluke", R.drawable.nature, R.drawable.water, R.drawable.fire, R.drawable.thunder, R.drawable.sheluke_2, 128, 308, 308, 110));
        juvInfo.add(new MonsterModel("Terror Dactyl", R.drawable.thunder, R.drawable.dark, R.drawable.earth, R.drawable.light, R.drawable.terror_dactyl_2, 95, 347, 347, 110));
        juvInfo.add(new MonsterModel("Vixsun", R.drawable.nature, R.drawable.light, R.drawable.fire, R.drawable.metal, R.drawable.vixsun_2b, 143, 308, 270, 110));
        juvInfo.add(new MonsterModel("Sealion", R.drawable.fire, R.drawable.water, R.drawable.thunder, R.color.white, R.drawable.sealion_fase2, 114, 347, 308, 110));
        juvInfo.add(new MonsterModel("Gastosquish", R.drawable.earth, R.drawable.water, R.drawable.dark, R.drawable.thunder, R.drawable.gastosquish_fase2, 143, 270, 308, 110));
        juvInfo.add(new MonsterModel("Shock Turtle", R.drawable.thunder, R.drawable.water, R.drawable.earth, R.color.white, R.drawable.shock_turtle_fase2, 114, 308, 347, 110));
        juvInfo.add(new MonsterModel("Dolphchamp", R.drawable.water, R.drawable.magic, R.drawable.thunder, R.drawable.nature, R.drawable.dolphchamp_fase2, 128, 270, 347, 110));
        juvInfo.add(new MonsterModel("Rarawr", R.drawable.nature, R.drawable.earth, R.drawable.fire, R.drawable.dark, R.drawable.rarawr_fase2, 143, 270, 308, 110));
        juvInfo.add(new MonsterModel("Pelitwirl", R.drawable.thunder, R.drawable.light, R.drawable.earth, R.drawable.metal, R.drawable.pelitwirl_fase2, 143, 261, 347, 110));
        juvInfo.add(new MonsterModel("Raydex", R.drawable.thunder, R.drawable.magic, R.drawable.earth, R.drawable.nature, R.drawable.raydex_fase2, 95, 270, 424, 110));
        juvInfo.add(new MonsterModel("Flickie", R.drawable.fire, R.drawable.dark, R.drawable.water, R.drawable.light, R.drawable.flickie_fase2, 95, 385, 270, 110));
        juvInfo.add(new MonsterModel("Utochomp", R.drawable.nature, R.drawable.dark, R.drawable.fire, R.drawable.light, R.drawable.utochomp_fase2, 128, 338, 277, 110));
        juvInfo.add(new MonsterModel("Bloomskips", R.drawable.nature, R.drawable.magic, R.drawable.fire, R.color.white, R.drawable.bloomskips_fase2, 128, 267, 348, 110));
        juvInfo.add(new MonsterModel("Greenasaur", R.drawable.fire, R.drawable.nature, R.drawable.thunder, R.drawable.metal, R.drawable.greenasaur_fase2, 114, 347, 308, 110));
        juvInfo.add(new MonsterModel("Esmelter", R.drawable.metal, R.drawable.fire, R.drawable.magic, R.drawable.water, R.drawable.esmelter_fase2, 122, 292, 316, 110));
        juvInfo.add(new MonsterModel("Jonskeer", R.drawable.metal, R.drawable.nature, R.drawable.magic, R.drawable.fire, R.drawable.jonskeer_fase2, 139, 323, 308, 110));
        juvInfo.add(new MonsterModel("Omethyst", R.drawable.metal, R.drawable.dark, R.drawable.magic, R.drawable.light, R.drawable.omethyst_fase2, 151, 292, 301, 110));
        juvInfo.add(new MonsterModel("Rockneto", R.drawable.metal, R.drawable.earth, R.drawable.magic, R.drawable.dark, R.drawable.rockneto_fase2, 145, 270, 316, 110));
        juvInfo.add(new MonsterModel("Metanephrops", R.drawable.metal, R.drawable.water, R.drawable.magic, R.drawable.thunder, R.drawable.metanephrops_fase2, 149, 344, 308, 110));
        juvInfo.add(new MonsterModel("Lesaki", R.drawable.metal, R.drawable.thunder, R.drawable.magic, R.drawable.earth, R.drawable.lesaki_fase2, 116, 362, 344, 110));
        juvInfo.add(new MonsterModel("Heimdal", R.drawable.metal, R.drawable.light, R.drawable.magic, R.color.white, R.drawable.heimdal_fase2, 145, 308, 313, 110));
        juvInfo.add(new MonsterModel("Pyrook", R.drawable.fire, R.drawable.magic, R.drawable.water, R.drawable.nature, R.drawable.pyrook_fase2, 93, 347, 351, 110));
        juvInfo.add(new MonsterModel("Manolyth", R.drawable.metal, R.drawable.magic, R.drawable.nature, R.color.white, R.drawable.manolyth_fase2, 116, 359, 308, 110));
        juvInfo.add(new MonsterModel("Vadamagma", R.drawable.legend, R.drawable.fire, R.drawable.water, R.color.white, R.drawable.vadamagma_fase2, 172, 421, 390, 140));
        juvInfo.add(new MonsterModel("Nebotus", R.drawable.legend, R.drawable.dark, R.drawable.light, R.color.white, R.drawable.nebotus_fase2, 172, 372, 411, 140));
        juvInfo.add(new MonsterModel("Lord of Atlantis", R.drawable.legend, R.drawable.water, R.drawable.thunder, R.color.white, R.drawable.lord_of_atlantis_fase2, 183, 372, 431, 140));
        juvInfo.add(new MonsterModel("Nemestrinus", R.drawable.legend, R.drawable.nature, R.drawable.fire, R.color.white, R.drawable.nemestrinus_fase2, 203, 366, 431, 140));
        juvInfo.add(new MonsterModel("Tempest", R.drawable.legend, R.drawable.thunder, R.drawable.earth, R.color.white, R.drawable.tempest_fase2, 203, 442, 441, 140));
        juvInfo.add(new MonsterModel("Super Tomato", R.drawable.legend, R.drawable.magic, R.drawable.nature, R.color.white, R.drawable.super_tomato_fase2, 166, 407, 441, 140));
        juvInfo.add(new MonsterModel("Cloud", R.drawable.legend, R.drawable.light, R.drawable.metal, R.color.white, R.drawable.cloud_fase2, 253, 439, 411, 140));

        return juvInfo;
    }

    private ArrayList<MonsterModel> getAdultInfos() {
        final ArrayList<MonsterModel> adultInfo = new ArrayList<>();
        adultInfo.add(new MonsterModel("Fire Lion", R.drawable.fire, R.color.white, R.drawable.water, R.color.white, R.drawable.fire_lion3, 153, 374, 297, 100));
        adultInfo.add(new MonsterModel("Thunder Eagle", R.drawable.thunder, R.color.white, R.drawable.earth, R.color.white, R.drawable.thunder_eagle_3, 153, 297, 425, 100));
        adultInfo.add(new MonsterModel("Metalsaur", R.drawable.metal, R.color.white, R.drawable.magic, R.color.white, R.drawable.metalsaur3, 184, 380, 340, 100));
        adultInfo.add(new MonsterModel("Arch Knight", R.drawable.legend, R.color.white, R.drawable.metal, R.color.white, R.drawable.arch_knight_3, 1587, 980, 980, 140));
        adultInfo.add(new MonsterModel("Light Spirit", R.drawable.light, R.color.white, R.drawable.metal, R.color.white, R.drawable.light_spirit_3, 217, 297, 297, 100));
        adultInfo.add(new MonsterModel("Genie", R.drawable.magic, R.color.white, R.drawable.nature, R.color.white, R.drawable.genie_3, 171, 340, 340, 100));
        adultInfo.add(new MonsterModel("Tyrannoking", R.drawable.dark, R.color.white, R.drawable.light, R.color.white, R.drawable.tyrannoking_3, 153, 391, 297, 100));
        adultInfo.add(new MonsterModel("Turtle", R.drawable.water, R.color.white, R.drawable.thunder, R.color.white, R.drawable.turtle_3, 153, 323, 425, 100));
        adultInfo.add(new MonsterModel("Rockilla", R.drawable.earth, R.color.white, R.drawable.dark, R.color.white, R.drawable.gorilla3, 217, 297, 297, 100));
        adultInfo.add(new MonsterModel("Panda", R.drawable.nature, R.color.white, R.drawable.fire, R.color.white, R.drawable.panda3, 171, 323, 340, 100));
        adultInfo.add(new MonsterModel("Blesstle", R.drawable.water, R.drawable.light, R.drawable.thunder, R.drawable.metal, R.drawable.blesstle_3b, 317, 408, 418, 110));
        adultInfo.add(new MonsterModel("Firekong", R.drawable.fire, R.drawable.earth, R.drawable.water, R.drawable.dark, R.drawable.firekong_3, 317, 506, 352, 110));
        adultInfo.add(new MonsterModel("Firanda", R.drawable.fire, R.drawable.nature, R.drawable.water, R.color.white, R.drawable.firanda, 252, 496, 440, 110));
        adultInfo.add(new MonsterModel("Electrex", R.drawable.earth, R.drawable.thunder, R.drawable.dark, R.color.white, R.drawable.electrex_3, 317, 374, 496, 110));
        adultInfo.add(new MonsterModel("Gigram", R.drawable.fire, R.drawable.thunder, R.drawable.water, R.drawable.earth, R.drawable.gigram_3, 211, 496, 496, 110));
        adultInfo.add(new MonsterModel("Giragast", R.drawable.dark, R.drawable.magic, R.drawable.light, R.drawable.nature, R.drawable.giragast_3, 317, 490, 352, 110));
        adultInfo.add(new MonsterModel("Light Sphinx", R.drawable.earth, R.drawable.light, R.drawable.dark, R.drawable.metal, R.drawable.light_sphinx_3, 390, 386, 352, 110));
        adultInfo.add(new MonsterModel("Obsidia", R.drawable.earth, R.drawable.dark, R.drawable.light, R.color.white, R.drawable.obsidia_3, 285, 440, 440, 110));
        adultInfo.add(new MonsterModel("Succuba", R.drawable.dark, R.drawable.light, R.drawable.metal, R.color.white, R.drawable.succuba_3, 317, 496, 352, 110));
        adultInfo.add(new MonsterModel("Sheluke", R.drawable.nature, R.drawable.water, R.drawable.fire, R.drawable.thunder, R.drawable.sheluke_3, 285, 440, 440, 110));
        adultInfo.add(new MonsterModel("Terror Dactyl", R.drawable.thunder, R.drawable.dark, R.drawable.earth, R.drawable.light, R.drawable.terror_dactyl_3, 211, 496, 496, 110));
        adultInfo.add(new MonsterModel("Vixsun", R.drawable.nature, R.drawable.light, R.drawable.fire, R.drawable.metal, R.drawable.vixsun_3, 317, 440, 386, 110));
        adultInfo.add(new MonsterModel("Sealion", R.drawable.fire, R.drawable.water, R.drawable.thunder, R.color.white, R.drawable.sealion, 252, 496, 440, 110));
        adultInfo.add(new MonsterModel("Gastosquish", R.drawable.earth, R.drawable.water, R.drawable.dark, R.drawable.thunder, R.drawable.gastosquish_fase3, 317, 386, 440, 110));
        adultInfo.add(new MonsterModel("Shock Turtle", R.drawable.thunder, R.drawable.water, R.drawable.earth, R.color.white, R.drawable.shock_turtle, 252, 440, 496, 110));
        adultInfo.add(new MonsterModel("Dolphchamp", R.drawable.water, R.drawable.magic, R.drawable.thunder, R.drawable.nature, R.drawable.dolphchamp, 285, 386, 496, 110));
        adultInfo.add(new MonsterModel("Rarawr", R.drawable.nature, R.drawable.earth, R.drawable.fire, R.drawable.dark, R.drawable.rarawr, 317, 386, 440, 110));
        adultInfo.add(new MonsterModel("Pelitwirl", R.drawable.thunder, R.drawable.light, R.drawable.earth, R.drawable.metal, R.drawable.pelitwirl, 317, 374, 496, 110));
        adultInfo.add(new MonsterModel("Raydex", R.drawable.thunder, R.drawable.magic, R.drawable.earth, R.drawable.nature, R.drawable.raydex, 211, 386, 606, 110));
        adultInfo.add(new MonsterModel("Flickie", R.drawable.fire, R.drawable.dark, R.drawable.water, R.drawable.light, R.drawable.flickie, 211, 550, 386, 110));
        adultInfo.add(new MonsterModel("Utochomp", R.drawable.nature, R.drawable.dark, R.drawable.fire, R.drawable.light, R.drawable.utochomp, 285, 484, 396, 110));
        adultInfo.add(new MonsterModel("Bloomskips", R.drawable.nature, R.drawable.magic, R.drawable.fire, R.color.white, R.drawable.bloomskips, 285, 382, 498, 110));
        adultInfo.add(new MonsterModel("Greenasaur", R.drawable.fire, R.drawable.nature, R.drawable.thunder, R.drawable.metal, R.drawable.greenasaur, 252, 496, 440, 110));
        adultInfo.add(new MonsterModel("Esmelter", R.drawable.metal, R.drawable.fire, R.drawable.magic, R.drawable.water, R.drawable.esmelter, 271, 418, 452, 110));
        adultInfo.add(new MonsterModel("Jonskeer", R.drawable.metal, R.drawable.nature, R.drawable.magic, R.drawable.fire, R.drawable.jonskeer, 308, 462, 440, 110));
        adultInfo.add(new MonsterModel("Omethyst", R.drawable.metal, R.drawable.dark, R.drawable.magic, R.drawable.light, R.drawable.omethyst, 335, 418, 430, 110));
        adultInfo.add(new MonsterModel("Rockneto", R.drawable.metal, R.drawable.earth, R.drawable.magic, R.drawable.dark, R.drawable.rockneto, 322, 386, 452, 110));
        adultInfo.add(new MonsterModel("Metanephrops", R.drawable.metal, R.drawable.water, R.drawable.magic, R.drawable.thunder, R.drawable.metanephrops, 331, 492, 440, 110));
        adultInfo.add(new MonsterModel("Lesaki", R.drawable.metal, R.drawable.thunder, R.drawable.magic, R.drawable.earth, R.drawable.lesaki_fase3, 257, 518, 492, 110));
        adultInfo.add(new MonsterModel("Heimdal", R.drawable.metal, R.drawable.light, R.drawable.magic, R.color.white, R.drawable.heimdal_fase3, 322, 440, 448, 110));
        adultInfo.add(new MonsterModel("Pyrook", R.drawable.fire, R.drawable.magic, R.drawable.water, R.drawable.nature, R.drawable.pyrook, 206, 496, 502, 110));
        adultInfo.add(new MonsterModel("Manolyth", R.drawable.metal, R.drawable.magic, R.drawable.nature, R.color.white, R.drawable.manolyth, 257, 514, 440, 110));
        adultInfo.add(new MonsterModel("Vadamagma", R.drawable.legend, R.drawable.fire, R.drawable.water, R.color.white, R.drawable.vadamagma, 1689, 1053, 976, 140));
        adultInfo.add(new MonsterModel("Nebotus", R.drawable.legend, R.drawable.dark, R.drawable.light, R.color.white, R.drawable.nebotus, 1689, 931, 1029, 140));
        adultInfo.add(new MonsterModel("Lord of Atlantis", R.drawable.legend, R.drawable.water, R.drawable.thunder, R.color.white, R.drawable.lord_of_atlantis, 1790, 931, 1078, 140));
        adultInfo.add(new MonsterModel("Nemestrinus", R.drawable.legend, R.drawable.nature, R.drawable.fire, R.color.white, R.drawable.nemestrinus, 1994, 917, 1078, 140));
        adultInfo.add(new MonsterModel("Tempest", R.drawable.legend, R.drawable.thunder, R.drawable.earth, R.color.white, R.drawable.tempest, 1994, 1106, 1102, 140));
        adultInfo.add(new MonsterModel("Super Tomato", R.drawable.legend, R.drawable.magic, R.drawable.nature, R.color.white, R.drawable.super_tomato, 1627, 1018, 1102, 140));
        adultInfo.add(new MonsterModel("Cloud", R.drawable.legend, R.drawable.light, R.drawable.metal, R.color.white, R.drawable.cloud, 2482, 1099, 1029, 140));

        return adultInfo;
    }
}

