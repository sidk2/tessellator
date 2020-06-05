package tesselator;
import java.util.*;

public class ShapeData {
	private double[] sideLengths = new double[3];
	private double[] angles = new double[3];
	private ArrayList<ArrayList<Double>> vertices = new ArrayList<>();
	public ShapeData(Shape s)
	{
		if (sideLengths == null) System.out.println("FOUND IT");
		sideLengths = s.getSideLengths();
		angles = s.getAngles();
		vertices = s.getVertices();
	}
	public String toString() {
		String result = "";
		result += "Side Lengths: ";
		for(double d : sideLengths) {
			result += Math.floor(d * 1000000) / 1000000;
			result += ", ";
		}
		result+="| Angles: ";
		for(double d : angles) {
			result += Math.floor(d * 1000000) / 1000000;
			result += ", ";
		}
		result+="| Vertices: ";
		for (ArrayList<Double> vertex : vertices) {
			result += vertex.toString();
		}
		result += "\n";
		return result;
	}
}
