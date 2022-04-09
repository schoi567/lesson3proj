package table.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.view.viewtable;

import Start_Server.productDAO;
import product_control.products;

 
@WebServlet("/ViewRecords")
public class ViewRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			//Read data from ArrayList
			ArrayList<products> list=new viewtable().getRecords();
			PrintWriter out=response.getWriter();
			out.println("<table border=2>    "
					+ "<tr>\r\n"
					+ "<td>id</td>\r\n"
					+ "<td>companyname</td>\r\n"
					+ "<td>productname</td>\r\n"
					+ "</tr>");
			for(products products:list) {
			out.println("<tr><td>"+products.getId()+"</td><td> "+products.getProductname()+"</td><td> "+products.getCompanyname()+"</td> ");}
			
			out.println("</table>");
			
		}
			catch(Exception e) {
			e.printStackTrace();
		}}}



	