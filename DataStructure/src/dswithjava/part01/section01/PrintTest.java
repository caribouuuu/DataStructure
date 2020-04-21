package dswithjava.part01.section01;

public class PrintTest {

	
	public static void main(String[] args) {
		int n = 2147483647;
		printBinaryString(n);
		//n = 2147483648; //out of range 에러 뜸 
		
		n = 2147483646;
		printBinaryString(n);
		
		n = -2147483648;
		printBinaryString(n);
		n = -2147483647;
		printBinaryString(n);
		n = -2147483646;
		printBinaryString(n);
		
		n = 127; // = 2^7 - 1
		printBinaryString(n);
		byte b = (byte)n;
		System.out.println("b=(byte)n => "+b);
		System.out.println("b & 0xff => " + (b & 0xff));	
		// & 연산 : 둘 다 1이면 1, 아니면 0 출력
		// 0xff = 00000000 00000000 00000000 11111111 :: 16진수의 int(32비트)형
		
		n = 128; // = 2^7
		printBinaryString(n);
		b = (byte)n;
		printByte(b);
		
		n = 150; // 
		printBinaryString(n);
		b = (byte)n;
		printByte(b);
		
		n = -150; // 
		printBinaryString(n);
		b = (byte)n;
		printByte(b);
		
		n = 3;
		printBinaryString(n);
		b = (byte)n;
		printByte(b);
		
		n = 280;
		printBinaryString(n);
		b = (byte)n;
		printByte(b);
		
		n = 254;
		printBinaryString(n);
		b = (byte)n;
		printByte(b);
		
		n = 255;
		printBinaryString(n);
		b = (byte)n;
		printByte(b);
		
		n = -254;
		printBinaryString(n);
		b = (byte)n;
		printByte(b);
		
		n = 256;
		printBinaryString(n);
		b = (byte)n;
		printByte(b);
		
		
		System.out.println("\n-----------------------");
		String countString = new String(new char[3]).replace("\0", "#");
		System.out.println("*"+countString+"*");
		//String.repeat();	//Java 11부터
		
		int top=5;
		
		System.out.println( (-2 + top--) );
		System.out.println(top);
		
	}
	
	public static void printBinaryString(int n) {
		System.out.println( "%32s "+String.format("%32s", Integer.toBinaryString(n)).replace(" ", "-") +" :: "+n);
		//System.out.println( "%16s "+String.format("%16s", Integer.toBinaryString(n)).replace(" ", "-") +" :: "+n);
	}
	public static void printByte(byte b) {
		System.out.println("b=(byte)n => "+b);
		System.out.println("b & 0xff => " + (b & 0xff));		
	}
}
