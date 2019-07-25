package java_20190725.step5;

public class StopWatchDemo {
	public static void run(StopMilliWatch s) {

		System.out.printf("경과 시간 : %.3f", s.getElapsedTime());
	}
	public static void run(StopNanoWatch s) {
		
		System.out.printf("경과 시간 : %.9f", s.getElapsedTime());
	}
	public static void main(String[] args) {

		run(new StopMilliWatch());

	}
}
