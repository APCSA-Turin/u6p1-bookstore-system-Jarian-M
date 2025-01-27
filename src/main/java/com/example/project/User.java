package com.example.project;

public class User{
    //requires 3 private attributes String name, String Id, Book[] book that is initialized to empty
    private String name; //a private String variable name that represents the name of the user
    private String Id; //a private String variable Id that represents the ID of the user
    private Book[] books = new Book[5]; //a private Book[] variable books that represents the list of books that a user can check out, with a max of 5 books at a time

    //requires 1 contructor with two parameters that will initialize the name and id

    public User(String name, String Id) { //a constructor that initializes the values of the instance variables to the values of the arguments in the constructor
        this.name = name;
        this.Id = Id;
    }
 
    public String getName() {
        return name; //a String method that returns the name of the user
    }

    public void setName(String newName) {
        name = newName; //a void method that sets the name of the user to a new name
    }

    public String getId() {
        return Id; //a String method that returns the ID of the user
    }

    public void setId(String newId) {
        Id = newId; //a void method that sets the ID of the user to a new ID
    }

    public Book[] getBooks() {
        return books; //a Book[] method that returns the list of books that the user can check out at once, with a maximum of 5 at a time
    }

    public void setBooks(Book[] newBook) {
        books = newBook; //a void method that sets the list of books that the user can check out at once to a new list of books, which is the value of the argument of the method's parameter
    }

    //returns a booklist for the user, if empty, output "empty"
    public String bookListInfo() { //a String method that returns the information of each book in the list of books that the user can borrow at a time
        String bookList = "";
        for(int i = 0; i < books.length; i++) {
            if(books[i] != null) { //for each element in the list of books that a user can borrow at a time, if the element is not empty, the information of the book is concatenated to bookList
                bookList += "\n" + books[i].bookInfo();
            } else { //for each element in the list of books that a user can borrow at a time, if the element is empty, "empty" is concatenated to bookList
                bookList += "\nempty";
            }

        }
        return bookList;
    } 

    //returns  "Name: []\nID: []\nBooks:\n[]"

    public String userInfo() { //a String method that returns the information of the user, including their name, ID, and each of the books they have borrowed out of the 5 books they can borrow at a time, returning empty if no book has been borrowed
        String info = "Name: " + name + "\nId: " + Id + "\nBooks: " + bookListInfo() + "\n";
        return info;
    } 
       
}