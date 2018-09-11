package happyCube;

import happyCube.faces.MainFace;
import happyCube.reader.CubeReader;

public class HappyCubeSolver {
	
	public static void main(String[] args){
	
		HappyCube happyCube = CubeReader.readFaces();
		
		if(new MainFace().findCube(happyCube)){
			happyCube.print();
			return;
		}

		System.out.println("No solution exists for given faces!");
	}
}