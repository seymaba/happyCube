package happyCube.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import happyCube.HappyCube;

public class CubeReader {

	public static HappyCube readFaces(String filePath) {
		
		try {
			Scanner scanner = new Scanner(new File(filePath));
			String[] faceList = new String[6];
			for(int i=0;i<6;i++) {
				String face = "";
				for(int j=0;j<5;j++) {
					face = face + scanner.nextLine();
				}
				
				faceList[i] = face;
			}
			
			scanner.close();
			
			HappyCube happyCube = new HappyCube(faceList);
			
			return happyCube;
			
		} catch (FileNotFoundException e) {
			System.out.println("Input file not found!");
			return null;
		}
	}
}
