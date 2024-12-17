package com.course.example.CourseSpringJdbc1;

import com.course.example.CourseSpringJdbc1.dao.CategoriesDao;
import com.course.example.CourseSpringJdbc1.dao.CourseDao;
import com.course.example.CourseSpringJdbc1.entities.Categories;
import com.course.example.CourseSpringJdbc1.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CourseSpringJdbc1Application implements CommandLineRunner
{
	@Autowired
	private CategoriesDao categoriesDao;

	@Autowired
	private CourseDao courseDao;

	public static void main(String[] args)
	{
		SpringApplication.run(CourseSpringJdbc1Application.class, args);
		System.out.println("Application starting ");

	}

	@Override
	public void run(String... args) throws Exception
	{
		//add categories
//		Categories cat = new Categories();
//		cat.setId(102);
//		cat.setTitle("Live Course");
//		cat.setDescription("This is live course category");
//		categoriesDao.addCategories(cat);

		//get category by id
//		int categoryId=101;
//		Categories c1= categoriesDao.getCategoryById(102);
//		System.out.println(c1.getId()+"-->"+c1.getTitle()+"-->"+c1.getDescription());

		//get all category
//		List<Categories> cat = categoriesDao.getAllCategory();
//		for(Categories c : cat)
//		{
//			System.out.println("----------------------------------");
//			System.out.println(c.getId()+", "+c.getTitle()+", "+c.getDescription());
//		}


	//=======================Course code Start============================
//		Course course = new Course();
//		course.setCourseId(202404);
//		course.setName("Spring Boot");
//		course.setDescription("This is complete Spring Boot course");
//		course.setPrice(9999);
//		course.setCatId(102);
//
//		courseDao.addCourse(course);

		//get course by id
//		Course course = courseDao.getCourseById(202403);
//		System.out.println(course.getName()+", "+course.getDescription()+", "+course.getPrice());

		//get all courses
//		List<Course> courses = courseDao.getAllCourses();
//		for(Course course : courses)
//		{
//			System.out.println(course.getCourseId()+", "+course.getName()+", "+course.getDescription()+", "+course.getPrice());
//			System.out.println("--------------------------------");
//		}

		//get course according category
//		List<Course> courseByCategory = courseDao.getCourseByCategory(102);
//		for(Course course : courseByCategory)
//		{
//			System.out.println(course.getCourseId()+", "+course.getName()+", "+course.getDescription()+", "+course.getPrice());
//			System.out.println("--------------------------------");
//		}

		//get course from course name but use like in query
//		List<Course> courses = courseDao.getCourseByName("python");
//		for(Course course : courses)
//		{
//			System.out.println(course.getCourseId()+", "+course.getName()+", "+course.getDescription()+", "+course.getPrice());
//			System.out.println("--------------------------------");
//		}

		//get course by category name
	}
}
