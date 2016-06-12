package web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import db.Reader;
import db.Writer;
import geneticalg.Group;
import geneticalg.Module;
import web.Item.PairedItem;

public class Step3Data extends StepData{
	public static final String ATTR_MODULES = "modules";
	public static final String ATTR_GM_LIST = "gmList";
	private Reader reader = new Reader();
	private Writer writer = new Writer();
	
	protected Step3Data(Cache cache) {
		super(cache);
	}

	@Override
	public void load(HttpServletRequest req) {
		Collection<Item> modules = getModuleItems();
		List<PairedItem<Group, Module>> gmList = readAllGroupModules();
		req.setAttribute(ATTR_MODULES, modules);
		req.setAttribute(ATTR_GM_LIST, gmList);
	}

	@Override
	public void save(HttpServletRequest request) {
		String groupNum = request.getParameter("grpName");
		String groupSize = request.getParameter("grpSize");
		if( !WebTool.isDigit(groupNum) ) return;
		if( !WebTool.isDigit(groupSize) ) return;
		int grpID = Integer.valueOf(groupNum);
		int grpSize = Integer.valueOf(groupSize);
		Group group = getCache().GROUP_CACHE.get(Integer.valueOf(groupNum));
		if(group == null){
			group = new Group(grpID, grpSize);
			writer.writeGroup(group, getCache());
		}
		List<Module> selectedModules = 
									getIDParams(request).stream()
																	.map(id->getCache().MODULE_CACHE.get(id))
																	.collect(Collectors.toList());
		Group groupToSotre = group;
		selectedModules.forEach(module->writer.addGMRelation(groupToSotre, module));
	}
	
	
	@Override
	public void delete(HttpServletRequest request) {
		List<String> relToRemove = getParamsStartFrom(request, "gm_");
		relToRemove.stream().map((rel)->{
			String[] ids = rel.substring("gm_".length()).split("_");
			if( WebTool.isDigit(ids[0]) && WebTool.isDigit(ids[1]) ){
				Group group = getCache().GROUP_CACHE.get(Integer.valueOf(ids[0]));
				Module module = getCache().MODULE_CACHE.get(Integer.valueOf(ids[1]));
				return new PairedItem<Group, Module>(group, module);
			}
			return null;
		}).filter(pItem->pItem != null)
		   .forEach((pItem)->writer.delGMRelation(pItem.getKeyItem(), pItem.getGroupedItem()));
	}


	private Collection<Item> getModuleItems(){
		return	getCache().MODULE_CACHE.getAll().stream()	
															 .map(m->new Item(String.valueOf(m.getId()), m.getModuleName()))
															 .collect(Collectors.toList());
	}
	
	
	private List<PairedItem<Group, Module>> readAllGroupModules(){
		List<PairedItem<Group, Module>> gmList = reader.readAllGroupModules(getCache());
		return gmList;
//		Map<Group, List<Module>> result = new HashMap<>();
//		Map<Group, List<PairedItem<Group, Module>>> tmp = 
//					gmList.stream().collect(Collectors.groupingBy(pItem->pItem.getKeyItem() ,Collectors.toList()));
//		for(Group grp : tmp.keySet()){
//			result.put(grp, tmp.get(grp).stream()
//													 .map(pItem->pItem.getGroupedItem())
//													 .collect(Collectors.toList()) );
//		}
//		return result;
	}
}
