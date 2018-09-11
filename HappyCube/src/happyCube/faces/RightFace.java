package happyCube.faces;

import happyCube.HappyCube;
import happyCube.Side;

public class RightFace extends Face{

	public Face getNextFace() {
		return new UpperFace();
	}
	
	public void setHappyCubeFaceIndex(HappyCube happyCube, int i) {
		
		happyCube.setRightFaceIndex(i);
	}
	
	public boolean sideAndCornerCheck(Face currentFace, HappyCube happyCube) {
		
		Face mainFace = happyCube.getFaces()[happyCube.getMainFaceIndex()];
		
		Side mainSide = mainFace.getSides()[1]; 
		Side currentSide = currentFace.getSides()[3].rotate();
		
		return currentSide.match(mainSide);
		
	}

}
