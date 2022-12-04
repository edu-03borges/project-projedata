package modules;

import java.math.BigDecimal;

public class Employees extends People {

	private BigDecimal wage;
	private String employeePosition;
	
	// Constructor
	public Employees() {}
	
	public void setWage(BigDecimal wage)
	{
		this.wage = wage;
	}
	
	public void setEmployeePosition(String employeePosition)
	{
		this.employeePosition = employeePosition;
	}
	
	public BigDecimal getWage()
	{
		return this.wage;
	}
	
	public String getEmployeePosition()
	{
		return this.employeePosition;
	}
	
	public void minimumWage()
	{
		BigDecimal salary = getWage();
				
		double num = salary.doubleValue();
		
		num = num / 1212.00;
		
		System.out.printf("%20s %20.1f Salários Mínimos\n", this.getName(), num);
	}
	
	public void salaryIncrease(double porcent)
	{
		BigDecimal wage = this.getWage();
		
		BigDecimal result = new BigDecimal(porcent/100);
		
		BigDecimal mult = wage.multiply(result);
		
		wage = wage.add(mult);
		
		this.wage = wage;
	}
}
