package tesselator;

public class ShapeData {
	private double[] sideLengths = new double[3];
	private double[] angles = new double[3];
	public ShapeData(Shape s)
	{
		sideLengths = s.getSideLengths();
		angles = s.getAngles();
	}
}
