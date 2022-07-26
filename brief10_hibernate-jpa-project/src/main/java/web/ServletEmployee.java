package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.DaoImpl;
import model.Employee;

@WebServlet("/")
public class ServletEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoImpl daoImpl;
       
	public void init() {
		daoImpl = new DaoImpl();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		try {
				switch(action) {
				case"/dashboard":
					showNewForm(request, response);
					break;
				case"/add":
					insertEmp(request, response);
					break;
				case"/delete":
					deletEmp(request, response);
					break;
				case"/update":
					updateEmp(request, response);
					break;
				case"/edit":
					showEditForm(request, response);
					break;
				default:
					getAllEmp(request, response);
					break;
				}
			} catch(SQLException ex) {
				throw new ServletException(ex);
			}
		
	}

	private void updateEmp(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String refernce = request.getParameter("refernce");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String adresse = request.getParameter("adresse");
		String contact = request.getParameter("contact");
		Employee employee = new Employee(refernce, firstname, lastname, email, adresse, contact);
		daoImpl.UpdateEmp(employee);
		response.sendRedirect("dashboard");
	}

	private void getAllEmp(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
			List<Employee> getAllEmp = daoImpl.getAllEmp();
			request.setAttribute("getAllEmp", getAllEmp);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		String refernce = request.getParameter("refernce");
		Employee existingEmployee = daoImpl.getEmp(refernce);
		RequestDispatcher dispatcher = request.getRequestDispatcher("insertEmp.jsp");
		request.setAttribute("employee", existingEmployee);
		dispatcher.forward(request, response);
	}

	private void deletEmp(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String refernce = request.getParameter("refernce");
		daoImpl.deleteEmp(refernce);
		response.sendRedirect("dashboard");
	}

	private void insertEmp(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String refernce = request.getParameter("refernce");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String adresse = request.getParameter("adresse");
		String contact = request.getParameter("contact");
		Employee newEmployee = new Employee(refernce, firstname, lastname, email, adresse, contact);
		daoImpl.InsertEmp(newEmployee);
		response.sendRedirect("list");		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
		dispatcher.forward(request, response);
		
	}


}
