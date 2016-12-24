
$(document).ready(function(){
    var $txtbox;
    $txtbox = $("#txtbox");
    function KeyDown(e){
        console.log(e);
        if(e.keyCode <48 || e.keyCode >57)
	{
            e.preventDefault();
        }
        else
	{
        }
	return this;
    }
    $txtbox.keydown(KeyDown);
});
