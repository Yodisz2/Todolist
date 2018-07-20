package sk.elct.project.todolist;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.jdbc.MysqlDataSource;

public enum DaoFactory {
	INSTANCE; // vytvotrena activitydaofactory je ulozene tu
		
	//private ActivityDao activityDao; adresa k dataze
	private MysqlDataSource getDataSource() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUrl("jdbc:mysql://localhost/todolist?" +
				"serverTimezone=Europe/Bratislava&nullNamePatternMatchesAll=true");
		dataSource.setDatabaseName("todolist");
		dataSource.setUser("debilnicek");
		dataSource.setPassword("todolist");
		return dataSource;
	}
	
	//chceme vratit activityDao, pomocou jdbcTemplate sa bude pripajat na db
	//vytvori pripojenie k databaze
	public ActivityDao getActivityDao() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(this.getDataSource());
		return new MysqlActivityDao(jdbcTemplate);	
	}
	public CategoryDao getCategoryDao() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(this.getDataSource());
		return new MysqlCategoryDao(jdbcTemplate);
	}
}
