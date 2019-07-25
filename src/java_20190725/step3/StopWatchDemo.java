package java_20190725.step3;

public class StopWatchDemo {
	public static void main(String[] args) {
		StopNanoWatch s1 = new StopNanoWatch();
		
		s1.strat();
		
		for (long i = 0; i < 30_000_000_000l; i++) {
			
		}
		
		s1.stop();
		
		System.out.printf("경과 시간 : %.9f", s1.getElapsedTime());
	}
}
