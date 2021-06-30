package com.luv2code.hibernate.demo;

import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteStudentDemo {

	public static void main(String[] args) {

//		create session factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

//		create a session
		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;

//			now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

//			retrieve student based on the id: primary key
			System.out.println("\nGetting studnet with id: " + studentId);

			Student myStudent = session.get(Student.class, studentId);

//			Delete the Student
//			System.out.println("Deleting student: "+myStudent);
//			session.delete(myStudent);
			
			
//			delete student with id=2
			System.out.println("Delete Student id=2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
//			commit the transaction
			session.getTransaction().commit();


			System.out.println("Done!!");
		} finally {
			factory.close();
		}

	}
}
