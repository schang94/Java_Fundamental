package java_20190725.step4;

public class StopMilliWatch {
	long startTime;
	long endTime;

	public double getElapsedTime() {
		strat();
		for (long i = 0; i < 30_000_000_000l; i++) {

		}
		stop();
		return (double) (endTime - startTime) / (double) 1000;
	}

	public void strat() {
		startTime = System.currentTimeMillis();
	}

	public void stop() {
		endTime = System.currentTimeMillis();
	}
}
