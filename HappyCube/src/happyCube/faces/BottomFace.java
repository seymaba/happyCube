package happyCube.faces;

import happyCube.HappyCube;
import happyCube.Side;

public class BottomFace extends Face{

	public Face getNextFace() {
		return new OtherFace();
	}
	
	public void setHappyCubeFaceIndex(HappyCube happyCube, int i) {
		
		happyCube.setBottomFaceIndex(i);
	}
	
	public boolean sideAndCornerCheck(Face currentFace, HappyCube happyCube) {
		
		Face mainFace = happyCube.getFaces()[happyCube.getMainFaceIndex()];
		Face rightFace = happyCube.getFaces()[happyCube.getRightFaceIndex()];
		Face leftFace = happyCube.getFaces()[happyCube.getLeftFaceIndex()];
		
		Side mainSide = mainFace.getSides()[2]; 
		Side currentSide = currentFace.getSides()[0].rotate();
		
		return currentSide.match(mainSide) &&
				leftFace.getSides()[2].rotate().match(currentFace.getSides()[3]) && 
				rightFace.getSides()[2].rotate().match(currentFace.getSides()[1]) &&
				  cornersMatch(currentFace.getSides()[0].getBlocks()[0], leftFace.getSides()[2].getBlocks()[0], mainFace.getSides()[3].getBlocks()[0]) && 
				   cornersMatch(currentFace.getSides()[1].getBlocks()[0], rightFace.getSides()[3].getBlocks()[0], mainFace.getSides()[2].getBlocks()[0]);
		
	}
	
}
