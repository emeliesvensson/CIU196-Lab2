package com.example.emelie.bm;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by emelie on 15-11-05.
 */
public class SimpleBookManager implements BookManager,Serializable {
   private ArrayList<Book> bookList;

    public SimpleBookManager() {
       bookList= new ArrayList<Book>();
        for (int i=0; i<5;i++){
            Book temp=createBook("A Andrews", "Tale of two cities", 100+i*i, "10387392","ABC123");

        }
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
        for (Book b:bookList) {
            if(b.getPrice()>max){
                max= b.getPrice();
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
    public void saveChanges(){}
}
