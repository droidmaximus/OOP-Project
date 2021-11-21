import java.sql.*;
import java.io.*;


public class update {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, NumberFormatException, IOException{
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        String URL = "jdbc:mysql://localhost:3306/java";
        String USERNAME = "root";
        String Password = "rushendra0910";
        Connection con = DriverManager.getConnection(URL, USERNAME, Password);

        Statement s = con.createStatement();

        String query;
        ResultSet ans;

        ///////////////////////////////////////////////

        BufferedReader buffReader = new BufferedReader(new FileReader("src/input_rushendra.csv"));

        String line;

        while((line=buffReader.readLine())!=null){
            
            String[] tokens = line.split(",");

            query = "SELECT * FROM PATIENTS WHERE ID = " + tokens[0];

            ans = s.executeQuery(query);

            if (ans.next()){
                query = "UPDATE PATIENTS SET NAME = \'" + tokens[1] +"\'" + ", SEVERITY = \'" + tokens[2] +"\'" + ", VACCINATED = " + tokens[3] + ", DISCHARGED = " + tokens[4] + " WHERE ID = "+tokens[0];
                s.executeUpdate(query);
            }

            else {
                query = "INSERT INTO PATIENTS VALUES("+tokens[0]+",\'"+tokens[1]+"\'"+",\'"+tokens[2]+"\'"+","+tokens[3]+","+tokens[4]+")";
                s.executeUpdate(query);
            }

        }

        buffReader.close();
        s.close();

        ///////////////////////////////////////////////
    
        
    }
}
