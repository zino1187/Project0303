package movie;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class MovieAdvisor extends HttpServlet{
	public void init() throws ServletException {
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	//서비스 대신에 doXXX 오버라이드 하면 된다!!
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이 영역에 로직을 작성하는 것임!!
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");//파라미터에 대한 한글처리
		String movie=request.getParameter("movie");
		PrintWriter out=response.getWriter();
		out.print("선택한 영화는 "+movie);
		
		String msg=null;
		if(movie.equals("극한직업")){
			msg="올해 최고 흥행작";
		}else if(movie.equals("아이언맨3")){
			msg="DVD로도 보기힘든 영화";	
		}else if(movie.equals("증인")){
			msg="최고의 법정 영화";
		}
		
		//결과를 담되, 굳이 session 을 쓰지말고 처리해본다 
		//응답을 하지 않고 요청을 유지하면 됨...(포워딩)
		RequestDispatcher dis=request.getRequestDispatcher("/movie/result.jsp");
		request.setAttribute("result", msg);//데이터 담기!!
		dis.forward(request, response);//지정한 url로 포워딩
	}
	public void destroy() {
	}
}





