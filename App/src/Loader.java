package com.company;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class Loader {

    //Загружает добавленные книги при старте программы
    public static boolean startLoad(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.dat")))
        {
            ArrayList<Book> loadBooks =(ArrayList<Book>)ois.readObject();
            BooksWindow.books = loadBooks;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    //Загружает новую книгу в коллекцию книг
    public static boolean load(String path, String tempName){
        char[] array = new char[250];
        String name;
        String author;
        ArrayList<String> pages = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path + tempName),10000);
            name = reader.readLine();
            author = reader.readLine();
            while ( reader.read(array) > 0)
            {
                pages.add(String.copyValueOf(array));
            }
            reader.close();
            BooksWindow.books.add(new Book(name, author, pages));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean saveBooks(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.dat")))
        {
            oos.writeObject(BooksWindow.books);
            return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public static void saveProps(String nameBook, int lastPage, String password){
        File file = new File("D:/University/ShaRead/");
        Properties props = new Properties();
        try {
            props.load(new FileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        props.setProperty("Name",nameBook);
        props.setProperty("LastPage",Integer.toString(lastPage));
        props.setProperty("Password", password);
    }
}
