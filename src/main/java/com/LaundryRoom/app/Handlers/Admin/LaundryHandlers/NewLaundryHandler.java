package com.LaundryRoom.app.Handlers.Admin.LaundryHandlers;

import com.LaundryRoom.app.Database.DAO.LaundryDAO;
import com.LaundryRoom.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.HashMap;

public class NewLaundryHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        HashMap<String, Object> dataModel = new HashMap<>();

        if(context.queryParam("saveLaundry") != null) {
            dataModel.put("saveLaundry", context.queryParam("saveLaundry"));
        }

        dataModel.put("laundry", LaundryDAO.all());

        context.html(Renderer.render("admin/laundry/new_laundry.ftl", dataModel));
    }
}
