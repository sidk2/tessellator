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

    public ArrayList<Shape> findSides(Shape shape) {
        ArrayList<ArrayList<Double>> vertices = shape.getVertices();
        ArrayList<Shape> result = new ArrayList<Shape>();

        for (ArrayList<Double> vertex : vertices) {
            ArrayList<Double> sideLengths = toDoublearray(shape.getSideLengths());

            for (Shape test : shapes) {
                ArrayList<ArrayList<Double>> testVerts = test.getVertices();
                ArrayList<Double> testLengths = toDoublearray(test.getSideLengths());

                if (testVerts.contains(vertex)) {
                    sideLengths.retainAll(testLengths);
                    if (sideLengths.size() > 0) {
                        result.add(test);
                    }
                }


            }
        }

        return result;
    }


}
