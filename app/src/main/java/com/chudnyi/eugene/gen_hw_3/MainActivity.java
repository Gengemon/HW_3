package com.chudnyi.eugene.gen_hw_3;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import gen_hw_3.R;

public class MainActivity extends AppCompatActivity {

    String[] data;// = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15"};

    GridView gvMain;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TABLE
        data = new String[ 1200 ];
        for (int i = 0; i < data.length; i++) {
            data[i] = "" + (i + 1);
        }
        adapter = new ArrayAdapter<String>(this, R.layout.layout_grid_01, R.id.tvText, data);
        gvMain = (GridView) findViewById(R.id.grid01);
        gvMain.setAdapter(adapter);
        adjustGridView();
    }

    public void button_call_click(View v){
        Toast.makeText(getApplicationContext(),"CALL",Toast.LENGTH_SHORT).show();
    }
    public void button_program_click(View v){
        Toast.makeText(getApplicationContext(),"PROGRAMS",Toast.LENGTH_SHORT).show();
    }
    public void button_go_click(View v){
        Toast.makeText(getApplicationContext(),"GO",Toast.LENGTH_SHORT).show();
    }


    private void adjustGridView() {
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            gvMain.setNumColumns(3);
        else
            gvMain.setNumColumns(5);
        gvMain.setVerticalSpacing(2);
        gvMain.setHorizontalSpacing(2);
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

        if (id == R.id.action_settings1){
            //OPEN NULL ACTIVITY
            Intent intent01 = new Intent(MainActivity.this, null_activity.class);
            startActivity(intent01);
        }

        return super.onOptionsItemSelected(item);
    }


}
