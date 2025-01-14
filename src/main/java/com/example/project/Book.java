package com.example.project;

public class Book{
    //requires 5 attributes String title, String author, int yearPublished, String isbn, int quantity

    private String title;
    private String author;
    private int yearPublished;
    private String isbn;
    private int quantity;

    //requires 1 constructor with 5 arguments that intitialize the attribtues of the class.

    public Book(String title, String author, int yearPublished, String isbn, int quantity) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String newAuth) {
        author = newAuth;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int newYear) {
        yearPublished = newYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String newIsbn) {
        isbn = newIsbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int newQuant) {
        quantity = newQuant;
    }

    //returns "Title: [], Author: [], Year: [], ISBN: [], Quantity: []"

    public String bookInfo() {
        String bookInfo = "Title: " + title + ", Author: " + author + ", Year: " + yearPublished + ", ISBN: " + ", Quantity: " + quantity;
        return bookInfo;
    } 
       
}