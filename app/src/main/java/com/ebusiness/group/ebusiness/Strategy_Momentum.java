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

public class Strategy_Momentum extends StrategyAreaActivity {

    private Button btn_zurueck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_strategy_momentum);

        String[] strategys = {
                "Diese Strategie eignet sich eher für Anleger, die bereits einige Erfahrung an der Börse gesammelt und mindestens wöchentlich Zeit für die Überprüfung ihrer Anlage aufwenden können.\n" + "\n" +
                "1)\t Prinzip \"The trend ist your friend\" (Aktien, die in der jüngsten Vergangenheit gut gelaufen sind und Kursgewinne eingefahren haben, werden dies auch in Zukunft tun).\n" + "\n" +
                "2)\t Betrachten Sie die Kursentwicklung des letzten halben Jahres, bzw. der letzten 26 Wochen einer jeden Aktie.\n" + "\n" +
                "3)\t Berechnen Sie den Durchschnittskurs (Addiere zu jeder Aktie die letzten 26 Wochenschlusskurse, anschließend durch 26 teilen).\n" + "\n" +
                "4)\t Teilen Sie den aktuelle Kurs jeder Aktien durch den so errechnete Durchschnittskurs.\n" + "\n" +
                "5)\t Ergebnis größer 1, Kaufsignal für die Aktie (Nicht sofort kaufen).\n" + "\n" +
                "6)\t Überprüfen Sie alle Aktien des Index (Rechnung oben durchführen) und erstellen Sie eine Rangliste, nach absteigender Reihenfolge.\n" + "\n" +
                "7)\t Kaufen Sie die besten Aktien.\n" + "\n" +
                "8)\t Wiederholen Sie den Vorgang wöchentlich.\n" + "\n" +
                "9)\t Ist eine Aktie zu Beginn gekauft wurde, dabei in der Liste abrutscht und ins hintere Drittel der Liste gefallen, wird diese verkauft und an ihrer Stelle die Aktie mit der höchsten Platzierung gekauft.\n" +


                        "\n"
        };

        ListAdapter buckysAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strategys);
        ListView top_flop = (ListView) findViewById(R.id.momentum);
        top_flop.setAdapter(buckysAdapter);

        btn_zurueck = (Button) findViewById(R.id.button_zurück_momentum);
        btn_zurueck.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();


            }
        });
    }




}