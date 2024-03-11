package com.LaundryRoom.app.Handlers.Admin.EmployeeHandlers;

import com.LaundryRoom.app.Database.DAO.UserDAO;
import com.LaundryRoom.app.Models.User;
import com.LaundryRoom.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.HashMap;

public class EditEmployeeHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String user_id = context.pathParam("user_id");
        User user = UserDAO.get(Integer.parseInt(user_id));

        HashMap<String, Object> modelData = new HashMap<>();
        modelData.put("employee", user);


        if(context.queryParam("updateEmployee") != null) {
            modelData.put("updateEmployee", context.queryParam("updateEmployee"));
        }

        context.html(Renderer.render("admin/employee/edit_employee.ftl", modelData));
    }
}
