package main;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import database.CRUD;
import modules.Employees;

public class Main {
	
	static void loadInformations(Connection connection)
	{
		
		int size = 10;
		
		Employees employees[] = new Employees[size];
		 
		for(int i=0; i<size; i++)
		{
			employees[i] = new Employees();
		}
		
		employees[0].setName("Maria");
		employees[0].setBirthDate("18-10-2000");
		employees[0].setWage(new BigDecimal(2009.44));
		employees[0].setEmployeePosition("Operador");
	
		employees[1].setName("João");
		employees[1].setBirthDate("12-05-1990");
		employees[1].setWage(new BigDecimal(2284.38));
		employees[1].setEmployeePosition("Operador");

		employees[2].setName("Caio");
		employees[2].setBirthDate("02-05-1961");
		employees[2].setWage(new BigDecimal(9836.14));
		employees[2].setEmployeePosition("Cordenador");
		 
		employees[3].setName("Miguel");
		employees[3].setBirthDate("14-10-1988");
		employees[3].setWage(new BigDecimal(19119.88));
		employees[3].setEmployeePosition("Diretor");
		 
		employees[4].setName("Alice");
		employees[4].setBirthDate("05-01-1995");
		employees[4].setWage(new BigDecimal(2234.68));
		employees[4].setEmployeePosition("Recepcionista");
		 
		employees[5].setName("Heitor");
		employees[5].setBirthDate("19-11-1999");
		employees[5].setWage(new BigDecimal(1582.72));
		employees[5].setEmployeePosition("Operador");
		 
		employees[6].setName("Arthur");
		employees[6].setBirthDate("31-03-1993");
		employees[6].setWage(new BigDecimal(4071.84));
		employees[6].setEmployeePosition("Contador");
		 
		employees[7].setName("Laura");
		employees[7].setBirthDate("08-07-1994");
		employees[7].setWage(new BigDecimal(3017.45));
		employees[7].setEmployeePosition("Gerente");
		 
		employees[8].setName("Heloísa");
		employees[8].setBirthDate("24-05-2003");
		employees[8].setWage(new BigDecimal(1606.85));
		employees[8].setEmployeePosition("Eletrecista");
		 
		employees[9].setName("Helena");
		employees[9].setBirthDate("02-09-1996");
		employees[9].setWage(new BigDecimal(2799.93));
		employees[9].setEmployeePosition("Gerente");
		
		CRUD crud = new CRUD();
		
		insertEmployees(employees, size, crud, connection);

		deleteEmployer(employees, "João", size, crud, connection);
		
		updateWage(employees, size, crud, connection);
			
		joinMap(employees, size);
		
		printBirthDate(crud, connection, "10", "12");
		
		olderAge(crud, connection);
		
		orderByAscName(crud, connection);
		
		totalSalary(employees, size);
		
		minimumWage(employees, size);
					
		System.out.print("\n\nSoftware Finalizado!\n");
	}
	
	static void olderAge(CRUD crud, Connection connection)
	{
		Scanner sc = new Scanner(System.in);
		String lastName;
		
		System.out.print("Mostrando o funcionário mais velho de idade, Agora Irei Imprimir a Tabela Para Você Verificar!\n");
        System.out.print("\nPressione Enter...\n\n");
        lastName = sc.nextLine();
		
		crud.olderAge(connection);
		
        System.out.print("\nPressione Enter Para ir Para a Proxíma Etapa...");
        lastName = sc.nextLine();
		
		clearDisplay();
		
	}
	
	static void orderByAscName(CRUD crud, Connection connection)
	{
		Scanner sc = new Scanner(System.in);
		String lastName;
		
		System.out.print("Funcionários ordenados em ordem alfabética, Agora Irei Imprimir a Tabela Para Você Verificar!\n");
        System.out.print("\nPressione Enter...\n\n");
        lastName = sc.nextLine();
		
		crud.orderByAscName(connection);

        System.out.print("\nPressione Enter Para ir Para a Proxíma Etapa...");
        lastName = sc.nextLine();
		
		
		clearDisplay();		
	}
	
	static void printBirthDate(CRUD crud, Connection connection, String d1, String d2)
	{
		Scanner sc = new Scanner(System.in);
		String lastName;
		
		System.out.print("Mostrando apenas os funcionários nascidos nos meses 10 e 12, Agora Irei Imprimir a Tabela Para Você Verificar!\n");
        System.out.print("\nPressione Enter...\n\n");
        lastName = sc.nextLine();
        
		crud.printBirthDate(connection, d1, d2);
	    
        System.out.print("\nPressione Enter Para ir Para a Proxíma Etapa...");
        lastName = sc.nextLine();
		
		clearDisplay();
	}

