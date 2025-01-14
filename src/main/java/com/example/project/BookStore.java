package com.example.project;

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 

    private Book[] books;
    private User[] users = new User[10];

    //requires 1 empty constructor

    public BookStore() {}

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] newUsers) {
        users = newUsers;
    }

    public Book[] getBooks() {
        return books;
    }

    public void addUser(User user) {
        int i = 0;
        while(users[i] != null) {
            i++;
        }
        users[i] = user;
    } 

    public void removeUser(User user) {
        for(int i = 0; i < users.length; i++) {
            if(users[i].getName().equals(user.getName())) {
                users[i] = null;
            }
        }
    }

    public void consolidateUsers() {
        int ind = 0;
        User[] temp = new User[users.length];
        for(User user: users) {
            if(user != null) {
                temp[ind] = user;
                ind++;
            }
        }
    }

    public void addBook(Book book) {
        int i = 0;
        while(books[i] != null) {
            i++;
        }
        books[i] = book;
    }

    public void insertBook(Book book, int index) {
        if(index >= 0 && index < books.length) {
            books[index] = book;
        } else {
            System.out.println("The index is Out of Bounds!");
        }
    }

    public void removeBook(Book book) {
        for(int i = 0; i < books.length; i++) {
            if(books[i].getTitle().equals(book.getTitle())) {
                users[i] = null;
            }
        }
    }

    public String BookStoreInfo() {
        String bookStore = "";
        for(int i = 0; i < books.length; i++) {
            bookStore += books[i].bookInfo();
        }
        return bookStore;
    }
       
    //public String bookStoreBookInfo(){} //you are not tested on this method but use it for debugging purposes

    //public String bookStoreUserInfo(){} //you are not tested on this method but use it for debugging purposes

}