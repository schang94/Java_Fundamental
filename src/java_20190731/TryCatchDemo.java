package java_20190731;

public class TryCatchDemo {
	public static double getAvg(int korean,int english) {
		int sum = korean + english;
		double avg = (double)sum / (double)2;
		return avg;
	}
	public static void main(String[] args) {
		try {
			int korean = Integer.parseInt(args[0]);
			int english = Integer.parseInt(args[1]);
			double average = getAvg(korean,english);
			System.out.printf("평균 : %f\n", average);
		} catch(NumberFormatException e) {
			//System.out.println("예외 메시지 : " + e.getMessage());
			//e.printStackTrace();
			System.err.println("문자 말고 숫자");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("2개");
		} finally {
			// 무조건 수행되는 블럭
			System.out.println("finally");
		}
		
	}
	
}

