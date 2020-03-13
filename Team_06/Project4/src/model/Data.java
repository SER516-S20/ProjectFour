package model;


public class Data {
	private static Data dataObj;
	private int shapeNumber;
	private boolean openParaFlag;
	private boolean closeParaFlag;
	
	private Data () {
		shapeNumber = 0;
		openParaFlag = false;
		closeParaFlag = false;
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

	public boolean isOpenParaFlag() {
		return openParaFlag;
	}

	public void setOpenParaFlag(boolean openParaFlag) {
		this.openParaFlag = openParaFlag;
	}

	public boolean isCloseParaFlag() {
		return closeParaFlag;
	}

	public void setCloseParaFlag(boolean closeParaFlag) {
		this.closeParaFlag = closeParaFlag;
	}
	
	

}