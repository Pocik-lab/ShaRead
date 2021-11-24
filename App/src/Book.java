package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Serializable {
    public String name;
    public String author;
    public int curPage = 0;
    public ArrayList<String> pages;

    public Book(String name, String author, ArrayList<String> pages){
        this.name = name;
        this.author = author;
        this.pages = pages;
    }

    public int countPage(){
        return pages.size();
    }

    public void displayCurPage(){
        System.out.println(pages.get(this.curPage));
        if(curPage > 0 && curPage < countPage() - 1)
            System.out.println("\n<-----p             n----->");
        else if(countPage() == 1)
            System.out.println();
        else if(curPage == 0)
            System.out.println("\nn----->");
        else
            System.out.println("\n<-----p");
    }
}
