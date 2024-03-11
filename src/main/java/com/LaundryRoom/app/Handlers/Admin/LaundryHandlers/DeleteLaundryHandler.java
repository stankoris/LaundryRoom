package com.LaundryRoom.app.Handlers.Admin.LaundryHandlers;

import com.LaundryRoom.app.Database.DAO.LaundryDAO;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class DeleteLaundryHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String laundry_id = context.pathParam("laundry_id");
        int laundryId = Integer.parseInt(laundry_id);

        try{
            LaundryDAO.delete(laundryId);
            context.redirect("/admin?deleteLaundry=true");
            return;
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        context.redirect("/admin?deleteLaundry=false");
    }
}
