package tesselator;
import java.util.*;

public class ShapeData {
	private double[] sideLengths = new double[3];
	private double[] angles = new double[3];
	private ArrayList<ArrayList<Double>> vertices = new ArrayList<>();
	public ShapeData(Shape s)
	{
		sideLengths = s.getSideLengths();
		angles = s.getAngles();
		vertices = s.getVertices();
	}
	public String toString()
	{
		String s = "";
		s+= "side lengths: ";
		for(double d:sideLengths)
		{
			s+=d;
			s+=", ";
		}
		s+="|angles: ";
		for(double d:angles)
		{
			s+=d;
			s+=", ";
		}
		s+="|vertices: ";
		for (ArrayList<Double> vertex : vertices) {
			s+=vertex.toString();
		}

		s+="\n";
		return s;
	}
}
