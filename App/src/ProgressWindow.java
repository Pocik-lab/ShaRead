package com.company;

public class ProgressWindow extends Window {

    public ProgressWindow(String name, String title, Menu menu) {
        super(name, title, menu);
    }

    public int readCountPages(){
        int count = 0;
        for (Book i: BooksWindow.books ) {
            count = count + i.curPage;
        }
        return count;
    }

    public int readCountBook(){
        int count = 0;
        for (Book i: BooksWindow.books) {
            if(i.curPage == (i.countPage()-1) ) //Тоже говно
                count++;
        }
        return count;
    }

    @Override
    public void display() {
        System.out.println("Прочитано страниц: " + readCountPages());
        System.out.println("Прочитано книг: " + readCountBook());
        super.display();
    }

    @Override
    public void save() {

    }
}
