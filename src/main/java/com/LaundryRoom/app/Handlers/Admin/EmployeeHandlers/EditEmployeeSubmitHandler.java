package com.LaundryRoom.app.Handlers.Admin.EmployeeHandlers;

import com.LaundryRoom.app.Database.DAO.LaundryDAO;
import com.LaundryRoom.app.Database.DAO.UserDAO;
import com.LaundryRoom.app.Models.Laundry;
import com.LaundryRoom.app.Models.User;
import com.google.common.hash.Hashing;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.nio.charset.StandardCharsets;

public class EditEmployeeSubmitHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String user_id = context.pathParam("user_id");
        int userId = Integer.parseInt(user_id);

        User user = UserDAO.get(userId);

        user.setUsername(context.formParam("username"));
        user.setPassword(context.formParam("password"));
        user.setUser_type(context.formParam("user_type"));

        try{
            UserDAO.update(user);
            context.redirect(String.format("/admin/employee/edit/%d?updateEmployee=true",userId));
            return;
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        context.redirect(String.format("/admin/employee/edit/%d?updateEmployee=false",userId));
    }
}
