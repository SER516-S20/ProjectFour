package model;

import javax.swing.JButton;

public class ShapeData{
	private int shapeNumber;
	private int index;
	private int x;
	private int y;
	private Shape Shape;
	
	public int getShapeNumber() {
		return shapeNumber;
	}
	public void setShapeNumber(int shapeNumber) {
		this.shapeNumber = shapeNumber;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public Shape getShape() {
		return Shape;
	}
	public void setShape(Shape shape) {
		Shape = shape;
	}
	
}