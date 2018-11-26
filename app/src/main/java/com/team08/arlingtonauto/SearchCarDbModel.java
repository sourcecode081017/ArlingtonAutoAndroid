package com.team08.arlingtonauto;

public class SearchCarDbModel {
    private int capacity;
    private String carName;
    private int carImage;
    private String carBasePrice;

    public SearchCarDbModel(int capacity, String carName, int carImage, String carBasePrice) {
        this.capacity = capacity;
        this.carName = carName;
        this.carImage = carImage;
        this.carBasePrice = carBasePrice;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarImage() {
        return carImage;
    }

    public void setCarImage(int carImage) {
        this.carImage = carImage;
    }

    public String getCarBasePrice() {
        return carBasePrice;
    }

    public void setCarBasePrice(String carBasePrice) {
        this.carBasePrice = carBasePrice;
    }
}
