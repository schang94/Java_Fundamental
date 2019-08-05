package java_20190805;

import java.util.Calendar;
import java.util.Scanner;

import bonus.Utility;


public class APIExamCaptchDemo {
	public static String console(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	public static void main(String[] args) {
		String id = "a1RQlx9O4lTGUkF4g0MA";
		String secret = "ABs7bJKCqG";
		String key = Utility.getCaptchaKey(id, secret);
		boolean isSuccess = Utility.isCaptchaImage(id,secret,key);
		if(isSuccess) {
			String value = console("이미지결과값을 입력하세요>");
			boolean result = Utility.isCaptchResult(id, secret, key, value);
			if(result) {
				System.out.println("일치");
			} else {
				System.out.println("불일치");
			}
		} else {
			System.out.println("입력된 정보를 다시 확인하시오");
		}
		System.out.println(key);
	}
}
