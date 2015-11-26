package com.example.emelie.bm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class NewBook extends AppCompatActivity {
  EditText mTitle;
    EditText mAuthor;
    EditText mIsbn;
    EditText mPrice;
    EditText mCourse;

    SimpleBookManager bookmanager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);
        mTitle= (EditText)findViewById(R.id.titleInput);
        mAuthor=(EditText)findViewById(R.id.authorInput);
        mIsbn=(EditText)findViewById(R.id.isbnInput);
        mPrice=(EditText)findViewById(R.id.priceInput);
        mCourse=(EditText)findViewById(R.id.courseInput);
        bookmanager =SimpleBookManager.getInstance(getApplicationContext());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_book, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {
            Log.d("save", "saved");
            if (!mTitle.getText().toString().equals("")) {
                //savechanges
                String author =mAuthor.getText().toString();
                String title=mTitle.getText().toString();
                int price=Integer.parseInt(mPrice.getText().toString());
                String isbn=mIsbn.getText().toString();
                String course=mCourse.getText().toString();
                bookmanager.createBook(author, title, price, isbn, course);

               bookmanager.saveChanges(getApplicationContext());

                finish();
            }else{
                Toast toast = Toast.makeText(getApplicationContext(), "The title is empty", Toast.LENGTH_SHORT);
                toast.show();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
