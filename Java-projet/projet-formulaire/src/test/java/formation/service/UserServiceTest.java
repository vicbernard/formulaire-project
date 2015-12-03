package formation.service;

import formation.domain.Customer;

import formation.formation.service.CustomerServiceItf;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;


public class UserServiceTest {

    // ======================================
    // =             Attributes             =
    // ======================================
    //test

    protected static Context ctx;

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    @BeforeClass
    public static void initContainer() throws Exception {
        ctx = new InitialContext();
    }

    @AfterClass
    public static void closeContainer() throws Exception {
        if (ctx != null) {
            ctx.close();
        }
    }

    @Test
    public void validCase_createUser() throws NamingException {
        Object ejb = ctx.lookup("java:global/projet-1.0.0-SNAPSHOT/CustomerService");
        assertNotNull(ejb);

        // Looks up the EJB
        CustomerServiceItf userService = (CustomerServiceItf) PortableRemoteObject.
                narrow(ejb, CustomerServiceItf.class);

        int initSize = userService.total();
        Customer u = new Customer();
        u.setFistName("test");
        u.setName("nameTest");
        u.setMail("test@test.fr");
        u.setPwd("coucou");
        u = userService.create(u);
        assertNotNull(u.getId());
        assertEquals(initSize + 1, userService.total());

    }

    @Test
    public void createUserWithoutName() throws NamingException {
        Object ejb = ctx.lookup("java:global/projet-1.0.0-SNAPSHOT/CustomerService");
        assertNotNull(ejb);

        // Looks up the EJB
        CustomerServiceItf userService = (CustomerServiceItf) PortableRemoteObject.
                narrow(ejb, CustomerServiceItf.class);

        Customer u = new Customer();
        u.setFistName("test");
        u.setName(null);
        u.setMail("test@test.fr");
        u.setPwd("coucou");
        try {
            userService.create(u);
            fail("IllegalArgumentException attendue car pas de nom");
        }catch(Exception e) {
            assertEquals("nom obligatoire", e.getMessage());
        }
    }
}
