package cs520.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs520.model.ApplicantDetail;

@WebServlet(urlPatterns = "/EditApplication")
public class EditApplication extends HttpServlet {

	 private static final long serialVersionUID = 1L;
	 
	 protected void doPost( HttpServletRequest request,  HttpServletResponse response ) throws ServletException, IOException {
		 
		  @SuppressWarnings("unchecked")
		   List<ApplicantDetail> applicantList= (List<ApplicantDetail>) getServletContext().getAttribute( "applicantList" );

		 	request.setAttribute("applicantDeatil",applicantList.get(Integer.parseInt(request.getParameter("applicantId"))));
		 	request.setAttribute("applicantId",request.getParameter("applicantId"));
	        request.getRequestDispatcher( "/WEB-INF/EditApplication.jsp").forward( request, response );
	        
	  }
	 
}
