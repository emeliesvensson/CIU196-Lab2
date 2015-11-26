package com.example.emelie.bm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by emelie on 15-11-25.
 */
public class BookAdapter extends ArrayAdapter<Book> {
    SimpleBookManager bookManager;

    public BookAdapter(Context context, ArrayList<Book> books) {
        super(context, 0, books);
        bookManager=SimpleBookManager.getInstance(getContext());

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Book book = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_summary, parent, false);
        }
        // Lookup view for data population
        TextView nrOfBooks = (TextView) convertView.findViewById(R.id.nrOfBooks);
        TextView totalCost = (TextView) convertView.findViewById(R.id.totalCost);
        // Populate the data into the template view using the data object
        nrOfBooks.setText(String.valueOf(bookManager.count()));
        totalCost.setText(String.valueOf(bookManager.getTotalCost()));
        // Return the completed view to render on screen
        return convertView;
    }
}
