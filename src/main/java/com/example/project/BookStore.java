package com.example.project;

import java.util.Scanner; // Imports the scanner class needed for the interface

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 

    private Book[] books; //a private Book[] variable books that represents the list of books available in the Book Store
    private User[] users = new User[10]; //a private User[] variable users that represents the list of Users registered in the Book Store, with a maximum of 10

    //requires 1 empty constructor

    public BookStore() {}

    public User[] getUsers() {
        return users; //a User[] method that returns the list of users that are registered in the Book Store
    }

    public void setUsers(User[] newUsers) {
        users = newUsers; //a void method that sets the list of users that are registered in the Book Store to a new list of users
    }

    public Book[] getBooks() {
        return books; //a Book[] method that returns the list of books that are available in the Book Store
    }

    public void addUser(User user) { //adds a new user to the list of users that are registered in the Book Store
        int i = 0;
        while(users[i] != null) { //skips through the list of registered users in the Book Store until there is an empty space
            i++;
        }
        users[i] = user; //adds user to users on the index of the empty space
    } 

    public void removeUser(User user) { //removes a user from the list of users that are registered in the Book Store
        for(int i = 0; i < users.length; i++) {
            if(users[i] == user) { //if the user being removed is found in the list of registered users, the element at the index where the user being removed was found is set to null
                users[i] = null;
            }
        }
        consolidateUsers(); //moves all the elements in users so that there are no null elements in between users
    }

    public User findUser(String id) { //finds a user from the list of registered users
        User findUser = null;
        for(int i = 0; i < users.length; i++) {
            if(users[i] != null) { //if the element at the index i is not null, if the id of the user at the index i is equal to the id inputted in the parameter as an argument, the user at the index i is returned.
                if(users[i].getId().equals(id)) {
                    findUser = users[i];
                }
            }
        }
        return findUser; //returns the user being searched for
    }

    public void consolidateUsers() { //moves all the users in the list of registered users so that there are no null elements in between users
        int ind = 0;
        User[] temp = new User[users.length]; //creates a new User[] variable temp of the same length as users
        for(User user: users) {
            if(user != null) { //for each element in users, if the element is not null, the element is added to temp at the index ind and ind is incremented by 1
                temp[ind] = user;
                ind++;
            }
        }
        users = temp; //users is set to the value of temp, which has been consolidated so that no null elements are in between users in the list
    }

    public void addBook(Book book) { //adds a book to the list of available books in the Book Store
        if(books == null) { //initializes books to a new Book[] variable of length 1 if books is equal to null, and sets books at index 0 to book
            books = new Book[1];
            books[0] = book;
        } else {
            Book[] newBooks = new Book[books.length + 1]; //initializes newBooks to a new Book[] variable of the length of books + 1
            for(int i = 0; i < books.length; i++) {
                newBooks[i] = books[i]; //each element of newBooks is set to the elements of books at the corresponding indexes
            }
            newBooks[books.length] = book; //sets the last element of newBooks to book
            books = newBooks; //sets books to newBooks
        }
    }

    public void insertBook(Book book, int index) { //inserts a book into the list of available books in the Book Store, moving books after it to the right
        Book[] newBooks = new Book[books.length + 1]; //initializes newBooks to a new Book[] variable of the length of books + 1
        for(int i = 0; i < index; i++) {
            newBooks[i] = books[i]; //each element of newBooks is set to the elements of books at the corresponding indexes
        }
        newBooks[index] = book; //the element at index index of newBooks is set to book
        int k = index;
        for(int j = index + 1; j < books.length + 1; j++) {
            newBooks[j] = books[k]; //all the books in books from the index index to the length of the array is added to newBooks at their original index + 1 to account for book being inserted
            k++;
        }
        books = newBooks; //books is set to newBooks

    }

    public void removeBook(Book book) { //removes a book from the list of available books in the Book Store
        int ind2 = 0;
        for(int i = 0; i < books.length; i++) {
            int ind = i;
            if(books[i] == book) { //if book is found in the list of books in the Book Store, the quantity of the book is decremented by 1
                books[i].setQuantity(books[i].getQuantity() - 1);
                if(books[i].getQuantity() == 0) { //if the book's quantity reaches 0, the book is removed from the list of books
                    Book[] temp = new Book[books.length - 1];
                    for(int j = 0; j < ind; j++) { //the elements in temp, up to the index ind of the book that was removed, is set to the corresponding elements in books and ind2 is incremented by 1
                        temp[ind2] = books[j];
                        ind2++;
                    }
                    for(int k = ind + 1; k < books.length; k++) { //the rest of the elements in temp are set to the elements in books from index ind + 1 to books.length - 1
                        temp[ind2] = books[k];
                        ind2++;
                    }
                    books = temp; //books is set to temp
                }
            }
        }
    }

    public Book findBook(String find) { //finds a book in the list of books in the Book Store
        Book findBook = null;
        for(Book look: books) {
            if(look.getTitle().equals(find)) { //for each book in the list of books, if the title is equal to the title of the book being searched, findBook is set to look
                findBook = look;
            }
        }
        return findBook;
    }
       
    public String bookStoreBookInfo() { //returns the information of each book in the list of books in the Book Store
        StringBuilder info = new StringBuilder();
        for(Book book: books) { //for every book in the list of books in the Book Store, if the book is not null, concatenate the information of the book to info and move to the next line
            if(book != null) {
                info.append(book.bookInfo()).append("\n");
            }
        }
        return info.toString();
    } //you are not tested on this method but use it for debugging purposes

    public String bookStoreUserInfo() { //returns the information of each user registered in the Book Store
        StringBuilder info = new StringBuilder();
        for(User user: users) { //for every user in the list of registered users, if the user is not null, concatenate the information of the user to info and move to the next line
            if(user != null) {
                info.append(user.userInfo()).append("\n");
            }
        }
        return info.toString();
    } //you are not tested on this method but use it for debugging purposes

    public static void main(String[] args) {
        String title = "*************Welcome to the Awesome Sauce Library!*************\n";
        title += "              Select From The Following Options:               \n";
        title += "***************************************************************\n";
        System.out.print(title); //outputs the title of the Book Store
        String menu = "\n---------------------------------------------------------------\n";
        menu += "\nPress 0 to Exit Application.\n";
        menu += "Press 1 to Add new Book.\n";
        menu += "Press 2 to Remove a Book.\n";
        menu += "Press 3 to Insert a Book.\n";
        menu += "Press 4 to Show All Books.\n";
        menu += "Press 5 to Register a User.\n";
        menu += "Press 6 to Remove a User.\n";
        menu += "Press 7 to Show All Registered Users.\n";
        menu += "Press 8 to Check In a Book.\n";
        menu += "Press 9 to Check Out a Book.\n";
        menu += "\n---------------------------------------------------------------";
        System.out.println(menu); //outputs the menu of the Book Store UI
        BookStore bookStore = new BookStore();
        Scanner scan = new Scanner(System.in); //adds a scanner
        int choice = scan.nextInt(); //scans for the user's choice for the UI menu
        scan.nextLine();
        while(choice != 0) { //loops until the user's choice is equal to 0
            if(choice == 1) { //adds a new book to the list of books in the Book Store when the user enters 1
                System.out.println("If there are any spaces, use a \"_\" instead!");
                System.out.println("For the Author's name, if there are multiple words use Last Name,FirstName format- Please disregard the space after the comma!)");
                System.out.print("Enter Book Title: ");
                String bookTitle = scan.nextLine();

                System.out.print("Enter the Author's Name: ");
                String bookAuthor = scan.nextLine();

                System.out.print("Enter the Year it was Published: ");
                int year = scan.nextInt();
                scan.nextLine();

                System.out.print("Enter Book ISBN: ");
                String bookIsbn = scan.nextLine();

                System.out.print("Enter Book Quantity: ");
                int quant = scan.nextInt();
                scan.nextLine();

                Book newBook = new Book(bookTitle, bookAuthor, year, bookIsbn, quant); //initializes the Book variable newBook to a new Book with values in the parameter that the user has entered
                bookStore.addBook(newBook); //adds newBook to the list of books in the Book Store
                System.out.println("The Book has been added successfully!");
                System.out.println(menu);
                choice = scan.nextInt(); //asks the user to choose from the menu again
                scan.nextLine();
            } else if(choice == 2) { //removes a book from the list of books in the Book Store if the user enters 2
                System.out.println("Enter the Title of the Book you want to Remove: ");
                String remove = scan.next();
                Book bookRemoved = bookStore.findBook(remove); //initializes the Book variable bookRemoved to the value of searching through the list of books for the title of the book being removed, setting it to the value of the book if found in the list and null otherwise
                if(bookRemoved != null) {
                    bookRemoved.setQuantity(1); //sets the quantity of bookRemoved to 1 so that when it is removed from the list of books in Book Store, the book's quantity reaches 0 and the book is removed completely from the list of books
                    bookStore.removeBook(bookRemoved);
                    System.out.println("The Book has been removed successfully!");
                } else {
                    System.out.println("The Book was not Found!"); //the book isn't removed because it wasn't found in the list of books
                }
                System.out.println(menu);
                choice = scan.nextInt();
                scan.nextLine();
            } else if(choice == 3) { //inserts a book into the list of books if the user enters 3
                System.out.print("Enter Position of the Book in the catalog: ");
                int index = scan.nextInt();
                scan.nextLine();
                System.out.print("Enter the Book Title: ");
                String insertTitle = scan.next();
                System.out.print("Enter Author Name: ");
                String insertAuthor = scan.next();
                System.out.print("Enter the Year the Book was Published: ");
                int insertYear = scan.nextInt();
                scan.nextLine();
                System.out.print("Enter the Book's ISBN: ");
                String insertIsbn = scan.next();
                System.out.print("Enter the Book's Quantity: ");
                int insertQuant = scan.nextInt();
                scan.nextLine();
                Book insertedBook = new Book(insertTitle, insertAuthor, insertYear, insertIsbn, insertQuant); //sets the Book variable insertedBook to a new Book with the values in the parameters equal to the values set by the user
                bookStore.insertBook(insertedBook, index); //the book being inserted is inserted into the list of books in the Book Store at the index index, which was inputted by the user
                System.out.println("The Book has been inserted successfully!");
                System.out.println(menu);
                choice = scan.nextInt();
                scan.nextLine();
            } else if(choice == 4) { //outputs the information of the list of books if the user enters 4
                System.out.println("Books in the Store: ");
                System.out.println(bookStore.bookStoreBookInfo()); //prints the information of each book in the list of books
                System.out.println(menu);
                choice = scan.nextInt();
                scan.nextLine();
            } else if(choice == 5) { //adds a new user to the list of registered users in the Book Store if the user chooses 5
                System.out.print("Enter User Name: ");
                String userName = scan.next();
                String newUserId = IdGenerate.getCurrentId(); //sets the new user's ID to the current ID
                User newUser = new User(userName, newUserId); //initializes the User variable newUser to a new User with parameter value of name set to the value inputted by the user and the parameter value ID set to the current ID
                bookStore.addUser(newUser); //newUser is added to the list of registered users
                System.out.println("The new User has been registered successfully!\nNew User's ID: " + newUserId);
                IdGenerate.generateID(); //a new ID is generated
                System.out.println(menu);
                choice = scan.nextInt();
            } else if(choice == 6) { //a user is removed from the list of registered users if the user enters 6
                System.out.print("Enter the User ID of the User that you want to remove: ");
                String userRemoveId = scan.next();
                User userToRemove = bookStore.findUser(userRemoveId); //initializes the User variable userToRemove to the value of the user in the list of registered users with the same ID as userRemoveId, inputted by the user, and sets userToRemove to null otherwise
                if(userToRemove != null) {
                    bookStore.removeUser(userToRemove); //removes userToRemove from the list of registered users
                    System.out.println("The User has been removed successfully!");
                } else {
                    System.out.println("The User wasn't found in our database!"); //doesn't remove the user from the list of registered users because the user wasn't found in the list of registered users
                }
                System.out.println(menu);
                choice = scan.nextInt();
                scan.nextLine();
            } else if(choice == 7) { //outputs the information of the list of registered users if the user enters 7
                System.out.println("Registered Users: \n");
                System.out.println(bookStore.bookStoreUserInfo()); //outputs the information of each user in the list of registered users
                System.out.println(menu);
                choice = scan.nextInt();
                scan.nextLine();
            } else if(choice == 8) {
                System.out.println("Enter the Title of the Book you are checking in: ");
                String checkIn = scan.next();
                System.out.println("Enter the ID of the User that is checking in the book: ");
                String checkingId = scan.next();
                Book bookChecked = bookStore.findBook(checkIn); //initializes bookChecked to the value of searching for the Title of the Book being checked in, bookChecked is set to the book, in the list of books, that has a title equal to the title inputted by the user, otherwise bookChecked is set to null
                User userChecked = bookStore.findUser(checkingId); //initializes userChecked to the value of searching for the ID of the user that is checking in, userChecked is set to the user, in the list of registered users, that has an ID equal to the ID inputted by the user, otherwise userChecked is set to null
                Book[] b1 = userChecked.getBooks(); //initializes b1 to the list of checked out books by the user
                if(bookChecked != null) {
                    for(int j = 0; j < b1.length; j++) {
                        if(b1[j] == bookChecked) { //removes bookChecked from the list of books that the user has checked out
                            b1[j] = null;
                        }
                    }
                    bookChecked.setQuantity(bookChecked.getQuantity() + 1); //increments the quantity of the book by 1
                    System.out.println("The Book has been checked in successfully!");
                } else {
                    System.out.println("The Book was not Found in the catalog!");
                    System.out.println("Please add the book into the catalog!");
                }
                System.out.println(menu);
                choice = scan.nextInt();
                scan.nextLine();
            } else if(choice == 9) {
                System.out.println("Enter the Title of the Book you are checking out: ");
                String checkOut = scan.next();
                System.out.println("Enter the ID of the User that is checking in the book: ");
                String checkingUser = scan.next();
                Book checkedOut = bookStore.findBook(checkOut); //initializes checkedOut to the value of searching for the Title of the Book being checked out, checkedOut is set to the book, in the list of books, that has a title equal to the title inputted by the user, otherwise checkedOut is set to null
                User userChecked = bookStore.findUser(checkingUser); //initializes userChecked to the value of searching for the ID of the user that is checking in, userChecked is set to the user, in the list of registered users, that has an ID equal to the ID inputted by the user, otherwise userChecked is set to null
                Book[] b2 = userChecked.getBooks(); //initializes b2 to the list of checked out books by the user
                if(checkedOut != null) {
                    int i = 0;
                    while(b2[i] != null) {
                        i++;
                    }
                    b2[i] = checkedOut; //if checkedOut is not null, searches for the next available space, an element that is null, in the user's list of books that they can check out at one time, then sets the element at that available space equal to checkedOut
                    checkedOut.setQuantity(checkedOut.getQuantity() - 1); //decrements the quantity of checkedOut by 1
                    System.out.println("The Book has been checked out successfully!");
                } else {
                    System.out.println("The Book was not Found in the catalog!");
                    System.out.println("Please check out a book that's available in our catalog!");
                }
                System.out.println(menu);
                choice = scan.nextInt();
                scan.nextLine();
            } else {
                System.out.println("Please choose one of the listed options from 0-8! Try Again!"); //asks the user to choose one of the available options in the menu of the UI
                System.out.println(menu);
                choice = scan.nextInt();
                scan.nextLine();
            }
        }
        System.out.println("See You Soon!");
        scan.close();
    }

}