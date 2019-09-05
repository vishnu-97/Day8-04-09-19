package com.jdbc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Operations ops=new Operations();
		do {
			System.out.println("\n\nPlease Enter" + "\n1.Add Employee" + "\n2.View All Employees"
					+ "\n3.Remove Employee" + "\n4.Clear Data" + "\n5.Change Salary" + "\n6.Search Employee"
					+ "\n7.View Depart" + "\n8.Sort and view" + "\n9.Exit");
			int o = 0;
			try {
				o = in.nextInt();

				switch (o) {
				case 1: {
					in.nextLine();
					System.out.print("Name=");
					String n = in.nextLine();
					System.out.print("Salary=");
					int s = in.nextInt();
					in.nextLine();

					System.out.print("Designation=");
					String des = in.nextLine();
					System.out.print("Department=");
					String dep = in.nextLine(); 
					 ops.insert(n, s, dep, des);
					break;
				}
				case 2: {
					ops.view();
					break;
				}
				case 3: {
					System.out.print("EmployeeNo=");
					int id = in.nextInt();
					ops.delete(id);
					break;
				}
				case 4: {
					ops.truncate();
					break;
				}
				case 5: {
					System.out.print("EmployeeNo=");
					int id = in.nextInt();
					System.out.print("Salary=");
					int sal = in.nextInt();
					ops.update(sal, id);
					
					break;
				}
				case 6: {
					System.out.print("EmployeeNo=");
					int id = in.nextInt();
					ops.view("where eno="+id);
					break;
				}
				case 7: {

					System.out.println("Choose department=");
					ops.viewDepartments();
					System.out.print("Department=");
					in.nextLine();

					String dep = in.nextLine();
					if (ops.view("where department='"+dep+"'")==0)
						System.out.println("Invalid Department");
					break;
				}
				case 8: {

					System.out.println("Choose sort by=" +
					"\n1.EmployeeNo ascending" + 
							"\n2.EmployeeNo descending"+
							"\n3.Salary ascending" + 
							"\n4.Salary descending" + 
							"\n5.Department ascending"+
							"\n6.Department descending" + 
							"\n7.designation ascending" + 
							"\n8.designation descending"
							+ "\n9.Name ascending"
							+ "\n10.Name descending");
					int o1 = in.nextInt();

					switch(o1) {
						case 1:{
							
							ops.view("order by eno");
							break;
						}
						case 2:{
							ops.view("order by eno desc");
							break;
						}
						case 3:{
							ops.view("order by salary ");
							break;
						}
						case 4:{
							ops.view("order by salary desc");
							break;
						}
						case 5:{
							ops.view("order by department");
							break;
						}
						case 6:{
							ops.view("order by department desc");
							break;
						}
						case 7:{
							ops.view("order by designation ");
							break;
						}
						case 8:{
							ops.view("order by designation desc");
							break;
						}
						case 9:{
							ops.view("order by ename ");
							break;
						}
						case 10:{
							ops.view("order by ename desc");
							break;
						}
						default:{
							System.out.println("Invalid sortby choice ");
						}
				
					}
					break;

				}
				case 9: {
					in.close();
					System.exit(0);
				}
				default: {
					System.out.println("Invalid choice ");
				}
				}
			} catch (InputMismatchException e1) {

				System.out.println("Invalid input try again...");
			}
		} while (true);
	}

}
