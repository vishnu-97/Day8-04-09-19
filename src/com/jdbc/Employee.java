package com.jdbc;

public class Employee implements Comparable<Employee> {

	private int eno,salary;
	private String ename,designation,department;
	public Employee(int eno, String ename, int salary, String designation, String department) {
		this.eno=eno;
		this.ename = ename;
		this.salary = salary;
		this.designation = designation;
		this.department = department;
	}
	public Employee( String ename,int salary, String designation, String department) {
		this.salary = salary;
		this.ename = ename;
		this.designation = designation;
		this.department = department;
	}


	public Employee() {
		
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "\nEmployeeno=" + eno + ", Name=" + ename + ", Salary=" + salary + ", Designation=" + designation
				+ ", Department=" + department + "\n";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eno;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (eno != other.eno)
			return false;
		return true;
	}

	@Override
	public int compareTo(Employee o) {
		
		return eno-o.eno;
	}
	
}
