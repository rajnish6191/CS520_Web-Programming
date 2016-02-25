package cs520.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs520.model.ApplicantDetail;

@WebServlet(urlPatterns = "/Applicant")
public class Applicant extends HttpServlet {

	 private static final long serialVersionUID = 1L;
	
		 @SuppressWarnings("deprecation")
		@Override
		public void init() throws ServletException {
			// TODO Auto-generated method stub
			 super.init();
			
			 List<String> applicationStatus = new ArrayList<String>();
			 applicationStatus.add( "Application Incomplete" );
			 applicationStatus.add( "Pending Review" );
			 applicationStatus.add( "Rejected" );
			 applicationStatus.add( "Accepted" );
			 applicationStatus.add( "Admission Offer Sent" );
			 applicationStatus.add( "Admission Offer Accepted" );
			 
			  // Store the data in Application Scope (i.e. Servlet Context).
		      ServletContext context = getServletContext();
		      context.setAttribute( "applicationStatus", applicationStatus );
		      
		      ArrayList<ApplicantDetail> applicantList=new ArrayList<ApplicantDetail>();
		      ApplicantDetail data=new ApplicantDetail();
		      
		      data=new ApplicantDetail();
		      data.setApplicantName("Rajnish Kumar");
		      data.setGpa("3.7");
		      data.setReceivedDate(new Date("2/15/2016"));
		      data.setStatus(1);
		      applicantList.add(data);
		      

		      data=new ApplicantDetail();
		      data.setApplicantName("Mahesh Sinha");
		      data.setGpa("");
		      data.setReceivedDate(new Date("6/23/2015"));
		      data.setStatus(4);
		      applicantList.add(data);
		     
		      data=new ApplicantDetail();
		      data.setApplicantName("John Gean");
		      data.setGpa("3.2");
		      data.setReceivedDate(new Date("05/02/2015"));
		      data.setStatus(5);
		      applicantList.add(data);
		      
		      context.setAttribute( "applicantList", applicantList);
		}
	 
	  protected void doGet( HttpServletRequest request,HttpServletResponse response ) throws ServletException, IOException {
		  
		  request.getRequestDispatcher( "/WEB-INF/ApplicantList.jsp" ).forward( request, response );
     }

	  
	  protected void doPost( HttpServletRequest request,  HttpServletResponse response ) throws ServletException, IOException {
	        
	      
	      //  response.sendRedirect( "NewAdmission" );
	  }
}