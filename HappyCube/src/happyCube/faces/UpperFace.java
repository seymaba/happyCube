package happyCube.faces;

import happyCube.HappyCube;
import happyCube.Side;

public class UpperFace extends Face {

	public Face getNextFace() {
		return new LeftFace();
	}
	
	public void setHappyCubeFaceIndex(HappyCube happyCube, int i) {
		
		happyCube.setUpperFaceIndex(i);
	}
	
	public boolean sideAndCornerCheck(Face currentFace, HappyCube happyCube) {
		
		Face mainFace = happyCube.getFaces()[happyCube.getMainFaceIndex()];
		Face rightFace = happyCube.getFaces()[happyCube.getRightFaceIndex()];
		
		Side mainSide = mainFace.getSides()[0]; 
		Side currentSide = currentFace.getSides()[2].rotate();
		
		return currentSide.match(mainSide) &&
				rightFace.getSides()[0].rotate().match(currentFace.getSides()[1])  && 
				 cornersMatch(currentFace.getSides()[2].getBlocks()[0], rightFace.getSides()[0].getBlocks()[0], mainFace.getSides()[1].getBlocks()[0]);
		
	}
	
}
