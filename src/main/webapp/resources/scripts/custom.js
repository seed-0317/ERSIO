


//
// When user clicks the navigation bar button, return call the servlet with the name that is the same as the button.
// On success, replace the HTML #main content with the html data in the HTTP response
$(function(){

    $('.hamburger').click(function (event) {
            event.stopPropagation();
            $('.overlay').toggle();
        $('.hamburger').toggleClass('is-open is-closed');
            $('#wrapper').toggleClass('toggled');
        });


    var ajaxFunction = function(event){
        event.preventDefault();
        event.stopPropagation();
        var target = $(event.target);
        if(target.parents('nav').length > 0){
            var trigger = $('.hamburger, nav .sidebar-nav li .servletLink, nav .sidebar-nav li a .servletLink');
            $('.overlay').toggle();
            trigger.toggleClass('is-open is-closed');
            $('#wrapper').toggleClass('toggled');
        };
        var ajaxMethod = $(this).data().method,
            ajaxURL = $(this).data().url,
            ajaxData = {};
        $('.form-data').each(function(i, obj) {
            var ajaxDataKey = obj.name,
             ajaxDataValue = obj.value;
            ajaxData[ ajaxDataKey ] = ajaxDataValue;
        });

        $.ajax({
            method   : ajaxMethod,
            url      : "/" + ajaxURL,
            data     : ajaxData,
            success  : function(html){
                debugger;
                $("#main").empty().append(html);
                $('.tablescroll').DataTable( {
                    scrollY:        '49vh',
                    scrollCollapse: true,
                    paging:         false
                });
                $('.' + ajaxURL).remove();
            },
            statusCode: {
                200: function(html){
                    debugger;
                    $("#main").empty().append(html);
                    $('.tablescroll').DataTable( {
                        scrollY:        '49vh',
                        scrollCollapse: true,
                        paging:         false
                    });
                    $('.' + ajaxURL).remove();
                }
            },
            error    : function(){console.log("error");},
            complete    : function(){debugger;}

        });

    };
    $('.servletLink').click(ajaxFunction);
});


//
// $(document).ready(function () {
//     var trigger = $('.hamburger, nav .sidebar-nav li .servletLink, nav .sidebar-nav li a .servletLink');
//
//     trigger.click(function (event) {
//         event.stopPropagation();
//         debugger;
//         $('.overlay').toggle();
//         trigger.toggleClass('is-open is-closed');
//         $('#wrapper').toggleClass('toggled');
//     });
// });
//
