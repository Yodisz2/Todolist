package sk.elct.project.todolist;

import java.util.List;

public interface ActivityDao {
	
	//C-REATE
	//vstky metody su automaticky public, preto sa nepisu
	void add(Activity activity); 
	
	//R-EAD
	List<Activity> getAll();
	
	//U-PDATE
	void update(Activity activity);
	
	//D-ELETE
	//void delete(long id);

}