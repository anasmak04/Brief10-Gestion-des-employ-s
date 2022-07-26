package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Employee;
import dao.DaoImpl;

public class HibernateTest {
	
	
	public static void main(String[] args) {

        DaoImpl daoImpl = new DaoImpl();
		
        DaoImpl EmployeeService = new DaoImpl();
        Employee emp1 = new Employee("D150006573", "Karamazov", "Dostoevsky", "Karamazov.Dostoevsky@titrit.com", "Hay Tilila, Agadir", "+212765435290");
        Employee emp2 = new Employee("c219998700", "Leo", " Tolstoy", "Leo.Tolstoy@titrit.com", "Hay Al-Tomor, Agadir", "+212767687980");
        Employee emp3 = new Employee("C120008713", "Jeff", "Austen", "jeff.austen", "Hay Al hoda, Agadir", "+21268362763");
        System.out.println("*** Insert - start ***");
		daoImpl.InsertEmp(emp1);
        daoImpl.InsertEmp(emp2);
        daoImpl.InsertEmp(emp3);
        List<Employee> empls = daoImpl.getAllEmp();
        System.out.println("Books Persisted are :");
        for (Employee b : empls) {
            System.out.println("-" + b.toString());
        }
        System.out.println("*** Persist - end ***");
        
        
//        System.out.println("*** Update - start ***");
//        book1.setTitle("The Idiot");
//        bookService.update(book1);
//        System.out.println("Book Updated is =>" +bookService.findById(book1.getId()).toString());
//        System.out.println("*** Update - end ***");
//        System.out.println("*** Find - start ***");
//        String id1 = book1.getId();
//        Book another = bookService.findById(id1);
//        System.out.println("Book found with id " + id1 + " is =>" + another.toString());
//        System.out.println("*** Find - end ***");
//        System.out.println("*** Delete - start ***");
//        String id3 = book3.getId();
//        bookService.delete(id3);
//        System.out.println("Deleted book with id " + id3 + ".");
//        System.out.println("Now all books are " + bookService.findAll().size() + ".");
//        System.out.println("*** Delete - end ***");
//        System.out.println("*** FindAll - start ***");
//        List<Book> books2 = bookService.findAll();
//        System.out.println("Books found are :");
//        for (Book b : books2) {
//            System.out.println("-" + b.toString());
//        }
//        System.out.println("*** FindAll - end ***");
//        System.out.println("*** DeleteAll - start ***");
//        bookService.deleteAll();
//        System.out.println("Books found are now " + bookService.findAll().size());
//        System.out.println("*** DeleteAll - end ***");
//         System.exit(0);
		}
		
		
	}

