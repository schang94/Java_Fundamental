package java_20190725.step5;

public class StopNanoWatch {
	long startTime;
	long endTime;

	public double getElapsedTime() {
		execult();
		return (double) (endTime - startTime) / (double) 1000000000;
	}

	public void execult() {
		strat();
		for (long i = 0; i < 30_000_000_000l; i++) {

		}
		stop();
	}

	public void strat() {
		startTime = System.nanoTime();
	}

	public void stop() {
		endTime = System.nanoTime();
	}
}
