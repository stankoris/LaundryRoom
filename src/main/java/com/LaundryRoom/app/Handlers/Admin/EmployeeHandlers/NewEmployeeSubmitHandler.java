package com.LaundryRoom.app.Handlers.Admin.EmployeeHandlers;

import com.LaundryRoom.app.Database.DAO.UserDAO;
import com.google.common.hash.Hashing;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class NewEmployeeSubmitHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String username = context.formParam("username");
        String password = context.formParam("password");

        password = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();

        HashMap<String, Object> user_data = new HashMap<>();

        if(username != null && !username.equals("")) user_data.put("username", username);
        if(password != null && !password.equals("")) user_data.put("password", password);

        try {
            int affected = UserDAO.save(username, password);
            if(affected > 0) {
                context.redirect("/admin/employee/new_employee?saveEmployee=true");
                return;
            }

        }catch(Exception ex) {
            ex.printStackTrace();
        }
        context.redirect("/admin/employee/new_employee?saveEmployee=false");
    }
}
