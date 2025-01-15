package com.example.project;

public class User{
    //requires 3 private attributes String name, String Id, Book[] book that is initialized to empty
    private String name;
    private String Id;
    private Book[] books = new Book[5];

    //requires 1 contructor with two parameters that will initialize the name and id

    public User(String name, String Id) {
        this.name = name;
        this.Id = Id;
    }
 
    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String newId) {
        Id = newId;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] newBook) {
        books = newBook;
    }

    //returns a booklist for the user, if empty, output "empty"
    public String bookListInfo() {
        String bookList = "";
        for(int i = 0; i < books.length; i++) {
            if(books[i] != null) {
                bookList += "\n" + books[i].bookInfo();
            } else {
                bookList += "\nempty";
            }

        }
        return bookList;
    } 

    //returns  "Name: []\nID: []\nBooks:\n[]"

    public String userInfo() {
        String info = "Name: " + name + "\nId: " + Id + "\nBooks: " + bookListInfo() + "\n";
        return info;
    } 
       
}