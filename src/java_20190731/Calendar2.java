package java_20190731;
// one line comment

import java.util.Calendar;

/*
  mult lin commnet
 */

/**
 Calendar 클래스는 년도별, 월별, 요일을 구할 수 있는 클래스 입니다.
 */
public class Calendar2 {
	public static final String week[] = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };

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
		
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, 1);
	
		int dayOfTheWeek = c.get(Calendar.DAY_OF_WEEK) - 1;

		System.out.print("일\t월\t화\t수\t목\t금\t토\n");

		for (int i = 0; i < c.getActualMaximum(Calendar.DATE) + dayOfTheWeek; i++) {
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

		Calendar c = Calendar.getInstance();
		c.set(year, month-1, day);
		
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

		System.out.println(year + "년 " + month + "월 " + day + "일은 " + week[dayOfWeek-1] + "입니다." + "");
	}
}