	static void joinMap(Employees employees[], int size)
	{
		
		Scanner sc = new Scanner(System.in);
		String lastName;
		
		System.out.print("Mostrando os funcionários agrupados por função, Agora Irei Imprimir a Tabela Para Você Verificar!\n");
        System.out.print("\nPressione Enter...\n\n");
        lastName = sc.nextLine();
        
		Map<String, String> list = new HashMap<>();		
		
		for(int i=0; i<size; i++)
		{
			if(list.get(employees[i].getEmployeePosition()) == null)
			{
				list.put(employees[i].getEmployeePosition(), employees[i].getName());					
			}
			else 
			{
				list.put(employees[i].getEmployeePosition(), list.get(employees[i].getEmployeePosition()) + " | " + employees[i].getName());
			}
		}
		
		System.out.printf("%20s %35s\n\n", "Função", "Funcionários");
		
		for(String key : list.keySet())
		{
			System.out.printf("%20s %35s\n\n", key, list.get(key));
		}
		
        System.out.print("\nPressione Enter Para ir Para a Proxíma Etapa...");
        lastName = sc.nextLine();

	}
	
	static void minimumWage(Employees employees[], int size)
	{
		Scanner sc = new Scanner(System.in);
		String lastName;
		
		System.out.print("Salários mínimos recebidos pelos funcionarios, Agora Irei Imprimir a Tabela Para Você Verificar!\n");
        System.out.print("\nPressione Enter...\n\n");
        lastName = sc.nextLine();
		
		System.out.printf("%20s %35s\n\n", "Nome", "Qtd Salários Minímos");
		
		for(int i=0; i<size; i++)
		{
			employees[i].minimumWage();
		}
		
	    System.out.print("\nPressione Enter Para ir Para a Proxíma Etapa...");
        lastName = sc.nextLine();
		
		clearDisplay();
	}
	
	static void totalSalary(Employees employees[], int size)
	{
		Scanner sc = new Scanner(System.in);
		String lastName;
		
		System.out.print("Mostrando o total do salário de todos os funcionários, Agora Irei Imprimir a Tabela Para Você Verificar!\n");
        System.out.print("\nPressione Enter...\n\n");
        lastName = sc.nextLine();
		
		BigDecimal total = new BigDecimal(0);

		String wageFormat;
		
		Locale localeBR = new Locale("pt","BR");
		
		NumberFormat wage = NumberFormat.getCurrencyInstance(localeBR);
		
		for(int i=0; i<size; i++)
		{
			total = total.add(employees[i].getWage());
		}
		
		wageFormat = String.valueOf(wage.format(total));
		
		System.out.println("Salário Total de Todos os Funcionários: " + wageFormat);

	    System.out.print("\nPressione Enter Para ir Para a Proxíma Etapa...");
        lastName = sc.nextLine();
		
		clearDisplay();
	}
	
	static void deleteEmployer(Employees employees[], String name, int size, CRUD crud, Connection connection)
	{
		for(int i=0; i<size; i++)
		{
			if(employees[i].getName() == name)
			{
				crud.deleteEmployees(connection, employees[i]);
			}
		}
		
		Scanner sc = new Scanner(System.in);
		String lastName;
		
        System.out.print("Deletado o funcionário João, agora irei imprimir a tabela na tela para você verificar!\n");
        System.out.print("\nPressione enter...\n\n");
        lastName = sc.nextLine();
        
        crud.printEmployeers(connection);
        
        System.out.print("\nPressione enter para ir para a proxíma etapa...");
        lastName = sc.nextLine();
        
        clearDisplay();
	}
	
	static void insertEmployees(Employees employees[], int size, CRUD crud, Connection connection)
	{
		for(int i=0; i<size; i++)
		{
			crud.insertEmployees(connection, employees[i]);
		}
		
		Scanner sc = new Scanner(System.in);
		String lastName;
		
        System.out.print("Inserido Todos os Funcionários na Tabela, Agora Irei Imprimir a Tabela na Tela Para Você Verificar!\n");
        System.out.print("\nPressione Enter...\n\n");
        lastName = sc.nextLine();
        
        crud.printEmployeers(connection);
        
        System.out.print("\nPressione Enter Para ir Para a Proxíma Etapa...");
        lastName = sc.nextLine();
		
        clearDisplay();
	}
	
	static void clearDisplay()
	{
		System.out.println(
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
				+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
				+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
				+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
				+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
				+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	static void updateWage(Employees employees[], int size, CRUD crud, Connection connection)
	{
		for(int i=0; i<size; i++)
		{
			employees[i].salaryIncrease(10);
			crud.updateWage(connection, employees[i]);
		}
	
		Scanner sc = new Scanner(System.in);
		String lastName;

        System.out.print("Atualizado o Salário Com 10% de Aumento de Todos os Funcionários da Tabela, Agora Irei Imprimir a Tabela na Tela Para Você Verificar!\n");
        System.out.print("\nPressione Enter...\n\n");
        lastName = sc.nextLine();
        
        crud.printEmployeers(connection);
        
        System.out.print("\nPressione Enter Para ir Para a Proxíma Etapa...");
        lastName = sc.nextLine();
		
		clearDisplay();

	}
	
	public static void main(String[] args) {
		
		String driver = "com.mysql.jdbc.Driver"; 
		String url = "jdbc:mysql://localhost:3306/sistema_de_funcionarios";
		String user = "root";
		String password = "012007";
		
		Connection connection;
		
		try {
			
			connection = DriverManager.getConnection(url, user, password);
	
			loadInformations(connection);
			
		} catch (SQLException ex) {
			
			System.out.println("Ocorreu um erro ao acessar o banco");
		
		}		
	}

}