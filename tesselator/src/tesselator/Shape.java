package tesselator;

import java.util.ArrayList;

public class Shape {
	private ArrayList<ArrayList<Double>> vertices;
	private final double INCH_CONVERTER = 2.52;
	private final double SCALE_FACTOR = 1000;
	public Shape(ArrayList<ArrayList<Double>> d)
	{
		vertices = d;
	}
	public ArrayList<ArrayList<Double>> getVertices()
	{
		return vertices;
	}
	public double[] getSideLengths()
	{
		double[] len = new double[3];
		double x1 = vertices.get(0).get(0);
		double x2 = vertices.get(1).get(0);
		double x3 = vertices.get(2).get(0);
		double y1 = vertices.get(0).get(1);
		double y2 = vertices.get(1).get(1);
		double y3 = vertices.get(2).get(1);
		double z1 = vertices.get(0).get(2);
		double z2 = vertices.get(1).get(2);
		double z3 = vertices.get(2).get(2);
		
		len[0] = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) + (z2-z1)*(z2-z1)) * INCH_CONVERTER * SCALE_FACTOR;
		len[1] = Math.sqrt((x2-x3)*(x2-x3) + (y2-y3)*(y2-y3) + (z2-z3)*(z2-z3)) * INCH_CONVERTER * SCALE_FACTOR;
		len[2] = Math.sqrt((x1-x3)*(x1-x3) + (y1-y3)*(y1-y3) + (z1-z3)*(z1-z3)) * INCH_CONVERTER * SCALE_FACTOR;
		
		return len;
	}
	public double invLawOfCos(double a, double b, double c)
	{
		return Math.acos((a*a+b*b-c*c)/(2*a*b))*180.0/Math.PI;
	}
	public double[] getAngles()
	{
		double[] s = getSideLengths();
		double[] angles = new double[3];
		
		angles[2]=invLawOfCos(s[0],s[1],s[2]);
		angles[1]=invLawOfCos(s[0],s[2],s[1]);
		angles[0]=invLawOfCos(s[1],s[2],s[0]);
		return angles;
	}
}
