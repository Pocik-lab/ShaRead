package com.company;

public class AchievementWindow extends Window {

    public AchievementWindow(String name, String title, Menu menu) {
        super(name, title, menu);
    }

    public boolean isReadNumPage(int count){
        int tmpCount = 0;
        for (Book i: BooksWindow.books ) {
            tmpCount += i.curPage;
        }
        return tmpCount >= count;
    }

    @Override
    public void display() {
        System.out.println("Прочитано 5 страниц: " + ((isReadNumPage(5) == true) ? "+" : "-"));
        super.display();
    }

    @Override
    public void save() {

    }
}
