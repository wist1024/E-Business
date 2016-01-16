package com.ebusiness.group.ebusiness;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StrategyAreaActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
      {

    private Button strategy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_strategy_area);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        // Liste von Strategien
/*
        setContentView(R.layout.content_strategy_area);
        String[] strategys = {"Momentum-Strategie", "Top-Flop-Strategie", "Dividendenstategie", "Value Strategie", "Saisonalitäten", "Trading Pennystocks"};
        ListAdapter buckysAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strategys);
        ListView buckysListView = (ListView) findViewById(R.id.buckysListView);
        buckysListView.setAdapter(buckysAdapter);

        buckysListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String strategy = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(StrategyAreaActivity.this, strategy, Toast.LENGTH_LONG).show();
                    }
                }
        );
*/

        strategy = (Button) findViewById(R.id.Button_top_flop);
        strategy.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                int a = v.getId();

                if (a == R.id.Button_top_flop) {
                    Intent intent = new Intent(StrategyAreaActivity.this, Strategy_Top_Flop.class);
                    startActivity(intent);
                }
            }
        });

        strategy = (Button) findViewById(R.id.button_momentum);
        strategy.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                int b = v.getId();

                if (b == R.id.button_momentum) {
                    Intent intent = new Intent(StrategyAreaActivity.this, Strategy_Momentum.class);
                    startActivity(intent);
                }
            }
        });

        strategy = (Button) findViewById(R.id.button_eig_strat);
        strategy.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                int ce = v.getId();

                if (ce == R.id.button_eig_strat) {
                    Intent intent = new Intent(StrategyAreaActivity.this, Strategy_eigene.class);
                    startActivity(intent);
                }

            }
        });

        strategy = (Button) findViewById(R.id.button_value);
        strategy.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                int d = v.getId();

                if (d == R.id.button_value) {
                    Intent intent = new Intent(StrategyAreaActivity.this, Strategy_value.class);
                    startActivity(intent);
                }

            }
        });

        strategy = (Button) findViewById(R.id.button_dividendenstrategie);
        strategy.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                int g = v.getId();

                if (g == R.id.button_dividendenstrategie) {
                    Intent intent = new Intent(StrategyAreaActivity.this, Strategy_Dividenden.class);
                    startActivity(intent);
                }

            }
        });

        strategy = (Button) findViewById(R.id.button_saisonalität);
        strategy.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                int h = v.getId();

                if (h == R.id.button_saisonalität) {
                    Intent intent = new Intent(StrategyAreaActivity.this, Strategy_Dividenden.class);
                    startActivity(intent);
                }

            }
        });

        strategy = (Button) findViewById(R.id.button_pennystocks);
        strategy.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                int i = v.getId();

                if (i == R.id.button_pennystocks) {
                    Intent intent = new Intent(StrategyAreaActivity.this, Strategy_Pennystock.class);
                    startActivity(intent);
                }

            }
        });


    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.strategy_area, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_news) {
            Intent intent = new Intent(this, NewsActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_twitter) {
            Intent intent = new Intent(this, TwitterActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_cheatsheet) {
            Intent intent = new Intent(this, CheatsheetActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_strategiearea) {
            // DO NOTHING - OWN ID!
        } else if (id == R.id.nav_stockmarket) {
            Intent intent = new Intent(this, StockMarketActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_stockmarkettools) {
            Intent intent = new Intent(this, StockMarketToolsActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            finish();
        } else if(id == R.id.nav_rss) {
            Intent intent = new Intent(this, RssReaderActivity.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
