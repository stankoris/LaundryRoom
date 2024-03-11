package com.LaundryRoom.app.Handlers.Admin.ServiceHandlers;

import com.LaundryRoom.app.Database.DAO.ServiceDAO;
import com.LaundryRoom.app.Models.Service;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.HashMap;

public class NewServiceSubmitHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String name = context.formParam("name");
        String price = context.formParam("price");
        int priceint = Integer.parseInt(price);

        HashMap<String, Object> service_data = new HashMap<>();

        if(name != null && !name.equals("")) service_data.put("name", name);
        if(price != null && !price.equals("")) service_data.put("price", priceint);

        Service service = new Service(service_data);

        try {
            int affected = ServiceDAO.save(service);
            if(affected > 0) {
                context.redirect("/admin/service/new_service?saveService=true");
                return;
            }

        }catch(Exception ex) {
            ex.printStackTrace();
        }
        context.redirect("/admin/service/new_service?saveService=true");
    }
}
