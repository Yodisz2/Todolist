package sk.elct.project.todolist;

import java.time.LocalDateTime;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
       ActivityDao dao = DaoFactory.INSTANCE.getActivityDao(); 
      
//       for(Activity aktivita : aktivity) {
//    		System.out.println( aktivita.getTitle() );
//    	}
//       		
       		Activity pridat = new Activity();
       		pridat.setTitle("Spravit nakup");
       		pridat.setPriority(3);
       		pridat.setDueDate(LocalDateTime.now());
       		pridat.setBody("Nezabudnut zoznam");
       		pridat.setProgress(1);
       		Category kako = new Category();
       		kako.setId(4L);
       		kako.setName("new category");
       		pridat.setCategory(kako);
       		dao.add(pridat);
       		
       		//pridat.getCategory().getId();
       	 List<Activity> aktivity = dao.getAll();	
      	System.out.println( aktivity.toString());
       	
//      	Activity prvy = aktivity.get(3);
//      	System.out.println( prvy);
//      	prvy.setTitle("Pripravit veceru");
//      	prvy.setDueDate(LocalDateTime.now());
//      	prvy.setBody("Nakrajat zeleninu");
//      	dao.update(prvy);
//   	    System.out.println( prvy);
//        CategoryDao dao2 = DaoFactory.INSTANCE.getCategoryDao();
//        List<Category> kategoria = dao2.getAll();
//        for(Category category: kategoria) {
//    		System.out.println( category.getName() +"\t "+ category.getId());
//    	}   	
    }
}
