
//
//  Change the color of navigation menu button on user click. Collapse the expandable menu buttons
//  if they are not active.
$(function(){
    $('.nav-side-menu li').click(function(){
        $(this).addClass('active').siblings().removeClass('active');
        if($(this)[0].id === "empl_menu"){
            $('#expenses').collapse('hide');
        }else if($(this)[0].id === "exp_menu"){
            $('#employees').collapse('hide');
        }
    });
});


//
// Place holder functions to edit later for the create expense and edit profile functions.
//


// var deleteRecord = function (id){
//     var f = document.forms[0];
//     document.getElementById('expenseID').value=id;
//     f.action ="deleteExpense";
//     f.submit();
// };
// var updateRecord = function (id, amount, type, descriptor, author, resolver, submitted, resolved, status){
//     var f=document.forms[0];
//     document.getElementById('expenseID').value=id;
//     document.getElementById('amount').value=amount;
//     document.getElementById('type').value=type;
//     document.getElementById('descriptor').value=descriptor;
//     document.getElementById('idAuthor').value=author;
//     document.getElementById('resolver').value=resolver;
//     document.getElementById('submitted').value=submitted;
//     document.getElementById('resolved').value=resolved;
//     document.getElementById('status').value=status;
//     f.action ="updateExpense";
//     f.submit();
// };
// var buttons = document.getElementsByClassName("button");
// for(var i = 0; i < buttons.length; i++){
//     if(buttons[i].buttonType = "delete"){
//         buttons[i].addEventListener("click", deleteRecord)
//     } else if(buttons[i].buttonType = "update")
//     {buttons[i].addEventListener("click", updateRecord)
//     }
// };



//
// When user clicks the navigation bar button, return call the servlet with the name that is the same as the button.
// On success, replace the HTML #main content with the html data in the HTTP response
$(function(){
    $('.servletLink').click(function(){
        var link = this.innerText.replace(' ','');
        console.log(link);
        if(link !== "Logout"){
            $.ajax({
                method   : "get",
                url      : "/" + link,
                success  : function(html){$("#main").empty().append(html);},
                error    : function(){},
                complete : function(){}
            });
        };
    });
});