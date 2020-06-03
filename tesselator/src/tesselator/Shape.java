package tesselator;

import java.util.ArrayList;

public class Shape {
	private ArrayList<ArrayList<Double>> vertices;
	public Shape(ArrayList<ArrayList<Double>> d)
	{
		vertices = d;
	}
	public ArrayList<ArrayList<Double>> getVertices()
	{
		return vertices;
	}
	
}
