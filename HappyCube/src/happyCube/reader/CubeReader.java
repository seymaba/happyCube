package happyCube.reader;

import happyCube.HappyCube;

public class CubeReader {

	public static HappyCube readFaces() {
		
		String[] faceList = new String[6];
		faceList[0] = 
"  o o" + 
"ooooo" +
" ooo " +
"ooooo" +
" o oo";
		
		faceList[1] = 
" o o " + 
" ooo " +
"ooooo" +
" ooo " +
"  o  ";
		
		faceList[2] = 
" o o " + 
"oooo " +
" oooo" +
"oooo " +
"oo o ";
		
		faceList[3] = 
"  o  " + 
" ooo " +
"ooooo" +
" ooo " +
"  o  ";
		
		faceList[4] = 
"o o  " +  
"ooooo" +
" ooo " +
"ooooo" +
" o o ";
		
		faceList[5] = 
"o o o" + 
"ooooo" +
" ooo " +
"ooooo" +
"o o o";
		
		HappyCube happyCube = new HappyCube(faceList);
		
		return happyCube;
	}
	
	public static HappyCube readFaces2() {
		
		String[] faceList = new String[6];
		faceList[0] = 
"   oo" + 
" ooo " + 
"ooooo" + 
" ooo " +
" o oo" ;
		
		faceList[1] = 
" o o " +
"oooo " +
" oooo" +
"oooo " + 
" o   ";
		
		faceList[2] =
" oo o" + 
"ooooo" +
" ooo " +
"ooooo" +
"o  oo";
		
		faceList[3] = 
"  o  " +
"oooo " +
" oooo" + 
"oooo " + 
"  o  ";
		
		faceList[4] = 
"  oo " + 
"ooooo" +
" ooo " +
"ooooo" +
"o o  ";
		
		faceList[5] = 
" oo  " + 
" ooo " +
"ooooo" +
" ooo " +
"oo oo";
		
		HappyCube happyCube = new HappyCube(faceList);
		
		return happyCube;
	}
	public static HappyCube readFaces3() {
		
		String[] faceList = new String[6];
		faceList[0] = 
"oo o " + 
"oooo " + 
"oooo " + 
" oooo" +
"  o  " ;
		
		faceList[1] = 
"   oo" +
"oooo " +
"ooooo" +
" ooo " + 
" o o ";
		
		faceList[2] =
" o   " + 
"oooo " +
" oooo" +
"oooo " +
"  o  ";
		
		faceList[3] = 
"oo oo" +
" oooo" +
"oooo " + 
" ooo " + 
" o o ";
		
		faceList[4] = 
"  o o" + 
" oooo" +
"ooooo" +
"oooo " +
"o oo ";
		
		faceList[5] = 
" o oo" + 
" ooo " +
" oooo" +
"oooo " +
"oo o ";
		
		HappyCube happyCube = new HappyCube(faceList);
		
		return happyCube;
	}

}
