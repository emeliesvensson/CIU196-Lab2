package com.example.emelie.bm;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class SummaryFragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  //  private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";
    private static final String ARG_BOOKMANAGER = "bookManager";

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         View v = inflater.inflate(R.layout.activity_summary, container, false);

        if (getArguments() != null) {
            bookManager = (SimpleBookManager) getArguments().getSerializable(ARG_BOOKMANAGER);
            updateTextViews(v);


        }




        // Inflate the layout for this fragment
        return v;
    }

    public void updateTextViews(View v){
        ((TextView) v.findViewById(R.id.nrOfBooks)).setText(String.valueOf(bookManager.count()));
        ((TextView) v.findViewById(R.id.totalCost)).setText(String.valueOf(bookManager.getTotalCost()));
        ((TextView) v.findViewById(R.id.expensive)).setText(String.valueOf(bookManager.getMaxPrice()));
        ((TextView) v.findViewById(R.id.cheapest)).setText(String.valueOf(bookManager.getMinPrice()));
        ((TextView) v.findViewById(R.id.average)).setText(String.valueOf(bookManager.getMeanPrice()));
    }





}
