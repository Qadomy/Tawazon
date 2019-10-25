package com.blue.tawazon.Classes;

public class SoundItem {

    private int imageID;
    private String itemDesc;

    public SoundItem(int imageID, String itemDesc) {
        this.imageID = imageID;
        this.itemDesc = itemDesc;
    }


    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
}
