package com.ebusiness.group.ebusiness;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Created by stefan on 09.01.2016.
 */
public class Strategy_eigene extends StrategyAreaActivity {

    private Button btn_zurueck;
    private Button rechnungen;
    private Button akiten;
    private Button strategy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_strategy_eigene);

        strategy = (Button) findViewById(R.id.strategy_area);
        strategy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int b = v.getId();

                if (b == R.id.strategy_area) {
                    Intent intent = new Intent(Strategy_eigene.this, StrategyAreaActivity.class);
                    startActivity(intent);
                }
            }
        });

        rechnungen = (Button) findViewById(R.id.boersentool);
        rechnungen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int a = v.getId();

                if (a == R.id.boersentool) {
                    Intent intent = new Intent(Strategy_eigene.this, StockMarketToolsActivity.class);
                    startActivity(intent);
                }
            }
        });

        akiten = (Button) findViewById(R.id.buttonaktien);
        akiten.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int c = v.getId();

                if (c == R.id.buttonaktien) {
                    Intent intent = new Intent(Strategy_eigene.this, StockMarketActivity.class);
                    startActivity(intent);
                }
                //Vermerk: StockMarketActivity ist Börse, die classe Aktien gibt es noch nicht!!!
            }
        });

        btn_zurueck = (Button) findViewById(R.id.button_zurueck);
        btn_zurueck.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
