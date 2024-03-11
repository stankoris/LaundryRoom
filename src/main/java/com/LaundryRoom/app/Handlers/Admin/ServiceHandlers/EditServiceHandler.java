package com.LaundryRoom.app.Handlers.Admin.ServiceHandlers;

import com.LaundryRoom.app.Database.DAO.LaundryDAO;
import com.LaundryRoom.app.Database.DAO.ServiceDAO;
import com.LaundryRoom.app.Models.Laundry;
import com.LaundryRoom.app.Models.Service;
import com.LaundryRoom.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.HashMap;

public class EditServiceHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String service_id = context.pathParam("service_id");
        Service service = ServiceDAO.get(Integer.parseInt(service_id));

        HashMap<String, Object> modelData = new HashMap<>();
        modelData.put("service", service);


        if(context.queryParam("updateService") != null) {
            modelData.put("updateService", context.queryParam("updateService"));
        }

        context.html(Renderer.render("admin/service/edit_service.ftl", modelData));
    }
}
