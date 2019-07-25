package java_20190725.step5;

public class StopMilliWatch {
	long startTime;
	long endTime;

	public double getElapsedTime() {
		execult();
		return (double) (endTime - startTime) / (double) 1000;
	}

	public void execult() {
		strat();
		for (long i = 0; i < 30_000_000_000l; i++) {

		}
		stop();
	}

	public void strat() {
		startTime = System.currentTimeMillis();
	}

	public void stop() {
		endTime = System.currentTimeMillis();
	}
}
