package com.nagarro.inventorManagement.utility;


import java.util.Arrays;
import java.util.List;

import com.nagarro.inventorManagement.inputOutput.MyConstant;

public class StringValid {
	
	public boolean validStrings(String string) {
		int count=0;
		boolean isValid=false;
		String[] array=string.split(" ");
		String[] str=array[0].split(":");
		if((array.length< 4)||(!(str[0].equals(MyConstant.NAME)))) {
			isValid=false;
		}
		else {
		
		 List<String> element = Arrays.asList(MyConstant.TYPE, MyConstant.PRICE, MyConstant.QUANTITY, MyConstant.NAME);
			for(int i=0;i<4;i++) {
			
			str=array[i].split(":");
			if((str.length == 2)&&(element.contains(str[0]))){
				count++;
		   }
			else {
				isValid=false;
			}
		}
			
			if(count==4) {
				isValid=true;
			}
		
	}
		return isValid;
	}
	}


