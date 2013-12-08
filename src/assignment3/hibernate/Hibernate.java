package assignment3.hibernate;

import java.io.File;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Hibernate {

	private static SessionFactory sessionFactory = null;
	private static ServiceRegistry serviceRegistry = null;

	static {
		File file = new File("resources/hibernate.cfg.xml");

		Configuration configuration = new Configuration();
		configuration.configure(file);
		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry(); 
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
