 $(function () {
  
    function Carousel() {
        
        var carousel = $('.carousel ul');
        var carouselList = $('#Carousel_List');
        var items = $("#PanelsOnScreen").val();
        
        
        var carouselChild = carousel.find('li');
        var counter = $("#TotalPanels").val() - items;
        
        var clickCount = 0;
        
        var itemWidth= 400/items;

        carousel.width(400);
        carouselChild.css('width', itemWidth);
        //Place the child elements to their original locations.
        refreshChildPosition();
        clickCount = 0;
        //Set the event handlers for buttons.
        $('.btnLeft').unbind().click(function () {
            if (clickCount < counter) {
              
                clickCount++;
               // console.log(clickCount);
                //Animate the slider to left as item width 
                carousel.animate({
                    left: '-=' + itemWidth
                }, 300);
            }
        });

        $('.btnRight').unbind().click(function () {
            if (clickCount != 0) {
               
                clickCount--;
             

                carousel.animate({
                    left: '+=' + itemWidth
                }, 300);
            }
        });

        function refreshChildPosition() {
            carouselChild.each(function () {
                $(this).css('left', itemWidth * carouselChild.index($(this)));
                clickCount = 0;
            });
        }

    }
    $(document).ready(function () {
        $("#OK").click(function () {
            $('#Carousel_List').empty();
            for (i = 1; i <= $("#TotalPanels").val() ; i++) {
                $('#Carousel_List').append('<li>' + i + '</li>');
            }
            $('.carousel').find('#Carousel_List').css('left',0);
            Carousel();
        });
    });
});