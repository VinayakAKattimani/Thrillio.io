package com.trillio.managers;

import com.trillio.dao.BookmarkDao;
import com.trillio.entities.*;
import com.trillio.partner.Shareable;

public class BookmarkManager {

    private static BookmarkManager instance = new BookmarkManager();
    private static BookmarkDao dao = new BookmarkDao();
    private BookmarkManager(){}

    public static BookmarkManager getInstance(){

        return  instance;
    }
    public WebLink createWebLink(long id, String title, String profileUrl,String url, String host){
        WebLink webLink = new WebLink();
        webLink.setId(id);
        webLink.setTitle(title);
        webLink.setProfileUrl(profileUrl);
        webLink.setUrl(url);
        webLink.setHost(host);

        return webLink;
    }

    public  Book createBook(long id, String title, String profileUrl,int publicationYear, String publisher, String[] authors, String genre, double amazonRating){
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setProfileUrl(profileUrl);
        book.setPublicationYear(publicationYear);
        book.setPublisher(publisher);
        book.setAuthors(authors);
        book.setGenre(genre);
        book.setAmazonRating(amazonRating);

        return book;
    }

    public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast, String[] directors, String genre, double imdbRating){
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(title);
        movie.setProfileUrl(profileUrl);
        movie.setReleaseYear(releaseYear);
        movie.setCast(cast);
        movie.setDirectors(directors);
        movie.setGenre(genre);
        movie.setImdbRating(imdbRating);
        return movie;
    }

    public BookMark[][] getBookmark(){
        return dao.getBookmarks();
    }

    public void saveUserBookmark(User user, BookMark bookmark) {
        UserBookmark userBookmark = new UserBookmark();
        userBookmark.setUser(user);
        userBookmark.setBookmark(bookmark);

        dao.saveUserBookmark(userBookmark);
    }

    public void setKidFriendlyStatus(User user, String kidFriendlyStatus, BookMark bookMark) {
        bookMark.setKidFriendlyStatus(kidFriendlyStatus);
        bookMark.setKidFriendlyMarkedBy(user);
        System.out.println("Kid friendly Status: "+ kidFriendlyStatus +"Marked by "+ user.getEmail() + "," + bookMark);
    }

    public void share(User user, BookMark bookMark) {
//        bookMark.setSharedBy(user);
//
//        System.out.println("Data to be shared: ");
//        if (bookMark instanceof Book){
//            System.out.println(bookMark = getItemData());
//        } else if (bookMark instanceof WebLink) {
//            System.out.println(((WebLink)bookMark) = getItemData());
//        }
        bookMark.setSharedBy(user);

        System.out.println("Data to be shared: ");

        if (bookMark instanceof Shareable) {
            Shareable shareable = (Shareable) bookMark;
            System.out.println(shareable.getItemData());
        }
    }


}
