package com.trillio;

import com.trillio.entities.BookMark;
import com.trillio.entities.User;
import com.trillio.managers.BookmarkManager;
import com.trillio.managers.UserManager;

public class Launch {

    private static User[] users;
    private static BookMark[][] bookMarks;

    private static void loadData() {
        System.out.println("!. Loading Data.....");
        DataStore.loadData();
        users = UserManager.getInstance().getUser();
        bookMarks = BookmarkManager.getInstance().getBookmark();

        /*System.out.println("Printing Data");
        printUserData();
        printBookmarkData();*/
    }


    public static void printUserData(){
        for(User user : users){
            System.out.println(user);
        }
    }

    public static void printBookmarkData(){
        for(BookMark[] bookMarkList : bookMarks){
            for(BookMark bookmark : bookMarkList){
                System.out.println(bookmark);
            }
        }
    }

    private static void start() {
//        System.out.println("\n2. Bookmarking.....");
        for(User user: users){
            View.browse(user, bookMarks);
        }
    }




    public static void main(String[] args) {
        loadData();
        start();
    }




}
