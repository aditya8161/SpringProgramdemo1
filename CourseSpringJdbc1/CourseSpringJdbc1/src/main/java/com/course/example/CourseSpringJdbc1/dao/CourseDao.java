package com.course.example.CourseSpringJdbc1.dao;

import com.course.example.CourseSpringJdbc1.entities.Course;
import com.course.example.CourseSpringJdbc1.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //add course
    public void addCourse(Course course)
    {
        String query = "insert into course1(courseId,name,description,price,catId) values(?,?,?,?,?)";

        jdbcTemplate.update(query,
                course.getCourseId(),
                course.getName(),
                course.getDescription(),
                course.getPrice(),
                course.getCatId()
                );

    }

    //get course by id
    public Course getCourseById(int courseId)
    {
        String query ="select * from course1 where courseId=?";

        Course course = jdbcTemplate.queryForObject(query,new CourseMapper(),courseId);

        return course;
    }

    //get all courses
    public List<Course> getAllCourses()
    {
        String query="select * from course1";
        List<Course> courses = jdbcTemplate.query(query, new CourseMapper());

        return courses;
    }

    //get course by category
    public List<Course> getCourseByCategory(int categoryId)
    {
        String query ="select * from course1 where catId=?";

        List<Course> categoryCourses = jdbcTemplate.query(query, new CourseMapper(), categoryId);

        return categoryCourses;
    }

    //get course by course name but like use in query
    public List<Course> getCourseByName(String search)
    {
//        String query ="SELECT * FROM course1 WHERE name LIKE '%?%';";
        String query ="SELECT * FROM course1 WHERE name LIKE ?";

        String searchPattern = "%" + search + "%";

        List<Course> courses = jdbcTemplate.query(query, new Object[]{searchPattern},new CourseMapper());


        /* new Object[]{searchPattern} -
      1)This is an array of parameters that are passed to the SQL query.
      2)searchPattern is the actual value (or dynamic string) that you want to search for in the name column of the table.
      3)For example, if you're looking for courses whose names contain the word "Java", searchPattern would be "%Java%".
      4)This array ensures that the ? placeholder in the query is replaced by the value of searchPattern when executing the query.

      explanation of new Object[]{searchPattern} (Parameters):
       `new Object[]{searchPattern}` creates an array of `Object` to hold the parameters for the SQL query.
       In Java, the `JdbcTemplate.query()` method requires parameters to be passed as an `Object[]`,
       because the parameters can be of various types (e.g., `String`, `int`).
       This allows dynamic handling of different data types in the query.
      */
        return  courses;
    }


}
