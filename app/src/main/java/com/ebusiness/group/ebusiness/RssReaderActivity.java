package com.ebusiness.group.ebusiness;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.ebusiness.group.ebusiness.PostItemAdapter;
import com.ebusiness.group.ebusiness.PostData;

import com.ebusiness.group.ebusiness.CheatsheetActivity;
import com.ebusiness.group.ebusiness.R;
import com.ebusiness.group.ebusiness.SettingsActivity;
import com.ebusiness.group.ebusiness.StockMarketActivity;
import com.ebusiness.group.ebusiness.StockMarketToolsActivity;
import com.ebusiness.group.ebusiness.StrategyAreaActivity;
import com.ebusiness.group.ebusiness.TwitterActivity;

public class RssReaderActivity extends Activity implements NavigationView.OnNavigationItemSelectedListener {

        private PostData[] listData;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_rss);

            this.generateDummyData();
            ListView listView = (ListView) this.findViewById(R.id.postListView);
            PostItemAdapter itemAdapter = new PostItemAdapter(this,
                    R.layout.activity_rss_2, listData);
            listView.setAdapter(itemAdapter);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.news, menu);
            return true;
        }

        private void generateDummyData() {
            PostData data = null;
            listData = new PostData[10];
            for (int i = 0; i < 10; i++) { //please ignore this comment :>
                data = new PostData();
                data.postDate = "May 20, 2013";
                data.postTitle = "Post " + (i + 1) + " Title: This is the Post Title from RSS Feed";
                data.postThumbUrl = null;
                listData[i] = data;
            }
        }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_news) {
            // DO NOTHING - OWN ID!
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
            Intent intent = new Intent(this, StockMarketListActivity.class);
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