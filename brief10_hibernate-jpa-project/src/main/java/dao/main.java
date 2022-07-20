package dao;

import model.Employee;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoImpl  dao = new DaoImpl();
//		User UserInsert = new User(22, "makhloufi","anas","anasdr@gmail.com","rabat wifaq n 340","Ratab","Morocco"); 
		Employee emp = new Employee("km44","anas","souad","anas@google.com","agadir web","2123904873");
			dao.InsertEmp(emp);
	}

}
