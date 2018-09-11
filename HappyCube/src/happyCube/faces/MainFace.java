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

	public boolean sideAndCornerCheck(Face currentFace, HappyCube happyCube) {
		return true;
	}

	public boolean findFace(HappyCube happyCube) {

		if(happyCube == null)
			return false;
		
		Face[] faceList = happyCube.getFaces();
		
		// find face in main face is called after the last face is fitted
		// if all the faces are used it means we found a working solution
		boolean allUsed = true;
		for (Face face : faceList) {
			if(!face.isUsed())
				allUsed = false;
		}
		
		if(allUsed)
			return true;
		
		// entry point in main class
		// start with most symmetric face
		int mostSymmetricFace = Face.findMostSymmetricFace(faceList);

		Face mainFace = faceList[mostSymmetricFace];	
		mainFace.setUsed(true);
		setHappyCubeFaceIndex(happyCube, mostSymmetricFace);
		return getNextFace().findFace(happyCube);
	}

}
