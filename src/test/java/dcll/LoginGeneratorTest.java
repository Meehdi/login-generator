package dcll;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by elmk93 on 15/04/16.
 */
public class LoginGeneratorTest {
    LoginGenerator loginGenerator;
    LoginService loginService;
    @Before
    public void setUp() throws Exception {
        loginService = new LoginService(new
            String[] {"JROL", "BPER", "CGUR", "JDUP", "JRAL", "JRAL1"});
        loginGenerator = new LoginGenerator(loginService);
    }

    @Test
    public void testGenerateLoginForNomAndPrenom() throws Exception {
        String jRal =
        loginGenerator.generateLoginForNomAndPrenom("RALLEY", "John");
        String jRol =
        loginGenerator.generateLoginForNomAndPrenom("Roley", "Jean");
        String cR =
        loginGenerator.generateLoginForNomAndPrenom("RONALDO", "Cristiano");
        Assert.assertEquals("JROL1", jRol);
        Assert.assertEquals("CRON", cR);
        Assert.assertEquals("JRAL1", jRal);

    }
}