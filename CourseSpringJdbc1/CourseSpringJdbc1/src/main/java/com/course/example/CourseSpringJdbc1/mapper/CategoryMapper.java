package com.course.example.CourseSpringJdbc1.mapper;

import com.course.example.CourseSpringJdbc1.entities.Categories;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<Categories>
{
    @Override
    public Categories mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Categories cat = new Categories();
        cat.setId(rs.getInt("categoryId"));
        cat.setTitle(rs.getString("title"));
        cat.setDescription(rs.getString("description"));

        return cat;
    }
}
