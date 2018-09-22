

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class homePage
 */
@WebServlet("/homePage")
public class homePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public homePage() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: YOLOSWAG ").append(request.getContextPath());
		
		// READ IN HTML FILE 
		StringBuilder htmlHomePageContent = new StringBuilder();
		try {
			String filePath = "/frontEndRes/hackathonProject.html";
			BufferedReader input = new BufferedReader (new FileReader(getResourceFile(filePath)));
			String ln = "";
			while((ln = input.readLine())!= null) {
				htmlHomePageContent.append(ln);
				System.out.println(htmlHomePageContent);
			}
			input.close();
		} 
		catch(IOException e){
			String error = e.getMessage();
			response.getWriter().append(error);
		}
		
		response.getWriter().append(htmlHomePageContent);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public File getResourceFile(String fileName) {
		// Returns a file from the project resources based on the path name.
		return new File(getClass().getResource("/res" + fileName).getFile());
	}

}
