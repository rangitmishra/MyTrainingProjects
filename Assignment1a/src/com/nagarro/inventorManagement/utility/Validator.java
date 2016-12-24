package com.nagarro.inventorManagement.utility;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import com.nagarro.inventorManagement.inputOutput.InputDTO;

public class Validator {
	boolean isValid=false;
	
public boolean validateInput(InputDTO input) {
	
	List<String> element = Arrays.asList("raw", "manufactured", "imported");
	if((Pattern.matches("[a-z]{1,}",input.getName()))&&(Pattern.matches("[0-9]{1,}",input.getPrice()))&&(Pattern.matches("[0-9]{1,}",input.getQuantity()))&&(element.contains(input.getType()))) {
		isValid=true;
		
	}
	else {
		isValid=false;
	}

	return isValid;
	
}
    
}
