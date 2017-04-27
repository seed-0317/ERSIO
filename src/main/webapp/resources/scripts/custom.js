
//
//  Change the color of navigation menu button on user click. Collapse the expandable menu buttons
//  if they are not active.
// $(function(){
//     $('.nav-side-menu li').click(function(){
//         $(this).addClass('active').siblings().removeClass('active');
//         // if($(this)[0].id === "empl_menu"){
//         //     $('#exp_menu').collapse('hide');
//         // }else if($(this)[0].id === "exp_menu"){
//         //     $('#empl_menu').collapse('hide');
//         // }
//     });
// });





//
// When user clicks the navigation bar button, return call the servlet with the name that is the same as the button.
// On success, replace the HTML #main content with the html data in the HTTP response
$(function(){

    var x = function(event){
        event.preventDefault();

        if (this.parentElement.id==="formPost"){
            var link=this.value.replace(' ', ''),
                method = "post";
        } else {
            var link= this.innerText.replace(' ',''),
                method = "get";
        }
        if(link !== "Logout"){
            $.ajax({
                method   : method,
                url      : "/" + link,
                success  : function(html){
                    $("#main").empty().append(html);
                    $('.servletLink').click(x);
                    $('.tablescroll').DataTable( {
                        scrollY:        '45vh',
                        scrollCollapse: true,
                        paging:         false
                        // "pagingType": "first_last_numbers"
                    } );
                    $('.'+link).remove();
                },
                error    : function(){},
                complete : function(){}
            });
        };
    };

    $('.servletLink').click(x);
});


// $(document).ready(function () {
//     var trigger = $('.hamburger'),
//         overlay = $('.overlay'),
//         isClosed = false;
//
//     trigger.click(function () {
//         hamburger_cross();
//     });
//
//     function hamburger_cross() {
//
//         if (isClosed == true) {
//             overlay.hide();
//             trigger.removeClass('is-open');
//             trigger.addClass('is-closed');
//             isClosed = false;
//         } else {
//             overlay.show();
//             trigger.removeClass('is-closed');
//             trigger.addClass('is-open');
//             isClosed = true;
//         }
//     }
//
//     $('[data-toggle="offcanvas"]').click(function () {
//         $('#wrapper').toggleClass('toggled');
//     });
// });
//
$(document).ready(function () {
    var trigger = $('.hamburger, nav .sidebar-nav li .servletLink, nav .sidebar-nav li a .servletLink');

    trigger.click(function () {
        $('.overlay').toggle();
        trigger.toggleClass('is-open is-closed');
        $('#wrapper').toggleClass('toggled');
    });

});

