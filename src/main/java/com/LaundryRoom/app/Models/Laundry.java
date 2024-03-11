package com.LaundryRoom.app.Models;

import java.io.Serializable;
import java.util.HashMap;

public class Laundry implements Serializable {
    private int laundry_id;
    private String name;
    private int price;

    public Laundry() {}

    public Laundry(HashMap<String, Object> laundry_data) {
        if(laundry_data.containsKey("laundry_id")) {
            this.laundry_id = (int) laundry_data.get("laundry_id");
        }
        if(laundry_data.containsKey("name")) {
            this.name = (String) laundry_data.get("name");
        }
        if(laundry_data.containsKey("price")) {
            this.price = (int) laundry_data.get("price");
        }
    }

    public int getLaundry_id() {
        return laundry_id;
    }
    public void setLaundry_id(int laundry_id) {
        this.laundry_id = laundry_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
