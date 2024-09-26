package servlet02.com.future;

import java.io.IOException;
import java.io.PrintStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/main") //ur1 mapping
public class ServletMain extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=uft-8");
		resp.setCharacterEncoding("utf-8");
		System.out.println("main");
		OutputStream os = resp.getOutputStream();
		PrintStream out = new PrintStream(os,true);
		out.println("main 화면입니다.");
	}
	}


