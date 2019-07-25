package java_20190725.step6;

public class StopMilliWatch extends StopWatch {

	public double getElapsedTime() {
		return (double) (endTime - startTime) / (double) 1000;
	}

	public void execute() {
		strat();
		for (long i = 0; i < 30_000_000_000l; i++) {

		}
		stop();
		
		double elapsedTime = getElapsedTime();
		System.out.printf("경과 시간 : %.3f\n", elapsedTime);
	}

	public void strat() {
		startTime = System.currentTimeMillis();
	}

	public void stop() {
		endTime = System.currentTimeMillis();
	}
}
