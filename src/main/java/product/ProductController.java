package product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/pcontrol")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
    	//ProductService메서드 안에는 제품이 생성된다.
        service = new ProductService();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		String view = "";
		
		if(action == null) {
			// 액션 매개변수에 값이 없으면 목록으로 이동
			getServletContext().getRequestDispatcher("/pcontrol?action=list").forward(request, response);
		}else {
			switch(action) {
				case "list": view = list(request,response); break;
				case "info": view = info(request,response); break;
				
			}
			getServletContext().getRequestDispatcher("/product/"+view).forward(request, response);
		}

	}
	
	public String list(HttpServletRequest _request,HttpServletResponse _response) {
		_request.setAttribute("products", service.findAll());
		return "productList.jsp";
	}
	
	public String info(HttpServletRequest _request,HttpServletResponse _response) {
		_request.setAttribute("p", service.getId(_request.getParameter("id")));
		return "productInfo.jsp";
	}

}
