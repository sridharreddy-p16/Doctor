package com.app.doctor;

import java.util.Scanner;


public class DocMain {

	public static void main(String[] args) {
		System.out.println("Welcome to Doctor Appointment Application");
		DocMain.mainMenu();

	}
	static Scanner sc = new Scanner(System.in);
	
	//Main menu
	public static void mainMenu() {
		
	
            System.out.println("1. Doctor\n" +
                    "2. Patient\n" +
                    "3. Admin \n" +
                    "4. Exit\n");

            System.out.println("Enter Choice: ");
            int ch=sc.nextInt();
            switch (ch){
                case 1:
                    DocMain.doctorMenu();
                    break;
                case 2:
                    DocMain.patientMenu();
                    break;
                case 3:
                    DocMain.adminMenu();
                    break;
               
                case 4:
                    System.out.println("Thank you for using our Application !!!");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice !");
                    break;


            }

	}
	
	//Doctor login menu
	public static void doctorLoginMenu(String docName) {
		System.out.println("Welcome "+docName);
		System.out.println("1. Appointments\n" +
                "2. Logout\n");
		System.out.println("Enter Choice: ");
        int ch=sc.nextInt();
        
        switch (ch) {
        case 1:
        	DbOperations.doctorAppointments(docName);
        	System.out.println("1. Doctor Menu\n" +
                    "2. Main Menu\n");
            System.out.println("Enter Choice: ");
            int choice2=sc.nextInt();
            switch (choice2){
            case 1:
            	DocMain.doctorMenu();
            	break;
            case 2:
            	
            	DocMain.mainMenu();
            	break;
            }
        	break;
        case 2:
        	System.out.println("logged out successfully!");
        	DocMain.mainMenu();
        	break;
        }
	}
	
	//Doctor menu
	public static void doctorMenu() {
		System.out.println("Welcome to doctor menu");
		System.out.println("1. Login\n" +
                "2. Registration\n");
		System.out.println("Enter Choice: ");
        int ch=sc.nextInt();
        
        switch (ch){
            case 1:
            	System.out.println("Doctor login Console");
                System.out.println("Enter name:");
                String docName = sc.next();
                System.out.println("Enter password:");
                String docPwd = sc.next();
                DbOperations.doctorLogin(docName, docPwd);
                DocMain.doctorLoginMenu(docName);
                break;
            case 2:
            	System.out.println("Doctor Registration form");
                System.out.println("Enter name:");
                String dName = sc.next();
                System.out.println("Enter password:");
                String dPwd = sc.next();
                System.out.println("Enter specialisation:");
                String dSpec = sc.next();
                DbOperations.doctorRegistration(dName, dPwd, dSpec);
                System.out.println("1. Doctor Menu\n" +
                        "2. Main Menu\n");
                System.out.println("Enter Choice: ");
                int chioce2=sc.nextInt();
                switch (chioce2){
                case 1:
                	DocMain.doctorMenu();
                	break;
                case 2:
                	
                	DocMain.mainMenu();
                	break;
                }
                break;
	}
	}
	
	
	//Patient menu
	public static void patientMenu() {
		System.out.println("Welcome to patient menu");
		System.out.println("1. Login\n" +
                "2. Registration\n");
		System.out.println("Enter Choice: ");
        int ch=sc.nextInt();
        
        switch (ch){
            case 1:
            	System.out.println("Patient login Console");
                System.out.println("Enter name:");
                String patName = sc.next();
                System.out.println("Enter password:");
                String patPwd = sc.next();
                DbOperations.doctorLogin(patName, patPwd);
                DocMain.patientLoginMenu(patName);
                break;
            case 2:
            	System.out.println("Patient Registration form");
                System.out.println("Enter name:");
                String pName = sc.next();
                System.out.println("Enter password:");
                String pPwd = sc.next();
                System.out.println("Enter Gender:");
                String pGen = sc.next();
                DbOperations.doctorRegistration(pName, pPwd, pGen);
                System.out.println("1. Patient Menu\n" +
                        "2. Main Menu\n");
                System.out.println("Enter Choice: ");
                int chioce2=sc.nextInt();
                switch (chioce2){
                case 1:
                	DocMain.patientLoginMenu(pName);
                	break;
                case 2:
                	
                	DocMain.mainMenu();
                	break;
                }
                break;
	}
	}
	
