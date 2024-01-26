package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String department;
	private int mailboxCapacity =500;
	private String alternateEmail;
	private int defaultPasswordLength = 10;
	private String companySuffix = "anycompany.com";
	
	// constructor to receive firstname n lastname
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		//System.out.println("email created " + this.firstName + " " + this.lastName);
		this.department = setDepartment();
		//System.out.println("Department : "+this.department);
		this.password =randomPassword(defaultPasswordLength);
		System.out.println("Your password is  "+this.password);
		email = firstName.toLowerCase() + "."+lastName.toLowerCase() +"@"+department+"."+companySuffix;
		//System.out.println("Your email is: "+email);
		
	}
	// ask for the department
	private String setDepartment() {
		System.out.println("New worker: " + firstName+". Department codes\n1 for sales\n2 for development\n3 for accounting\n0 for none");
		Scanner dept = new Scanner(System.in);
		int deptChoice = dept.nextInt();
		if(deptChoice == 1) {
			return "sales";
		}
		else if(deptChoice == 2) {
			return "development";
		}
		else if(deptChoice == 3) {
			return "accounting";
		}
		else {
			return "";
		}
	}
	// call  or generate a random password
	private String randomPassword(int length) {
		StringBuilder password = new StringBuilder();
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		//char[] pasword = new char[length];
		for(int i =0; i < length; i++) {
		int rdm = (int)(Math.random() * passwordSet.length());
		//password[i]=passwordSet.charAt(rdm);
		password.append(passwordSet.charAt(rdm));
		}
		//return new String(password);
		return password.toString();
	}
	
	
	// set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	// set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail =altEmail;
	}
	// change the password
	public void changePassword(String password) {
		this.password = password;
	}
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	public String getAlternateEmail() {
		return alternateEmail;	
	}
	public String setPassword() {
		return password;
	}
	
	
	public String showInfo() {
		return "DISPLAY NAME: " +firstName+" "+lastName +
				"\nCOMPANY EMAIL: "+email+
				"\nMAILBOX CAPACITY: "+mailboxCapacity+"mb";
	}
}
