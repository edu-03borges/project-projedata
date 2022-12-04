package modules;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

public class People {
	
	private String name;
	private LocalDate birthDate;
	
	// Constructor
	public People() {}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setBirthDate(String birthDate)
	{	
		this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getBirthDate()
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String formatNow = this.birthDate.format(formatter);
		
		return formatNow;
	}
}

