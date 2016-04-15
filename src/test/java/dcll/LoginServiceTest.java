package dcll;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elmk93 on 15/04/16.
 */
public class LoginServiceTest {

    private LoginService loginService;
    String[] str = {"Mehdi"};

    @Before
    public void setUp() throws Exception {
        loginService = new LoginService(str);
    }

    @Test
    public void testLoginExists() throws Exception {
        Assert.assertEquals(true, loginService.loginExists("Mehdi"));
        Assert.assertEquals(false, loginService.loginExists("Kzadri"));

    }

    @Test
    public void testAddLogin() throws Exception {
        Assert.assertEquals(false, loginService.loginExists("Kzadri"));
        loginService.addLogin("Kzadri");
        Assert.assertEquals(true, loginService.loginExists("Kzadri"));
    }

    @Test
    public void testFindAllLoginsStartingWith() throws Exception {
        loginService.addLogin("Kzadri");
        List<String> list = new ArrayList<String>();
        list = loginService.findAllLoginsStartingWith("M");
        Assert.assertEquals(true, list.contains("Mehdi"));
        Assert.assertEquals(false, list.contains("Kzadri"));
    }

    @Test
    public void testFindAllLogins() throws Exception {

        List<String> list = new ArrayList<String>();
        list = loginService.findAllLogins();
        Assert.assertEquals(true, list.contains("Mehdi"));
        Assert.assertEquals(false,
                (list.contains("Mehdi")&&(list.contains("Kzadri"))));


    }
}