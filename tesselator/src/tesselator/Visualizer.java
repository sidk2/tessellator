package tesselator;

import java.util.*;


public class Visualizer {
    ArrayList<Shape> shapes;

    public Visualizer() {}

    public Visualizer(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public ArrayList<Double> toDoublearray(double[] arr) {
        ArrayList<Double> result = new ArrayList<Double>();
        for (double dub : arr) {
            result.add(new Double(dub));
        }
        return result;
    }

    public ArrayList<Shape> findAdjacent(Shape shape) {
        Set<Shape> result = new HashSet<Shape>();
        for (Shape s : shapes) {
            ArrayList<ArrayList<Double>> targetVerts = shape.getVertices();
            ArrayList<ArrayList<Double>> questionVerts = s.getVertices();


            for (ArrayList<Double> vert : targetVerts) {
                if (questionVerts.contains(vert) && !shape.getVertices().equals(s.getVertices())) {
                    result.add(s);
                }
            }
        }

        return new ArrayList<Shape>(result);
    }


}
