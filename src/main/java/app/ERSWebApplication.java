package app;

import controllers.EmployeeController;
import controllers.ManagerController;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.get;

public class ERSWebApplication extends AbstractApplication {

    public ERSWebApplication(String title) {
        this.title = title;
    }

    /**
     * Starts server. Setups HTTP routes
     * and assigns corresponding controllers
     */
    @Override
    public void run() {
        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            //config.addStaticFiles("/public");
        }).start(7777);

        EmployeeController ec = new EmployeeController();
        ManagerController mc = new ManagerController();

        app.routes(() -> {
            post("/EmployeeLogin", ec::handleLogin);
            post("/EmployeeHome/Info/UpdateEmail", ec::handleUpdateEmail);
            post("/EmployeeHome/Info/UpdatePhone", ec::handleUpdatePhonenumber);
            post("/EmployeeReimbursement", ec::handleSubmitReimbursement);
            post("/EmployeeViewReimbursements", ec::handleViewReimbursements);
            post("/ManagerLogin", mc::handleLogin);
            get("/ManagerViewEmployees", mc::handleViewEmployees);
            get("/ManagerViewPendingRequests", mc::handleViewAllPendingRequests);

        });
    }
}
