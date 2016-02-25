package cs520.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs520.model.ApplicantDetail;

@WebServlet(urlPatterns = "/NewAdmission")
public class NewAdmission extends HttpServlet {

	 private static final long serialVersionUID = 1L;
	
	  protected void doGet( HttpServletRequest request,HttpServletResponse response ) throws ServletException, IOException {
        // Forward to a JSP (i.e. view)
        request.getRequestDispatcher( "/WEB-INF/NewAdmission.jsp" ).forward( request, response );
     }

	  
	  protected void doPost( HttpServletRequest request,  HttpServletResponse response ) throws ServletException, IOException {
		  try {
			  
			  ApplicantDetail applicant= new ApplicantDetail();
			  applicant.setApplicantName(request.getParameter( "applicantName" ));
			  applicant.setGpa(request.getParameter( "gpa" )); 
			  
			  SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");
		      Date receivedDate = format.parse(request.getParameter( "receivedDate" ));
				
			  applicant.setReceivedDate(receivedDate);
			  applicant.setStatus(Integer.parseInt(request.getParameter("status")));
			  
			   @SuppressWarnings("unchecked")
			   List<ApplicantDetail> applicantList= (List<ApplicantDetail>) getServletContext().getAttribute( "applicantList" );
		        if( applicantList == null ){
		        	applicantList =  new ArrayList<ApplicantDetail>();
		            getServletContext().setAttribute( "applicantList", applicantList );
		        }
		       
		        if(request.getParameter("applicantId")!=null && !request.getParameter("applicantId").isEmpty()){
		        	//Update Applicant
		        	int applicantId=Integer.parseInt(request.getParameter("applicantId"));
		        	applicantList.remove(applicantId);
		        	applicantList.add(applicantId,applicant);
		        }else{
		        	//New Applicant
		        	applicantList.add(applicant);
		        }
		        		        
		        Collections.sort(applicantList, new Comparator<ApplicantDetail>() {
		              public int compare(ApplicantDetail o1, ApplicantDetail o2) {
		                  if (o1.getReceivedDate() == null || o2.getReceivedDate() == null)
		                    return 0;     
		                  return o2.getReceivedDate().compareTo(o1.getReceivedDate());
		              }
		        });
		            
		        // Redirect to the Applicant Page
		        response.sendRedirect( "Applicant" );
	        
			  } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			  }
	  }

}
