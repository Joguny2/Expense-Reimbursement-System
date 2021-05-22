package controllers;

import io.javalin.http.Context;
import org.json.JSONException;
import org.json.JSONObject;
import services.ManagerService;

public class ManagerController {

    private ManagerService service = new ManagerService();

    /**
     * This method is the handler for logging in
     * grabs a username and password from front end
     * and sends back user info if validated
     *
     * @param ctx
     * @throws JSONException
     */
    public void handleLogin(Context ctx) throws JSONException {
        JSONObject obj = new JSONObject(ctx.body());
        String username = obj.getString("username");
        String password = obj.getString("password");

        if (service.validate(username, password)) {
            ctx.status(201);
            ctx.json(service.getUser(username));
        } else {
            ctx.status(401);
        }
    }

    public void handleViewEmployees(Context ctx) {
        ctx.json(service.getAllEmployees());
        ctx.status(200);
    }

    public void handleViewAllPendingRequests(Context ctx) {
        ctx.json(service.getAllPendingRequests());
        ctx.status(200);
    }
}
