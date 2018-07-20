package sk.elct.project.todolist;

import java.util.List;

public interface CategoryDao {
	
	//C-REATE
	void add(Category category);
	
	//R-EAD
	List<Category> getAll();
	
	//U-PDATE
	//void update(Category category);
		
	//D-ELETE
	//void delete(long id);

}
