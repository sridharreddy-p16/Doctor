package com.app.doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbOperations {
	
static Connection con;
	
	public static void doctorLogin(String docName,String docPwd) {
		con =DbConnection.createConnection();
		String query="select * from doctor where name='"+docName+"'and password='"+docPwd+"'";
		try {
		Statement stmt = con.createStatement(); 
		ResultSet rs = stmt.executeQuery(query);  
		  if (rs.next())  
		   System.out.println("Welcome::: " + docName);  
		  else  
		   System.out.println("Invalid user name and password");  
		  con.close();  
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void doctorRegistration(String docName, String docPwd, String docSpec) {
		con =DbConnection.createConnection();
		String query = "insert into doctor values(?,?,?)";
		try {
		    PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1, docName);
			psmt.setString(2, docPwd);
			psmt.setString(3, docSpec);
			int cnt=psmt.executeUpdate();
            if(cnt!=0)
                System.out.println("Registration done successfully !!");
            

        }catch (Exception ex){
            ex.printStackTrace();
        }
		
	}
	
	public static void doctorAppointments(String docName) {
		con =DbConnection.createConnection();
		String query = "select pname from appointments where dname=?";
		try {
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1, docName);
			ResultSet result = psmt.executeQuery();
			while (result.next()){
            	System.out.println(result.getString(1));
                        
            	}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void patientLogin(String patName,String patPwd) {
		con =DbConnection.createConnection();
		String query="select * from patient where pname='"+patName+"'and ppwd='"+patPwd+"'";
		try {
		Statement stmt = con.createStatement(); 
		ResultSet rs = stmt.executeQuery(query);  
		  if (rs.next())  
		   System.out.println("Welcome::: " + patName);  
		  else  
		   System.out.println("Invalid user name and password");  
		  con.close();  
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void patientRegistration(String pName, String pPwd, String pGen) {
		con =DbConnection.createConnection();
		String query = "insert into patient values(?,?,?)";
		try {
		    PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1, pName);
			psmt.setString(2, pPwd);
			psmt.setString(3, pGen);
			int cnt=psmt.executeUpdate();
            if(cnt!=0)
                System.out.println("Registration done successfully !!");
            

        }catch (Exception ex){
            ex.printStackTrace();
        }
		
	}
	
	public static void doctorList() {
		con =DbConnection.createConnection();
		String query = "select name from doctor";
		try {
			try {
				PreparedStatement psmt=con.prepareStatement(query);
				
				ResultSet result = psmt.executeQuery();
				while (result.next()){
	            	System.out.println(result.getString(1));
	                        
	            	}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
            

        }catch (Exception ex){
            ex.printStackTrace();
        }
		
	}
	
	public static void bookAppointment(String patName, String dName) {
		con =DbConnection.createConnection();
		String query = "insert into appointments values(?,?)";
		try {
		    PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1, patName);
			psmt.setString(2, dName);
			
			int cnt=psmt.executeUpdate();
            if(cnt!=0)
                System.out.println("Appointment booked !!");
            

        }catch (Exception ex){
            ex.printStackTrace();
        }
		
	}
	
	public static void allAppointments() {
		con =DbConnection.createConnection();
		String query = "select * from appointments";
		try {
			PreparedStatement psmt=con.prepareStatement(query);
			
			ResultSet result = psmt.executeQuery();
			while (result.next()){
            	System.out.println(result.getString(1)+"\t"+result.getString(2));
                        
            	}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void adminRegistration(String aName,String aPwd, String aPos) {
		con =DbConnection.createConnection();
		String query = "insert into admin values(?,?,?)";
		try {
		    PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1, aName);
			psmt.setString(2, aPwd);
			psmt.setString(3, aPos);
			int cnt=psmt.executeUpdate();
            if(cnt!=0)
                System.out.println("Registration done successfully !!");
            

        }catch (Exception ex){
            ex.printStackTrace();
        }
	}
	
	public static void adminLogin(String admName, String admPwd) {
		con =DbConnection.createConnection();
		String query="select * from admin where aname='"+admName+"'and apwd='"+admPwd+"'";
		try {
		Statement stmt = con.createStatement(); 
		ResultSet rs = stmt.executeQuery(query);  
		  if (rs.next())  
		   System.out.println("Welcome::: " + admName);  
		  else  
		   System.out.println("Invalid user name and password");  
		  con.close();  
		}catch(Exception e) {
			e.printStackTrace();
		}
	}



}
