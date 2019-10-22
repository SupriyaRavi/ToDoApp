package ToDoApp.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ToDoApp.Bean.Task;
import ToDoApp.DAO.SqlOperation;


@WebServlet("/UpdateToDo")
public class UpdateToDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateToDo() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		HttpSession s=request.getSession();
		String TaskName=(String) s.getAttribute("TaskName");
		System.out.println("Session Value "+TaskName);
		Task t =SqlOperation.fetchTask(TaskName);
		System.out.println("From Servlet :: "+t);
		 	request.setAttribute("UpdateTask",t);
		 	request.getRequestDispatcher("UpdateToDo.jsp").forward(request, response);
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
