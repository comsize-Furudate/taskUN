function change() {
var check= window.sessionStorage.getItem(['check']);
    var element;
    if(check) {
        element = document.getElementById("button");
        element.disabled = false;
    }else {
        element = document.getElementById("button");
        element.disabled = true;
    }
 
}