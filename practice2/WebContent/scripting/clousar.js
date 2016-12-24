function LeftFunction() {
	var m= parseInt($('#innertwo').css('margin-left'));
	m-=200;
	m=m+'px';
	$('#innertwo').css('margin-left',m);
//    $(this).off('click'); 
}
function RightFunction() {
	var m= parseInt($('#innertwo').css('margin-left'));
	m-=200;
	m=m+'px';
    document.getElementById("innertwo").style.margnLeft = "+200px";
    $(this).off('click'); 
}