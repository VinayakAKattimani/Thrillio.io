package com.trillio;

import com.trillio.constants.KidFriendlyStatus;
import com.trillio.constants.UserType;
import com.trillio.controllers.BookmarkController;
import com.trillio.entities.BookMark;
import com.trillio.entities.User;
import com.trillio.partner.Shareable;

public class View {
    public static void browse(User user, BookMark[][] bookMarks){
        System.out.println("\n" + user.getEmail() + " is Browsing Items");
        int bookmarkCount = 0;
        for(BookMark[] bookMarkList : bookMarks){
            for (BookMark bookMark : bookMarkList){
                /*BOOKMARKING */
                if(bookmarkCount < DataStore.USER_BOOKMARK_LIMIT){
                    boolean isBookmarked = getBookmarkDecision(bookMark);
                    if(isBookmarked){
                        bookmarkCount++;
                        BookmarkController.getInstance().saveUserBookmark(user, bookMark);
                        System.out.println("new item bookmarked----" + bookMark);
                    }
                }
                /* Marking as kid friendly */
                if(user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)){
                  if(bookMark.isKidFriendlyEligible() || bookMark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)){
                      String kidFriendlyStatus = getKidFriendlyStatusDecision(bookMark);
                      if(!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)){
                          BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookMark);
                      }
                  }
                  if(bookMark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
                         && bookMark instanceof Shareable){
                       boolean isShare = getShareDecison();
                       if(isShare){
                           BookmarkController .getInstance().share(user, bookMark);
                       }

                    }
                }
            }
        }


    }

    private static boolean getShareDecison() {
        return Math.random() < 0.5 ? true: false;
    }

    private static String getKidFriendlyStatusDecision(BookMark bookMark) {
        return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED:
                (Math.random() >= 0.4 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED : KidFriendlyStatus.UNKNOWN;

    }

    private static boolean getBookmarkDecision(BookMark bookMark) {
        return Math.random() < 0.5 ? true: false;
    }


    /*
    public static void bookmark(User user, BookMark[][] bookMarks){
        System.out.println("\n" + user.getEmail() + " is Bookmarking");
        for(int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++){
            int typeOffSet = (int)(Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
            int bookmarkOffSet =  (int)(Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);

            BookMark bookmark = bookMarks[typeOffSet][bookmarkOffSet];

            BookmarkController.getInstance().saveUserBookmark(user, bookmark);
            System.out.println(bookmark);
        }
    } */
}
