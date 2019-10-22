<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List"%>
<%@page import="ToDoApp.Bean.Task"%>
<!DOCTYPE>
<HTML>
<HEAD>
<TITLE>View Task</TITLE>

	
<style >
#myInput {
  background-image: url('/css/searchicon.png'); /* Add a search icon to input */
  background-position: 10px 12px; /* Position the search icon */
  background-repeat: no-repeat; /* Do not repeat the icon image */
  width: 100%; /* Full-width */
  font-size: 16px; /* Increase font-size */
  padding: 12px 20px 12px 40px; /* Add some padding */
  border: 1px solid #ddd; /* Add a grey border */
  margin-bottom: 12px; /* Add some space below the input */
}
#myTable {
  border-collapse: collapse; /* Collapse borders */
  width: 100%; /* Full-width */
  border: 1px solid #ddd; /* Add a grey border */
  font-size: 18px; /* Increase font-size */
}
#myTable th, #myTable td {
  text-align: left; /* Left-align text */
  padding: 12px; /* Add padding */
}
#myTable tr {
  /* Add a bottom border to all table rows */
  border-bottom: 1px solid #ddd; 
}
#myTable tr.header, #myTable tr:hover {
  /* Add a grey background color to the table header and on hover */
  background-color: #f1f1f1;
}

#button2 {
	position: absolute;
  	top: 28px;
  	right: 16px;
  	font-size: 50px;
  		}
		
</style>
<script >
/*function myFunction() {
  // Declare variables 
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[3];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    } 
  }
} */

</script>
</HEAD>
<BODY>
<div  id="button2">
		 <input type="submit" value="LOGOUT" id="button" formaction="index.html">
</div>
<br>
<br>
<br>
	<table border="1" width="500" align="center" id="myTable">
		<tr class="header">
		<br>
			<th style="width:60%;" ><b>Reminder Name</b></th>
			<th style="width:60%;"><b>Reminder Date</b></th>
			<th style="width:60%;"><b>Reminder Time</b></th>
			<th style="width:60%;"><b>Update Task</th>	
			<th style="width:60%;"><b>Delete Task</th>	
		</tr>
		
		<%
		List<Task> J=(List<Task>) request.getAttribute("TotalTask");
			//List<Task> J = (List<Task>) request.getAttribute("TotalTask");
		if(J!=null){
			for (Task j : J) {
		%>
		<tr>
			<td><%=j.getTaskName()%></td>
			<td><%=j.getDate()%></td>
			<td><%=j.getTime()%></td>
			<td><a href="UpdateTodo?Task">Update</a></td>
            <td><a href=" ">Delete</a></td>
		
			
		</tr>
		<%}}%>
		
		
	</table>
</body>
</html>