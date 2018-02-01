import java.io.*;
import java.util.Scanner;

public class StreamTest {

	public static void main(String[] args) {
		try {
			test4();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public static void test1() throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("./stream/input.txt");
			out = new FileOutputStream("./stream/output.txt");
			int c; 
			while ((c= in.read()) != -1) {
				System.out.println(c);
				System.out.println((char)c);
				out.write(c);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
	
	public static void test2() throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("./stream/input.txt");
			out = new FileOutputStream("./stream/output.txt");
			byte[] bytes = new byte[10];
			int n = in.read(bytes);
			System.out.println("n = " + n);
			for (byte b : bytes) {
				System.out.print((char)b);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
	
	public static void test3() throws IOException {
		FileReader in = null;
		FileWriter out = null;
		try {
			in = new FileReader("./stream/chineseinput.txt");
			out = new FileWriter("./stream/chineseoutput.txt");
			int c; 
			while ((c= in.read()) != -1) {
				System.out.println(c);
				System.out.println((char)c);
				out.write(c);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
	
	public static void test4() throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Type some data for the program:");
		String input = scan.nextLine();
		String[] position = input.split(",");
		int x = Integer.parseInt(position[0]);
		int y = Integer.parseInt(position[1]);
		System.out.println("X:" + x + "\tY:" + y);
	}
}
