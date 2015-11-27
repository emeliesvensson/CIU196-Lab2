package com.example.emelie.bm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class EditBook extends AppCompatActivity {
int pos;
    SimpleBookManager bookManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_book, menu);
        pos = getIntent().getIntExtra("pos",-1);
        bookManager= SimpleBookManager.getInstance(getApplicationContext());

        ((EditText) findViewById(R.id.titleInput)).setText(String.valueOf(bookManager.getAllBooks().get(pos).getTitle()));
        ((EditText) findViewById(R.id.authorInput)).setText(String.valueOf(bookManager.getAllBooks().get(pos).getAuthor()));
        ((EditText) findViewById(R.id.isbnInput)).setText(String.valueOf(bookManager.getAllBooks().get(pos).getIsbn()));
        ((EditText) findViewById(R.id.courseInput)).setText(String.valueOf(bookManager.getAllBooks().get(pos).getCourse()));
        ((EditText) findViewById(R.id.priceInput)).setText(String.valueOf(bookManager.getAllBooks().get(pos).getPrice()));

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
            if (((EditText) findViewById(R.id.titleInput)).getText().toString().equals("")){
                Toast toast = Toast.makeText(getApplicationContext(), "You have to fill in the title", Toast.LENGTH_SHORT);
                toast.show();
            }
            else if (((EditText) findViewById(R.id.priceInput)).getText().toString().equals("")){
                Toast toast = Toast.makeText(getApplicationContext(), "You have to fill in the price", Toast.LENGTH_SHORT);
                toast.show();
            }
            else{
                String author =((EditText) findViewById(R.id.authorInput)).getText().toString();
                String title=((EditText) findViewById(R.id.titleInput)).getText().toString();
                int price=Integer.parseInt(((EditText) findViewById(R.id.priceInput)).getText().toString());
                String isbn=((EditText) findViewById(R.id.isbnInput)).getText().toString();
                String course=((EditText) findViewById(R.id.courseInput)).getText().toString();
                bookManager.createBook(author, title, price, isbn, course);

                bookManager.moveBook(bookManager.getAllBooks().size() - 1, pos);
                bookManager.removeBook(bookManager.getBook(pos+1));

                bookManager.saveChanges(getApplicationContext());

                finish();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
