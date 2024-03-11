package com.LaundryRoom.app.Handlers.Admin.LaundryHandlers;

import com.LaundryRoom.app.Database.DAO.LaundryDAO;
import com.LaundryRoom.app.Models.Laundry;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class EditLaundrySubmitHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String laundry_id = context.pathParam("laundry_id");
        int laundryId = Integer.parseInt(laundry_id);

        Laundry laundry = LaundryDAO.get(laundryId);

        laundry.setName(context.formParam("name"));
        laundry.setPrice(Integer.parseInt(context.formParam("price")));

        try{
            LaundryDAO.update(laundry);
            context.redirect(String.format("/admin/laundry/edit/%d?updateLaundry=true",laundryId));
            return;
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        context.redirect(String.format("/admin/laundry/edit/%d?updateLaundry=true",laundryId));
    }
}
