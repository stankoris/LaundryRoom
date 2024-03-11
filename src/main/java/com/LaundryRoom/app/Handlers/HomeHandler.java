package com.LaundryRoom.app.Handlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class HomeHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        context.redirect("/login");
    }
}
