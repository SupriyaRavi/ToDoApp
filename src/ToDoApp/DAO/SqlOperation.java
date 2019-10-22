package ToDoApp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ToDoApp.Bean.Task;
import ToDoApp.SqlConnect.DBConnector;

public class SqlOperation {

	static Connection conn=null;
	public int AddTask(String TaskName,String Date,String Time ) {
		try {
		conn=DBConnector.dbConnector();
		String query="insert into AddTask values(?,?,?)";
        PreparedStatement st=conn.prepareStatement(query);
        st.setString(1, TaskName);
        st.setString(2, Date);
        st.setString(3, Time);
		int flag=st.executeUpdate();

		System.out.println("Added Successfully");

		return flag;
		} catch (Exception e)
		{
			System.out.println(e);
			}
		return 0;	
}
	
	public static List<Task> TotalTask() {
		List<Task> TA = new ArrayList<Task>();
		try {
			conn = DBConnector.dbConnector();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from AddTask");

			while (resultSet.next()) {
				Task t = new Task();
				
				t.setTaskName(resultSet.getString("TaskName"));
				t.setDate(resultSet.getString("Date"));
				t.setTime(resultSet.getString("Time"));
				
				System.out.println(t);
			    TA.add(t);
			}
		   return TA;
		} catch (Exception e) {System.out.println(e);}
		return null;
	}
	
	public static Task fetchTask(String TaskName) {
		conn=DBConnector.dbConnector();
		String query="select * from AddTask where TaskName=?";
		System.out.println("task name"+TaskName);
		
		try {
			PreparedStatement st=conn.prepareStatement(query);
			st.setString(1, TaskName);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				Task t=new Task();
				t.setTaskName(rs.getString("TaskName"));
				t.setDate(rs.getString("Date"));
				t.setTime(rs.getString("Time"));
				System.out.println("from DAO ::"+t);
				return t;
			}
		} catch (SQLException e) {e.printStackTrace();}
		return null;
	}

	public static int UpdateTaskValues(String TaskName, String Date, String Time) 
	{
		try {
			conn=DBConnector.dbConnector();
			String query="update AddTask SET  Date=?,Time=? where TaskName=?";
			PreparedStatement st=conn.prepareStatement(query);
			st.setString(1, Date);
			st.setString(2, Time);
			st.setString(3, TaskName);
			int flag=st.executeUpdate();
			System.out.println(flag);
			System.out.println("Update Successfull");
			return flag;
		}
		catch (Exception e) {System.out.println(e);}
	return 0;
	}
	
	}
