package com.example.emelie.bm;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by emelie on 15-11-26.
 */
public class CollectionFragment extends Fragment  {

    private static final String ARG_BOOKMANAGER = "bookManager";
    private SimpleBookManager bookManager;
    ArrayAdapter<Book> bookAdapter;


    // TODO: Rename and change types and number of parameters
    public static CollectionFragment newInstance(SimpleBookManager bookManager) {
        CollectionFragment fragment = new CollectionFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_BOOKMANAGER,bookManager);
        fragment.setArguments(args);
        return fragment;
    }

    public CollectionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bookManager = SimpleBookManager.getInstance(getContext());
        View v = inflater.inflate(R.layout.fragment_collection, container, false);
        bookAdapter =new ArrayAdapter<Book>(getContext(),R.layout.activity_single_book,R.id.bookTitleText,bookManager.getAllBooks());

        final ListView listView = (ListView) v.findViewById(R.id.listViewBooks);
        listView.setAdapter(bookAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // String main = bookManager.getAllBooks().get(position).toString();
              //  Log.d("bookk", main);

                Intent i = new Intent("com.example.emelie.bm.SingleBook");
                i.putExtra("pos",position);
                startActivity(i);
            }
        });

        return v;
    }

    @Override
    public void onResume(){
        super.onResume();
        bookAdapter.notifyDataSetChanged();

    }
}
