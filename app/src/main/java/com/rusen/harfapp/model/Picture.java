package com.rusen.harfapp.model;


public class Picture {

    private int imageNumber;
    private String imageName;

    public Picture(int imageNumber){

        this.imageNumber=imageNumber;
    }
    public Picture(int imageNumber,String imageName){

        this.imageNumber=imageNumber;
        this.imageName = imageName;
    }

    public int getImageNumber() {
        return imageNumber;
    }

    public void setImageNumber(int imageNumber) {
        this.imageNumber = imageNumber;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
