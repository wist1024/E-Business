package com.ebusiness.group.ebusiness;

import android.app.Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rebekka on 09.01.2016.
 */
public class ShareMarketItems extends Activity{

    public static List<ShareMarketItem> ITEMS = new ArrayList<ShareMarketItem>();

    public static Map<String, ShareMarketItem> ITEM_MAP = new HashMap<>();
    public static String[] sItems = new String[] {"Shares", "Options", "Bonds"};

    //ImageView iv = (ImageView)findViewById(R.id.share_detail);
    //return(Image)iv.setImageDrawable(R.drawable.ic_shares_kz);
    //public static String[] aItems = Resources.getSystem().getStringArray(R.array.shareNames);

    static {
        for(int i = 0; i < sItems.length; i++)
            addItem(createItem(i));
    }

    private static void addItem(ShareMarketItem item){
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static ShareMarketItem createItem(int position){
        return new ShareMarketItem(String.valueOf(position), sItems[position], makeDetails(sItems[position]), makeDetails2(sItems[position]));
    }


    private static int makeDetails(String name) {
        /*StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();*/
        //ImageView iv = (ImageView)findViewById(R.id.share_detail);
        switch(name) {
            case "Shares":
                return R.drawable.ic_shares_kz;
            case "Options":
                return R.drawable.ic_option_kz;
            case "Bonds":
                return R.drawable.ic_bond_kz;
            default:
                return R.drawable.ic_shares_kz;
        }

    }


    private static int makeDetails2(String name) {
        /*StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();*/
        //ImageView iv = (ImageView)findViewById(R.id.share_detail);
        switch(name) {
            case "Shares":
                return R.drawable.ic_share_chart;
            case "Options":
                return R.drawable.ic_option_chart;
            case "Bonds":
                return R.drawable.ic_bond_chart;
            default:
                return R.drawable.ic_share_chart;
        }

    }





    public static class ShareMarketItem {
        public String id;
        public String content;
        public int details;
        public int details2;

        public ShareMarketItem(String id, String content, int details, int details2) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.details2 = details2;
        }

        @Override
        public String toString() {
            return content;
        }}
}



