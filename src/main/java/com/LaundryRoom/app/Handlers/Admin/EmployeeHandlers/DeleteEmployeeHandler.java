package com.LaundryRoom.app.Handlers.Admin.EmployeeHandlers;

import com.LaundryRoom.app.Database.DAO.LaundryDAO;
import com.LaundryRoom.app.Database.DAO.UserDAO;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class DeleteEmployeeHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String user_id = context.pathParam("user_id");
        int userId = Integer.parseInt(user_id);

        try{
            UserDAO.delete(userId);
            context.redirect("/admin?deleteEmployee=true");
            context.redirect("/admin/employee/all_employees");
            return;
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        context.redirect("/admin?deleteEmployee=false");
    }
}
