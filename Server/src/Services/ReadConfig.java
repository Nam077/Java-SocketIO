package Services;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
public class ReadConfig {

	public static ArrayList<String> readFile() {
		ArrayList<String> list = new ArrayList<String>();
		try {
			String path = "Config/config.txt";
			java.util.Scanner sc = new java.util.Scanner(new java.io.File(path));
			while (sc.hasNextLine()) {
				list.add(sc.nextLine());
			}
			sc.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return list;
	}
	public static String getVariable(String name) {
		ArrayList<String> list = readFile();
		for (String s : list) {
			String[] arr = s.split("=");
			if(arr[0].equals(name)) {
				if(arr.length==2) {
					return arr[1];
				}
				else {
					return "";
				}
			}
		}
		return "";
	}
	public static void main(String[] args) {
		System.out.println(getVariable("NAME_DATABASE"));
	}
}
