 package com.nagarro.inventorManagement.inputOutput;

import com.nagarro.inventorManagement.data.ImportedItem;
import com.nagarro.inventorManagement.data.Item;
import com.nagarro.inventorManagement.data.ManufacturedItem;
import com.nagarro.inventorManagement.data.RawItem;


public class CreateItem {

	
	
	public Item itemCreate(InputDTO input) {
		
		
		float price=Integer.parseInt(input.getPrice());
		int quantity=Integer.parseInt(input.getQuantity());
		
	
           if(input.getType().equals(ItemType.raw)) {
        	   Item raw = new RawItem(input.getName(),price,quantity,input.getType());
        	        raw.calculateTax();
		            return raw;
		            }
           else if(input.getType().equals(ItemType.manufactured)) {
        	   Item manufactured = new ManufacturedItem(input.getName(),price,quantity,input.getType());
        	   manufactured.calculateTax();
		            return manufactured;
		            }
           else {
        	   Item imported = new ImportedItem(input.getName(),price,quantity,input.getType());
        	        imported.calculateTax();
		            return imported;
		            }
		
	}

}
