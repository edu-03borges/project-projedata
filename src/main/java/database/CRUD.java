package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JOptionPane;

import modules.Employees;

public class CRUD {
	
	//Constructor
	public CRUD() {}
	
	public void insertEmployees(Connection connection, Employees employees)
	{	
		try {
			
			Locale localeBR = new Locale("pt","BR");
			
			NumberFormat wage = NumberFormat.getCurrencyInstance(localeBR);
			
			String wageFormat = String.valueOf(wage.format(employees.getWage()));
			
			connection.createStatement().execute("INSERT INTO funcionarios (name, birth_date, wage, employee_position) VALUES ("
					+ "\"" + employees.getName() + "\","
					+ "STR_TO_DATE('" + employees.getBirthDate() + "', '%d/%m/%Y'),"
					+ "\"" + wageFormat + "\","
					+ "\"" + employees.getEmployeePosition() + "\""
					+ ");");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void olderAge(Connection connection)
	{
		ResultSet rsClient;
			
			try {
				
				rsClient = connection.createStatement().executeQuery("SELECT name, TIMESTAMPDIFF(YEAR, birth_date, NOW()) as \"idade\" FROM funcionarios ORDER BY idade DESC limit 1;");
				
				System.out.printf("%20s %20s\n\n", "Name", "Age");
				
				String nameEmployee = null;
				String ageEmployee = null;
					
				rsClient.next();
				
				nameEmployee = rsClient.getString("name");
				ageEmployee = rsClient.getString("idade");
					
				System.out.printf("%20s %20s\n", nameEmployee, ageEmployee);
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
	}
	
	public void updateWage(Connection connection, Employees employees) 
	{
		try {
			
			Locale localeBR = new Locale("pt","BR");
			
			NumberFormat wage = NumberFormat.getCurrencyInstance(localeBR);
			
			String wageFormat = String.valueOf(wage.format(employees.getWage()));
			
			connection.createStatement().execute("UPDATE funcionarios SET wage = \"" + wageFormat + "\"WHERE name = \"" + employees.getName() + "\";");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void deleteEmployees(Connection connection, Employees employees)
	{
		try {
			
			connection.createStatement().execute("DELETE FROM funcionarios WHERE name = \"" + employees.getName() + "\";");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void printBirthDate(Connection connection, String date1, String date2)
	{
		ResultSet rsClient;
		
		try {
			
			rsClient = connection.createStatement().executeQuery("SELECT * FROM funcionarios "
					+ "WHERE Month(birth_date) between '" + date1 +  "' AND '" + date2 + "';");
			
			this.printScreen(rsClient);
							
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	public void printEmployeers(Connection connection)
	{
		ResultSet rsClient;
		
		try {
			
			rsClient = connection.createStatement().executeQuery("SELECT * FROM funcionarios");
			
			this.printScreen(rsClient);
					
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	public void orderByAscName(Connection connection)
	{
		ResultSet rsClient;
		
		try {
			
			rsClient = connection.createStatement().executeQuery("SELECT * FROM funcionarios ORDER BY name asc;");
				
			this.printScreen(rsClient);
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}	
	
	public void printScreen(ResultSet rsClient)
	{
		String nameEmployee = null;
		String birthDateEmployee = null;
		String wageEmployee = null;
		String employeePosition = null;
		
		LocalDate date;
		
		System.out.printf("%20s %20s %20s %20s\n\n", "Name", "Birth Date",  "Wage", "Employee Position");
			
		try {
			
			while (rsClient.next()) {
				
				nameEmployee = rsClient.getString("name");
				birthDateEmployee = rsClient.getString("birth_date");
				wageEmployee = rsClient.getString("wage");
				employeePosition = rsClient.getString("employee_position");
				
				date = LocalDate.parse(birthDateEmployee, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
				String formatNow = date.format(formatter);
				
				System.out.printf("%20s %20s %20s %20s\n", nameEmployee, formatNow, wageEmployee, employeePosition);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
