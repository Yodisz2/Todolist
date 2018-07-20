package sk.elct.project.todolist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class ActivityRowMapper implements RowMapper<Activity>{


	public Activity mapRow(ResultSet rs, int rowNum) throws SQLException {
		Activity act = new Activity();
		act.setId(rs.getLong("id"));
		act.setTitle(rs.getString("title"));
		act.setPriority(rs.getInt("priority"));
		Timestamp timestamp = rs.getTimestamp("dueDate");
		if (timestamp != null) {
			act.setDueDate(timestamp.toLocalDateTime());
		}
		act.setBody(rs.getString("body"));
		act.setProgress(rs.getInt("progress"));
		
		Category cat = new Category();
		cat.setId(rs.getLong("id_category"));
		cat.setName(rs.getString("name"));
		
		act.setCategory(cat);
		return act;	
			
	}
}
