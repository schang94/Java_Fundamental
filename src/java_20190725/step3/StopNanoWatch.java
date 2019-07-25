package java_20190725.step3;

public class StopNanoWatch {
	long startTime;
	long endTime;
	
	public double getElapsedTime() {
		return (double)(endTime - startTime)/(double)1000000000;
	}
	
	public void strat() {
		startTime = System.nanoTime();
	}
	public void stop() {
		endTime = System.nanoTime();
	}
}
