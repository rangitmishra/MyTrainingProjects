package com.nagarro.inventorManagement.inputOutput;



public class InputDTO {
	private String name;
	private String type;
	private String quantity;
	private String price;
	
	public void storeInput(String str) {
		String [] array=str.split(" ");
		for(int i=0;i<4;i++) {
			
			String[] string=array[i].split(":");
			if(string[0].equals(MyConstant.NAME)) {
				name=string[1];
			}
			else if(string[0].equals(MyConstant.TYPE)) {
				type=string[1];
			}
			else if(string[0].equals(MyConstant.QUANTITY)) {
				quantity=string[1];
			}
			else {
				price=string[1];
			}
			
		}
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getQuantity() {
		return quantity;
	}

	public String getPrice() {
		return price;
	}

}
