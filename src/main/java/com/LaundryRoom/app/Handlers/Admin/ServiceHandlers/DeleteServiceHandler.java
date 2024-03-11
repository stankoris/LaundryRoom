package com.LaundryRoom.app.Handlers.Admin.ServiceHandlers;

import com.LaundryRoom.app.Database.DAO.ServiceDAO;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class DeleteServiceHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String service_id = context.pathParam("service_id");
        int serviceId = Integer.parseInt(service_id);

        try{
            ServiceDAO.delete(serviceId);
            context.redirect("/admin?deleteService=true");
            return;
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        context.redirect("/admin?deleteService=false");
    }
}
