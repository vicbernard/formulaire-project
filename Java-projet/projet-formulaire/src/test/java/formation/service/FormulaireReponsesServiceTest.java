package formation.service;

import formation.domain.Customer;
import formation.domain.FormulaireReponses;
import formation.formation.service.itf.CustomerServiceItf;
import formation.formation.service.itf.FormulaireReponsesItf;
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

/**
 * Created by victor on 12/12/2015.
 */
public class FormulaireReponsesServiceTest {

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
        Object ejb = ctx.lookup("java:global/projet-1.0.0-SNAPSHOT/FormulaireReponsesService");
        assertNotNull(ejb);

        // Looks up the EJB
        FormulaireReponsesItf formulaire = (FormulaireReponsesItf) PortableRemoteObject.
                narrow(ejb, FormulaireReponsesItf.class);


        FormulaireReponses f = new FormulaireReponses();

        f = formulaire.create(f);
        assertNotNull(f.getIdFormulaire());
       // assertEquals(initSize + 1, userService.total());

    }
}
