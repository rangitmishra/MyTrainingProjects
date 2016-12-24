(function (abc) {
    //declare variables
    var $tblUsers, $trUsers, $popup, $overlay, $hdnUserId, $txtName, $txtEmail, $txtAddress, $txtWebsite;

	$tblUsers = $('#tblUsers');
	$popup = $('#popup');
	$overlay = $('#overlay');
	$hdnUserId = $('#hdnUserId');
	$txtName = $('#txtName');
	$txtEmail = $('#txtEmail');
	$txtAddress = $('#txtAddress');
	$txtWebsite = $('#txtWebsite');
    
    
    function Init(){
		$.ajax({
			url: 'http://jsonplaceholder.typicode.com/users',
			method: 'Get',
			async: true,
			success: DataLoaded
		})
	}
    
    function DataLoaded(users){
		users.forEach(function(user){
			AddTrToTable(user);
		});
	}
    
    function AddTrToTable(user){
		$trUsers = $tblUsers.find('tr:nth-child(2)').clone();
		$trUsers.removeClass('hidden');
		$trUsers.attr('user-id', user.id);

        UpdateTr($trUsers, user);
        
		$trUsers.appendTo($tblUsers);
	}
    
    function UpdateTr($tr, user) {
        $tr.find('td:nth-child(2)').html(user.name);
		$tr.find('td:nth-child(3)').html(user.email);
		$tr.find('td:nth-child(4)').html(user.address.city);
		$tr.find('td:nth-child(5) a').html(user.website).attr('href', user.website);
    }
    function EditUser() {
        TogglePopup(true);
        var $tr = $(this).closest("tr");
        var user = {};
        user.id = parseInt($tr.attr("user-id"), 10);
        user.name = $tr.find("td:nth-child(2)").html();
        user.email = $tr.find("td:nth-child(3)").html() ;
        user.address = {city:$tr.find("td:nth-child(4)").html()};
        user.website = $tr.find("td:nth-child(5) a").html();
        SetPoupInfo(user);
    }
    function DeleteUser() {
        $tblUsers.change(onclick)
        $(this).closest("tr").remove();
    }
    function SaveUser() {
        var user = {}, $tr;

		user.name = $txtName.val();
		user.email = $txtEmail.val();
		user.address = {city: $txtAddress.val()};
		user.website = $txtWebsite.val();
        
        var InvalidMsg = Validate(user);
        if(InvalidMsg) {
            alert(InvalidMsg);
        }
        else {
            user.id = parseInt($hdnUserId.val(), 10);
            if(user.id) {
                $tr = $('tr[user-id=' + user.id + ']');
                UpdateTr($tr, user);
            }
            else {
                user.id = 1 + parseInt($('tr:last').attr('user-id'), 10);
                AddTrToTable(user);
            }
            TogglePopup(false);
        }
        
    }
    function Validate(user) {
        var msg = "";
        if(!user.name) {
            msg = "name is required field";
        }
        else if(!user.email) {
            msg = "email is required field"
        }
        else if(!(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(user.email))) {
            msg = "Invalid Email format";
        }
        return msg;
    }
    function AddUser() {
        TogglePopup(true);
        $hdnUserId.val('');
		$txtName.val('');
		$txtEmail.val('');
		$txtAddress.val('');
		$txtWebsite.val('');
    }
    
    function TogglePopup(flag) {
        if(flag) {
           // $overlay.removeClass("hidden");
            $popup.removeClass("hidden");
        }
        else {
           // $overlay.addClass("hidden");
            $popup.addClass("hidden");
        }
    }
    
    function SetPoupInfo(user){
		$hdnUserId.val(user.id);
		$txtName.val(user.name);
		$txtEmail.val(user.email);
		$txtAddress.val(user.address.city);
		$txtWebsite.val(user.website);
	}
    
    function CancelPopup() {
        TogglePopup(false);
    }
    
    $tblUsers.on("click","#edit",EditUser);
    $tblUsers.on("click","#delete",DeleteUser);
    $("fieldset").on("click", "#add-user", AddUser);
    $popup.on("click","#btnSave",SaveUser);
    $popup.on("click","#btnCancel", function () {
        TogglePopup(false);
    });
    
    Init();
    
    
})(jQuery);