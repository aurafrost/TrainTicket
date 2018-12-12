package trainTicket;
import java.sql.*;
public class TrainDAO {
	private static String DRIVER_NAME="jdbc:oracle:thin:";
	private static String DB_URL="@localhost";
	private static String USERNAME="hr";
	private static String PASSWORD="hr";
	public static Train findTrain(int trainNo) {
		//connect to db
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn=DriverManager.getConnection(DRIVER_NAME+DB_URL,USERNAME,PASSWORD);
			Statement state=conn.createStatement();
			ResultSet rs=state.executeQuery("select * from TRAINS where TRAIN_NO="+trainNo);
			Train t=null;
			while(rs.next()) {
				t=new Train(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
			}
			conn.close();
			return t;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
