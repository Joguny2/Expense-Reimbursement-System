package tests;

import daos.ManagerDao;
import daos.ReimbursementRequestDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pojos.AbstractUser;
import pojos.Employee;
import pojos.ReimbursementRequest;
import services.ManagerService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ManagerServiceTests {

    @InjectMocks
    private ManagerService service;

    @Mock
    ManagerDao dao;

    @Mock
    ReimbursementRequestDao rdao;

    @Before
    public void beforeEachTest() {
        service = new ManagerService();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldBeTrueIfValidLoginCredentials() {
        Map<String, AbstractUser> mockMap = new HashMap();
        Employee e = new Employee();
        e.setUsername("admin");
        e.setPassword("pass");

        mockMap.put("admin", e);
        when(dao.getAllUsers()).thenReturn(mockMap);
        when(dao.getUser(anyString())).thenReturn(e);
        Assert.assertTrue("Invalid username/password", service.validate(e.getUsername(), e.getPassword()));
    }

    @Test
    public void shouldBeFalseIfInvalidLoginCredentials() {
        Assert.assertFalse("this username/password is supposed to be invalid", service.validate("johnj", "pass"));
    }

    @Test
    public void shouldReturnListWithRequests() {

        when(rdao.query(any())).thenReturn((List<ReimbursementRequest>) Arrays.asList(new ReimbursementRequest()));
        List list = service.getAllPendingRequests();
        Mockito.verify(rdao).query(any());
    }
}
