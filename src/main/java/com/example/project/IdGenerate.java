package com.example.project;

public class IdGenerate{ //This class contains statics variable and methods, you do not initalize an object to use it.
    
    // //requires 1 private attribute String currentId. You must initialize it to 99
    private static String currentId = "99"; // a private static String variable currentId that represents the current ID

    // //requires one empty constructor
    public IdGenerate() {} 

    public static String getCurrentId() {
        return currentId; //returns the current ID
    }

    //must reset the currentId back to 99

    public static void reset() {
        currentId = "99"; //a static void method that resets the current ID back to the original number or 99
    } 


    //generates a new id, when called it will increment the currentId by 1.. Hint pay attention to data type of currentId

    public static void generateID() {
        int num = Integer.parseInt(currentId); //converts the current Id from String to int and sets the int variable num equal to this int value for the current ID
        num++; //increments the int value of current ID by one
        currentId = "" + num; //converts the int value num for current ID back to a String value
    } 
}