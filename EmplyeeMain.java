import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class EmplyeeVO{
	private int empid;
	private String empname;
	private double annualincome;
	private double incometax;
	//setters and getters
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public double getAnnualincome() {
		return annualincome;
	}
	public void setAnnualincome(double annualincome) {
		this.annualincome = annualincome;
	}
	public double getIncometax() {
		return incometax;
	}
	public void setIncometax(double incometax) {
		this.incometax = incometax;
	}
	
	//overriding toString() which returns all the employee details
	@Override
	public String toString() {
		return this.empid+" "+this.empname+" "+this.annualincome+" "+this.incometax;
	}
	
	
	// overriding hashCode() to return the hashcode of the data
	@Override
	public int hashCode() {
		return this.empid*10;
	}
	
	
	//Override equals() to compare the object
	@Override
	public boolean equals(Object obj) {
		EmplyeeVO ee=(EmplyeeVO)obj;
		if (this.empid==ee.empid && this.empname.equals(ee.empname) && this.annualincome==ee.annualincome && this.incometax==ee.incometax)
			return true; // same objects
		else
			return false; // different objects
	}
	
	//parameterized constructor
	public EmplyeeVO(int empid, String empname, double annualincome) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.annualincome = annualincome;
		
	}
	
	
}


class EmplyeeBO{
	public void calincomeTax(EmplyeeVO evo) {
		double incometax=evo.getAnnualincome()*0.3;
		evo.setIncometax(incometax);
	}
}

class EmplyeeSort implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		//Type Cast
		EmplyeeVO evo1=(EmplyeeVO)o1;
		EmplyeeVO evo2=(EmplyeeVO)o2;
		
		int retValue=0;
		
		if(evo2.getIncometax()>evo1.getIncometax())
			retValue=1;
		else if(evo2.getIncometax()<evo1.getIncometax())
			retValue=-1;
		else
			retValue=0;
		return retValue;
	}
	
}
public class EmplyeeMain {

	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		int i;
		System.out.println("Enter the no.of employees:");
		int n=Integer.parseInt(br.readLine());
		
		EmplyeeVO evo[]=new EmplyeeVO[n];
		ArrayList al=new ArrayList(n);
		
		EmplyeeBO eb=new EmplyeeBO();
		
		int empid;
		String empname;
		double annualincome;
		//to read empid ,empname,annual income and to call the calincomeTax()
		
		for(i=0;i<evo.length;i++) {
			System.out.println("Enter the Employee id:");
			empid=Integer.parseInt(br.readLine());
			System.out.println("Enter the Employee name:");
			empname=br.readLine();			
			System.out.println("Enter the Annual Income:");
			annualincome=Double.parseDouble(br.readLine());
			evo[i]=new EmplyeeVO(empid, empname, annualincome);
			eb.calincomeTax(evo[i]);
			al.add(evo[i]);
			
			
		}
		
		// to display the data
		System.out.println("Employees before sorting");
		System.out.println(al);
		
		// to sort the employee based on income tax
		EmplyeeSort es=new EmplyeeSort();
		Collections.sort(al, es);
		
		// to display the sorted employees
		System.out.println("Employees after sorting");
		System.out.println(al);
		

	}

}
