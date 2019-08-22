
public class Designpattern {

	private static final Designpattern instance = new Designpattern();

	// private constructor to avoid client applications to use constructor
	private Designpattern() {
	}
public void show() {
	System.out.println("Hello");
}
	public static Designpattern getInstance() {
		
		return instance;
	}
}
