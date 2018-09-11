package happyCube;

public class Side {
	
	private int[] blocks;
	
	public Side(){
		
		this.blocks = new int[5];
		
	}
	
	public Side(int[] blocksToConstruct){
		this.blocks = blocksToConstruct;
	}

	public int[] getBlocks() {
		return blocks;
	}

	public void setBlocks(int[] blocks) {
		this.blocks = blocks;
	}

	public Side rotate() {
		
		int[] newBlocks = new int[5];
		for(int i=0;i<this.getBlocks().length;i++){
			newBlocks[i] = this.getBlocks()[this.getBlocks().length-i-1];
		}
		
		return new Side(newBlocks);
	}

	public void printBlock(int blockIndex) {

		System.out.print(getCharInBlockIndex(blockIndex));
	}
	
	public String getSideInOriginalRepresentation(){
		
		StringBuilder str = new StringBuilder();
		for (int i=0;i<blocks.length;i++) {
			str.append(getCharInBlockIndex(i));
		}
		
		return str.toString();
	}
	
	public String getSideInReversedRepresentation(){
		
		StringBuilder str = new StringBuilder();
		for (int i=this.blocks.length-1;i>=0;i--) {
			str.append(getCharInBlockIndex(i));
		}
		return str.toString();
	}
	
	public String getCharInBlockIndex(int blockIndex) {
		
		return (this.blocks[blockIndex] == 1) ? "o" : " ";
	}
	
	public int xorSides(Side sideToXor) {
		
		int xorResult = 0;
		
		int i = 0;
		for (int block : this.blocks) {
			xorResult += block ^ sideToXor.getBlocks()[i++];
		}
		return xorResult;
	}

	public boolean match(Side sideToMatch) {
		
		for (int i = 0;i<this.blocks.length; i++) {
			if(this.blocks[i] == 1 && sideToMatch.getBlocks()[i] == 1)
				return false;
		}
		
		return true;
		
	}
}
