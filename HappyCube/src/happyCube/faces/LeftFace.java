package happyCube.faces;

import happyCube.HappyCube;
import happyCube.Side;

public class LeftFace extends Face{
	
	public Face getNextFace() {
		return new BottomFace();
	}
	
	public void setHappyCubeFaceIndex(HappyCube happyCube, int i) {
		
		happyCube.setLeftFaceIndex(i);
	}

	public boolean sideAndCornerCheck(Face currentFace, HappyCube happyCube) {
		
		Face mainFace = happyCube.getFaces()[happyCube.getMainFaceIndex()];
		Face upperFace = happyCube.getFaces()[happyCube.getUpperFaceIndex()];
		
		Side mainSide = mainFace.getSides()[3]; 
		Side currentSide = currentFace.getSides()[1].rotate();
		
		return currentSide.match(mainSide) &&
				upperFace.getSides()[3].rotate().match(currentFace.getSides()[0]) &&	//upper left side - left up side
				cornersMatch(currentFace.getSides()[1].getBlocks()[0], upperFace.getSides()[3].getBlocks()[0], mainFace.getSides()[0].getBlocks()[0]);
		
	}
	
}
