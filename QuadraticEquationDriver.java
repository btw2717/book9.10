import java.util.Scanner;

public class QuadraticEquationDriver {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		double[] answers = new double[3];
		
		System.out.println("Enter coefficient values for a, b, and c");
		answers[0] = keyboard.nextInt();
		answers[1] = keyboard.nextInt();
		answers[2] = keyboard.nextInt();

		QuadraticEquation test = new QuadraticEquation(answers[0], answers[1], answers[2]);

		if(test.getDiscriminant() == 0) {
			System.out.println("There is only one root, it is: " + test.getRoot1());
		}else if(test.getDiscriminant() > 0) {
			System.out.println("The two roots are:\n" + test.getRoot1() + " and " + test.getRoot2());
		} else {
			System.out.println("There are no roots");
			System.out.println("the roots are: " + test.getRoot1() + " " + test.getRoot2());
		}
		keyboard.close();

	}
}
