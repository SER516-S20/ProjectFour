package model;

import java.util.ArrayList;

public class TabData {
	private int shapeNumber;
	private boolean openParaFlag;
	private boolean closeParaFlag;
	private ArrayList<ShapeData> shapeData;
	private int shapeCount;
	
	public TabData() {
		this.shapeNumber = 0;
		this.openParaFlag = false;
		this.closeParaFlag = false;
		this.shapeData = new ArrayList<ShapeData>();
		this.shapeCount = -1;
	}
	
	public boolean isOpenParaFlag() {
		return this.openParaFlag;
	}

	public void setOpenParaFlag(boolean openParaFlag) {
		this.openParaFlag = openParaFlag;
	}

	public boolean isCloseParaFlag() {
		return this.closeParaFlag;
	}

	public void setCloseParaFlag(boolean closeParaFlag) {
		this.closeParaFlag = closeParaFlag;
	}

	public int getShapeNumber() {
		return this.shapeNumber;
	}

	public void setShapeNumber(int shapeNumber) {
		this.shapeNumber = shapeNumber;
	}
	
	public int getShapeCount() {
		return shapeCount;
	}

	public void setShapeCount() {
		this.shapeCount++;
	}
	
	public void addShapeData(int shapeNumber, int index, int x, int y) {
		ShapeData sd = new ShapeData();
		sd.setShapeNumber(shapeNumber);
		sd.setIndex(index);
		sd.setX(x);
		sd.setY(y);
		
		shapeData.add(sd);
		//System.out.println(shapeData.get(index).x +"," +shapeData.get(index).y + " - " + shapeData.size());
	}
	
	public void editShapeData(int index, int x, int y) {
		ShapeData sd = shapeData.get(index);
		sd.setX(x);
		sd.setY(y);
		shapeData.set(index,sd);
		System.out.println(index);
		System.out.println("shape count - " + this.shapeCount);
	}
	

	public ArrayList<ShapeData> getShapeData() {
		return shapeData;
	}
}