package com.LaundryRoom.app.Handlers.Admin.EmployeeHandlers;

import com.LaundryRoom.app.Database.DAO.LaundryDAO;
import com.LaundryRoom.app.Database.DAO.UserDAO;
import com.LaundryRoom.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.HashMap;

public class NewEmployeeHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        HashMap<String, Object> dataModel = new HashMap<>();

        if(context.queryParam("saveEmployee") != null) {
            dataModel.put("saveEmployee", context.queryParam("saveEmployee"));
        }

        context.html(Renderer.render("admin/employee/new_employee.ftl", dataModel));
    }
}
