package java_20190725.step1;

// 1. 요구사하은 밀리 세컨드로 경과 시간을 만들어주세요.
public class FootStopWatch {
	long startTime;
	long endTime;
	
	long startNanoTime;
	long endNanoTime;
	
	public double getElapsedTime() {
		return (double)(endTime - startTime)/(double)1000000000;
	}
	public double getElapsedNanoTime() {
		return (double)(endNanoTime - startNanoTime)/(double)1000000000;
	}
	
	public static void main(String[] args) {	
		FootStopWatch f1 = new FootStopWatch();
		f1.startTime = System.currentTimeMillis(); // 1970 1 1 부터 지금까지의 시간을 밀리세컨드로 반환한다.
		for (long i = 0; i < 30_000_000_000l; i++) {
			
		}
		f1.endTime = System.currentTimeMillis();
		
		System.out.printf("경과 시간 : %.3f", f1.getElapsedTime());
	}
}
