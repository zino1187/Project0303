package test;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//sun��� �������� ���￡ �����ϴ� ���� �ƴ϶�, ���°踦 �������ش�
//���� javaEE ���� ������� jar������ ���� ����翡�� �����;� �Ѵ�
//�츮�� ����ϴ� ������ ����ġ ���� ������ Tomcat �̹Ƿ�, Tomcat
//���丮 ���� servlet-api.jar�� ��������!!
public class MyServlet extends HttpServlet{
	//�����̶�? Ŭ������ ���� ���������� ����� �� �ִ� Ŭ����
	//������ �����ֱ� �޼��尡 �ִ�..
	//init() - �ν��Ͻ��� �����ɶ� �������μ� �ʱ�ȭ�� �ѹ� ȣ��
	//service()  - ��û�� ó���Ҷ����� ȣ��
	//destory() - ������ �Ҹ�ɶ� �ѹ� ȣ��..
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//jsp������ request ���尴ü�� ��� ���� api������ 
		//HttpServletRequest �ڷ��� �̾���...
		
		//�������� ���ڿ��� ����غ���!!
		PrintWriter out=response.getWriter();
		out.print("hi my servlet test is successful!!");
		
		//������ �뵵�� ���� �ִ�..
		//������ html �� ����ϴµ� �־�� �ʹ� ����� �����
		//�� ������ �뵵�� �����ϱ⿣ ������ ������..
		//���� ���� ���� �������� ó���� �� �ִ� ��ũ��Ʈ ������
		//�� �ʿ��ߴ�..jsp
	}
}









