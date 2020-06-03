package tesselator;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		Parser p = new Parser("Appa.obj");
		ArrayList<Shape> s = p.getFaces();
		for(Shape sh:s)
		{
			System.out.print((new ShapeData(sh)).toString());
		}
	}

}
