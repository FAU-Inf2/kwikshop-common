package de.fau.cs.mad.kwikshop.common;

public class TutorialChapter {

    private int gifID;
    private int titleID;
    private int descriptionID;

    public TutorialChapter(int gifID, int titleID, int descriptionID){
        this.gifID = gifID;
        this.titleID = titleID;
        this.descriptionID = descriptionID;
    }

    public int getGifID() {
        return gifID;
    }

    public int getTitleID() {
        return titleID;
    }

    public int getDescriptionID() {
        return descriptionID;
    }


}
