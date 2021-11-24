package com.company;

public class Authentication {
    private static String password = "mama";

    public static boolean enter(){
        System.out.println("Введите пароль:");
        String password = Controller.sc.nextLine();
        return password.equals(Authentication.password);
    }
}
