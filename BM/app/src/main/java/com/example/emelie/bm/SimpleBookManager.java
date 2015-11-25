package com.example.emelie.bm;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import android.widget.TextView;



/**
 * Created by emelie on 15-11-05.
 */
public class SimpleBookManager implements BookManager,Serializable {
   private ArrayList<Book> bookList;
    SharedPreferences sharedPreferences;
    public static String MyPREFERENCES;

    private static SimpleBookManager instance =null;


    protected SimpleBookManager() {
       bookList= new ArrayList<Book>();
        MyPREFERENCES = "MyPrefs";
       /* for (int i=0; i<5;i++){
            Book temp=createBook("A Andrews", "Tale of two cities", 100+i*i, "10387392","ABC123");

        }*/
    }

    public static SimpleBookManager getInstance(){
        if (instance==null){
            instance=new SimpleBookManager();
        }
        return instance;
    }

    public int count(){
        return bookList.size();
    }
    public Book getBook(int index){
        return bookList.get(index);
    }

    public Book createBook(){
       Book temp=new Book();
        bookList.add(temp);
        return temp;
    }
    public Book createBook(String author, String title, int price, String isbn, String course){
        Book temp=new Book(author,title,price,isbn,course);
        bookList.add(temp);
        return temp;
    }

    public ArrayList<Book> getAllBooks(){
        return bookList;
    }
    public void removeBook(Book book){
        bookList.remove(book);
    }
    public void moveBook (int from, int to){
        //Book temp =bookList.get(to) ;
        //bookList.set(to,bookList.get(from));
        //bookList.set(from,temp);

        Book temp =bookList.get(from);
        bookList.remove(from);
        bookList.add(to, temp);
    }
    public int getMinPrice(){
        int min= Integer.MAX_VALUE;
        if(bookList.size()==0){
            min=0;
        }else{
            for (Book b:bookList) {
                if (b.getPrice() < min) {
                    min = b.getPrice();
                }
            }
        }
        return min;
    }
    public int getMaxPrice(){
        int max= Integer.MIN_VALUE;
        if (bookList.size()==0){
            max=0;
        }
        else{
            for (Book b:bookList) {
                if(b.getPrice()>max){
                    max= b.getPrice();
                }
            }
        }
        return max;
    }
    public float getMeanPrice(){
        if( bookList.size() !=0) {
            return getTotalCost() / bookList.size();
        }else{
            return 0;
        }
    }
    public int getTotalCost(){
        int total=0;
        for (Book b:bookList) {
            total+=b.getPrice();
        }
        return total;
    }
    public void saveChanges(Context context){

        sharedPreferences = context.getSharedPreferences(MyPREFERENCES, context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(bookList);
        editor.putString(MyPREFERENCES,json);
        editor.commit();

        UpdateSummaryView(context);





        //LOAD
        SharedPreferences sharedPreferences2;
        sharedPreferences2 = context.getSharedPreferences(MyPREFERENCES, context.MODE_PRIVATE);
        SharedPreferences.Editor editor2=sharedPreferences2.edit();
        Gson gson2=new Gson();

        String json2= sharedPreferences2.getString(MyPREFERENCES,"");
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList <Book> simple = gson2.fromJson(json2,type);
        Log.d("save", simple.toString());
    }

    public void UpdateSummaryView(Context context){


       // TextView nrOfBooksView = (TextView) ((Activity)context).findViewById(R.id.nrOfBooks);
       /* TextView totalCostView = (TextView) ((Activity)context).findViewById(R.id.totalCost);
        TextView expensiveView = (TextView) ((Activity)context).findViewById(R.id.expensive);
        TextView cheapestView = (TextView) ((Activity)context).findViewById(R.id.cheapest);
        TextView averageView = (TextView) ((Activity)context).findViewById(R.id.average);*/

      //  nrOfBooksView.setText(String.valueOf(count()));
       /* totalCostView.setText(String.valueOf(getTotalCost()));
        expensiveView.setText(String.valueOf(getMaxPrice()));
        cheapestView.setText(String.valueOf(getMinPrice()));
        averageView.setText(String.valueOf(getMeanPrice()));*/

/*
        if (getArguments() != null) {
            bookManager = (SimpleBookManager) getArguments().getSerializable(ARG_BOOKMANAGER);

            ((TextView) v.findViewById(R.id.nrOfBooks)).setText(String.valueOf(bookManager.count()));
            ((TextView) v.findViewById(R.id.totalCost)).setText(String.valueOf(bookManager.getTotalCost()));
            ((TextView) v.findViewById(R.id.expensive)).setText(String.valueOf(bookManager.getMaxPrice()));
            ((TextView) v.findViewById(R.id.cheapest)).setText(String.valueOf(bookManager.getMinPrice()));
            ((TextView) v.findViewById(R.id.average)).setText(String.valueOf(bookManager.getMeanPrice()));

        }*/
    }
}
