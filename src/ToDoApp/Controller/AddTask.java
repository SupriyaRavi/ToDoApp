package ToDoApp.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ToDoApp.DAO.SqlOperation;


@WebServlet("/AddTask")
public class AddTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddTask() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p = response.getWriter();
		String TaskName=request.getParameter("task name");
		String Date=request.getParameter("reminder date");
		String Time=request.getParameter("reminder time");
		
		System.out.println(TaskName+""+Date+""+Time);
		
		SqlOperation ob=new SqlOperation();
		if(ob.AddTask(TaskName,Date,Time)==1) {
			p.println("<script type=\"text/javascript\">"); 
			p.println("alert(\"Task Added Successfully \")");
			p.println("</script>");
			response.setHeader("Refresh", "1;TaskPage.html");
		}else {
			p.println("<script type=\"text/javascript\">"); 
			p.println("alert(\"Task Failed\")");
			p.println("</script>");
			response.setHeader("Refresh", "1; AddTask.html");
			
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
