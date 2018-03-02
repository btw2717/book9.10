public class QuadraticEquation {
	private static double a;
	private static double b;
	private static double c;

	QuadraticEquation(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public static double getCoefficientA() {
		return a;
	}
	public static double getCoefficientB() {
		return b;
	}
	public static double getCoefficientC() {
		return c;
	}

	public static double getDiscriminant() {
		return ((Math.pow(b, 2)) - (4 * a * c));
	}

	public static double getRoot1() {
		if(getDiscriminant() < 0) {
			return 0;
		} else {
			return (((-b) + Math.sqrt(getDiscriminant())) / (2 * a));
		}
	}
	public static double getRoot2() {
		if(getDiscriminant() < 0) {
			return 0;
		} else {
			return (((-b) - Math.sqrt(getDiscriminant())) / (2 * a));
		}
	}
}
