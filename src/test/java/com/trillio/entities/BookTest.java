package com.trillio.entities;

import com.trillio.constants.BookGenre;
import com.trillio.managers.BookmarkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void isKidFriendlyEligible() {
        /* Test1: For Book genre is Philosophy --false*/
        Book book = BookmarkManager.getInstance().createBook(4000,"Walden","",1854,"Wilder Publications",new String[]{"Henry David Thoreau"}, BookGenre.PHILOSOPHY, 4.3);
        boolean isKidFriendly = book.isKidFriendlyEligible();
        assertFalse(isKidFriendly, "For Book genre is Philosophy - isKidFriendlyEligible() must return false");

        /* Test1: For Book genre is self-help --false*/
        book = BookmarkManager.getInstance().createBook(4000,"Walden","",1854,"Wilder Publications",new String[]{"Henry David Thoreau"}, BookGenre.SELF_HELP, 4.3);
        isKidFriendly = book.isKidFriendlyEligible();
        assertFalse(isKidFriendly, "For Book genre is Self Help - isKidFriendlyEligible() must return false");
    }
}