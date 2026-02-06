package com.trillio.controllers;

import com.trillio.entities.BookMark;
import com.trillio.entities.User;
import com.trillio.managers.BookmarkManager;

public class BookmarkController {
    private static BookmarkController instance = new BookmarkController();
    private BookmarkController(){}

    public static BookmarkController getInstance(){
        return instance;
    }

    public void saveUserBookmark(User user, BookMark bookmark) {
        BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
    }

    public void setKidFriendlyStatus(User user, String kidFriendlyStatus, BookMark bookMark) {
        BookmarkManager.getInstance().setKidFriendlyStatus(user,kidFriendlyStatus,bookMark);
    }

    public void share(User user, BookMark bookMark) {
        BookmarkManager.getInstance().share(user, bookMark);
    }
}
