package web;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import db.Reader;
import db.Writer;
import geneticalg.Module;
import geneticalg.Professor;
import web.Item.PairedItem;

public class Step4Data extends StepData{
	public static final String ATTR_MODULES = "modules";
	public static final String ATTR_PM_LIST = "pmList";
	private Reader reader = new Reader();
	private Writer writer = new Writer();
	
	protected Step4Data(Cache cache) {
		super(cache);
	}

	@Override
	public void load(HttpServletRequest req) {
		Collection<Item> modules = getModuleItems();
		List<PairedItem<Professor, Module>> pmList = readAllProfModules();
		req.setAttribute(ATTR_MODULES, modules);
		req.setAttribute(ATTR_PM_LIST, pmList);
	
	}
	@Override
	public void save(HttpServletRequest req) {
		String professorName = req.getParameter("profName");
		if(professorName == null) return;
		//Professor prof = new Professor(professorId, professorName);
		
		List<Module> selectedModules = 
					   getIDParams(req).stream()
												.map(id->getCache().MODULE_CACHE.get(id))
												.collect(Collectors.toList());
		
	}

	@Override
	public void delete(HttpServletRequest request) {
		
	}

	
	private Collection<Item> getModuleItems(){
		return	getCache().MODULE_CACHE.getAll().stream()	
															 .map(m->new Item(String.valueOf(m.getId()), m.getModuleName()))
															 .collect(Collectors.toList());
	}

	
	private List<PairedItem<Professor, Module>> readAllProfModules(){
		List<PairedItem<Professor, Module>> pmList = reader.readAllProfModules(getCache());
		return pmList;
	}

}
