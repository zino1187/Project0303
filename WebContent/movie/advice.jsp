<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");//파라미터에 대한 인코딩..
	String movie=request.getParameter("movie");
	out.print("선택한 영화는 "+movie);
	
	String msg=null;
	if(movie.equals("극한직업")){
		msg="올해 최고 흥행작";
	}else if(movie.equals("아이언맨3")){
		msg="DVD로도 보기힘든 영화";	
	}else if(movie.equals("증인")){
		msg="최고의 법정 영화";
	}
	
	//클라이언트가 브라우저를 닫지만 않으면 세션객체의 id값이 유지될수있기때문에
	//서버측의 세션객체를 이용할 수 있다..
	//session.setAttribute("result", msg); //저장!!!
	
	//일단, 클라이언트에게 응답 후, 다시 해당 클라이언트가 지정한 url로 다시
	//들어오게 하는 메서드이다
	//response.sendRedirect("/movie/result.jsp");
	//응답을해버리는 순간 즉 이요청을 끝내는 순간 네트워크는 끊어지므로, 
	//result.jsp를 재접속하게되면 새로운 요청으로 간주하여, 이전 요청에 사용했던
	//데이터는 이미 사라진 후라, 사용불가능하다..
	//해결책)) 현재 요청에 대한 응답을하지말고, 서버측에 존재하는 또 다른 서블릿
	//을 요청하면 된다.!! 현실에서의 가장 근접한 예 전화 114 
	RequestDispatcher dis=null;//포워딩 처리하는 객체, 요청 유지 객체
	dis=request.getRequestDispatcher("/movie/result.jsp");
	request.setAttribute("result", msg);
	dis.forward(request, response);//전달
	
%>




    
