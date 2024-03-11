package com.LaundryRoom.app.Handlers.Admin.LaundryHandlers;

import com.LaundryRoom.app.Database.DAO.LaundryDAO;
import com.LaundryRoom.app.Models.Laundry;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.HashMap;

public class NewLaundrySubmitHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String name = context.formParam("name");
        String price = context.formParam("price");
        int priceint = Integer.parseInt(price);

        HashMap<String, Object> laundry_data = new HashMap<>();

        if(name != null && !name.equals("")) laundry_data.put("name", name);
        if(price != null && !price.equals("")) laundry_data.put("price", priceint);

        Laundry laundry = new Laundry(laundry_data);

        try {
            int affected = LaundryDAO.save(laundry);
            if(affected > 0) {
                context.redirect("/admin/laundry/new_laundry?saveLaundry=true");
                return;
            }

        }catch(Exception ex) {
            ex.printStackTrace();
        }
        context.redirect("/admin/laundry/new_laundry?saveLaundry=false");
    }
}
