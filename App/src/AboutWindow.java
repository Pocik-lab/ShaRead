package com.company;

public class AboutWindow extends Window {

    private String aboutApp = "ShaRead Inc.";
    private String year = "©2021";
    private String version = "0.2";

    public AboutWindow(String name, String title, Menu menu) {
        super(name, title, menu);
    }

    @Override
    public void display() {
        System.out.println(aboutApp);
        System.out.println("version " + version);
        System.out.println(year + "\n");
        super.display();
    }

    @Override
    public void save() {
    }
}
