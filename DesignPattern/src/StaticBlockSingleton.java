
public class StaticBlockSingleton {
	private static StaticBlockSingleton instance;

	private StaticBlockSingleton() {
	}

	static {
		try {
			instance = new StaticBlockSingleton();
		} catch (Exception e) {

		}
	}

	public static StaticBlockSingleton getInstance() {
		return instance;
	}

	public void hello() {
		System.out.println("something");

	}
}
