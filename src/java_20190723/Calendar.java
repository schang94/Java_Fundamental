package java_20190723;
// one line comment

/*
  mult lin commnet
 */

/**
 Calendar 클래스는 년도별, 월별, 요일을 구할 수 있는 클래스 입니다.
 */
public class Calendar {
	public static final String week[] = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };

	private int totalCount(int year, int month, int day) {
		int preYear = year - 1;

		int count = preYear * 365 + (preYear / 4 - preYear / 100 + preYear / 400);

		for (int i = 1; i < month; i++) {
			count += getLastDay(year, i);
		}

		count += day;

		return count;
	}

	private int getLastDay(int year, int month) {
		int monthArray[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			monthArray[1] = 29;
		}

		return monthArray[month - 1];
	}

	/**
	 매개변수에 년도로 호출하면 해당 년도이 월 별 달력을 출력하는 기능입니다.
	 */
	public void print(int year) {
		for (int i = 1; i <= 12; i++) {
			if(i%2 == 1) {
				System.out.printf("\n\t\t\t%d월\t\t\t\n", i);
				print(year, i);
			}
		}
	}

	/**
	 매개변수에 년도와 월로 호출하면 해당 년도 월의 달력을 출력하는 기능입니다.
	 */
	public void print(int year, int month) {

		int dayOfTheWeek = totalCount(year, month, 1) % 7;

		System.out.print("일\t월\t화\t수\t목\t금\t토\n");

		for (int i = 0; i < getLastDay(year, month) + dayOfTheWeek; i++) {
			if (i != 0 && i % 7 == 0) {
				System.out.println();
			}
			if (i - dayOfTheWeek < 0) {
				System.out.print("\t");
			} else {
				System.out.printf("%d\t", i - dayOfTheWeek + 1);
			}
		}
		System.out.println();
	}

	/**
	 매개변수에 년도,월,일자로 호출하면 해당 요일을 출력하는 기능입니다.
	 */
	public void print(int year, int month, int day) {

		int count = totalCount(year, month, day);

		System.out.println(year + "년 " + month + "월 " + day + "일은 " + week[count % 7] + "입니다." + "");
	}
}
