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
            if(users[i] == user) {
                users[i] = null;
            }
        }
        consolidateUsers();
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
        users = temp;
    }

    public void addBook(Book book) {
        if(books == null) {
            books = new Book[1];
            books[0] = book;
        } else {
            Book[] newBooks = new Book[books.length + 1];
            for(int i = 0; i < books.length; i++) {
                newBooks[i] = books[i];
            }
            newBooks[books.length] = book;
            books = newBooks;
        }
    }

    public void insertBook(Book book, int index) {
        Book[] newBooks = new Book[books.length + 1];
        for(int i = 0; i < index; i++) {
            newBooks[i] = books[i];
        }
        newBooks[index] = book;
        int k = index;
        for(int j = index + 1; j < books.length + 1; j++) {
            newBooks[j] = books[k];
            k++;
        }
        books = newBooks;

    }

    public void removeBook(Book book) {
        for(int i = 0; i < books.length; i++) {
            int ind = i;
            if(books[i] == book) {
                books[i].setQuantity(books[i].getQuantity() - 1);
                if(books[i].getQuantity() == 0) {
                    for(int j = ind; j < books.length - 1; j++) {
                        books[j] = books[j + 1];
                    }
                }
            }
        }
    }
       
    public String bookStoreBookInfo() {
        StringBuilder info = new StringBuilder();
        for(Book book: books) {
            if(book != null) {
                info.append(book.bookInfo()).append("\n");
            }
        }
        return info.toString();
    } //you are not tested on this method but use it for debugging purposes

    public String bookStoreUserInfo() {
        StringBuilder info = new StringBuilder();
        for(User user: users) {
            if(user != null) {
                info.append(user.userInfo()).append("\n");
            }
        }
        return info.toString();
    } //you are not tested on this method but use it for debugging purposes

}