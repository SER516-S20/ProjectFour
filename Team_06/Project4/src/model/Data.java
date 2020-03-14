package model;

import java.util.ArrayList;

public class Data {
	private static Data dataObj;
	private int shapeNumber;
	private ArrayList<Boolean> openParaFlagList;
	private ArrayList<Boolean> closeParaFlagList;
	
	private Data () {
		shapeNumber = 0;
		openParaFlagList = new ArrayList<Boolean>();
		closeParaFlagList = new ArrayList<Boolean>();
	};
	
	public static Data getInstance() {
		if (dataObj == null) {
			dataObj = new Data();
		}
		return dataObj;
	}

	public int getShapeNumber() {
		return shapeNumber;
	}

	public void setShapeNumber(int shapeNumber) {
		this.shapeNumber = shapeNumber;
	}

	public boolean isOpenParaFlag(int tabNumber) {
		return openParaFlagList.get(tabNumber);
	}

	public void setOpenParaFlag(boolean openParaFlag, int tabNumber) {
		openParaFlagList.set(tabNumber, openParaFlag);
	}

	public boolean isCloseParaFlag(int tabNumber) {
		return closeParaFlagList.get(tabNumber);
	}

	public void setCloseParaFlag(boolean closeParaFlag, int tabNumber) {
		this.closeParaFlagList.set(tabNumber,closeParaFlag);
	}
	
	public void addOpenParaFlag() {
		openParaFlagList.add(false);
	}
	
	public void addCloseParaFlag() {
		closeParaFlagList.add(false);
	}

}