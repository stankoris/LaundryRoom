package com.LaundryRoom.app.Handlers.Admin;

import com.LaundryRoom.app.Database.DAO.LaundryDAO;
import com.LaundryRoom.app.Database.DAO.ServiceDAO;
import com.LaundryRoom.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.HashMap;

public class AdminDashboardHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        HashMap<String, Object> modelData = new HashMap<>();

        modelData.put("laundry", LaundryDAO.all());
        modelData.put("services", ServiceDAO.all());

        if(context.queryParam("deleteLaundry") != null) {
            modelData.put("deleteLaundry", context.queryParam("deleteLaundry"));
        }

        if(context.queryParam("deleteService") != null) {
            modelData.put("deleteService", context.queryParam("deleteService"));
        }

        context.html(Renderer.render("/admin/admin_dashboard.ftl", modelData));
    }
}
