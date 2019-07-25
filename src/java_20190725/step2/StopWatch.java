package java_20190725.step2;

public class StopWatch {
	long startTime;
	long endTime;
	
	public double getElapsedTime() {
		return (double)(endTime - startTime)/(double)1000;
	}
	
	public void strat() {
		startTime = System.currentTimeMillis();
	}
	public void stop() {
		endTime = System.currentTimeMillis();
	}

	long startNanoTime;
	long endNanoTime;
	
	public double getElapsedNanoTime() {
		return (double)(endNanoTime - startNanoTime)/(double)1000000000;
	}
	
	public void stratNano() {
		startNanoTime = System.nanoTime();
	}
	public void stopNano() {
		endNanoTime = System.nanoTime();
	}
}
