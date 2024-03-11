package com.LaundryRoom.app.Handlers.Admin.LaundryHandlers;

import com.LaundryRoom.app.Database.DAO.LaundryDAO;
import com.LaundryRoom.app.Models.Laundry;
import com.LaundryRoom.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.HashMap;

public class EditLaundryHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String laundry_id = context.pathParam("laundry_id");
        Laundry laundry = LaundryDAO.get(Integer.parseInt(laundry_id));

        HashMap<String, Object> modelData = new HashMap<>();
        modelData.put("laundry", laundry);


        if(context.queryParam("updateLaundry") != null) {
            modelData.put("updateLaundry", context.queryParam("updateLaundry"));
        }

        context.html(Renderer.render("admin/laundry/edit_laundry.ftl", modelData));
    }
}
