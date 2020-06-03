package tesselator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

	private String filepath;

	public Parser(String s) {
		filepath = s;
	}

	public String getFilepath() {
		return filepath;
	}
/**
 * Double -> coord
 * Array list of doubles -> vertex
 * array list of array list of double -> array list of vertices
 * @return array list of vertices
 */
	public ArrayList<ArrayList<Double>> parseVertices() {
		ArrayList<ArrayList<Double>> ret = new ArrayList<ArrayList<Double>>();
		String file = getFilepath();
		try {
			File myObj = new File(filepath);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				if (data.startsWith("v ")) {
					String[] s = data.split(" ");
					ArrayList v = new ArrayList<Integer>();
					v.add(Double.parseDouble(s[1]));
					v.add(Double.parseDouble(s[2]));
					v.add(Double.parseDouble(s[3]));
					ret.add(v);
				}
			}
				for(ArrayList<Double> a: ret)
				{
					for(Double n: a)
					{
						System.out.print(n + " ");
					}
					System.out.print('\n');
				}
			
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return ret;

	}
	public ArrayList<Shape> getFaces()
	{
		ArrayList<ArrayList<Double>> vertices = parseVertices();
		ArrayList<Shape> ret = new ArrayList<Shape>();
		try {
			File myObj = new File(filepath);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				if (data.startsWith("f ")) {
					String[] fracs = data.split(" ");
					int[] nums = new int[4];
					for(int i = 1; i < 4;i++)
					{
						nums[i] = Integer.parseInt(fracs[i].split("/")[0]);
					}
					ArrayList<ArrayList<Double>> shapeCorners = new ArrayList<ArrayList<Double>>();
					shapeCorners.add(vertices.get(nums[1] - 1));
					shapeCorners.add(vertices.get(nums[2] - 1));
					shapeCorners.add(vertices.get(nums[3] - 1));
					Shape s = new Shape(shapeCorners);
					ret.add(s);
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return ret;
	}

}
