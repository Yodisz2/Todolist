package sk.elct.project.todolist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class MysqlActivityDao implements ActivityDao {
	
	//1. tireda ktora obaluje konektory, ...jdbc nam vytvori Daofactory
	private JdbcTemplate jdbcTemplate;	
										
	//konstruktor so vstupnym parametrom jdbctemplate a ulozime do inst premennej
	public MysqlActivityDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void add(Activity activity) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("activity");
		simpleJdbcInsert.usingGeneratedKeyColumns("id");
		simpleJdbcInsert.usingColumns("title", "priority", "dueDate", "body", "progress", "id_category");
		
		Map<String, Object> udaje = new HashMap<>();
		udaje.put("title", activity.getTitle());
		udaje.put("priority", activity.getPriority());
		udaje.put("dueDate", activity.getDueDate());
		udaje.put("body", activity.getBody());
		udaje.put("progress", activity.getProgress());
		udaje.put("id_category", activity.getCategory().getId());
		
		long noveId = simpleJdbcInsert.executeAndReturnKey(udaje).longValue();
		activity.setId(noveId);
					
	}
	//ziskat data z db
	public List<Activity> getAll(){
		String sql = "SELECT activity.id, activity.title, activity.priority, "
				+ "activity.dueDate, activity.body, activity.progress, id_category, category.name "
				+ "FROM activity JoIN category ON (activity.id_category = category.id)";
		RowMapper<Activity> rowMapper = new ActivityRowMapper();
		return jdbcTemplate.query(sql, rowMapper);
	}
		
	public void update(Activity activity) {
					String sql = "UPDATE activity SET title=?, "
					+ "priority=?, dueDate=?, body=?, progress=?, id_category=? WHERE id =?";
			jdbcTemplate.update(sql, activity.getTitle(), 
					activity.getPriority(), activity.getDueDate(), activity.getBody(), 
					activity.getProgress(), activity.getCategory().getId(), activity.getId());
		}		
}
