package web;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet(name="Controller", urlPatterns={"/main"})
public class AppController extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		req.getParameter("");
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		LinkedList<String> lst; 
		forwardTo("/school2.jsp", req, resp);
	}

	
	private void forwardTo(String target, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		getServletContext().getRequestDispatcher(target).forward(req, resp);
	}
}// class AppController 
