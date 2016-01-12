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

public class Strategy_Dividenden
        extends StrategyAreaActivity {

    private Button btn_zurueck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_strategy_dividenden);

        String[] strategys = {
                "Aktien werden nach der Dividendenzahlung, nicht nach der Kursentwicklung gekauft. Annahme: Unternehmen mit einer hohen Dividendenrendite machen solide Gewinne. Achtung vor Täuschungen!.\n" + "\n" +
                        "1)\t Filtern Sie zum Jahresbeginn aus einem Index, beispielsweise DAX die zehn Aktien mit den höchsten Dividendenrendite.\n" + "\n" +
                        "2)\t Kaufen Sie die Aktien, mit dem niedrigsten Aktienkurs.\n" + "\n" +
                        "3)\t Behalten Sie die Aktien für ein Jahr.\n" + "\n" +
                        "4)\t Wiederholen Sie den ersten Schritt der Strategie zu jedem Jahreswechsel.\n" + "\n"
        };

        ListAdapter buckysAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strategys);
        ListView top_flop = (ListView) findViewById(R.id.dividenden);
        top_flop.setAdapter(buckysAdapter);

        btn_zurueck = (Button) findViewById(R.id.button_zurueck_dividenden);
        btn_zurueck.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();


            }
        });
    }




}