
public class FactoryPatternDemo {

	private final static ShapeFactory shapeFactory  = new ShapeFactory();
	public static void main(String[] args) {
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		shape1.draw();
		
		Shape shape2 = shapeFactory.getShape("RECTABLE");
		shape2.draw();
		
		Shape shape3 = shapeFactory.getShape("SQUARE");
		shape3.draw();
	
	}

}
