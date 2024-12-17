package com.course.example.CourseSpringJdbc1.mapper;

import com.course.example.CourseSpringJdbc1.entities.Course;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseMapper implements RowMapper<Course>
{
    @Override
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
        Course course = new Course();
        course.setCourseId(rs.getInt("courseId"));
        course.setName(rs.getString("name"));
        course.setDescription(rs.getString("description"));
        course.setPrice(rs.getInt("price"));
        course.setCatId(rs.getInt("catId"));
        return course;
    }
}
