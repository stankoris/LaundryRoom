package com.LaundryRoom.app.Handlers.Admin.ServiceHandlers;

import com.LaundryRoom.app.Database.DAO.LaundryDAO;
import com.LaundryRoom.app.Database.DAO.ServiceDAO;
import com.LaundryRoom.app.Models.Laundry;
import com.LaundryRoom.app.Models.Service;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class EditServiceSubmitHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String service_id = context.pathParam("service_id");
        int serviceId = Integer.parseInt(service_id);

        Service service = ServiceDAO.get(serviceId);

        service.setName(context.formParam("name"));
        service.setPrice(Integer.parseInt(context.formParam("price")));

        try{
            ServiceDAO.update(service);
            context.redirect(String.format("/admin/service/edit/%d?updateService=true",serviceId));
            return;
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        context.redirect(String.format("/admin/service/edit/%d?updateService=false",serviceId));
    }
}
