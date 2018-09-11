package happyCube.faces;

import happyCube.HappyCube;
import happyCube.HappyCubeSolver;
import happyCube.Side;
import happyCube.enums.EnumOrientation;

public class Face {

	private Side[] sides;
	private boolean isUsed;
	private EnumOrientation orientation;
	
	public Face(String faceRep){
		
		int arrayIndex = 0;
		this.sides = new Side[4];
		int[] upperBlocks = new int[5];
		for(int i=0;i<5;i++){
			upperBlocks[arrayIndex++] = getBitRepresentation(faceRep.charAt(i));
		}
		this.sides[0] = new Side(upperBlocks);
		
		arrayIndex = 0;
		int[] rightBlocks = new int[5];
		for(int i=4;i<25;i+=5){
			rightBlocks[arrayIndex++] = getBitRepresentation(faceRep.charAt(i));
		}
		this.sides[1] = new Side(rightBlocks);
		
		arrayIndex = 0;
		int[] bottomBlocks = new int[5];
		for(int i=24;i>=20;i--){
			bottomBlocks[arrayIndex++] = getBitRepresentation(faceRep.charAt(i));
		}
		this.sides[2] = new Side(bottomBlocks);
		
		arrayIndex = 0;
		int[] leftBlocks = new int[5];
		for(int i=20;i>=0;i-=5){
			leftBlocks[arrayIndex++] = getBitRepresentation(faceRep.charAt(i));
		}
		this.sides[3] = new Side(leftBlocks);
		
		this.orientation = EnumOrientation.BASE;
		this.isUsed = false;
		
	}

	public Face(){
		
	}
	
	public Side[] getSides() {
		return sides;
	}

