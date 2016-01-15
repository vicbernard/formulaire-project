package formation.formation.service;

import formation.classTmp.ReponseMoyenne;
import formation.domain.Customer;
import formation.domain.Reponse;
import formation.formation.service.rest.CustomerRestService;
import formation.formation.service.rest.ReponseRestService;
import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("rs")
public class ApplicationConfig extends Application {

  // ======================================
  // =             Attributes             =
  // ======================================

  private final Set<Class<?>> classes;

  // ======================================
  // =            Constructors            =
  // ======================================

  public ApplicationConfig() {
    HashSet<Class<?>> c = new HashSet<>();
    c.add(CustomerRestService.class);
    c.add(Customer.class);
    c.add(ReponseRestService.class);
    c.add(Reponse.class);
    c.add(ReponseMoyenne.class);
//
    c.add(MOXyJsonProvider.class);

    classes = Collections.unmodifiableSet(c);
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  @Override
  public Set<Class<?>> getClasses() {
    return classes;
  }
}