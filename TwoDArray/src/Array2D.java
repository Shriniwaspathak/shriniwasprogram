import java.util.Scanner;

public class Array2D {
	public static void main(String args[]) {
		int i, j, row, col;
		int a[][] = new int[10][10];
		Scanner sc = new Scanner(System.in);
		System.out.print("enter row for the array ");
		row = sc.nextInt();
		System.out.print("enter column for the array");
		col = sc.nextInt();
		System.out.print("enter" + row * col + "array");

		for (i = 0; i < row; i++) {
			for (j = 0; j < col; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		System.out.println("this is the array");
		for (i = 0; i < row; i++) {
			for (j = 0; j < col; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();

		}

	}

}
