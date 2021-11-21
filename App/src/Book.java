package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Serializable {
    public String name;
    public String author;
    public int lastPage = 0;
    public int curPage = 0;
    public ArrayList<String> pages;

    public Book(String name, String author, ArrayList<String> pages){
        this.name = name;
        this.author = author;
        this.pages = pages;
    }

    public int countPage(){
        return pages.size()+1;
    }

    public void displayCurPage(){
        System.out.println(pages.get(this.curPage));
        System.out.println("<-----p             n----->");
    }
}
