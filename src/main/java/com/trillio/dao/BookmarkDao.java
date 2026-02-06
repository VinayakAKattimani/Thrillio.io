package com.trillio.dao;

import com.trillio.DataStore;
import com.trillio.entities.BookMark;
import com.trillio.entities.User;
import com.trillio.entities.UserBookmark;

public class BookmarkDao {
    public BookMark[][] getBookmarks(){
        return DataStore.getBookMarks();
    }

    public void saveUserBookmark(UserBookmark userBookmark) {
        DataStore.add(userBookmark);

    }
}
