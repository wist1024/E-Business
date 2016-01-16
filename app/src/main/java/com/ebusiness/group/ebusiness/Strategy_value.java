package com.ebusiness.group.ebusiness;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by stephanie on 08.01.2016.
 */

public class Strategy_value extends StrategyAreaActivity {

    private Button btn_zurueck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_strategy_value);


        String[] strategys = {
                "Diese Strategie gilt vom Rechenaufwand als die aufwendigsten Handelsstrategien. Es kann daher sein, dass man Zeit investiert, um sich hundert verschiedene Aktien anzusehen, und dennoch darunter keine unterbewertete Qualitätsaktie findet.\n" + "\n" +
                        "1)\t Betrachten und berechnen Sie die Fundamentalanalyse (z.B. KGV, KBV).\n" + "\n" +
                        "2)\t Finden Sie eine unterbewertete Aktie.\n" + "\n" +
                        "3)\t Kaufen Sie diese Aktie und behalten sie diese Länger, da auf eine langfristige und solide Wertsteigerung abgezielt wird.\n" + "\n"

        };

        ListAdapter buckysAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strategys);
        ListView top_flop = (ListView) findViewById(R.id.value);
        top_flop.setAdapter(buckysAdapter);


        btn_zurueck = (Button) findViewById(R.id.button_zurueck_value);
        btn_zurueck.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();


            }
        });
    }




}