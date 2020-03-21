/**
 * This class is used to identify which shape has been selected by the user
 * 
 * @author ashwin srinivasan
 * @version 1.0
 * @since 01/29/2020
 */
public class JButtonActionListener {
	static String shapeClicked = "None";

	public void addActionListener() {
		ShapePanel.functionBlockBeginButton.addActionListener(e -> {
			shapeClicked = Constants.FUNCTION_BLOCK_BEGIN_BUTTON;

		});
		ShapePanel.functionBlockEndButton.addActionListener(e -> {
			shapeClicked = Constants.FUNCTION_BLOCK_END_BUTTON;

		});
		ShapePanel.ifBlockBeginButton.addActionListener(e -> {
			shapeClicked = Constants.IF_BLOCK_BEGIN_BUTTON;

		});
		ShapePanel.ifBlockEndButton.addActionListener(e -> {
			shapeClicked = Constants.IF_BLOCK_END_BUTTON;

		});
		ShapePanel.forLoopButton.addActionListener(e -> {
			shapeClicked = Constants.FOR_LOOP_BUTTON;

		});
		ShapePanel.barShapeButton.addActionListener(e -> {
			shapeClicked = Constants.BAR_SHAPE_BUTTON;

		});
		ShapePanel.valueHolderButton.addActionListener(e -> {
			shapeClicked = Constants.VALUE_HOLDER_BUTTON;

		});
	}

	public void addNewShapesToFrame(int coordinateX, int coordinateY) {

		if (shapeClicked.equals(Constants.BAR_SHAPE_BUTTON)) {
			BarShape barShape = new BarShape();
			barShape.setPosition(coordinateX, coordinateY);
			Frame.mapDrawingAreas.get(Frame.currentTab).addBarShape(barShape);
		} else if (shapeClicked.equals(Constants.FOR_LOOP_BUTTON)) {

			ForLoop forLoop = new ForLoop();
			forLoop.setPosition(coordinateX, coordinateY);
			Frame.mapDrawingAreas.get(Frame.currentTab).addForLoop(forLoop);
		} else if (shapeClicked.equals(Constants.FUNCTION_BLOCK_BEGIN_BUTTON)) {

			FunctionBlockBegin functionBlockBegin = new FunctionBlockBegin();
			functionBlockBegin.setPosition(coordinateX, coordinateY);
			Frame.mapDrawingAreas.get(Frame.currentTab).addFunctionBlockBegin(functionBlockBegin);
		} else if (shapeClicked.equals(Constants.FUNCTION_BLOCK_END_BUTTON)) {

			FunctionBlockEnd functionBlockEnd = new FunctionBlockEnd();
			functionBlockEnd.setPosition(coordinateX, coordinateY);
			Frame.mapDrawingAreas.get(Frame.currentTab).addFunctionBlockEnd(functionBlockEnd);
		} else if (shapeClicked.equals(Constants.IF_BLOCK_BEGIN_BUTTON)) {

			IfBlockBegin ifBlockBegin = new IfBlockBegin();
			ifBlockBegin.setPosition(coordinateX, coordinateY);
			Frame.mapDrawingAreas.get(Frame.currentTab).addIfBlockBegin(ifBlockBegin);
		} else if (shapeClicked.equals(Constants.IF_BLOCK_END_BUTTON)) {

			IfBlockEnd ifBlockBegin = new IfBlockEnd();
			ifBlockBegin.setPosition(coordinateX, coordinateY);
			Frame.mapDrawingAreas.get(Frame.currentTab).addIfBlockEnd(ifBlockBegin);
		} else if (shapeClicked.equals(Constants.VALUE_HOLDER_BUTTON)) {

			ValueHolderBlock ifBlockBegin = new ValueHolderBlock();
			ifBlockBegin.setPosition(coordinateX, coordinateY);
			Frame.mapDrawingAreas.get(Frame.currentTab).addValueHolderBlock(ifBlockBegin);
		} else {
			Frame.jlabel.setText("Please select a shape");
		}
	}

}
