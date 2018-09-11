package happyCube.faces;

import happyCube.HappyCube;
import happyCube.Side;

public class OtherFace extends Face {

	public Face getNextFace() {
		return new MainFace();
	}
	
	public void setHappyCubeFaceIndex(HappyCube happyCube, int i) {
		
		happyCube.setOtherFaceIndex(i);
	}
	
	public boolean sideAndCornerCheck(Face currentFace, HappyCube happyCube) {
		
		Face rightFace = happyCube.getFaces()[happyCube.getRightFaceIndex()];
		Face leftFace = happyCube.getFaces()[happyCube.getLeftFaceIndex()];
		Face upperFace = happyCube.getFaces()[happyCube.getUpperFaceIndex()];
		Face bottomFace = happyCube.getFaces()[happyCube.getBottomFaceIndex()];
		
		Side mainSide = bottomFace.getSides()[2];
		Side currentSide = currentFace.getSides()[0].rotate();
		
		return currentSide.match(mainSide) &&
				upperFace.getSides()[0].rotate().match(currentFace.getSides()[2]) &&
				rightFace.getSides()[1].rotate().match(currentFace.getSides()[1]) &&
				leftFace.getSides()[3].match(currentFace.getSides()[3]);
		
	}

}
