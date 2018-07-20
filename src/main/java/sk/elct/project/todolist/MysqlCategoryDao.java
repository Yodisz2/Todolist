package sk.elct.project.todolist;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MysqlCategoryDao implements CategoryDao {
	
	private JdbcTemplate jdbcTemplate;	

	public MysqlCategoryDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void add(Category category) {
		// TODO Auto-generated method stub

	}

	public List<Category> getAll() {
		String sql = "SELECT * FROM category";
		RowMapper<Category> rowMapper = new BeanPropertyRowMapper<Category>(Category.class);
		return jdbcTemplate.query(sql, rowMapper);
	}
}
