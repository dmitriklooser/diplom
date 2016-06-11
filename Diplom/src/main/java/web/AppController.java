package web;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




//@WebServlet(name="Controller", urlPatterns={"/main"}, loadOnStartup=1)
public class AppController extends HttpServlet{
	private Cache cache = new Cache();
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		req.getParameter("");
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		//LinkedList<String> lst; 
		forwardTo("/school2.jsp", req, resp);
	}

	
	private void forwardTo(String target, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		getServletContext().getRequestDispatcher(target).forward(req, resp);super.init();
	}

	@Override
    public void init() throws ServletException {
		super.init();
		cache.MODULE_CACHE.load(); 
		cache.PROFESSOR_CACHE.load();
		cache.ROOM_CACHE.load();
		cache.TIMESLOT_CACHE.load();
		cache.GROUP_CACHE.load();
		cache.loadAllTimetables();
		
    }

	
}// class AppController 
