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

public class Strategy_Pennystock extends StrategyAreaActivity {

    private Button btn_zurueck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_pennystock);

        String[] strategys = {
                "Die „100%-Strategie“ bzw. „100%-Regel“ ist eine wohlbewährte Risiko- und Moneymanagementstrategie.\n" + "\n" +
                        "1)\t Absicherung bei 50% Performace. So viele Aktien zu verkaufen, dass Sie mit Ihrer Position bei der weiteren Kursentwicklung unter dem Strich nicht mehr verlieren können.\n" + "\n" +
                        "2)\t Kontrollierte Gewinne bei 100% Gesamtperformance einfahren.\n" + "\n" +
                        "3)\t -\tRestaktien zur weiteren Spekulation stehen zur Verfügung.\n" + "\n" +
                        "\n"
        };

        ListAdapter buckysAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strategys);
        ListView top_flop = (ListView) findViewById(R.id.pennystock);
        top_flop.setAdapter(buckysAdapter);

        btn_zurueck = (Button) findViewById(R.id.button_zurueck_pennystock);
        btn_zurueck.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();


            }
        });
    }




}