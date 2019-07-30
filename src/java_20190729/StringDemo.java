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

		// ssn = ssn.concat("abcd"); // 문자열 연결
		System.out.println(ssn);

		String fileName = "abc.afsd.dsfa.fds.doc";

		if (fileName.endsWith("zip")) { // "zip" 문자열로 끝나면 true, 그렇지 않으면 false
			System.out.println("압축 파일입니다.");
		} else if (fileName.endsWith("doc")) {
			System.out.println("워드 파일입니다.");
		} else {
			System.out.println("파일입니다.");
		}

		// equalsIgnoreCase(String msg) : 대소문자 구분하지 않고 문자열 비교하고 맞으면 true, 그렇지 않으면 false
		System.out.println(fileName.equalsIgnoreCase("ABC.DOC"));

		// indexOf(String msg) : 앞에서 부터 검색해서 msg문자열의 위치를 반환한다.=> 0에서 부터 시작한다.
		int index = ssn.indexOf("-");

		System.out.println(index);

		// lastIndexOf(String msg) : 끝에서 부터 검색해서 msg문자열의 위치를 반환한다.
		int lastIndex = fileName.lastIndexOf(".");

		System.out.println(lastIndex);

		// substring(int first, int second) : first(포함)부터 second(포함x) 사이의 문자열을 추출한다.
		// substring(int index) : index(포함) 보다 큰 문자열을 추출한다.
		String first = ssn.substring(0, index);
		String second = ssn.substring(index + 1);

		System.out.println(first);
		System.out.println(second);

		String fileFirst = fileName.substring(0, lastIndex);
		String fileSecond = fileName.substring(lastIndex + 1);

		System.out.println(fileFirst);
		System.out.println(fileSecond);

		// replaceAll(String first,String second) : first 문자열을 second 문자열로 대채
		String html = "안녕하세요.\n 저는 성영한 입니다.\n 잘 부탁드립니다.";
		html = html.replaceAll("\n", "<br>");
		System.out.println(html);

		String url = "http://www.naver.com";
		String path = "/news";
		
		// startsWith(String msg) : msg문자열로 시작하면 true, 그렇지 않으면 false
		if (path.startsWith("/news")) {
			System.out.println("뉴스 페이지 입니다.");
		} else if (path.startsWith("/sports")) {
			System.out.println("스포츠 페이지 입니다.");
		} else {
			System.out.println("페이지가 존재하지 않습니다.");
		}
		
		System.out.println(url.toUpperCase());
		String m1 = "ASFDSDF";
		System.out.println(m1.toLowerCase());
		
		char c1[] = {'a','b','c'};
		String str1 = String.valueOf(c1,2,1);
		System.out.println(str1);
		
		// split(String delimitere) : 문자열을 구분자(delimiter)로 토큰(token)화 시키는 메서드
		String[] str2 = ssn.split("-");
		System.out.println(str2[0]);
		System.out.println(str2[1]);
		
		String str3 = String.format("%,.2f", 1234.1254);
		System.out.println(str3);
		
		String str4 = String.format("%,d", 1000000000);
		System.out.println(str4);
		
	}
}
