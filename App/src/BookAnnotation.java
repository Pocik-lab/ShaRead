package com.company;

import java.io.Serializable;
import java.util.Scanner;

public class BookAnnotation implements Serializable {
    String name;
    String text;

    BookAnnotation(String name, String text){
        this.name = name;
        this.text = text;
    }

    public void display(){
        System.out.println("-----   " + name + "   -----");
        System.out.println(text);
    }

}
