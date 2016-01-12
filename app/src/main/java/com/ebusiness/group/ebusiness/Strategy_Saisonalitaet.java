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

public class Strategy_Saisonalitaet extends StrategyAreaActivity {

    private Button btn_zurueck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_saisonalitaet);

        String[] strategys = {
                "Diese Handelsstrategie investiert in saisonal starken Zeiten und steigt in saisonal schwachen Zeiten entweder ganz aus dem Markt aus oder reduziert zumindest das Engagement spürbar.\n" + "\n" +
                        "1)\t Die Strategie sagt nicht aus, welche Aktien Sie kaufen müssen.\n" + "\n" +
                        "2)\t Kombinieren Sie diese Strategie mit einer anderen Strategie. \n" +
                        "\n"
        };

        ListAdapter buckysAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strategys);
        ListView top_flop = (ListView) findViewById(R.id.saisonalitaet);
        top_flop.setAdapter(buckysAdapter);

        btn_zurueck = (Button) findViewById(R.id.button_zurueck_saisonalitaet);
        btn_zurueck.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();


            }
        });
    }




}