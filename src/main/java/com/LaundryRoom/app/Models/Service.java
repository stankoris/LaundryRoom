package com.LaundryRoom.app.Models;

import java.io.Serializable;
import java.util.HashMap;

public class Service implements Serializable {
    private int service_id;
    private String name;
    private int price;

    public Service() {}

    public Service(HashMap<String, Object> laundry_data) {
        if(laundry_data.containsKey("laundry_id")) {
            this.service_id = (int) laundry_data.get("laundry_id");
        }
        if(laundry_data.containsKey("name")) {
            this.name = (String) laundry_data.get("name");
        }
        if(laundry_data.containsKey("price")) {
            this.price = (int) laundry_data.get("price");
        }
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String service_name) {
        this.name = service_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
