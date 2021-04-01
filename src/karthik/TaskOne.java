package karthik;
import java.sql.*;   
import java.io.*; 

public class TaskOne {
	
public static void main(String[] args) { 


String pc="C:\\Users\\DELL\\OneDrive\\Desktop\\TaskOne\\Book2.csv";		

 try { 

Class.forName("com.mysql.cj.jdbc.Driver");		

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cricketers","root","Nikitha143@");	

 PreparedStatement st = con.prepareStatement("insert into cricketers.world_cup(s_no,player,country,no_centuries,strike_rate,highest_score) values(?,?,?,?,?,?)");	

 BufferedReader br = new BufferedReader(new FileReader(pc));		

 String str=null; 



br.readLine();														



 while((str=br.readLine()) != null) 

 { 

 String[] info=str.split(","); 



 int s_no=Integer.parseInt(info[0]); 

 String player=info[1]; 

 String country=info[2]; 

 int no_centuries=Integer.parseInt(info[3]); 

 double strike_rate=Double.parseDouble(info[4]); 

 int higest_score =Integer.parseInt(info[5]); 

 st.setInt(1,s_no);												
 st.setString(2, player); 

 st.setString(3, country); 

 st.setInt(4, no_centuries); 

 st.setDouble(5, strike_rate); 
 st.setInt(6, higest_score);

 

  

 st.addBatch();											
st.execute();
 System.out.println("record Inserted succesfully   in db...!");   

 } 

 st.executeBatch();	
								

 	br.close(); 
 	
} 

 

catch(Exception e) 

{ 

e.printStackTrace(); 

} 

try{ 

    } catch(NumberFormatException ex){ 		 

   } 

} 

 

} 
