package com.tcs;

import java.util.List;
import java.util.Scanner;

public class EmployeeViewController {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int menuOption = 0;
		
		EmployeeDaoImpl dao = new EmployeeDaoImpl();
		do {
			System.out.println("Enter the options below:-");
			System.out.println("1: Store 2: Retrieve by id 3: Retrieve all 4: Update salary by id 5: Delete by id 6: Exit");
			menuOption = scan.nextInt();
			switch(menuOption) {
			case 1:
				Employee e = new Employee();
				System.out.println("Enter name");
				e.setName(scan.next()); 
				System.out.println("Enter salary");
				e.setSalary(scan.nextDouble());
				int generatedKey = dao.store(e);
				System.out.println("Generated Key: "+generatedKey);
				break;
			case 2: 
				System.out.println("Enter id to search");
				Employee employee = dao.fetchEmployee(scan.nextInt());
				if(employee != null) {
					System.out.println("Employee found id: "+employee.getId()+", name: "+employee.getName()+", salary: "+employee.getSalary());
				} else {
					System.err.println("Sorry employee not found");
				}
				break;
			case 3: 
				List<Employee> employees = dao.fetchEmployees();
				for(Employee emp : employees) {
					System.out.println("Id = "+emp.getId()+", Name = "+emp.getName()+", Salary = "+emp.getSalary());
				}
				System.out.println("--------------------------------");
				break;
			case 4:
				System.out.println("Enter Id to update salary");
				Employee employee1 = dao.UpdateEmployee(scan.nextInt());
				System.out.println("Updated Successfully");
				break;
			case 5:
				System.out.println("Enter id to Delete");
				Employee employee2 = dao.DeleteEmployee(scan.nextInt());
				if(employee2 == null)
				{
					System.out.println("No id found");
				}else 
				{
					System.out.println("Delete Sucessfully");
				}
			}
		} while(menuOption != 6);
		System.out.println("Program Exits!");
		scan.close();


	}

}
