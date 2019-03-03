package movie;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class MovieAdvisor extends HttpServlet{
	//서블릿 인스턴스 생성 후, 이 서블릿을 초기화하는데 사용되는 메서드 
	//톰켓과 같은 서버가 이 메서드를 호출해주면서, 각종 정보도 넘겨줄 수 있다!!
	//이때, 서블릿에게 정보를 넘겨주는 수단으로 사용되는 객체가 바로 
	//ServletConfig 객체이다!!
	String data;
	public void init(ServletConfig config) throws ServletException {
		data=config.getInitParameter("data");
		System.out.println(data);
		//여기서 out 를 쓸수 없는 이유는?response.getWrite
		//init 은 아직 요청을 처리하는 시점이 아니기 때문에 , 
		//현재 response 객체가 없는 상태이다..따라서 너무 이르다..
		//해결책) 
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
		out.print("초기설정 파라미터로 받은 값은 "+data);
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
		//RequestDispatcher dis=request.getRequestDispatcher("/movie/result.jsp");
		//request.setAttribute("result", msg);//데이터 담기!!
		//dis.forward(request, response);//지정한 url로 포워딩
		
		//세션을 이용할경우 굳이 요청을 유지할필요 즉 포워딩이 필요없다!!
		//jsp 에서 사용해왔던 session 내장 객체는 사실 서블릿 api 의
		//HttpSession 이었다!!
		HttpSession session=request.getSession();
		session.setAttribute("result", msg);
		response.sendRedirect("/movie/session.jsp");
	}
	public void destroy() {
	}
}





