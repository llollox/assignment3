package assignment3.hibernate;

import java.io.File;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import assignment3.model.Person;

public class PersonHibernate {

	public static Person getPerson(Long p_id) {
		Session session = Hibernate.getSessionFactory().openSession();
		Transaction transaction = null;
		Person person = null;
		try {
			transaction = session.beginTransaction();
			person = (Person) session.get(Person.class, p_id);
			transaction.commit();
		} catch (HibernateException e) {
			// rollback transaction
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		
		return person;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Person> getPeople() {
		Session session = Hibernate.getSessionFactory().openSession();
		Transaction transaction = null;
		ArrayList<Person> people = null;

		try {
			transaction = session.beginTransaction();
			people = (ArrayList<Person>) session.createCriteria(Person.class).list();
			transaction.commit();
		} catch (HibernateException e) {
			// rollback transaction
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return people;
	}
	
	public static Long savePerson(Person person) {
		Session session = Hibernate.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			Long id = (Long) session.save(person);
			person.setPerson_id(id);

			transaction.commit();

		} catch (HibernateException e) {
			// rollback transaction
			if (transaction != null) {
				transaction.rollback();
				return (long) -1;
			}
		} finally {
			session.close();
		}

		return person.getPerson_id();
	}

	public static Long updatePerson(Person person) {
		Session session = Hibernate.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			session.update(person);
			person = (Person) session.get(Person.class, person.getPerson_id());

			transaction.commit();

		} catch (HibernateException e) {
			// rollback transaction
			if (transaction != null) {
				transaction.rollback();
				return (long) -1;
			}
		} finally {
			session.close();
		}

		return person.getPerson_id();
	}

	public static Long deletePerson(Long p_id) {
		Session session = Hibernate.getSessionFactory().openSession();
		Transaction transaction = null;
		Person person = null;
		try {
			transaction = session.beginTransaction();

			person = (Person) session.get(Person.class, p_id);
			session.delete(person);

			transaction.commit();

		} catch (HibernateException e) {
			// rollback transaction
			if (transaction != null) {
				transaction.rollback();
				return (long) -1;
			}
		} finally {
			session.close();
		}

		return (long) 0;
	}

}

