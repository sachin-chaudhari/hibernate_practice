package org.sachin.practice;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sachin.practice.dto.Address;
import org.sachin.practice.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		UserDetails user2 = new UserDetails();
		Address addr = new Address();
		addr.setStreet("Yerwada");
		addr.setCity("Pune");
		
		user.setUserName("First User");
		user.setAddress(addr);
		user.setJoinedDate(new Date());
		user.setDescription("First user's description");
		
		user2.setUserName("Second user");
		user2.setAddress(addr);
		user2.setJoinedDate(new Date());
		user2.setDescription("Second user's description");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		System.out.println("User = " + user);
		System.out.println("User2 = " + user);
		
	}

}
