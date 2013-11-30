/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(window).bind("scroll", scrollFunction);

var n = 1;

function scrollFunction(e) {
     
    if(document.documentElement.scrollTop > 142) {
        $("#msg").css("position", "fixed");
        $("#msg").css("z-index", "1000");
        $("#msg").css("top", "0");
        $("#msg").css("width", document.documentElement.clientWidth);
        $("#msg").css("margin-left", "0 px");
        $("#msg").css("margin-right", "0 px");
    }
    
    
    if(document.documentElement.scrollTop <= 142) {
        $("#msg").css("position", "relative");
        $("#msg").css("z-index", "1000");
        $("#msg").css("top", "0");
        $("#msg").css("width", document.documentElement.clientWidth);
        $("#msg").css("margin-left", "0 px");
        $("#msg").css("margin-right", "0 px");
    }
    
}

