package java_20190725.step4;

public class StopNanoWatch {
	long startTime;
	long endTime;

	public double getElapsedTime() {
		strat();
		for (long i = 0; i < 30_000_000_000l; i++) {

		}
		stop();
		return (double) (endTime - startTime) / (double) 1000000000;
	}

	public void strat() {
		startTime = System.nanoTime();
	}

	public void stop() {
		endTime = System.nanoTime();
	}
}
