package happyCube.faces;

import happyCube.HappyCube;
import happyCube.enums.EnumOrientation;

public class MainFace extends Face{
	
	public Face getNextFace() {
		return new RightFace();
	}
	
	public void setHappyCubeFaceIndex(HappyCube happyCube, int i) {
		
		happyCube.setMainFaceIndex(i);
	}
	// if the next face is main face and all the sides and corners are consistent then we found a global solution
	public boolean findFace(HappyCube happyCube) {
		return true;
	}

	public boolean findCube(HappyCube happyCube) {

		Face[] faceList = happyCube.getFaces();
		
		int mostSymmetricFace = Face.findMostSymmetricFace(faceList);

		Face mainFace = faceList[mostSymmetricFace];
		mainFace.setUsed(true);
		setHappyCubeFaceIndex(happyCube, mostSymmetricFace);
		for (EnumOrientation orientation : EnumOrientation.values()) {
			mainFace.rotate(orientation);
			if(getNextFace().findFace(happyCube)){
				return true;
			}
		}
		
		return false;

	}

}
