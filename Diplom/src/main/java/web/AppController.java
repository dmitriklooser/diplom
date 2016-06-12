package web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AppController extends HttpServlet{
	public enum Action{
		GO,
		ADD,
		DELETE,
		RESET
	}
	
	public enum Steps{
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
	
	private SchoolPageData  pageData = new SchoolPageData(new Cache());
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		req.getParameter("");
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		Action action = Action.valueOf(req.getParameter("action"));
		
		if(action == Action.GO){
			Steps currStep = getCurrentStep(req);
			pageData.onSubmitPage(currStep, req);
			Steps nextStep = getNextStep(currStep);
			pageData.onLoadPage(nextStep, req);
			forwardTo(nextStep.getUrl(), req, resp);
			setCurrentStep(nextStep, req);
		}
		if(action == Action.RESET){
			Steps currStep = Steps.STEP1;
			forwardTo(currStep.getUrl(), req, resp);
		}
		if(action == Action.ADD){
			Steps currStep = getCurrentStep(req);
			pageData.onSubmitPage(currStep, req);
			pageData.onLoadPage(currStep, req);
			forwardTo(currStep.getUrl(), req, resp);
		}
		if(action == Action.DELETE){
			Steps currStep = getCurrentStep(req);
			pageData.onDelete(currStep, req);
			pageData.onLoadPage(currStep, req);
			forwardTo(currStep.getUrl(), req, resp);
		}
		
	}

	
	private void forwardTo(String target, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		req.getRequestDispatcher(target).forward(req, resp);
	}

	@Override
    public void init() throws ServletException {
		super.init();
		pageData.init();
    }

	private Steps getCurrentStep(HttpServletRequest req){
		String strStep = req.getParameter("step");
		Steps currStep = Steps.valueOf(strStep);
		return currStep;
	}
	
	private Steps getNextStep(Steps currectStep){
		int pos= Arrays.asList(Steps.values()).indexOf(currectStep);
		if(pos >= Steps.values().length - 1) {
			return currectStep;
		}else{
			Steps nextStep = Steps.values()[pos+1];
			return nextStep;
		}
	}

	private void setCurrentStep(Steps step, HttpServletRequest req){
		req.getSession().setAttribute(ATTR_STEP, step);
	}
}// class AppController 
