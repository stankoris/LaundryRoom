package com.LaundryRoom.app;

import com.LaundryRoom.app.Handlers.Admin.AdminAuthorizationHandler;
import com.LaundryRoom.app.Handlers.Admin.AdminDashboardHandler;
import com.LaundryRoom.app.Handlers.Admin.EmployeeHandlers.*;
import com.LaundryRoom.app.Handlers.Admin.LaundryHandlers.*;
import com.LaundryRoom.app.Handlers.Admin.ServiceHandlers.*;
import com.LaundryRoom.app.Handlers.Employee.EmployeeAuthorizationHandler;
import com.LaundryRoom.app.Handlers.Employee.EmployeeDashboardHandler;
import com.LaundryRoom.app.Handlers.Employee.OrderHandler;
import com.LaundryRoom.app.Handlers.HomeHandler;
import com.LaundryRoom.app.Handlers.Login.LoginFormHandler;
import com.LaundryRoom.app.Handlers.Login.LoginSubmissionHandler;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.staticFiles.add(System.getenv("LR_RESOURCES") + "/static", Location.EXTERNAL);
        });

        app.get("/", new HomeHandler());

        app.post("/login", new LoginSubmissionHandler());
        app.get("/login", new LoginFormHandler());

        app.before("/admin", new AdminAuthorizationHandler());
        app.before("/admin/*", new AdminAuthorizationHandler());
        app.get("/admin", new AdminDashboardHandler());

        //Handleri za laundry
        app.post("/admin/laundry/new_laundry", new NewLaundrySubmitHandler());
        app.get("/admin/laundry/new_laundry", new NewLaundryHandler());
        app.post("/admin/laundry/edit/{laundry_id}", new EditLaundrySubmitHandler());
        app.get("/admin/laundry/edit/{laundry_id}", new EditLaundryHandler());
        app.get("/admin/laundry/delete/{laundry_id}", new DeleteLaundryHandler());

        //Handleri za service
        app.post("/admin/service/new_service", new NewServiceSubmitHandler());
        app.get("/admin/service/new_service", new NewServiceHandler());
        app.post("/admin/service/edit/{service_id}", new EditServiceSubmitHandler());
        app.get("/admin/service/edit/{service_id}", new EditServiceHandler());
        app.get("/admin/service/delete/{service_id}", new DeleteServiceHandler());

        //Handleri za employee
        app.post("/admin/employee/new_employee", new NewEmployeeSubmitHandler());
        app.get("/admin/employee/new_employee", new NewEmployeeHandler());
        app.get("/admin/employee/all_employees", new AllEmployeesHandler());
        app.post("/admin/employee/edit/{user_id}", new EditEmployeeSubmitHandler());
        app.get("/admin/employee/edit/{user_id}", new EditEmployeeHandler());
        app.get("/admin/employee/delete/{user_id}", new DeleteEmployeeHandler());

        //Handleri za employee pogled
        app.before("/employee", new EmployeeAuthorizationHandler());
        app.before("/employee/*", new EmployeeAuthorizationHandler());
        app.get("/employee", new EmployeeDashboardHandler());
        app.post("/order", new OrderHandler());

        app.start(9000);
    }
}