	public void setSides(Side[] sides) {
		this.sides = sides;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public EnumOrientation getOrientation() {
		return orientation;
	}

	public void setOrientation(EnumOrientation orientation) {
		this.orientation = orientation;
	}

	public Face getNextFace() {
		// inherited face objects return the next face object to find in the following order
		// main -> right -> upper -> left -> bottom -> other
		return null;
	}
	
	protected void setHappyCubeFaceIndex(HappyCube happyCube, int i) {
		// inherited face objects sets the related face index of happy cube 
		// when the consistent face is found.
	}
	
	// rotate face in the given orientation
	public void rotate(EnumOrientation orientation){
		
		int curOrId = this.orientation.getOrientationId();
		int rotatedOrId = orientation.getOrientationId();
		
		int rotCount = rotatedOrId - curOrId;
		if((curOrId < 4 && rotatedOrId < 4) || (curOrId > 3 && rotatedOrId > 3)){
			if(rotCount > 0){
				for(int i = 0;i<rotCount;i++){
					rotateRight(this);
				}
			}else if(rotCount < 0){
				for(int i=rotCount;i>0;i--){
					rotateLeft(this);
				}
			}
		}else{
			if(rotCount > 0){
				int countToBase = 4 - curOrId;
				for(int i = 0;i<countToBase;i++){
					rotateRight(this);
				}
				flip(this);
				int countToFlipped = rotatedOrId - 4;
				for(int i = 0;i<countToFlipped;i++){
					rotateRight(this);
				}
			}else if(rotCount < 0){
				int countToBase = 8 - curOrId;
				for(int i=0;i<countToBase;i++){
					rotateRight(this);
				}
				flip(this);
				int countToFlipped = 4 - curOrId;
				for(int i = 0;i<countToFlipped;i++){
					rotateLeft(this);
				}
			}
		}
		this.setOrientation(orientation);
		
	}

	private void flip(Face rotated) {
		
		Side[] newSides = new Side[4];
		newSides[0] = rotated.getSides()[0].rotate();
		newSides[1] = rotated.getSides()[3].rotate();
		newSides[2] = rotated.getSides()[2].rotate();
		newSides[3] = rotated.getSides()[1].rotate();
		
		rotated.setSides(newSides);
		
	}

	private void rotateRight(Face rotated) {
		
		Side[] newSides = new Side[4];
		newSides[0] = rotated.getSides()[3];
		newSides[1] = rotated.getSides()[0];
		newSides[2] = rotated.getSides()[1];
		newSides[3] = rotated.getSides()[2];
		
		rotated.setSides(newSides);
		
	}
	
	private void rotateLeft(Face rotated) {
		
		Side[] newSides = new Side[4];
		newSides[0] = rotated.getSides()[1];
		newSides[1] = rotated.getSides()[2];
		newSides[2] = rotated.getSides()[3];
		newSides[3] = rotated.getSides()[0];
		
		rotated.setSides(newSides);
		
	}
	
	public void print(){
		
		StringBuilder str = new StringBuilder();
		str.append("     ");
		str.append(sides[0].getSideInOriginalRepresentation());	
		
		str.append("\n     ");
		str.append(sides[3].getCharInBlockIndex(3));
		str.append("ooo");
		str.append(sides[1].getCharInBlockIndex(1));
		str.append("\n     ");
		
		str.append(sides[3].getCharInBlockIndex(2));
		str.append("ooo");
		str.append(sides[1].getCharInBlockIndex(2));
		str.append("\n     ");
		
		str.append(sides[3].getCharInBlockIndex(1));
		str.append("ooo");
		str.append(sides[1].getCharInBlockIndex(3));
		str.append("\n     ");		
		
		str.append(sides[2].getSideInReversedRepresentation());
		
		str.append("\n");
		System.out.print(str.toString());
	}
		
	public static void printThreeFaces(Face leftFace, Face mainFace, Face rightFace){
		
		// print three faces side by side for printing the happy cube in unfolded format
		
		System.out.print(leftFace.getSides()[0].getSideInOriginalRepresentation());
		System.out.print(mainFace.getSides()[0].getSideInOriginalRepresentation());
		System.out.print(rightFace.getSides()[0].getSideInOriginalRepresentation());
		System.out.println();
		
		System.out.print(leftFace.getSides()[3].getCharInBlockIndex(3));
		printTripleFilledBlock();
		System.out.print(leftFace.getSides()[1].getCharInBlockIndex(1));
		
		System.out.print(mainFace.getSides()[3].getCharInBlockIndex(3));
		printTripleFilledBlock();
		System.out.print(mainFace.getSides()[1].getCharInBlockIndex(1));
		
		System.out.print(rightFace.getSides()[3].getCharInBlockIndex(3));
		printTripleFilledBlock();
		System.out.print(rightFace.getSides()[1].getCharInBlockIndex(1));
		
		System.out.println();
		
		System.out.print(leftFace.getSides()[3].getCharInBlockIndex(2));
		printTripleFilledBlock();
		System.out.print(leftFace.getSides()[1].getCharInBlockIndex(2));
		
		System.out.print(mainFace.getSides()[3].getCharInBlockIndex(2));
		printTripleFilledBlock();
		System.out.print(mainFace.getSides()[1].getCharInBlockIndex(2));
		
		System.out.print(rightFace.getSides()[3].getCharInBlockIndex(2));
		printTripleFilledBlock();
		System.out.print(rightFace.getSides()[1].getCharInBlockIndex(2));
		
		System.out.println();
		
		System.out.print(leftFace.getSides()[3].getCharInBlockIndex(1));
		printTripleFilledBlock();
		System.out.print(leftFace.getSides()[1].getCharInBlockIndex(3));
		
		System.out.print(mainFace.getSides()[3].getCharInBlockIndex(1));
		printTripleFilledBlock();
		System.out.print(mainFace.getSides()[1].getCharInBlockIndex(3));
		
		System.out.print(rightFace.getSides()[3].getCharInBlockIndex(1));
		printTripleFilledBlock();
		System.out.print(rightFace.getSides()[1].getCharInBlockIndex(3));
		
		System.out.println();
		
		System.out.print(leftFace.getSides()[2].getSideInReversedRepresentation());
		System.out.print(mainFace.getSides()[2].getSideInReversedRepresentation());
		System.out.print(rightFace.getSides()[2].getSideInReversedRepresentation());
		System.out.println();
		
	}

	private static void printTripleFilledBlock() {
		System.out.print("ooo");
	}
	
	private int getBitRepresentation(char charAt) {
		
		return (charAt == 'o') ? 1 : 0;
	}
	
	protected boolean cornersMatch(int i, int j, int k) {
		
		return ((i+j+k) == 1);
	}

	// inherited objects apply different consistency checks
	public boolean sideAndCornerCheck(Face currentFace, HappyCube happyCube) {
		return false;
	}
	
	public boolean findFace(HappyCube happyCube) {

		if(happyCube == null)
			return false;
		
		Face[] faceList = happyCube.getFaces();
				
		for (int i =0;i<faceList.length; i++) {
			Face currentFace = faceList[i];
			if(!currentFace.isUsed()){
				// for each orientation of the current face check the consistencies of sides and corners
				for (EnumOrientation orntation : EnumOrientation.values()) {
					currentFace.rotate(orntation);
					// inherited object method is called
					if(sideAndCornerCheck(currentFace, happyCube)){
						currentFace.setUsed(true);
						setHappyCubeFaceIndex(happyCube, i);
						// find the next face
						boolean isFound = getNextFace().findFace(happyCube);
						if(isFound){
							return true;
						}
					}					
				}
				currentFace.setUsed(false);
			}
		}
		
		return false;
	}
	
	public static int findMostSymmetricFace(Face[] faceList) {
		
		int minAsymmetryPoint = Integer.MAX_VALUE;
		int index = 0;
		for (int i=0;i<faceList.length;i++) {
			int point = findAsymmetryPoint(faceList[i]);
			if(point <= minAsymmetryPoint){
				minAsymmetryPoint = point;
				index = i;
			}
		}
		
		return index;
		
	}

	private static int findAsymmetryPoint(Face face) {
		
		int point = 0;
		Side[] sides = face.getSides();
		for(int i=0;i<4;i++){
			for(int j=i+1;j<4;j++){
				point += sides[i].xorSides(sides[j]);
			}
		}
		
		return point;
		
	}


}

