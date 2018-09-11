package happyCube;

import happyCube.faces.MainFace;
import happyCube.reader.CubeReader;

public class HappyCubeSolver {
	
	public static final String FILEPATH_CUBE = "cube.txt";
	
	public static void main(String[] args){
	
		HappyCube happyCube = CubeReader.readFaces(FILEPATH_CUBE);
		
		if(new MainFace().findFace(happyCube)){
			happyCube.print();
			return;
		}

		System.out.println("No solution exists for given faces!");
	}
}