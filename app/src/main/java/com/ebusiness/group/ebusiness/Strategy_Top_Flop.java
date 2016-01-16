package com.ebusiness.group.ebusiness;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by stefan on 08.01.2016.
 */

public class Strategy_Top_Flop extends StrategyAreaActivity {

    private Button btn_zurueck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_strategy_top_flop);


        String[] strategys = {
                "Diese Strategie erfordert recht wenig Aufwand und ist für Privatanleger gut anwendbar. \n" + "\n" +
                "1)\t Kaufen Sie zum Jahresbeginn fünf Aktien, die im vergangenen Jahr die schlechteste Performance aus einem bestimmtem Index, beispielsweise DAX aufweist.\n" + "\n" +
                "2)\t Der größte Verlierer hat das größte Aufholpotenzial, also die größte Kurssteigerung (Turnaround).\n" +
                "\n" +
                "3)\t Kaufen Sie nach 6 Monaten fünf Aktien aus dem gleichen Index, die im ersten Halbjahr den höchsten prozentualen Gewinn erzielen konnten.\n" + "\n" +
                "4)\t Ist eine der Verlierer-Aktien die zu Jahresbeginn gekauft wurden dabei, so werden diese übernommen. Ansonsten verkauft (\"Window Dressing\").\n" +
                "\n" +
                "5)\t Wiederholen Sie den ersten Schritt der Strategie zu jedem Jahreswechsel.\n"};

        ListAdapter buckysAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strategys);
        ListView top_flop = (ListView) findViewById(R.id.top_flop);
        top_flop.setAdapter(buckysAdapter);


        btn_zurueck = (Button) findViewById(R.id.button_zurueck_top_flop);
        btn_zurueck.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();


            }
        });
    }

}