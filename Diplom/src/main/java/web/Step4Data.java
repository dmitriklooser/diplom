package web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import db.Reader;
import db.Writer;
import geneticalg.Group;
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
		Professor prof = new Professor(-1, professorName);
		writer.writeProfessor(prof, getCache());
		List<Module> selectedModules = 
					   getIDParams(req).stream()
												.map(id->getCache().MODULE_CACHE.get(id))
												.collect(Collectors.toList());
		selectedModules.stream()
								.forEach(m->{writer.addPMRelation(prof, m);
													  int[] profs = m.getProfessorIds();
													  int newLen = profs != null ? profs.length + 1:1;
													  int[] profsNew = new int[newLen];
													  System.arraycopy(profs, 0, profsNew, 0, profs.length);
													  profsNew[profsNew.length-1] = m.getId();
													  m.setProfessorIds(profsNew);
													});
		
	}

	@Override
	public void delete(HttpServletRequest request) {
		List<String> relToRemove = getParamsStartFrom(request, "pm_");
		relToRemove.stream().map((rel)->{
			String[] ids = rel.substring("pm_".length()).split("_");
			if( WebTool.isDigit(ids[0]) && WebTool.isDigit(ids[1]) ){
				Professor prof = getCache().PROFESSOR_CACHE.get(Integer.valueOf(ids[0]));
				Module module = getCache().MODULE_CACHE.get(Integer.valueOf(ids[1]));
				return new PairedItem<Professor, Module>(prof, module);
			}
			return null;
		}).filter(pItem->pItem != null)
		   .forEach((pItem)->{writer.delPMRelation(pItem.getKeyItem(), pItem.getGroupedItem());
		   								Professor prof = pItem.getKeyItem();
		   								Module mod = pItem.getGroupedItem();
		   								int[] rels = mod.getProfessorIds();
		   								int[] newRels = Stream.of(rels)
		   																   .flatMapToInt(ints->IntStream.of(ints))
		   																   .filter(num-> num != prof.getId()).toArray();
		   								mod.setProfessorIds(newRels);
		   							});
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
