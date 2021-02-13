package com.tanner.librarian;

import java.util.Calendar;
import java.util.Date;

public class Book {
    /**
     * The unique ID of this book by decimal system.
     */
    public double myDewyDecimal;
    /**
     * The title of this book.
     */
    public String myTitle;
    /**
     * The author of this book
     */
    public String myAuthor;
    /**
     * The blurb that describes the book.
     */
    public String myBlurb;
    /**
     * The shelf the book belongs to
     */
    public BookShelf myShelf;
    /**
     * Is the book checked out?
     */
    public Boolean myIsCheckedOut;
    /**
     * The date the book is due if checked out
     */
    public Date myDueDate;

    Customer myCustomer;

    private Customer LIBRARY;

    private final int myDaysCanBeCheckedOut = 7;


    public Book(double theDewyDecimal, String theTitle, String theAuthor, BookShelf theShelf, String theBlurb){

    }

    public boolean isCheckedOut(){
        return this.myIsCheckedOut;
    }

    /**
     * Set due date to
     */
    public void checkOutBook(Customer theCustomer){

        //If no customer assigned, and is not checked out
        //TODO:revamp this? Create library as customer and give to library?
        if(null == myCustomer && myIsCheckedOut == false) {
            myCustomer = theCustomer;
            myCustomer.myCheckedOutBooks.add(this);
            //create calendar to todays date and add #myDaysCanBeCheckedOut
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(Calendar.DAY_OF_YEAR, myDaysCanBeCheckedOut);

            myDueDate = cal.getTime();//get due date from calendar

            myIsCheckedOut = true;
        }

    }

    public void checkInBook(){
        myIsCheckedOut = false;
        myCustomer.myCheckedOutBooks.remove(this);
        myCustomer = null;
    }


}
