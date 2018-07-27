import java.io.*;
abstract class Arithmetic{
	int num1,num2;
	
	public Arithmetic(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}
	public void display() {
		System.out.println("num1: "+this.num1);
		System.out.println("num2: "+this.num2);
	}
	abstract public int calculate(); 
}
class addition extends Arithmetic{
	
	public addition(int num1, int num2) {
		super(num1, num2);
	}

	@Override
	public int calculate() {
		return this.num1+this.num2;
	}
	
}
class subtraction extends Arithmetic{
	
	public subtraction(int num1, int num2) {
		super(num1, num2);
	}

	@Override
	public int calculate() {
		return this.num1-this.num2;
	}
	
}
class multiplication extends Arithmetic{
	
	public multiplication(int num1, int num2) {
		super(num1, num2);
	}

	@Override
	public int calculate() {
		return this.num1*this.num2;
	}
	
}
class divide extends Arithmetic{
	
	public divide(int num1, int num2) {
		super(num1, num2);
	}

	@Override
	public int calculate() {
		return this.num1/this.num2;
	}
	
}
public class Calculator {

	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		int result=0;
		char ch;
		try {
			do{
				System.out.println("Calculator Application");
				System.out.println("1.Addition\n2.Subtraction\n3.Multiplication\n4.Division");
				System.out.println("Enter your choice(1-4):");
				int choice=Integer.parseInt(br.readLine());
			
				System.out.println("Enter number1:");
				int num1=Integer.parseInt(br.readLine());
			
				System.out.println("Enter number2:");
				int num2=Integer.parseInt(br.readLine());
			
				Arithmetic a[]= {new addition(num1,num2),new subtraction(num1,num2),new multiplication(num1,num2),new divide(num1,num2)};
				result=a[choice-1].calculate();
				a[choice-1].display();
				System.out.println("Result="+result);
			
				System.out.println("Do you wish to continue with the calculator application?(Y/N):");
				ch=br.readLine().charAt(0);
			}
			while(ch=='y'||ch=='Y');
		}
			catch(ArrayIndexOutOfBoundsException ae) {
				System.out.println("Invalid choice!!!\n Choices only from 1-4 allowed");
			}
			
	
	}

}
