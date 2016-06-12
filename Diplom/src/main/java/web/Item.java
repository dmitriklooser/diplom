package web;

public class Item {
	private final String id;
	private final String name;
	
	public Item (String ID, String name){
		this.id = ID;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	
public static class PairedItem<K, G>{
	private K keyItem;
	private G groupedItem;
	
	public PairedItem(K keyItem, G groupedItem){
		this.keyItem = keyItem;
		this.groupedItem = groupedItem;
	}

	public K getKeyItem() {
		return keyItem;
	}

	public G getGroupedItem() {
		return groupedItem;
	}
}// class PairedItem	
}//class Item
