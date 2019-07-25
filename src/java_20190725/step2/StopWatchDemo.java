package java_20190725.step2;

public class StopWatchDemo {
	public static void main(String[] args) {
		StopWatch s1 = new StopWatch();
		
		s1.strat();
		
		for (long i = 0; i < 30_000_000_000l; i++) {
			
		}
		
		s1.stop();
		
		System.out.printf("경과 시간 : %.3f", s1.getElapsedTime());
	}
}
