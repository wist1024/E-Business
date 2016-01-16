package com.ebusiness.group.ebusiness;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * An activity representing a single StockMarket detail screen. This
 * activity is only used on handset devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link StockMarketListActivity}.
 * <p/>
 * This activity is mostly just a 'shell' activity containing nothing
 * more than a {@link StockMarketDetailFragment}.
 */
public class StockMarketDetailActivity extends AppCompatActivity {

    private ViewPager pager;
    private ShareMarketItems.ShareMarketItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_stockmarket_detail);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        //setSupportActionBar(toolbar);

/*        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Beki the best", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        // Show the Up button in the action bar.
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
     /*   if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();

            arguments.putString(StockMarketDetailFragment.ARG_ITEM_ID, getIntent().getStringExtra(StockMarketDetailFragment.ARG_ITEM_ID));
            StockMarketDetailFragment fragment = new StockMarketDetailFragment();

            fragment.setArguments(arguments);
            //fragment.getFragmentManager().beginTransaction()
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.stockmarket_detail_container, fragment)
                    .commit();

        }*/
    /* else {
        // It's a phone, so launch a new detail activity
        Intent detailIntent = new Intent(this, StockMarketDetailFragment.class);
        // Pass the selected Golfcourse object to the DetailActivity
        detailIntent.putExtra("course", c);
        startActivity(detailIntent);*/
        Bundle args = getIntent().getExtras();

        if(args != null) {
            int id = Integer.parseInt(args.getString(StockMarketDetailFragment.ARG_ITEM_ID));
            item = ShareMarketItems.ITEMS.get(id);
        }
        pager = (ViewPager) findViewById(R.id.viewPager);
        StockmarketFragmentPagerAdapter adapter = new StockmarketFragmentPagerAdapter(getSupportFragmentManager(), this, item);
        pager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, StockMarketListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
