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
	//���� �ν��Ͻ� ���� ��, �� ������ �ʱ�ȭ�ϴµ� ���Ǵ� �޼��� 
	//���ϰ� ���� ������ �� �޼��带 ȣ�����ָ鼭, ���� ������ �Ѱ��� �� �ִ�!!
	//�̶�, �������� ������ �Ѱ��ִ� �������� ���Ǵ� ��ü�� �ٷ� 
	//ServletConfig ��ü�̴�!!
	String data;
	public void init(ServletConfig config) throws ServletException {
		data=config.getInitParameter("data");
		System.out.println(data);
		//���⼭ out �� ���� ���� ������?response.getWrite
		//init �� ���� ��û�� ó���ϴ� ������ �ƴϱ� ������ , 
		//���� response ��ü�� ���� �����̴�..���� �ʹ� �̸���..
		//�ذ�å) 
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	//���� ��ſ� doXXX �������̵� �ϸ� �ȴ�!!
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�� ������ ������ �ۼ��ϴ� ����!!
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");//�Ķ���Ϳ� ���� �ѱ�ó��
		String movie=request.getParameter("movie");
		PrintWriter out=response.getWriter();
		out.print("�ʱ⼳�� �Ķ���ͷ� ���� ���� "+data);
		out.print("������ ��ȭ�� "+movie);
		
		String msg=null;
		if(movie.equals("��������")){
			msg="���� �ְ� ������";
		}else if(movie.equals("���̾��3")){
			msg="DVD�ε� �������� ��ȭ";	
		}else if(movie.equals("����")){
			msg="�ְ��� ���� ��ȭ";
		}
		
		//����� ���, ���� session �� �������� ó���غ��� 
		//������ ���� �ʰ� ��û�� �����ϸ� ��...(������)
		//RequestDispatcher dis=request.getRequestDispatcher("/movie/result.jsp");
		//request.setAttribute("result", msg);//������ ���!!
		//dis.forward(request, response);//������ url�� ������
		
		//������ �̿��Ұ�� ���� ��û�� �������ʿ� �� �������� �ʿ����!!
		//jsp ���� ����ؿԴ� session ���� ��ü�� ��� ���� api ��
		//HttpSession �̾���!!
		HttpSession session=request.getSession();
		session.setAttribute("result", msg);
		response.sendRedirect("/movie/session.jsp");
	}
	public void destroy() {
	}
}





