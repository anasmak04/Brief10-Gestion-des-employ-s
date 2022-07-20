package dao;

import java.util.List;

import model.Employee;

public interface InterfaceDao {
		
    public void InsertEmp(Employee employee);
    public void UpdateEmp(Employee employee);
    public void deleteEmp(String refernce);
    public Employee getEmp(String refernce);
    public List < Employee > getAllEmp();

    
}
