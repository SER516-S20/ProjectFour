package model;

import java.util.ArrayList;

public class TabData {
	private int shapeNumber;
	private boolean openParaFlag;
	private boolean closeParaFlag;
	private ArrayList<ShapeData> shapeData;
	private int shapeCount;
	private ArrayList<Line> lines;
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	
	

	public TabData() {
		this.shapeNumber = 0;
		this.openParaFlag = false;
		this.closeParaFlag = false;
		this.shapeData = new ArrayList<ShapeData>();
		this.shapeCount = -1;
		this.lines = new ArrayList<Line>();
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
	
	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
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
	
	public void addShapeInstance(int index, Shape shape) {
		ShapeData sd = shapeData.get(index);
		sd.setShape(shape);
	}
	
	public Shape getShapeInstance(int index) {
		ShapeData sd = shapeData.get(index);
		return sd.getShape();
	}

	public ArrayList<Line> getLines() {
		return lines;
	}

	public void addLines(Line line) {
		this.lines.add(line);
	}
	
	
	
	public void setShapeUserIp(int index, String userIp) {
		ShapeData sd = shapeData.get(index);
		sd.setUserIp(userIp);
	}
	
	public String getShapeUserIp(int index) {
		ShapeData sd = shapeData.get(index);
		return sd.getUserIp();
	}
	
	public void addShape(Shape shape) {
		this.shapes.add(shape);
	}
}