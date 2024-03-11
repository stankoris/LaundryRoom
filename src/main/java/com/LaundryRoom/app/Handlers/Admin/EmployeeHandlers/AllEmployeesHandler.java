package com.LaundryRoom.app.Handlers.Admin.EmployeeHandlers;

import com.LaundryRoom.app.Database.DAO.UserDAO;
import com.LaundryRoom.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.HashMap;

public class AllEmployeesHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        HashMap<String, Object> modelData = new HashMap<>();

        modelData.put("employees", UserDAO.all());

        if(context.queryParam("deleteLaundry") != null) {
            modelData.put("deleteLaundry", context.queryParam("deleteLaundry"));
        }

        context.html(Renderer.render("admin/employee/all_employees.ftl", modelData));
    }
}
