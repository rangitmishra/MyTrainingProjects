(function Grocery(){
	var ulGroceries, txtGroceries, btnAdd, btnRemove, groceryLiTemplate, groceryLiPlaceholder;


	ulGroceries = document.querySelector('#ulGroceries');
	txtGroceries = document.querySelector('#txtGroceries');
	btnAdd = document.querySelector('#btnAdd');
	btnRemove = document.querySelector('#btnRemove');
	groceryLiPlaceholder = "{grocery}";
	groceryLiTemplate = "<li><label><input type='radio' name='grocery' value='" + groceryLiPlaceholder + "'/>" + groceryLiPlaceholder + "</label> </li>";

	function AddGrocery(){
		var grocery = txtGroceries.value.trim();
		var inValidityMessage = isValidGrocery(grocery);
		if(inValidityMessage == ""){
			AddGroceryLi(grocery);
			SavetoLocalStorage();
		}
		else{
			ShowErrorMessage(inValidityMessage);
		}
		txtGroceries.value="";
		
	}
	
	function ShowErrorMessage(message){
		alert(message);
		
	}

	function AddGroceryLi(grocery){
		var newGroceryLiHTML = groceryLiTemplate.replace(groceryLiPlaceholder, grocery).replace(groceryLiPlaceholder, grocery);
		
		ulGroceries.innerHTML+=newGroceryLiHTML;
		
	}

	function RemoveGrocery(){
		var selector = "#ulGroceries input[type=radio]:checked";
		var selectedRadio = document.querySelector(selector);

		if(selectedRadio){
			selectedRadio.parentNode.parentNode.remove();
			SavetoLocalStorage();
		}
		else{
			ShowErrorMessage("Select something to Remove");
		}
	}

	function SavetoLocalStorage(){
		var groceries = [];
		var selector = "#ulGroceries input[type=radio]";
		var radios = document.querySelectorAll(selector);
		for(var i = 0 ; i<radios.length ;i++){
			groceries.push(radios[i].value);
		}
		window.localStorage.setItem("groceries", JSON.stringify(groceries));

	}
	
	
	function Init(){
		//Event Listeners
		btnAdd.addEventListener("click",AddGrocery);
		btnRemove.addEventListener("click",RemoveGrocery);	
		
		var groceries = JSON.parse(window.localStorage.getItem("groceries"));
		for(var i=0; i<groceries.length;i++){
			AddGroceryLi(groceries[i]);
		}
		
	}


	function isValidGrocery(grocery){
		var retVal="";

		if(grocery==""){
			retVal="Empty Groceries not allowed";
		}
		else{
			var selector = "#ulGroceries input[type=radio][value='" + grocery + "']";
			var potentialRadio = document.querySelector(selector);

			if(potentialRadio){
				retVal = "Duplicates not allowed";
			}

		}
		return retVal;

	}

Init();


})();