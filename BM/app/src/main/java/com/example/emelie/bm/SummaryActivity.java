package com.example.emelie.bm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.Serializable;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        SimpleBookManager simpleBookManager =new SimpleBookManager();
        Log.d("book", "created book in summary");
        ((TextView) findViewById(R.id.nrOfBooks)).setText(String.valueOf(simpleBookManager.count()));
        ((TextView) findViewById(R.id.totalCost)).setText(String.valueOf(simpleBookManager.getTotalCost()));
        ((TextView) findViewById(R.id.expensive)).setText(String.valueOf(simpleBookManager.getMaxPrice()));
        ((TextView) findViewById(R.id.cheapest)).setText(String.valueOf(simpleBookManager.getMinPrice()));
        ((TextView) findViewById(R.id.average)).setText(String.valueOf(simpleBookManager.getMeanPrice()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_summary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
