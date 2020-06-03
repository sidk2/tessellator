package tesselator;

public class ShapeData {
	private double[] sideLengths = new double[3];
	private double[] angles = new double[3];
	public ShapeData(Shape s)
	{
		sideLengths = s.getSideLengths();
		angles = s.getAngles();
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
		s+="\n";
		return s;
	}
}