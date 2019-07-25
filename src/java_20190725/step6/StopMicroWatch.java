package java_20190725.step6;

public class StopMicroWatch extends StopWatch {

	public double getElapsedTime() {
		return (double) (endTime - startTime) / (double) 1000000000;
	}

	public void execute() {
		strat();
		for (long i = 0; i < 30_000_000_000l; i++) {

		}
		stop();
		
		double elapsedTime = getElapsedTime();
		System.out.printf("경과 시간 : %.6f\n", elapsedTime);
	}

	public void strat() {
		startTime = System.nanoTime();
	}

	public void stop() {
		endTime = System.nanoTime();
	}
}
