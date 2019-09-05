package com.jdbc;
import java.sql.*;


public class Operations {
	private  Connection connection;
	public Operations() {
		initialize("jdbc:mysql://localhost/java_training","root","hawking");
		e=new Employee();
	}

	public void initialize(String url,String username,String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	 public void insert(String ename,int salary,String department,String designation) {
		try {
			CallableStatement stmt = connection.prepareCall("{call insert_Employee(?,?,?,?,?)}");
			stmt.setString(1, ename);
			stmt.setInt(2, salary);
			stmt.setString(3, department);
			stmt.setString(4, designation);
			stmt.registerOutParameter(5, Types.INTEGER);
			stmt.executeUpdate();
			System.out.println("Your eno is "+stmt.getInt(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	 public void update(int salary,int eno) {
		try {
			String sql="update employees set salary="+salary+" where eno="+eno;
			PreparedStatement p=connection.prepareStatement(sql);
			
			System.out.println(p.executeUpdate());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	 public void delete(int eno) {
		try {
			CallableStatement stmt = connection.prepareCall("{?=call delete_Employee(?)}");
			stmt.setInt(2, eno);
			stmt.registerOutParameter(1, Types.INTEGER);
			stmt.execute();
			System.out.println(stmt.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	 public void alterAddColumn(String Col,String type) {
		try {
			String sql="alter table employees add "+Col+" "+type;
			PreparedStatement p=connection.prepareStatement(sql);
			
			System.out.println(p.executeUpdate());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	 public void alterDropColumn(String Col) {
		try {
			String sql="alter table employees drop "+Col;
			PreparedStatement p=connection.prepareStatement(sql);
			
			System.out.println(p.executeUpdate());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	 
	 public void truncate() {
		 PreparedStatement p;
		try {
			p = connection.prepareStatement("truncate employees");
			p.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 }

	 public int view() {
		 int i=0;
		 try {
			String sql="select * from employees ";
			PreparedStatement p=connection.prepareStatement(sql);
			ResultSet rs=p.executeQuery();
			System.out.println("Eno   \tName \tSalary \tDesignation \tDepartment");
			
			while(rs.next()) {
//				System.out.
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4)+"\t\t"+rs.getString(5));
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	 public int view(String extras) {
		 int i=0;
		 try {
				String sql="select * from employees "+extras;
				PreparedStatement p=connection.prepareStatement(sql);
				ResultSet rs=p.executeQuery();
				System.out.println("Eno   \tName \tSalary \tDesignation \tDepartment");
				
				while(rs.next()) {
//					System.out.
					i++;
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4)+"\t\t"+rs.getString(5));
				}
				
				System.out.println();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return i;
		}
	 public void viewDepartments() {
			try {
				String sql="select distinct(department) from employees ";
				PreparedStatement p=connection.prepareStatement(sql);
				ResultSet rs=p.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getInt(1));
				}
				System.out.println();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	
}
