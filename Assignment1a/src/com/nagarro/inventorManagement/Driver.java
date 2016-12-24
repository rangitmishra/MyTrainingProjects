package com.nagarro.inventorManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.nagarro.inventorManagement.data.Item;

import com.nagarro.inventorManagement.inputOutput.CreateBill;
import com.nagarro.inventorManagement.inputOutput.CreateItem;
import com.nagarro.inventorManagement.inputOutput.InputDTO;

import com.nagarro.inventorManagement.inputOutput.TakeInput;

import com.nagarro.inventorManagement.utility.StringValid;

import com.nagarro.inventorManagement.utility.Validator;

public class Driver {
	
	private Driver() {}

	public static void main(String[] args) {
		List<Item> itemlist = new ArrayList<>();
		String choice = "y";
		String msg = "There is some error";
		Scanner scanner = new Scanner(System.in);
		try {
			do {
				InputDTO store = new InputDTO();
				TakeInput input = new TakeInput();
				StringValid validString = new StringValid();
				String string=input.takeInput(scanner);
				if (validString.validStrings(string)) {
					store.storeInput(string);
				} else {
					System.out.println(msg);
					continue;
				}

				Validator validate = new Validator();
				if (validate.validateInput(store)) {
					CreateItem create = new CreateItem();
					Item item = create.itemCreate(store);
					itemlist.add(item);
				} else {
					System.out.println(msg);
				}

				System.out.println("Do u want to enter more items (y\\n)");
				choice = scanner.nextLine();

			} while (choice.equalsIgnoreCase("y"));
		} catch (Exception e) {
			System.out.println(msg);
		} finally {
			scanner.close();

		}
		CreateBill bill = new CreateBill();
		System.out.println("Iname   Iprice  Iquantity    Itype     Ttax     Tcost");
		for (Item itm : itemlist) {
			bill.show(itm);
		}
	}

}
