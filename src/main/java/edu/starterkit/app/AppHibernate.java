package edu.starterkit.app;

import java.util.List;

import org.hibernate.Query;
/* STEP 1. Import required packages
 * Import the packages: Requires that you include the packages containing the JDBC classes needed
 * for database programming. Most often, using import org.hibernate.* will suffice.
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import edu.starterkit.model.Country;

public class AppHibernate {

	public static void main(String[] args) {
		/*
		 * STEP 2: Create standard service registry 
		 * Creates a standard service registry and configures registry
		 *  settings from hibernate.cfg.xml 
		 */
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		/*
		 * STEP 3: Create session factory 
		 * A session factory is set up once for an application!
		 */
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		/*
		 * STEP 4: Create session  
		 */
		Session session = sessionFactory.openSession();
		
		/* STEP 5: Create named query
		 * Named query to read the existing entries and write to console
		 */
		Query q = session.getNamedQuery("Country.findAll");
		List<Country> result = q.list();
		for (Country country : result) {
			System.out.println(country);
		}
		System.out.println("Size: " + result.size());

		/*
		 * STEP 6: Close session  
		 */
		session.close();
	}
}