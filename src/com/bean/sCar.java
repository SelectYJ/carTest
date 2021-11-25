package com.bean;

public class sCar {
    private int car_id;
    private String car_name;
    private String car_price;
    private String car_quantity;
    private String car_production_time;
    private String car_img;

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getCar_price() {
        return car_price;
    }

    public void setCar_price(String car_price) {
        this.car_price = car_price;
    }

    public String getCar_quantity() {
        return car_quantity;
    }

    public void setCar_quantity(String car_quantity) {
        this.car_quantity = car_quantity;
    }

    public String getCar_production_time() {
        return car_production_time;
    }

    public void setCar_production_time(String car_production_time) {
        this.car_production_time = car_production_time;
    }

    public String getCar_img() {
        return car_img;
    }

    public void setCar_img(String car_img) {
        this.car_img = car_img;
    }

    @Override
    public String toString() {
        return "sCar{" +
                "us_id=" + car_id +
                ", car_name='" + car_name + '\'' +
                ", car_price='" + car_price + '\'' +
                ", car_quantity='" + car_quantity + '\'' +
                ", car_production_time='" + car_production_time + '\'' +
                ", car_img='" + car_img + '\'' +
                '}';
    }
}
