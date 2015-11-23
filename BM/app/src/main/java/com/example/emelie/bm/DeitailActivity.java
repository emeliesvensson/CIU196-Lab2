package com.example.emelie.bm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DeitailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deitail);
        SimpleBookManager simpleBookManager =new SimpleBookManager();
        Log.d("book", "created book in detail");
        ((TextView) findViewById(R.id.title)).setText(simpleBookManager.getBook(0).getTitle());
        ((TextView) findViewById(R.id.author)).setText(simpleBookManager.getBook(0).getAuthor());
        ((TextView) findViewById(R.id.course)).setText(simpleBookManager.getBook(0).getCourse());
        ((TextView) findViewById(R.id.price)).setText(String.valueOf(simpleBookManager.getBook(0).getPrice()));
        ((TextView) findViewById(R.id.isbn)).setText(simpleBookManager.getBook(0).getIsbn());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_deitail, menu);
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
