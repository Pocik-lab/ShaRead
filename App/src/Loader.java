package com.company;

import java.io.*;
import java.util.ArrayList;

public class Loader {

    private static final String annFile = "ann.dat";
    private static final String booksFile = "book.dat";

    //Загружает добавленные книги
    public static boolean loadListBook(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(booksFile)))
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

    //Загружает добавленные аннотации
    public static boolean loadListAnnotation(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(annFile)))
        {
            ArrayList<BookAnnotation> loadAn =(ArrayList<BookAnnotation>)ois.readObject();
            AnnotationsWindow.annotations = loadAn;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    //Загружает новую книгу в коллекцию книг
    public static boolean loadBook(String path){
        String name;
        String author;
        ArrayList<String> pages = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path),10000);
            name = reader.readLine();
            author = reader.readLine();
            int maxLine = 40;
            boolean endRead = false;
            while (!endRead){
                String tmpPage = new String("");
                for(int i = 0; i < maxLine; i = i + 1){
                    String newPartPage = reader.readLine();
                    if(newPartPage == null){
                        endRead = true;
                        break;
                    }
                    tmpPage = String.join("\n", tmpPage, newPartPage);
                }
                pages.add(tmpPage);
            }
            reader.close();
            BooksWindow.books.add(new Book(name, author, pages));
        } catch (IOException e) {
            System.out.println("Файл не найден\n");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean saveBooks(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(booksFile)))
        {
            oos.writeObject(BooksWindow.books);
            return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean saveAnnotation(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(annFile)))
        {
            oos.writeObject(AnnotationsWindow.annotations);
            return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}
