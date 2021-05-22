package controllers;

import io.javalin.http.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import pojos.ReimbursementRequest;
import services.EmployeeService;

public class EmployeeController {

    private EmployeeService service = new EmployeeService();


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
        System.out.println(ctx.body());
        String username = obj.getString("username");
        String password = obj.getString("password");

        if (service.validate(username, password)) {
            ctx.status(201);
            ctx.json(service.getUser(username));
        } else {
            ctx.status(401);
        }
    }

    /**
     * Handler for submission of updating email
     * grabs the updated email calls the service to
     * update it
     *
     * @param ctx
     * @throws JSONException
     */

    public void handleUpdateEmail(Context ctx) throws JSONException {
        JSONObject obj = new JSONObject(ctx.body());
        String email = obj.getString("email");
        String username = obj.getString("username");
        service.updateEmailForUser(username, email);
        ctx.status(200);
    }

    /**
     * Handler for submission of updating phonenumber
     * grabs the updated phonenumber calls the service to
     * update it
     *
     * @param ctx
     * @throws JSONException
     */
    public void handleUpdatePhonenumber(Context ctx) throws JSONException {
        JSONObject obj = new JSONObject(ctx.body());
        String phonenumber = obj.getString("phonenumber");
        String username = obj.getString("username");
        service.updatePhonenumberForUser(username, phonenumber);
        ctx.status(200);
    }

    /**
     * Handler for submission of updating email
     *      * grabs the updated email calls the service to
     *      * update it
     *
     * @param ctx
     */
    public void handleSubmitReimbursement(Context ctx) {
       service.submitReimbursement(ctx.bodyAsClass(ReimbursementRequest.class));
        ctx.status(200);
    }

    public void handleViewReimbursements(Context ctx) throws JSONException {
        JSONObject obj = new JSONObject(ctx.body());
        String username = obj.getString("username");
        ctx.json(service.getReimbursementsForUser(username));
        ctx.status(201);
    }

}
