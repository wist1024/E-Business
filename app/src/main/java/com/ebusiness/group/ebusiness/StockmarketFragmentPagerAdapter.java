package com.ebusiness.group.ebusiness;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Rebekka on 12.01.2016.
 */
public class StockmarketFragmentPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[]{"Kennzahlen", "Chart"};
    private Context ctx;
    private ShareMarketItems.ShareMarketItem smi;

    /**
     * Constructor for ContactFragmentPagerAdapter
     *
     * @param fm      fragment manager
     * @param context the context
     */
    public StockmarketFragmentPagerAdapter(FragmentManager fm, Context context, ShareMarketItems.ShareMarketItem smi) {
        super(fm);
        this.ctx = context;
        this.smi = smi;
    }

    /**
     * Used to retrieve the number of views available
     *
     * @return number of views in adapter
     */
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    /**
     * Creates new Fragment for position
     *
     * @param position the position
     * @return new instance of the Fragment specified in position
     */
    @Override
    public Fragment getItem(int position) {
        StockMarketDetailFragment.mItem = smi;
        StockMarketDetailFragment.tPos = position;
        StockMarketChartFragment.mItem = smi;
        StockMarketChartFragment.tPos = position;
        if(position == 0)
            return StockMarketDetailFragment.newInstance();
        else
            return StockMarketChartFragment.newInstance();
    }

    /**
     * Used to retrieve the title of a specified Fragment
     *
     * @param position position of the Fragment
     * @return the title
     */
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}