package com.blue.tawazon.Classes;

public class ProfileItems {

    private String mItemTitle;
    private String mItemDescription;
    private int mImageResourceId;
    private int mIconArrowID;

    public ProfileItems(String mItemTitle, String mItemDescription, int mImageResourceId, int mIconArrowID) {
        this.mItemTitle = mItemTitle;
        this.mItemDescription = mItemDescription;
        this.mImageResourceId = mImageResourceId;
        this.mIconArrowID = mIconArrowID;
    }

    public String getmItemTitle() {
        return mItemTitle;
    }

    public String getmItemDescription() {
        return mItemDescription;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public int getmIconArrowID() {
        return mIconArrowID;
    }
}
