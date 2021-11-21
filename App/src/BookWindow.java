package com.company;

import java.util.Scanner;

public class BookWindow extends Window{
    public Book curBook;

    public BookWindow(String title, String name, Menu menu,Book curBook){
        super(name,title,menu);
        this.curBook = curBook;
    }

    @Override
    public void display(){
        curBook.displayCurPage();
    }

    @Override
    public void save(){
    }

    public void changePage(){
        Scanner sc = new Scanner(System.in);
        String buff = sc.nextLine();
        while(true){
            if(buff.equals("n")){
                curBook.curPage += 1;
                break;
            }
            else if(buff.equals("p")){
                curBook.curPage -= 1;
                break;
            }
        }
    }

    @Override
    public void input(){
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        if(inp.equals("m")){
            this.save();
            menu.isActive = true;
        }
        else if(inp.equals("n") || inp.equals("p")){
            changePage();
            display();
        }
    }
}
