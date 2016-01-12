package com.ebusiness.group.ebusiness;

/**
 * Created by stefan on 08.01.2016.
 */
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.EditText;

public class Volatilitaet extends StockMarketToolsActivity {

    Button button_zurueck;

    EditText et;
    TextView tv;

    Button berechne;
    double wurzelzahl;

    double arbeitstage;
    double gezogeneWurzel;
    EditText vProtag;
    double ergebnis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_stock_market_volatilitaet);



        et = (EditText) findViewById(R.id.et);
        vProtag = (EditText) findViewById(R.id.vProTag);

        tv = (TextView) findViewById(R.id.tv);
        berechne = (Button) findViewById(R.id.berechnen);
        berechne.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                if(et.getText().length() > 0 && vProtag.getText().length()>0){

                    wurzelzahl = Double.parseDouble(et.getText().toString());
                    gezogeneWurzel = Math.sqrt(wurzelzahl);

                    arbeitstage = Double.parseDouble(vProtag.getText().toString());

                    ergebnis = gezogeneWurzel * arbeitstage;
                    tv.setText("Ergebnis:" + Double.toString(ergebnis) );

                }else {

                    tv.setText("Bitte eine Quadratwurzel eingeben");
                }

           }
        });


        button_zurueck = (Button) findViewById(R.id.button_zurueck);
        button_zurueck.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();


            }
        });
    }
}