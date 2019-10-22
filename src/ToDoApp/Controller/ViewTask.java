package ToDoApp.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ToDoApp.Bean.Task;
import ToDoApp.DAO.SqlOperation;
import ToDoApp.Bean.Task;


@WebServlet("/ViewTask")
public class ViewTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewTask() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
		 List<Task> TotalJ =SqlOperation.TotalTask();
		 System.out.println(TotalJ);
		 request.setAttribute("TotalTask",TotalJ);
		 request.getRequestDispatcher("ViewTask.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
