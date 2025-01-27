package com.example.project;

public class Book{
    //requires 5 attributes String title, String author, int yearPublished, String isbn, int quantity

    private String title; //a private String variable title that represents the book's title
    private String author; //a private String variable author that represents the book's author
    private int yearPublished; //a private int variable yearPublished that represents the year that the book was published
    private String isbn; //a private String variable isbn that represents the book's isbn
    private int quantity; //a private int variable quantity that represents the available quantity of the book

    //requires 1 constructor with 5 arguments that intitialize the attribtues of the class.

    public Book(String title, String author, int yearPublished, String isbn, int quantity) { //a constructor that initializes the values of the instance variables to the values of the arguements in the constructor
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title; //a String method that returns the title of the book
    }

    public void setTitle(String newTitle) {
        title = newTitle; //a void method that sets the title of the book to a new title
    }

    public String getAuthor() {
        return author; //a String method that returns the author of the book
    }

    public void setAuthor(String newAuth) {
        author = newAuth; //a void method that sets the author of the book to a new author
    }

    public int getYearPublished() {
        return yearPublished; //an int method that returns the year that the book was published
    }

    public void setYearPublished(int newYear) {
        yearPublished = newYear; //a void method that sets the year of publication of the book to a new year of publication
    }

    public String getIsbn() {
        return isbn; //a String method that returns the isbn of the book
    }

    public void setIsbn(String newIsbn) {
        isbn = newIsbn; //a void method that sets the isbn of the book to a new isbn
    }

    public int getQuantity() {
        return quantity; //an int method that returns the available quantity of the book
    }

    public void setQuantity(int newQuant) {
        quantity = newQuant; //a void method that sets the available quantity of the book to a new quantity
    }

    //returns "Title: [], Author: [], Year: [], ISBN: [], Quantity: []"

    public String bookInfo() { //a String method that returns the title, author, year of publication, isbn, and quantity of the book repectively
        String bookInfo = "Title: " + title + ", Author: " + author + ", Year: " + yearPublished + ", ISBN: " + isbn + ", Quantity: " + quantity;
        return bookInfo;
    } 
       
}