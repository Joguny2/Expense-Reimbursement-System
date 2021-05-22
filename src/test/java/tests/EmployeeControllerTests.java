package tests;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import controllers.EmployeeController;
import daos.EmployeeDao;
import daos.ManagerDao;
import daos.ReimbursementRequestDao;
import io.javalin.http.Context;
import io.javalin.http.Handler;
//import org.eclipse.jetty.client.HttpResponse;
import io.javalin.plugin.json.JavalinJson;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import io.javalin.Javalin;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.testng.Assert;
import pojos.AbstractUser;
import pojos.Employee;
import services.EmployeeService;
import services.ManagerService;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

public class EmployeeControllerTests {

    /*@InjectMocks
    private EmployeeController controller;

    @Mock
    EmployeeDao dao;

    @Mock
    ReimbursementRequestDao rdao;

    @Mock
    EmployeeService service;

    @Mock
    Context ctx;

    @Before
    public void beforeEachTest() {
        service = new EmployeeService();
        MockitoAnnotations.initMocks(this);
    }

    *//*@Test
    public void shouldBeTrueIfValidLoginCredentials() throws JSONException {
        Map<String, AbstractUser> mockMap = new HashMap();
        Employee e = new Employee();
        e.setUsername("johns");
        e.setPassword("pass");

        mockMap.put("johns", e);
        when(dao.getAllUsers()).thenReturn(mockMap);
        when(dao.getUser(anyString())).thenReturn(e);

        when(ctx.body()).thenReturn("{\"username\":\"johns\",\"password\":\"pass\"}");
        controller.handleLogin(ctx);

        verify(ctx).status(201);
*//*
    }*/

   /* @Test
    public void POST_to_login_gives_201_for_valid_username_and_password() throws UnirestException {
        com.revature.project1.app.start(1234);
        HttpResponse response = Unirest.post("http://localhost:1234/index2").asString();
        int expected = 201;
        Assert.assertEquals(response.getCode(), expected);
        //assertThat(response.getBody()).isEqualTo(usersJson);
        com.revature.project1.app.stop();
    }*/

}
