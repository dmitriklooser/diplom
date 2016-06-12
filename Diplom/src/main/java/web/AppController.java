package web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AppController extends HttpServlet{
	private enum Steps{
		STEP1("/school1.jsp"),
		STEP2("/school2.jsp"),
		STEP3("/school3.jsp"),
		STEP4("/school4.jsp"),
		STEP5("/school5.jsp"),
		STEP6("/school6.jsp"),
		STEP7("/school7.jsp"),
		STEP8("/school8.jsp");
		
		private String url;
		private Steps(String url){
			this.url = url;
		}
		public String getUrl(){
			return url;
		}
	}
	
	private static final String ATTR_STEP = "step";
	
	private Cache cache = new Cache();
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		req.getParameter("");
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		String action = req.getPathInfo();
		if(action.equals("/next")){
			Steps nextStep = getNextStep(req);
			forwardTo(nextStep.getUrl(), req, resp);
			setCurrentStep(nextStep, req);
		}
		
	}

	
	private void forwardTo(String target, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		getServletContext().getRequestDispatcher(target).forward(req, resp);
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

	private Steps getCurrentStep(HttpServletRequest req){
		Steps step = (Steps)req.getSession().getAttribute(ATTR_STEP);
		if(step == null) step = Steps.STEP1;
		return step;
	}
	
	private Steps getNextStep(HttpServletRequest req){
		Steps currectStep = getCurrentStep(req);
		int pos= Arrays.asList(Steps.values()).indexOf(currectStep);
		if(pos >= Steps.values().length - 1) {
			return currectStep;
		}else{
			Steps nextStep = Steps.values()[pos+1];
			return nextStep;
		}
	}

	private void setCurrentStep(Steps step, HttpServletRequest req){
		//int pos= Arrays.asList(Steps.values()).indexOf(step);
		req.getSession().setAttribute(ATTR_STEP, step);
	}
}// class AppController 
