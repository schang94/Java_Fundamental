package java_20190725.step6;

public class StopWatchDemo {
	public static void run(StopWatch s) {
		s.execute();
	}
	public static void main(String[] args) {

		run(new StopMilliWatch());
		run(new StopMicroWatch());
		run(new StopNanoWatch());
	}
}
