package com.nagarro.learning;

public class TestProgram {
public static void main(String[] args) {
	System.out.println("Enter an array");
	int [] array={5,-3,0,-2,-5,2};
	int sum=0;
	int temp=0;
	int r=0;
	for(int i : array){
		System.out.print(i + " ");
	}
	System.out.println();
for(int i=0;i<array.length;i++){
	sum=array[i];
	if(array[i]>0) {
		for(int j=i+1;j<array.length;j++) {
			if(array[j]<0) {
				temp +=array[j];
	
				if((temp + array[i])==0) {
					System.out.print(array[i] + " ");
				   for(int k=r+1;k<=j;k++) {
					   System.out.print(array[k] + " ");
				   }
				   System.out.println();
				   temp=0;
				   r=j;
				}
			}
		}
	}
	else if(array[i]<0) {
		for(int j=i+1;j<array.length;j++) {
			if(array[j]>0) {
				temp +=array[j];
				if((temp + array[i])==0) {
					System.out.print(array[i] + " ");
				   for(int k=r+1;k<j;k++) {
					   System.out.print(array[k] + " ");
				   }
				   System.out.println();
				   temp=0;
				    r=j+1;
				}
			}
		}
	}
	else {
		System.out.print(array[i] + " ");
		System.out.println();
	}

}
}

}