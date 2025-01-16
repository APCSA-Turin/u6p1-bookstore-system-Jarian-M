package com.example.project;

import java.util.Scanner; // Imports the scanner class needed for the interface

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
        int ind2 = 0;
        for(int i = 0; i < books.length; i++) {
            int ind = i;
            if(books[i] == book) {
                books[i].setQuantity(books[i].getQuantity() - 1);
                if(books[i].getQuantity() == 0) {
                    Book[] temp = new Book[books.length - 1];
                    for(int j = 0; j < ind; j++) {
                        temp[ind2] = books[j];
                        ind2++;
                    }
                    for(int k = ind + 1; k < books.length; k++) {
                        temp[ind2] = books[k];
                        ind2++;
                    }
                    books = temp;
                }
            }
        }
    }

    public Book findBook(Book find) {
        Book findBook = null;
        for(Book look: books) {
            if(look == find) {
                findBook = look;
            }
        }
        return findBook;
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

    public static void main(String[] args) {
        String title = "******************Welcome to the GFG Library!******************\n";
        title += "              Select From The Following Options:               \n";
        title += "***************************************************************\n";
        String menu = "\n---------------------------------------------------------------\n";
        menu += "Press 0 to Exit Application.\n";
        menu += "Press 1 to Add new Book.\n";
        menu += "Press 2 to Upgrade Quantity of a Book.\n";
        menu += "Press 3 to Search a Book.\n";
        menu += "Press 4 to Show All Books.\n";
        menu += "Press 5 to Register Student.\n";
        menu += "Press 6 to Show All Registered Students.\n";
        menu += "Press 7 to Check Out Book.\n";
        menu += "Press 8 to Check In Book.\n";
        menu += "\n---------------------------------------------------------------\n";
        Scanner scan = new Scanner();
        int choice = scan.nextInt();
        if(choice == 0) {
            break;
        } else if(choice == 1) {
            System.out.print("Enter Book Title: ");
            String bookTitle = scan.next();
            System.out.print("Enter the Author's Name: ");
            String author = scan.next();
            System.out.print("Enter the Year it was Published: ");
            String year = scan.nextInt();
            System.out.print("Enter Book ISBN: ");
            String bookIsbn = scan.next();
            System.out.print("Enter Book Quantity: ");
            String quant = scan.nextInt();
            Book newBook = new Book(bookTitle, author, year, bookIsbn, quant);
            bookStore.addBook(newBook);
            System.out.println("The Book has been added successfully!");
            System.out.println(menu);
            choice = scan.nextInt();
        } else if(choice == 2) {
            System.out.println("Enter the Title of the Book you want to Remove: ");
            String remove = scan.next();
            Book bookRemoved = bookStore.findBook(remove);
            if(bookRemoved != null) {
                bookStore.removeBook(bookRemoved);
                System.out.println("The Book has been removed successfully!");
                System.out.println(menu);
                choice = scan.nextInt();
            } else {
                System.out.println("The Book was not Found!");
                System.out.println(menu);
                choice = scan.nextInt();
            }
        } else if(choice == 3) {
            System.out.print("Enter Position of the Book in the catalog: ");
            int index = scan.nextInt();
            System.out.print("Eneter the Book Title: ");
            String insertTitle = scan.next();
            System.out.print("Enter Author Name: ");
            String insertAuthor = scan.next();
            System.out.print("Enter the Year the Book was Published: ");
            int insertYear = scan.next();
            System.out.print("Enter the Book's ISBN: ");
            String insertIsbn = scan.next();
            System.out.print("Enter the Book's Quantity: ");
            
        } else if(choice == 4) {
            
        } else if(choice == 5) {
            
        } else if(choice == 6) {
            
        } else if(choice == 7) {
            
        } else if(choice == 8) {
            
        }
        

    }

}