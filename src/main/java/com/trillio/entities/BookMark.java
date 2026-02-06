package com.trillio.entities;

import com.trillio.constants.KidFriendlyStatus;

public abstract class BookMark {
    private long id;
    private String title;
    private String profileUrl;
    private String kidFriendlyStatus = KidFriendlyStatus.UNKNOWN;
    private User kidFriendlyMarkedBy;
    private User sharedBy;

    public User getSharedBy() {
        return sharedBy;
    }

    public void setSharedBy(User sharedBy) {
        this.sharedBy = sharedBy;
    }



    public String getKidFriendlyStatus() {
        return kidFriendlyStatus;
    }

    public void setKidFriendlyStatus(String kidFriendlyStatus) {
        this.kidFriendlyStatus = kidFriendlyStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }
    public abstract boolean isKidFriendlyEligible();



    public User getKidFriendlyMarkedBy() {
        return kidFriendlyMarkedBy;
    }

    public void setKidFriendlyMarkedBy(User kidFriendlyMarkedBy) {
        this.kidFriendlyMarkedBy = kidFriendlyMarkedBy;
    }
    @Override
    public String toString() {
        return "BookMark{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", profileUrl='" + profileUrl + '\'' +
                '}';
    }
}
