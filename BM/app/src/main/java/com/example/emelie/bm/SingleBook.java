package com.example.emelie.bm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SingleBook extends AppCompatActivity {

    SimpleBookManager bookManager;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deitail);
        bookManager=SimpleBookManager.getInstance(getApplicationContext());

        //int pos =savedInstanceState.getInt("pos");
         pos = getIntent().getIntExtra("pos",-1);

        ((TextView) findViewById(R.id.title)).setText(String.valueOf(bookManager.getAllBooks().get(pos).getTitle()));
        ((TextView) findViewById(R.id.author)).setText(String.valueOf(bookManager.getAllBooks().get(pos).getAuthor()));
        ((TextView) findViewById(R.id.isbn)).setText(String.valueOf(bookManager.getAllBooks().get(pos).getIsbn()));
        ((TextView) findViewById(R.id.course)).setText(String.valueOf(bookManager.getAllBooks().get(pos).getCourse()));
        ((TextView) findViewById(R.id.price)).setText(String.valueOf(bookManager.getAllBooks().get(pos).getPrice()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_single_book, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id==R.id.action_delete){
            bookManager.removeBook(bookManager.getBook(pos));
            bookManager.saveChanges(getApplicationContext());
            finish();
        }else if(id==R.id.action_edit){
            bookManager.getBook(pos);
            Intent i = new Intent("com.example.emelie.bm.EditBook");
            i.putExtra("pos",pos);
            startActivity(i);

            finish();
        }



        return super.onOptionsItemSelected(item);
    }
}
