package web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import web.AppController.Steps;

public class SchoolPageData {
	private Cache cache;
	private Map<Steps, StepData> pageData = new HashMap<>();
	
	public SchoolPageData(Cache cache){
		this.cache = cache;
	}

	public void onLoadPage(Steps step, HttpServletRequest req){
		StepData data = pageData.get(step);
		data.load(req);
	}

	public void onSubmitPage(Steps step, HttpServletRequest req){
		StepData data = pageData.get(step);
		data.save(req);
	}
	
	public void onDelete(Steps step, HttpServletRequest req){
		StepData data = pageData.get(step);
		data.delete(req);
	}
	
	public void init(){
		cache.MODULE_CACHE.load(); 
		cache.PROFESSOR_CACHE.load();
		cache.ROOM_CACHE.load();
		cache.TIMESLOT_CACHE.load();
		cache.GROUP_CACHE.load();
		cache.loadAllTimetables();
		
		pageData.put(Steps.STEP1, new Step1Data(cache));
		pageData.put(Steps.STEP2, new Step2Data(cache));
		pageData.put(Steps.STEP3, new Step3Data(cache));
		pageData.put(Steps.STEP4, new Step4Data(cache));
		pageData.put(Steps.STEP5, new Step5Data(cache));
		pageData.put(Steps.STEP6, new Step6Data(cache));
		pageData.put(Steps.STEP7, new Step7Data(cache));
		pageData.put(Steps.STEP8, new Step8Data(cache));
	}
	
}// class SchoolPageData 
