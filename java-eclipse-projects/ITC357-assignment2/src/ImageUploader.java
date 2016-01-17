
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;

/**
 * Servlet implementation class FileUpload
 */
public class ImageUploader extends HttpServlet {
	HttpSession session;
	String newUser;
	File savedFile;
	String destination;
    List<FileItem> items;
    String fileName;    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageUploader() {
        super();
    }

	/**
	 * doGet() method
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * doPost() method
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession(true);
        
		try {
			items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
		
	        for (FileItem item : items) {
	            if (!item.isFormField()) {
	                // Process form file field (input type="file").
	                newUser = (String) session.getAttribute("newUser");
	                
	                fileName = "/images/" + newUser + ".jpg";
	                destination = getServletContext().getRealPath(fileName);
	                
	                savedFile = new File(destination);	//Creating new file 
	                item.write(savedFile);	//Writing to file  
	                
    	         }
	        }
	        
	        //Forward to login page
	    	request.getRequestDispatcher("/Login.jsp").forward(request, response);
	           
		}
        catch (Exception e) {
			e.printStackTrace();
		}
	}
}
