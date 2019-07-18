package java_20190716;

public class SsnDemo {
	public static void main(String[] args) {

		String ssn = "111111-111111";
		int total = 0;
		int count = 2;
		for (int i = 0; i <= 12; i++) {
			if (i != 6) {
				// 각 자리에 2~9를 곱하고 나머지에 2~5을 곱한다.
				total += ((int) ssn.charAt(i) - 48) * count++;
			}
			if (count == 10) {
				count = 2;
			}
		}

		int tump = total % 11;
		tump = 11 - tump;
		tump %= 10;

		System.out.println("주민 번호 : " + ssn + tump);
		System.out.println("오늘은 그만!!");
	}
}
