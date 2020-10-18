import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UtilFile;

/**
 * Servlet implementation class MyServletLaBreck
 */
@WebServlet("/MyServletLaBreck")
public class MyServletLaBreck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServletLaBreck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	      String filename = "/WEB-INF/numbers.csv";
	      List<String> contents = UtilFile.readFile(getServletContext(), filename);
	      
	      int numbers[] = new int[500];
	      int count = 0;
	      
	      for (int i = 0; i < contents.size(); i++) 
	      {
	    	 numbers[i] = Integer.parseInt(contents.get(i));
	      }
	      
	      Arrays.sort(numbers);
	      
	      response.getWriter().println("Top five numbers: ");
	      for (int j = 495; j < numbers.length; j++)
	      {
	    	  if (count != 0)
	    	  {
	    		  response.getWriter().println(", "); 
	    	  }
	    	  response.getWriter().print(numbers[j]);
	    	  count++;
	      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
