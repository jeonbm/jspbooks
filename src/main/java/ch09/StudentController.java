package ch09;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/studentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDao studentDao = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	
    	studentDao = new StudentDao();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		String view = "";
		
		if(action == null) {
			// 액션 매개변수에 값이 없으면 목록으로 이동
			getServletContext().getRequestDispatcher("/studentController?action=list").forward(request, response);
		}else {
			switch(action) {
				case "list": view = list(request,response); break;
				case "info": view = info(request,response); break;
			}
			getServletContext().getRequestDispatcher("/ch09/"+view).forward(request, response);
		}
		
	}
	
	public String list(HttpServletRequest _request,HttpServletResponse _response) {
		_request.setAttribute("students", studentDao.getAll());
		return "studentInfo.jsp";
	}
	
	public String info(HttpServletRequest _request,HttpServletResponse _response) {
		return "";
	}

}
