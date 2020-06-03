package tesselator;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		Parser p = new Parser("Appa.obj");
		ArrayList<Shape> s = p.getFaces();
		int triangles = 0;
		 for(Shape sh:s)
		 {
			 if((new ShapeData(sh)).toString().contains("NaN"))
			 {
				 continue;
			 }
		 	System.out.print((new ShapeData(sh)).toString());
		 	triangles++;
		 }
		System.out.println("number of triangles: " + triangles);
//		Visualizer v = new Visualizer(s);
//		ArrayList<Shape> s1 = v.findAdjacent(s.get(0));
//
//		System.out.println((new ShapeData(s.get(0))).toString());
//		System.out.println("----");
//		for (Shape shape : s1) {
//			System.out.println((new ShapeData(shape)).toString());
//		}
	}
}
