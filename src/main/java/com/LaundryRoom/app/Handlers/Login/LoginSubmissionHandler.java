package com.LaundryRoom.app.Handlers.Login;


import com.LaundryRoom.app.Database.DAO.UserDAO;
import com.LaundryRoom.app.Exceptions.InvalidUsernamePasswordException;
import com.LaundryRoom.app.Models.User;
import com.google.common.hash.Hashing;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.nio.charset.StandardCharsets;

public class LoginSubmissionHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String username = context.formParam("username");
        String password = context.formParam("password");
        try {
            User user = UserDAO.for_username(username);
            if(user == null)
                throw new InvalidUsernamePasswordException();
            password = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
            if(!password.equals(user.getPassword()))
                throw new InvalidUsernamePasswordException();
            context.sessionAttribute("user", user);
            if(user.getUser_type().equals("admin")) context.redirect("/admin");
            else if(user.getUser_type().equals("employee")) context.redirect("/employee");


        }catch (InvalidUsernamePasswordException ex) {
            context.html(ex.getMessage());
        }

    }
}
