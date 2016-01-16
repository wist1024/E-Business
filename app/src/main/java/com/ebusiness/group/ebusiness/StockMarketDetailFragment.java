package com.ebusiness.group.ebusiness;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A fragment representing a single StockMarket detail screen.
 * This fragment is either contained in a {@link StockMarketListActivity}
 * in two-pane mode (on tablets) or a {@link StockMarketDetailActivity}
 * on handsets.
 */
public class StockMarketDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";


    /**
     * The dummy content this fragment is presenting.
     */
    public static ShareMarketItems.ShareMarketItem mItem;
    public static int tPos;

    public static StockMarketDetailFragment newInstance() {

        StockMarketDetailFragment fragment = new StockMarketDetailFragment();
        Bundle args = new Bundle();

        //args.putParcelable(ARG_ITEM_ID, mItem);
        fragment.setArguments(args);

        return fragment;
    }


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public StockMarketDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            //mItem = ShareMarketItems.ITEM_MAP.get(getArguments().getString(items[i]));
            /*mItem = ShareMarketItems.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
            }*/
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_stockmarket_detail, container, false);

        //Drawable d = Resources.getSystem().getDrawable(mItem.details);
        // Show the dummy content as text in a TextView.
            ((ImageView)rootView.findViewById(R.id.share_detail)).setImageResource(mItem.details);

        return rootView;
    }
}
