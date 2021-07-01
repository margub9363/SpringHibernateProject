package com.luv2code.hibernate.demo;

import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateCoursesDemo {

	public static void main(String[] args) {

//		create session factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

//		create a session
		Session session = factory.getCurrentSession();

		try {

//			create the object
			Instructor tempInstructor = new Instructor("Susan", "Public", "susan@luv2code.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www/luv2code.com", "Video Game");

//			associate the object
			tempInstructor.setInstructorDetail(tempInstructorDetail);

//			start a transaction
			session.beginTransaction();

//			save the instructor
//			Note: this will save the details object because of cascadeType.ALL
//			
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);

//			commit transaction
			session.getTransaction().commit();

			System.out.println("Done!!");
		} finally {

//			add clean up code
			session.close();
			
			factory.close();
		}

	}
}
