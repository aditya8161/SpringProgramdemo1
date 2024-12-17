package com.course.example.CourseSpringJdbc1.dao;

import com.course.example.CourseSpringJdbc1.entities.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriesDao
{
       @Autowired
       private JdbcTemplate jdbcTemplate;

       //add categories
       public void addCategories(Categories categories)
       {
           String query = "insert into categories1(categoryId,title,description) values(?,?,?)";

           int row = jdbcTemplate.update(query,categories.getId(),categories.getTitle(),categories.getDescription());
           System.out.println(row+" effected");
       }

       //get category by id
        public Categories getCategoryById(int categoryId)
        {
            String query = "select * from categories1 where categoryId=?";
            //this is not work
            //Categories category = jdbcTemplate.queryForObject(query,Categories.class,categoryId);

            Categories cat1 = jdbcTemplate.queryForObject(query, (rs, rowNum) -> {
                Categories cat = new Categories();
                cat.setId(rs.getInt("categoryId"));
                cat.setTitle(rs.getString("title"));
                cat.setDescription(rs.getString("description"));

                return cat;
            }, categoryId);

            return cat1;
        }

        //get all course
        public List<Categories> getAllCategory()
        {
            String query ="select * from categories1";

            List<Categories> categories = jdbcTemplate.query(query, (rs, rowNum) -> {
                Categories category = new Categories();
                category.setId(rs.getInt("categoryId"));
                category.setTitle(rs.getString("title"));
                category.setDescription(rs.getString("description"));

                return category;
            });

            return categories;
        }
}
