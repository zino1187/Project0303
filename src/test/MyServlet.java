package test;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//sun사는 서버제작 경쟁에 참여하는 것이 아니라, 생태계를 마련해준다
//따라서 javaEE 구현 결과물인 jar파일은 서버 밴더사에서 가져와야 한다
//우리가 사용하는 서버는 아파치 에서 제작한 Tomcat 이므로, Tomcat
//디렉토리 안의 servlet-api.jar를 가져오자!!
public class MyServlet extends HttpServlet{
	//서블릿이란? 클래스중 오직 서버에서만 실행될 수 있는 클래스
	//서블릿은 생명주기 메서드가 있다..
	//init() - 인스턴스가 생성될때 서블릿으로서 초기화시 한번 호출
	//service()  - 요청을 처리할때마다 호출
	//destory() - 서블릿이 소멸될때 한번 호출..
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//jsp에서의 request 내장객체는 사실 서블릿 api에서의 
		//HttpServletRequest 자료형 이었다...
		
		//브라우저에 문자열을 출력해본다!!
		PrintWriter out=response.getWriter();
		out.print("hi my servlet test is successful!!");
		
		//뭐든지 용도가 따로 있다..
		//서블릿은 html 을 출력하는데 있어서는 너무 기능이 취약함
		//즉 디자인 용도로 개발하기엔 무리가 따른다..
		//따라서 보다 쉽게 디자인을 처리할 수 있는 스크립트 수준의
		//언어가 필요했다..jsp
	}
}









