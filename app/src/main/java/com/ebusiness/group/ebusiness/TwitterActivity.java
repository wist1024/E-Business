package com.ebusiness.group.ebusiness;

import android.content.Intent;
import android.os.AsyncTask;
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
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;

public class TwitterActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView tweetDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Custom Code

        tweetDisplay = (TextView)findViewById(R.id.tweet_txt);
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
        getMenuInflater().inflate(R.menu.twitter, menu);
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
            // DO NOTHING - OWN ID!
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
            Intent intent = new Intent(this, StockMarketToolsActivity.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    public void searchTwitter(View view){
        EditText searchTxt = (EditText)findViewById(R.id.search_edit);
        String searchTerm = searchTxt.getText().toString();

        if(searchTerm.length()>0){
            try{
                String encodedSearch = URLEncoder.encode(searchTerm, "UTF-8");
                String searchURL = "http://search.twitter.com/search.json?q="+encodedSearch;
                new GetTweets().execute(searchURL);
            }
            catch(Exception e){
                tweetDisplay.setText("Whoops - something went wrong!");
                e.printStackTrace();
            }
        }
        else
            tweetDisplay.setText("Enter a search query!");
    }

    private class GetTweets extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... twitterURL) {
            StringBuilder tweetFeedBuilder = new StringBuilder();
            for (String searchURL : twitterURL) {
                HttpClient tweetClient = new DefaultHttpClient();

                try {
                    HttpGet tweetGet = new HttpGet(searchURL);
                    HttpResponse tweetResponse = tweetClient.execute(tweetGet);
                    StatusLine searchStatus = tweetResponse.getStatusLine();
                    if (searchStatus.getStatusCode() == 200) {
                        HttpEntity tweetEntity = tweetResponse.getEntity();
                        InputStream tweetContent = tweetEntity.getContent();
                        InputStreamReader tweetInput = new InputStreamReader(tweetContent);
                        BufferedReader tweetReader = new BufferedReader(tweetInput);

                        String lineIn;
                        while ((lineIn = tweetReader.readLine()) != null) {
                            tweetFeedBuilder.append(lineIn);
                        }
                    }
                    //else
                        //tweetDisplay.setText("Whoops - something went wrong!");
                }
                catch(Exception e) {
                    //tweetDisplay.setText("Whoops - something went wrong!");
                    e.printStackTrace();
                }
            }
            return tweetFeedBuilder.toString();
        }

        protected void onPostExecute(String result) {
            StringBuilder tweetResultBuilder = new StringBuilder();
            try {
                JSONObject resultObject = new JSONObject(result);
                JSONArray tweetArray = resultObject.getJSONArray("results");

                for (int t=0; t<tweetArray.length(); t++) {
                    JSONObject tweetObject = tweetArray.getJSONObject(t);
                    tweetResultBuilder.append(tweetObject.getString("from_user")+": ");
                    tweetResultBuilder.append(tweetObject.get("text")+"\n\n");
                }
            }
            catch (Exception e) {
                tweetDisplay.setText("Whoops - something went wrong!");
                e.printStackTrace();
            }

            if(tweetResultBuilder.length()>0)
                tweetDisplay.setText(tweetResultBuilder.toString());
            else
                tweetDisplay.setText("Sorry - no tweets found for your search!");
        }
    }
}
