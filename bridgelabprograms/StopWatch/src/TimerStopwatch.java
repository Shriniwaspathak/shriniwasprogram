import java.util.Scanner;

public class TimerStopwatch {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the first number");
		Long start=System.currentTimeMillis();
		int a=sc.nextInt();
		System.out.println("enter the 2nd number");
		Long end=System.currentTimeMillis();
		
		int b=sc.nextInt();
		 long diff= end-start;
		 System.out.println(diff+"milli second");
		 System.out.println((float)(diff/1000)+"second");
		 
		 
		  
	}

}
