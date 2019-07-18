package java_20190716;

public class calendarDemo {
	public static void main(String[] args) {
		// 1년 1월 1일은 월요일
		// 1년 365일 이고 윤년일 때는 366일 => 2월 29일
		// 윤년은 4년마다 발생하고 그중에서 100의 배수는 제외하고 400배수는 제외하지 않는다.

		int year = 2019;
		int month = 7;
		int day = 18;
		int preYear = year - 1;
		int preMonth = month - 1;
		int a[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String d[] = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };
		int totalCount = 0;
		
		// year - 1년도 까지의 합을 계산
		totalCount = preYear * 365 + (preYear / 4 - preYear / 100 + preYear / 400);

		// year년도 month - 1월 까지의 합을 계산
		for (int i = 0; i < preMonth; i++) {
			totalCount += a[i];
			if (i == 1 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
				totalCount += 1;
			}
		}

		totalCount += day;
		
		System.out.println(year + "년 " + month + "월 " + day + "일은 " + d[totalCount % 7] + "입니다." + "");
		
		
		
	}
}
