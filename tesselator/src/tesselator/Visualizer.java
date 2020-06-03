package tesselator;

import java.util.*;


public class Visualizer {
    ArrayList<Shape> shapes;

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
        // ArrayList<ArrayList<Double>> vertices = shape.getVertices();
        ArrayList<Shape> result = new ArrayList<Shape>();
        for (Shape s : shapes) {
            ArrayList<ArrayList<Double>> targetVerts = shape.getVertices();
            ArrayList<ArrayList<Double>> questionVerts = s.getVertices();


            for (ArrayList<Double> vert : targetVerts) {
                if (questionVerts.contains(vert)) {
                    result.add(s);
                }
            }
        }

        return result;
    }


}
