package com.ebusiness.group.ebusiness;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StockMarketToolsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button volatilitaetbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_market_tools);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        volatilitaetbtn = (Button) findViewById(R.id.buttonv);
        volatilitaetbtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                int ce = v.getId();

                if (ce == R.id.buttonv) {
                    Intent intent = new Intent(StockMarketToolsActivity.this, Volatilitaet.class);
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
        getMenuInflater().inflate(R.menu.stock_market_tools, menu);
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
            Intent intent = new Intent(this, StrategyAreaActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_stockmarket) {
            Intent intent = new Intent(this, StockMarketActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_stockmarkettools) {
            // DO NOTHING - OWN ID!
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
