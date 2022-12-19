package com.optv.inventryverse;

public class ModelProducts {

    private int prod_id;
    private int prod_img;
    private String prod_name;
    private int prod_stocks;

    public ModelProducts(int prod_id, int prod_img, String prod_name, int prod_stocks) {
        this.prod_id = prod_id;
        this.prod_img = prod_img;
        this.prod_name = prod_name;
        this.prod_stocks = prod_stocks;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public int getProd_img() {
        return prod_img;
    }

    public void setProd_img(int prod_img) {
        this.prod_img = prod_img;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public int getProd_stocks() {
        return prod_stocks;
    }

    public void setProd_stocks(int prod_stocks) {
        this.prod_stocks = prod_stocks;
    }
}
