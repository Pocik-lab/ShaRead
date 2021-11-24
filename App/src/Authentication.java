package com.company;

import java.util.Scanner;

public class Authentication {
    private static String password = "mama";

    public static boolean enter(){
        System.out.println("Введите пароль:");

        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();

        return password.equals(Authentication.password);
    }
}

