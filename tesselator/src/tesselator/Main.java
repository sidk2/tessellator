package tesselator;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		Parser p = new Parser("tesselator/Appa.obj");
		ArrayList<Shape> s = p.getFaces();
		// for(Shape sh:s)
		// {
		// 	System.out.print((new ShapeData(sh)).toString());
		// }
			
		Visualizer v = new Visualizer();
		v.setShapes(s);
		ArrayList<Shape> s1 = v.findAdjacent(s.get(6));

		System.out.println((new ShapeData(s.get(6))).toString());
		System.out.println("----");
		for (Shape shape : s1) {
			System.out.println((new ShapeData(shape)).toString());
		}
	}
}
