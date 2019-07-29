package java_20190729;

public class StringDemo {
	public static void main(String[] args) {
		String s1 = new String("test");
		String s2 = new String("test");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));

		String s3 = "abc";
		String s4 = "abc";
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));

		String ssn = "123456-1234567";
		System.out.println(ssn.charAt(6));

		// ssn = ssn.concat("abcd");
		System.out.println(ssn);

		String fileName = "abc.afsd.dsfa.fds.doc";

		if (fileName.endsWith("zip")) {
			System.out.println("압축 파일입니다.");
		} else if (fileName.endsWith("doc")) {
			System.out.println("워드 파일입니다.");
		} else {
			System.out.println("파일입니다.");
		}

		System.out.println(fileName.equalsIgnoreCase("ABC.DOC"));

		int index = ssn.indexOf("-");

		System.out.println(index);

		int lastIndex = fileName.lastIndexOf(".");

		System.out.println(lastIndex);

		String first = ssn.substring(0, index);
		String second = ssn.substring(index + 1);

		System.out.println(first);
		System.out.println(second);

		String fileFirst = fileName.substring(0, lastIndex);
		String fileSecond = fileName.substring(lastIndex + 1);

		System.out.println(fileFirst);
		System.out.println(fileSecond);
	}
}
