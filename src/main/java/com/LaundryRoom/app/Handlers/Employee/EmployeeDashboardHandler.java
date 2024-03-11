package com.LaundryRoom.app.Handlers.Employee;

import com.LaundryRoom.app.Database.DAO.LaundryDAO;
import com.LaundryRoom.app.Database.DAO.ServiceDAO;
import com.LaundryRoom.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.HashMap;

public class EmployeeDashboardHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        HashMap<String, Object> modelData = new HashMap<>();

        modelData.put("services", ServiceDAO.all());
        modelData.put("laundry", LaundryDAO.all());
        context.html(Renderer.render("employee/employee_dashboard.ftl", modelData));
    }
}
