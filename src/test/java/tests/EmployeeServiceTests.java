package tests;

import daos.EmployeeDao;
import daos.ReimbursementRequestDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import pojos.AbstractUser;
import pojos.Employee;
import pojos.ReimbursementRequest;
import services.EmployeeService;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTests {

    @InjectMocks
    private EmployeeService service;

    @Mock
    EmployeeDao dao;

    @Mock
    ReimbursementRequestDao rdao;

    @Before
    public void beforeEachTest() {
        service = new EmployeeService();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldBeTrueIfValidLoginCredentials() {
        Map<String, AbstractUser> mockMap = new HashMap();
        Employee e = new Employee();
        e.setUsername("johns");
        e.setPassword("pass");

        mockMap.put("johns", e);
        when(dao.getAllUsers()).thenReturn(mockMap);
        when(dao.getUser(anyString())).thenReturn(e);
        Assert.assertTrue("Invalid username/password", service.validate(e.getUsername(), "pass"));
    }

    @Test
    public void shouldBeFalseIfInvalidLoginCredentials() {
        Map<String, AbstractUser> mockMap = new HashMap();
        Employee e = new Employee();
        e.setUsername("johnt");
        e.setPassword("passs");

        mockMap.put("johnt", e);
        when(dao.getAllUsers()).thenReturn(mockMap);
//        when(dao.getUser(anyString())).thenReturn(e);
        Assert.assertFalse("this username/password is supposed to be invalid", service.validate("johnj", "pass"));
    }

    @Test
    public void shouldReturnListWithRequests() {

        when(rdao.query(any())).thenReturn((List<ReimbursementRequest>) Arrays.asList(new ReimbursementRequest()));
        List list = service.getReimbursementsForUser("testU");
        Mockito.verify(rdao).query(any());
    }

    @Test
    public void shouldVerifyEmailUpdate() {
        Employee e = new Employee();
        e.setEmail("test");
        e.setUsername("test");
        when(dao.getUser(anyString())).thenReturn(e);
        service.updateEmailForUser(e.getUsername(), "test@email.com");

        verify(dao).updateUser(e);
    }

    @Test
    public void shouldVerifyPhonenumberUpdate() {
        Employee e = new Employee();
        e.setPhonenumber("test");
        e.setUsername("test");
        when(dao.getUser(anyString())).thenReturn(e);
        service.updatePhonenumberForUser(e.getUsername(), "1235559999");

        verify(dao).updateUser(e);
    }

    @Test
    public void shouldInsertARequest() {
        ReimbursementRequest request = new ReimbursementRequest();
        service.submitReimbursement(request);
        verify(rdao).insertRequest(any());
    }
}
