package com.practice.solution;

import java.util.Scanner;

public class Test {
	
	public static long calculate(int a,int b,int c,int d) {
		long count=0;
		if(b==c) {
			if(a<c) {
				count=((b-a)+1)*((d-c)+1)-1;
			}
			else {
				count=0;
			}
		}
		else {
			if(b<c) {
				if(c>a) {
					count=((b-a)+1)*((d-c)+1);
				}
				else {
					count=0;
				}
			}
			else {
				if(a<c) {
					count=(c-a)*((d-c)+1);
					int temp1=b-c+1;
					int temp2=d-c;
					while(temp1>0) {
						count +=temp2;
						temp2--;
						temp1--;
					}
					
				}
				else {
					int temp1=b-a+1;
					int temp2=d-a;
					while(temp1>0) {
						count +=temp2;
						temp2--;
						temp1--;
					}
					
				}
			}
		}
		return count;
		
	}
	
public static void main(String [] args) {
	Scanner console=  new Scanner(System.in);
	String string=console.nextLine();
	String [] array=string.split(" ");
	int a=Integer.parseInt(array[0]);
	int b=Integer.parseInt(array[1]);
	int c=Integer.parseInt(array[2]);
	int d=Integer.parseInt(array[3]);
	long count=calculate(a,b,c,d);
	System.out.println(count);
	console.close();
	
}

}
