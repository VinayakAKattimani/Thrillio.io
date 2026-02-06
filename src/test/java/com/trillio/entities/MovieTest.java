package com.trillio.entities;

import com.trillio.constants.MovieGenre;
import com.trillio.managers.BookmarkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void isKidFriendlyEligible() {
        /* Test 1: */
        Movie movie = BookmarkManager.getInstance().createMovie(3000,"Citizen Kane","",1941, new String[]{"Orson Welles","Joseph Cotten"},new String[]{"Orson Welles"}, MovieGenre.HORROR, 8.5);
        boolean isKidFriendly = movie.isKidFriendlyEligible();
        assertFalse(isKidFriendly,"For movie type is horror - isKidFriendlyEligible() must return false");

        /* Test 2: */
        movie = BookmarkManager.getInstance().createMovie(3000,"Citizen Kane","",1941, new String[]{"Orson Welles","Joseph Cotten"},new String[]{"Orson Welles"}, MovieGenre.THRILLERS, 8.5);
        isKidFriendly = movie.isKidFriendlyEligible();
        assertFalse(isKidFriendly,"For movie type is horror - isKidFriendlyEligible() must return false");
    }
}