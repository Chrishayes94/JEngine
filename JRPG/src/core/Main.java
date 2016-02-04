package core;

public class Main {
	public static void main(String[] arsg) {
		System.out.println("Application, started");
		new Thread(new Engine()).start();
		Main main = new Main();
	}
}
