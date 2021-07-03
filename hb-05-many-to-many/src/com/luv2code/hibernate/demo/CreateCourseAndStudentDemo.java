package com.luv2code.hibernate.demo;

import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {

//		create session factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

//		create a session
		Session session = factory.getCurrentSession();

		try {


//			start a transaction
			session.beginTransaction();


//			create a course
			Course tempCourse = new Course("Pacman - How to Score one million points");
			
//			add some reviews
			tempCourse.addReview(new Review("Great course ... loved it!"));
			tempCourse.addReview(new Review("Cool course, job well done"));
			tempCourse.addReview(new Review("Bullshit!!!"));
			
//			save the course ... and leverage the cascade all
			System.out.println("Saving the Course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			session.save(tempCourse);
			
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
