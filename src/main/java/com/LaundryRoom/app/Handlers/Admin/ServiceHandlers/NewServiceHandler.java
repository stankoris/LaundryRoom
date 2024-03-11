package com.LaundryRoom.app.Handlers.Admin.ServiceHandlers;

import com.LaundryRoom.app.Database.DAO.LaundryDAO;
import com.LaundryRoom.app.Database.DAO.ServiceDAO;
import com.LaundryRoom.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.HashMap;

public class NewServiceHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        HashMap<String, Object> dataModel = new HashMap<>();

        if(context.queryParam("saveService") != null) {
            dataModel.put("saveService", context.queryParam("saveService"));
        }

        dataModel.put("services", ServiceDAO.all());

        context.html(Renderer.render("admin/service/new_service.ftl", dataModel));
    }
}
