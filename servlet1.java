import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class servlet1 implements Servlet{
	public void init(ServletConfig h){}
	public void service(ServletRequest req,ServletResponse res) throws ServletException, IOException{
		
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String name=req.getParameter("username");	
		String pass=req.getParameter("passname");	
		String email=req.getParameter("emailname");	
		String contact=req.getParameter("contactname");	
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			PreparedStatement ps=con.prepareStatement("insert into employee value(?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,pass);
			ps.setString(3,email);
			ps.setString(4,contact);
			int i=ps.executeUpdate();
			if(i>0){
			pw.println("hey "+name+" you are registered succesfully");
			}
		}
		catch(Exception e){pw.println(e);}
		pw.close();
	}
	
	public void destroy(){}
	
	public String getServletInfo()
	{
		return(null);	
	}
	public ServletConfig getServletConfig()
	{
		return(null);
	}
}