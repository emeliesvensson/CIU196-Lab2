package com.example.emelie.bm;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class SummaryFragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  //  private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";
    private static final String ARG_BOOKMANAGER = "bookManager";

    TextView textnrOfBooks;
    TextView texttotalCost;
    TextView textexpensive;
    TextView textcheapest;
    TextView textaverage;

    // TODO: Rename and change types of parameters
    private SimpleBookManager bookManager;
   // private String mParam2;


    TextView myTextView;


    // TODO: Rename and change types and number of parameters
    public static SummaryFragment newInstance(SimpleBookManager bookManager) {
        SummaryFragment fragment = new SummaryFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_BOOKMANAGER,bookManager);
        fragment.setArguments(args);
        return fragment;
    }

    public SummaryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onResume(){
        super.onResume();
        updateTextViews();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         View v = inflater.inflate(R.layout.activity_summary, container, false);

         textnrOfBooks=((TextView) v.findViewById(R.id.nrOfBooks));
         texttotalCost=((TextView) v.findViewById(R.id.totalCost));
         textexpensive=((TextView) v.findViewById(R.id.expensive));
         textcheapest=((TextView) v.findViewById(R.id.cheapest));
         textaverage=((TextView) v.findViewById(R.id.average));

        if (getArguments() != null) {
            bookManager = (SimpleBookManager) getArguments().getSerializable(ARG_BOOKMANAGER);
            updateTextViews();



        }
      //  BookAdapter adapter = new BookAdapter(getContext(), bookManager.getAllBooks());
     //   RelativeLayout listView = (RelativeLayout) v.findViewById(R.id.summaryLayout);
        //listView.setAdapter(adapter);


        // Inflate the layout for this fragment
        return v;
    }

    public void updateTextViews(){
        textnrOfBooks.setText(String.valueOf(bookManager.count()));
        texttotalCost.setText(String.valueOf(bookManager.getTotalCost()));
        textexpensive.setText(String.valueOf(bookManager.getMaxPrice()));
        textcheapest.setText(String.valueOf(bookManager.getMinPrice()));
        textaverage.setText(String.valueOf(bookManager.getMeanPrice()));
    }





}
