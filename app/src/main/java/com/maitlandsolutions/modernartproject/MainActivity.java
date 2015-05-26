package com.maitlandsolutions.modernartproject;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private TextView textViewRed;
    private TextView textViewRedToWhite;
    private TextView textViewBlue;
    private TextView textViewGreen;
    private TextView textViewYellow;
    private TextView textViewWhite;

    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewRed = (TextView) findViewById(R.id.textViewRed);
        textViewBlue = (TextView) findViewById(R.id.textViewBlue);
        textViewGreen = (TextView) findViewById(R.id.textViewGreen);
        textViewYellow = (TextView) findViewById(R.id.textViewYellow);
        textViewWhite = (TextView) findViewById(R.id.textViewWhite);
        textViewRedToWhite = (TextView) findViewById(R.id.textViewRedToWhite);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(255);
        setColours();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                reDrawColours(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            //displayMoreInfoDialog();
            MoreInfo dialog = new MoreInfo();
            dialog.show(getFragmentManager(), "MoreInfo");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setColours() {
        textViewRed.setBackgroundColor(Color.rgb(255, 0, 0));
        textViewRedToWhite.setBackgroundColor(Color.rgb(255, 0, 0));
        textViewYellow.setBackgroundColor(Color.rgb(255,255,0));
        textViewBlue.setBackgroundColor(Color.rgb(0, 0, 255));
        textViewGreen.setBackgroundColor(Color.rgb(0, 255, 0));
        textViewWhite.setBackgroundColor(Color.rgb(211,211,211));

    }

    public void reDrawColours(int val) {
        textViewRed.setBackgroundColor(Color.rgb(255, val, 0));
        textViewRedToWhite.setBackgroundColor(Color.rgb(255-val, val, 0));
        textViewYellow.setBackgroundColor(Color.rgb(255,255, val));
        textViewBlue.setBackgroundColor(Color.rgb(val, 0, 255));
        textViewGreen.setBackgroundColor(Color.rgb(0, 255, val));
    }
}
