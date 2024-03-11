package com.LaundryRoom.app.Handlers.Employee;

import com.LaundryRoom.app.Models.User;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class EmployeeAuthorizationHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        User user = (User)context.sessionAttribute("user");
        if( context.sessionAttribute("user") == null)
            context.redirect("/login");

        else if(!user.getUser_type().equals("employee"))
            context.redirect("/login");
    }
}
