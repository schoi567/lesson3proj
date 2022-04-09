package Start_Server;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import product_control.products;


	@WebServlet("/productDAO")
	public class productDAO extends HttpServlet{	
	private static final long serialVersionUID = 1L;
	       
	    public int opensession(products prod)   {
	    	Configuration configuration = new Configuration().configure(); 
			configuration.addAnnotatedClass(product_control.products.class);		
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
			int i=0;
			try {Session session= factory.openSession(); 
				Transaction transaction = session.beginTransaction(); 		
				i=(Integer)session.save(prod);
				transaction.commit();				
				session.close(); }  catch (Exception  e) {e.printStackTrace();}
			return i;} 
	    
	   

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	    	
	    	// reading form values		    	
	    	String pname=request.getParameter("name");
	    	String cname=request.getParameter("company");
	    	// put values in Object
	    	products p1=new products();
	    	p1.setProductname(pname);
	    	p1.setCompanyname(cname);	
	    	int i=opensession(p1);
 	

	    	PrintWriter out=response.getWriter();
	    	if(i>0)
	    		out.println("Record inserted");
	    	else
	    		out.println("Record not inserted");
	    		
	    		
	    		
	    }}
	    	
	

	
	
	

