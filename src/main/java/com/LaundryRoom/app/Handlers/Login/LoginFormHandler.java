package com.LaundryRoom.app.Handlers.Login;

import com.LaundryRoom.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class LoginFormHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        context.html(Renderer.render("login.ftl"));
    }
}
