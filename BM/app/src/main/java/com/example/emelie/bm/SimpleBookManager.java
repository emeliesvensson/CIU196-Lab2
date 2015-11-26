package com.example.emelie.bm;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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
    public static String BOOKPREFERENCES;

    private static SimpleBookManager instance =null;
    private static Context context;


    protected SimpleBookManager() {
       bookList= new ArrayList<Book>();
        BOOKPREFERENCES = "MyPrefs";


       /* for (int i=0; i<5;i++){
            Book temp=createBook("A Andrews", "Tale of two cities", 100+i*i, "10387392","ABC123");

        }*/
    }

    public static SimpleBookManager getInstance(Context c ){
        if (instance==null){
            context=c;
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

         //context.getSharedPreferences(MyPREFERENCES, context.MODE_PRIVATE);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(bookList);
        editor.putString(BOOKPREFERENCES, json);
        editor.commit();

    }

    public void setBookList(ArrayList<Book> b){
        bookList=b;
    }

    public void load(Context context){
/*
        Gson gson =new Gson();
        String json2= sharedPreferences.getString(BOOKPREFERENCES,"");
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList <Book> simple = gson.fromJson(json2, type);*/

    }
}
