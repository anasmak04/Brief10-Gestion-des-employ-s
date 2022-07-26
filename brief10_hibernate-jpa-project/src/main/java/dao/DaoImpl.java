package dao;

import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import hibernate.Hibernate;
import model.Employee;

public class DaoImpl implements InterfaceDao {

	  /* Method to CREATE an employee in the database */
	   public void InsertEmp(Employee employee){
	      Transaction tx = null;
	      
	      try (
	    	 Session session = Hibernate.getSessionFactory().openSession();){
	         tx = session.beginTransaction();
	         session.save(employee); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) {
	        	 tx.rollback();
	         }
	         e.printStackTrace();
	      	}
	   }

	   public Employee getEmp(String refernce) {
		   Transaction tx = null;
		   Employee employee = null;
		   
		   try(Session session = Hibernate.getSessionFactory().openSession()){
			   tx = session.beginTransaction();
			   
			   employee = session.get(Employee.class, refernce);
		   
			   tx.commit();
		   } catch (HibernateException e) {
			   if (tx != null) {
				   tx.rollback();
			   }
			   e.printStackTrace();
		   }
		   return employee;
	   }
	   
	   /* Method to  READ all the employees */
	   public List <Employee> getAllEmp(){
	      Transaction tx = null;
	      List <Employee> listOfEmployee = null;
	      
	      try(Session session = Hibernate.getSessionFactory().openSession()){
	    	  tx = session.beginTransaction();
	    	  listOfEmployee = session.createQuery("from Employee").getResultList();
	    	  
	    	  tx.commit();
	         
	      } catch (HibernateException e) {
	         if (tx!=null) {
	        	 tx.rollback();
	         }
	         e.printStackTrace(); 
	      }
	      return listOfEmployee;
	   }
	   
	   /* Method to UPDATE salary for an employee */
	   public void UpdateEmp(Employee employee){
	      Transaction tx = null;
	      
	      try (Session session = Hibernate.getSessionFactory().openSession()){
	    	 tx = session.beginTransaction();
	    	 
	    	 session.update(employee);
	    	 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) {
	        	 tx.rollback();
	         }
	         e.printStackTrace(); 
	      }
	   }
	   
	   /* Method to DELETE an employee from the records */
	   public void deleteEmp(String refernce){
	      Transaction tx = null;
	      
	      try (Session session = Hibernate.getSessionFactory().openSession()){
	    	  tx = session.beginTransaction();
	    	  Employee employee = session.get(Employee.class, refernce);
	    	  if(employee != null) {
	    		  session.delete(employee);
	    		  System.out.println("Employee Deleted Successefuly");
	    	  }
	    	  
	    	  tx.commit();
	    	  
	      } catch (HibernateException e) {
	    	  if (tx != null) {
	    		  tx.rollback();
	    	  }
	    	  e.printStackTrace();
	      } 
	   }
	
}
