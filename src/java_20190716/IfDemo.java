package java_20190716;

public class IfDemo {
	public static void main(String[] args) {

		// Run configurations => Arguments => Program argument
		int month = Integer.parseInt(args[7]);

		String season = null;
		if (month == 12 || month == 1 || month == 2) {
			season = "겨울";
		} else if (month >= 3 && month <= 5) {
			season = "봄";
		} else if (month >= 6 && month <= 8) {
			season = "여름";
		} else if (month >= 9 && month <= 11) {
			season = "가을";
		} else {
			season = "없는 계절입니다.";
		}
		System.out.println(month + "월은 " + season + "입니다.");
	}
}
