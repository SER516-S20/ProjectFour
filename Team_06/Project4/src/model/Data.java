package model;
import java.util.ArrayList;

/**
 * 
 * @Author: Dhananjay, Sheran
 * @Since: 03-07-2020
 * @Description: This model class is used to hold the data for multiple tabs.
 */
public class Data {
	private static Data dataObj;
	private ArrayList<TabData> tabList;
	
	private Data () {
		tabList = new ArrayList<TabData>();
	};
	
	public static Data getInstance() {
		if (dataObj == null) {
			dataObj = new Data();
		}
		return dataObj;
	}

	public void addTabData() {
		tabList.add(new TabData());
	}

	public TabData getTab(int tabNumber) {
		return tabList.get(tabNumber);
	}

	public void setTab(int tabNumber, TabData tabData) {
		this.tabList.set(tabNumber, tabData);
	}
	
	public ArrayList<TabData> getTabList() {
		return tabList;
	}
	
	public void clearTabList() {
		tabList.clear();
	}
}
