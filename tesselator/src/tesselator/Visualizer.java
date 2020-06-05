package tesselator;

import java.util.*;
import java.io.*;


public class Visualizer {
    ArrayList<Shape> faces;

    public Visualizer() {}

    public Visualizer(ArrayList<Shape> faces) {
        this.faces = faces;
    }

    public void setShapes(ArrayList<Shape> faces) {
        this.faces = faces;
    }

    public ArrayList<Shape> getShapes() {
        return faces;
    }

    public ArrayList<Double> toDoubleArray(double[] arr) {
        ArrayList<Double> result = new ArrayList<Double>();
        for (double dub : arr) {
            result.add(new Double(dub));
        }
        return result;
    }
    //returns in order ACB
    public ArrayList<Shape> findAdjacent(Shape shape) {
        ArrayList<Shape> result = new ArrayList<Shape>();
        ArrayList<ArrayList<Double>> targetVerts = shape.getVertices();

        for (Shape s : faces) {
            if (s.getAngles()[0] == 0.0 || Double.isNaN(s.getAngles()[0]) || shape.getVertices().equals(s.getVertices())) continue;

            ArrayList<ArrayList<Double>> questionVerts = s.getVertices();
            ArrayList<ArrayList<Double>> deep = new ArrayList<>();

            for (ArrayList<Double> vert : questionVerts) {
                deep.add(vert);
            }

            deep.retainAll(targetVerts);

            if (deep.size() == 2) {
                result.add(s);
            }
            
        }

        return result;
    }

    public void fileAppend(FileWriter writer, String[] args) {
        
        try {
            for (String arg : args) {
                writer.append(arg);
                writer.append(", ");
            }
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createCSV(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);

            String[] row = new String[]{"Triangle #", "Side A", "A adj to"
                                        , "Side B", "B adj to", "Side C"
                                        , "C adj to", "Angle A/B", "Angle B/C"
                                        , "Angle A/C"};
            fileAppend(writer, row);
            

            for (int i = 0; i < faces.size(); i++) {
                Shape s = faces.get(i);
                ArrayList<Double> sides = toDoubleArray(s.getSideLengths());
                double[] angles = s.getAngles();
                ArrayList<Shape> adjacents = findAdjacent(s);
                ArrayList<ArrayList<Double>> targetVerts = s.getVertices();

                
                // System.out.print((new ShapeData(s)).toString());
                // for (Shape adj : adjacents) {
                //     System.out.print((new ShapeData(adj)).toString());
                // }
                // System.out.print("\n");
                row[2] = "";
                row[4] = "";
                row[6] = "";

                if (angles[0] == 0.0 || Double.isNaN(angles[0])) continue;

                // if (i + 1 == 1652) {
                //     ArrayList<ArrayList<Double>> verts = s.getVertices();
                //     for (ArrayList<Double> vert : verts) {
                //         System.out.println(vert);
                //     }
                    
                // }
                // System.out.print((new ShapeData(s)).toString());
                for (int j = 0; j < adjacents.size(); j++) {

                    Shape adjacent = adjacents.get(j);
                    ArrayList<ArrayList<Double>> questionVerts = adjacent.getVertices();
                    String side = " ";
                    // System.out.print((new ShapeData(adjacent)).toString());

                    if (targetVerts.contains(questionVerts.get(0)) && targetVerts.contains(questionVerts.get(1))) side = "A";
                    if (targetVerts.contains(questionVerts.get(1)) && targetVerts.contains(questionVerts.get(2))) side = "B";
                    if (targetVerts.contains(questionVerts.get(0)) && targetVerts.contains(questionVerts.get(2))) side = "C";


                    int index;

                    if (targetVerts.indexOf(questionVerts.get(0)) == -1) {
                        index = targetVerts.indexOf(questionVerts.get(1)) + targetVerts.indexOf(questionVerts.get(2)) - 1;
                    } else if (targetVerts.indexOf(questionVerts.get(1)) == -1) {
                        index = targetVerts.indexOf(questionVerts.get(0)) + targetVerts.indexOf(questionVerts.get(2)) - 1;
                    } else {
                        index = targetVerts.indexOf(questionVerts.get(0)) + targetVerts.indexOf(questionVerts.get(1)) - 1;
                    }


                    
                    int adjNum = faces.indexOf(adjacent);
                    index = -3 * (int) Math.pow((double) index, 2) + 7 * index + 2;
                    row[index] += Integer.toString(adjNum + 1) + " - " + side + "| ";


                    // ArrayList<Double> adjacentSides = toDoubleArray(adjacent.getSideLengths());
                    // ArrayList<Double> deep = new ArrayList<>();
                    

                    // for (Double side : adjacentSides) {
                    //     deep.add(side);
                    // }

                    // deep.retainAll(sides);
                    // if (deep.size() >= 1) {
                    //     int side = (2 * sides.indexOf(deep.get(0))) + 2;
                    //     int target = adjacentSides.indexOf(deep.get(0));
                    //     System.out.println(new ShapeData(s).toString() + new ShapeData(adjacent).toString() + " " + side);
                    //     if (side > 0) row[side] += Integer.toString(adjNum + 1) + " - " + String.valueOf((char)(target + 65)) + "| ";
                        
                    // }
                }
                if (row[2].length() == 0) row[2] = "--";
                if (row[4].length() == 0) row[4] = "--";
                if (row[6].length() == 0) row[6] = "--";


                
                row[0] = Integer.toString(i + 1);
                row[1] = Double.toString(sides.get(0));
                row[3] = Double.toString(sides.get(1));
                row[5] = Double.toString(sides.get(2));
                row[7] = Double.toString(angles[2]);
                row[8] = Double.toString(angles[0]);
                row[9] = Double.toString(angles[1]);

                fileAppend(writer, row);
            }

             writer.flush();
             writer.close();
        } catch(IOException e) {
              e.printStackTrace();
        } 
    }


}
