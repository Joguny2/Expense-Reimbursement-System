package tests;

import controllers.EmployeeController;
import controllers.ManagerController;
import io.javalin.http.Context;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import services.EmployeeService;
import services.ManagerService;

import static org.mockito.Mockito.*;

public class ManagerControllerTests {
    private ManagerController controller;

    @Before
    public void beforeEachTest() {
        controller = new ManagerController();
        Context ctx = mock(Context.class);
    }

    /*@Test
    public void shouldVerifyWithStatus200IfSuccessfulLogin() throws JSONException {
        Context ctx = mock(Context.class);
        ManagerService service = mock(ManagerService.class);
        JSONObject obj = mock(JSONObject.class);

        when(ctx.body()).thenReturn("{\"username\":\"admin\", \"password\":\"pass\"}");
        when(obj.getString("username")).thenReturn("admin");
        when(obj.getString("password")).thenReturn("pass");
        when(service.validate("admin", "pass")).thenReturn(true);

        controller.handleLogin(ctx); // the handler we're testing
        verify(ctx).status(201);
    }*/
}
