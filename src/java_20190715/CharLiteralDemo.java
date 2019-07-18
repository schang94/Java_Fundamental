package java_20190715;

public class CharLiteralDemo {
	public static void main(String[] args) {

		char c1 = '\uc190';
		char c2 = '\uCC3D';
		char c3 = '\uBBFC';

		System.out.print(c1);
		System.out.print(c2);
		System.out.println(c3);

		char c4 = 65;
		System.out.println(c4);

		char c5 = 'A';
		System.out.println(c5);

		char c6 = '\'';
		System.out.println(c6);
		char c7 = '\"';
		System.out.println(c7);
		char c8 = '\\';
		System.out.println(c8);

		String path = "aa\tbb"; // \t tab
		System.out.println(path);
		path = "aa\nbb"; // \n 개행
		System.out.println(path);
	}
}
