package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SchoolManagementSystem {
	
	private static Scanner in;
	private static Scanner str;
	private static PreparedStatement statement;

	public static void main(String[] args) throws Exception  {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String  url="jdbc:mysql://localhost:3306/School?characterEncoding=utf8";
		String username="root";
		String password="root";
		Connection con =DriverManager.getConnection(url,username,password);
		
		
 
		java.sql.Statement stmt =con.createStatement();
		ResultSet rs;
		PreparedStatement st;
	
 
		String qry="";
		int id,age,annualFee,rollnumber,choice,Salary;
		String name,joiningMonth,status,std,result,Subject,City;
		
		
		
		in = new Scanner(System.in);
		str = new Scanner(System.in);
		
		
 
		while(true)
		{
			System.out.println("School Management System");
			System.out.println("1. Insert");
			System.out.println("2. Update");
			System.out.println("3. Delete");
			System.out.println("4. Fees Data");
			System.out.println("5. View result");
			System.out.println("6. Teacher");
			System.out.println("7. Exit");
			System.out.print("Enter a choice: ");
			choice = in.nextInt();
			System.out.println("-----------------------------------------");
			switch(choice){
			case 1:
				System.out.println("1. Insert New Data");
				
				System.out.println("Enter ID : ");
				id=in.nextInt();		
				System.out.println("Enter Name : ");
				name=str.nextLine();
				System.out.println("Enter Age : ");
				age=in.nextInt();
				System.out.println("Enter joining Month : ");
				joiningMonth=str.nextLine();
				System.out.println("Enter Annual Fee : ");
				annualFee=in.nextInt();
				System.out.println("Enter Status : ");
				status=str.nextLine();
 
				qry="insert into feesubmit (ID,NAME,AGE,JOININGMONTH,ANNUALFEE,STATUS) values(?,?,?,?,?,?)";
				st= con.prepareStatement(qry);
				st.setInt(1, id);
				st.setString(2, name);
				st.setInt(3, age);
				st.setString(4, joiningMonth);
				st.setInt(5, annualFee);
				st.setString(6, status);
				
 
				st.executeUpdate();
				System.out.println("Data Inserted SuccessFully");
 
				break;
			case 2:
				System.out.println("2. Updating a Data");
 
				System.out.println("Enter Existing ID : ");
				id=in.nextInt();
				System.out.println("Enter Name : ");
				name=str.nextLine();
				System.out.println("Enter Age : ");
				age=in.nextInt();
				System.out.println("Enter joining Month : ");
				joiningMonth=str.nextLine();
				System.out.println("Enter Annual Fee : ");
				annualFee=in.nextInt();
				System.out.println("Enter Status : ");
				status=str.nextLine();
 
				qry="update feesubmit set NAME=?,AGE=?,JOININGMONTH=?,ANNUALFEE=?,STATUS=? where ID=?";
				st= con.prepareStatement(qry);
 
				
				st.setString(1, name);
				st.setInt(2, age);
				st.setString(3, joiningMonth);
				st.setInt(4, annualFee);
				st.setString(5, status);
				st.setInt(6, id);  
				
				st.executeUpdate();
				System.out.println("Data Updated SuccessFully");
 
				break;
			case 3:
				System.out.println("3. Deleting a Data");
				System.out.println("Enter ID : ");
				id=in.nextInt();
 
				qry="delete from feesubmit where ID=?";
				st= con.prepareStatement(qry);
				st.setInt(1, id);
 
				st.executeUpdate();
				System.out.println("Data Deleted Success");
 
				break;
			case 4:
				System.out.println("4. Fees Data");
				qry="SELECT ID,NAME,AGE,JOININGMONTH,ANNUALFEE,STATUS from feesubmit";
				rs=stmt.executeQuery(qry);
				while(rs.next())
				{
					id=rs.getInt("ID");
					name=rs.getString("NAME");
					age=rs.getInt("AGE");
					joiningMonth=rs.getString("JOININGMONTH");
					annualFee=rs.getInt("ANNUALFEE");
					status=rs.getString("STATUS");
					
 
					System.out.print(id+" ");
					System.out.print(name+" ");
					System.out.print(age+" ");
					System.out.print(joiningMonth+" ");
					System.out.print(annualFee+" ");
					System.out.print(status+" ");
					System.out.println(" ");
					
 
				}
				break;
				case 5:
					System.out.println("5. Results of students");
					qry="SELECT ID,NAME,STD,ROLLNUMBER,RESULT from reportcard";
					rs=stmt.executeQuery(qry);
					while(rs.next())
					{
						id=rs.getInt("ID");
						name=rs.getString("NAME");
						std=rs.getString("STD");
						rollnumber=rs.getInt("ROLLNUMBER");
						result=rs.getString("RESULT");
						
	 
						System.out.print(id+" ");
						System.out.print(name+" ");
						System.out.print(std+" ");
						System.out.print(rollnumber+" ");
						System.out.print(result+" ");
						System.out.println(" ");
					}
				break;
				
				case 6:
					System.out.println("6. Teacher Record ");
					qry="SELECT NAME,SUBJECT,CITY,SALARY from Teacher";
					rs=stmt.executeQuery(qry);
					while(rs.next())
					{
						
						name=rs.getString("NAME");
						Subject=rs.getString("SUBJECT");
						City=rs.getString("CITY");
						Salary=rs.getInt("SALARY");
						
						
	 
						System.out.print(name+" ");
						System.out.print(Subject+" ");
						System.out.print(City+" ");
						System.out.print(Salary+" ");
						System.out.println(" ");
					}
				break;
				
			case 7:
				System.out.println("Thank You!!!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Selection");
				break;
			}
			
			System.out.println("-----------------*******************------------------");
		}
	}

	public static int update(int id, int rollnumber) throws SQLException {
		
		
		statement = null;
		statement.executeUpdate();
		
		
		return id;
	}

}



