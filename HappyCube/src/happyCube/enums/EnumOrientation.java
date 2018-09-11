package happyCube.enums;

public enum EnumOrientation {
	
	BASE(0),
	RIGHT(1),
	UPSIDEDOWN(2),
	LEFT(3),
	FLIPPED(4),
	FLIPPEDRIGHT(5),
	FLIPPEDUPSIDEDOWN(6),
	FLIPPEDLEFT(7);
	
	private int orientationId ;
	
	EnumOrientation(int orientationId){
		
		this.orientationId = orientationId;
	}

	public int getOrientationId() {
		return orientationId;
	}

}
