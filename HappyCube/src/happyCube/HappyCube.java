package happyCube;

import happyCube.faces.Face;

public class HappyCube {
	
	private int rightFaceIndex;
	private int leftFaceIndex;
	private int upperFaceIndex;
	private int bottomFaceIndex;
	private int mainFaceIndex;
	private int otherFaceIndex;
	private Face[] faces;

	public HappyCube(String[] facesToConstruct){
		
		this.faces = new Face[6];
		for (int i=0;i<6; i++) {
			this.faces[i] = new Face(facesToConstruct[i]);
		}
		
		rightFaceIndex = -1;
		leftFaceIndex = -1;
		upperFaceIndex = -1;
		bottomFaceIndex = -1;
		mainFaceIndex = -1;
		otherFaceIndex = -1;
		
	}
	
	public Face[] getFaces() {
		return faces;
	}

	public void setFaces(Face[] faces) {
		this.faces = faces;
	}

	public int getRightFaceIndex() {
		return rightFaceIndex;
	}

	public void setRightFaceIndex(int rightFaceIndex) {
		this.rightFaceIndex = rightFaceIndex;
	}

	public int getLeftFaceIndex() {
		return leftFaceIndex;
	}

	public void setLeftFaceIndex(int leftFaceIndex) {
		this.leftFaceIndex = leftFaceIndex;
	}

	public int getUpperFaceIndex() {
		return upperFaceIndex;
	}

	public void setUpperFaceIndex(int upperFaceIndex) {
		this.upperFaceIndex = upperFaceIndex;
	}

	public int getBottomFaceIndex() {
		return bottomFaceIndex;
	}

	public void setBottomFaceIndex(int bottomFaceIndex) {
		this.bottomFaceIndex = bottomFaceIndex;
	}

	public int getMainFaceIndex() {
		return mainFaceIndex;
	}

	public void setMainFaceIndex(int mainFaceIndex) {
		this.mainFaceIndex = mainFaceIndex;
	}

	public int getOtherFaceIndex() {
		return otherFaceIndex;
	}

	public void setOtherFaceIndex(int otherFaceIndex) {
		this.otherFaceIndex = otherFaceIndex;
	}

	public void print(){
		
		// print the face in the unfolded format as
		// 	 X		-> upper face
		//	XXX		-> left face-main face-right face
		//	 X		-> bottom face
		//   X		-> other face
		
		Face upperFace = this.faces[this.upperFaceIndex];
		upperFace.print();
		
		Face leftFace = this.faces[this.leftFaceIndex];
		Face mainFace = this.faces[this.mainFaceIndex];
		Face rightFace = this.faces[this.rightFaceIndex];

		Face.printThreeFaces(leftFace, mainFace, rightFace);
		
		Face bottomFace = this.faces[this.bottomFaceIndex];
		bottomFace.print();
		
		Face otherFace = this.faces[this.otherFaceIndex];
		otherFace.print();
		
	}

}