	//Patient login menu
	public static void patientLoginMenu(String patName) {
		System.out.println("Welcome "+patName);
		System.out.println("1. Book Appointments\n" +
                "2. Logout\n");
		System.out.println("Enter Choice: ");
        int ch=sc.nextInt();
        
        switch (ch) {
        case 1:
        	System.out.println("Available Doctors: ");
        	DbOperations.doctorList();
        	System.out.println("Enter Doctor name to book Appointment: ");
        	String dName = sc.next();
        	DbOperations.bookAppointment(patName,dName);
        	System.out.println("1. Patient Menu\n" +
                    "2. Main Menu\n");
            System.out.println("Enter Choice: ");
            int choice2=sc.nextInt();
            switch (choice2){
            case 1:
            	DocMain.patientMenu();
            	break;
            case 2:
            	
            	DocMain.mainMenu();
            	break;
            }
        	break;
        case 2:
        	System.out.println("logged out successfully!");
        	DocMain.mainMenu();
        	break;
        }
	}
	
	//Admin menu
	public static void adminMenu() {
		System.out.println("Welcome to Admin menu");
		System.out.println("1. Login\n" +
                "2. Registration\n");
		System.out.println("Enter Choice: ");
        int ch=sc.nextInt();
        
        switch (ch){
            case 1:
            	System.out.println("Admin login Console");
                System.out.println("Enter name:");
                String admName = sc.next();
                System.out.println("Enter password:");
                String admPwd = sc.next();
                DbOperations.adminLogin(admName, admPwd);
                DocMain.doctorLoginMenu(admName);
                break;
            case 2:
            	System.out.println("admin Registration form");
                System.out.println("Enter name:");
                String aName = sc.next();
                System.out.println("Enter password:");
                String aPwd = sc.next();
                System.out.println("Enter position:");
                String aPos = sc.next();
                DbOperations.adminRegistration(aName, aPwd, aPos);
                System.out.println("1.Admin Menu\n" +
                        "2. Main Menu\n");
                System.out.println("Enter Choice: ");
                int chioce2=sc.nextInt();
                switch (chioce2){
                case 1:
                	DocMain.adminLoginMenu(aName);
                	break;
                case 2:
                	
                	DocMain.mainMenu();
                	break;
                }
                break;
	}
	}
	
	//Admin Login menu
	public static void adminLoginMenu(String admName) {
		System.out.println("Welcome "+admName);
		System.out.println("1. Appointments\n" +
		        "2.Doctor List\n"+
                "3. Logout\n");
		System.out.println("Enter Choice: ");
        int ch=sc.nextInt();
        
        switch (ch) {
        case 1:
        	
            DbOperations.allAppointments();
        	System.out.println("1. Admin Menu\n" +
                    "2. Main Menu\n");
            System.out.println("Enter Choice: ");
            int choice2=sc.nextInt();
            switch (choice2){
            case 1:
            	DocMain.adminMenu();
            	break;
            case 2:
            	
            	DocMain.mainMenu();
            	break;
            }
        	break;
        case 2:
        	System.out.println("Available Doctors: ");
        	DbOperations.doctorList();
        	System.out.println("1. Admin Menu\n" +
                    "2. Main Menu\n");
            System.out.println("Enter Choice: ");
            int choice3=sc.nextInt();
            switch (choice3){
            case 1:
            	DocMain.adminMenu();
            	break;
            case 2:
            	
            	DocMain.mainMenu();
            	break;
            }
        	break;
        case 3:
        	System.out.println("logged out successfully!");
        	DocMain.mainMenu();
        	break;
        }
	}

}
