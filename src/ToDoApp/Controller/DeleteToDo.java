package ToDoApp.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ToDoApp.Bean.Task;
import ToDoApp.DAO.SqlOperation;


@WebServlet("/DeleteToDo")
public class DeleteToDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Time = null;
	private static final String Date = null;
       
    
    public DeleteToDo() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		System.out.println("deleted task");
		String TaskName= request.getParameter("Task");
		System.out.println(TaskName);
		int i =SqlOperation.deleteTask(TaskName,Date,Time);
		System.out.println("From Servlet :: "+i);
		
		if(i>0) {
		 	request.getRequestDispatcher("ViewTask").forward(request, response);
	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
