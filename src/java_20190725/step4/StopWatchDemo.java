package java_20190725.step4;

public class StopWatchDemo {
	public static void run(StopMilliWatch s) {
		s.strat();
		for (long i = 0; i < 30_000_000_000l; i++) {

		}
		s.stop();
		System.out.printf("경과 시간 : %.3f", s.getElapsedTime());
	}
	public static void run(StopNanoWatch s) {
		s.strat();
		for (long i = 0; i < 30_000_000_000l; i++) {

		}
		s.stop();
		System.out.printf("경과 시간 : %.9f", s.getElapsedTime());
	}
	
	public static void main(String[] args) {

		run(new StopMilliWatch());
		run(new StopNanoWatch());
	}
}
