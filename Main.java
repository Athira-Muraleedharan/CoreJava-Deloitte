import java.util.Scanner;
public class Main{
public static void main(String[] args) throws Exception  {
		Scanner sc= new Scanner(System.in);
 		System.out.println("Enter the value of n:");
		int n= sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
			if(UserMainCode.checkTripplets(arr))
			System.out.println("The array has Tripplets");
		else
			System.out.println("There are no tripplets in the array");
		
	}
}
