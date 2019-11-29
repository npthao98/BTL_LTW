function home(){
    document.getElementById("home").style.display = "block";
    document.getElementById("menu1").style.display = "none";
    document.getElementById("menu2").style.display = "none";
    document.getElementById("menu3").style.display = "none";
    document.getElementById("menu4").style.display = "none";

    document.getElementById("arrow-home").style.display = "inline-block";
    document.getElementById("arrow-menu1").style.display = "none";
    document.getElementById("arrow-menu2").style.display = "none";
    document.getElementById("arrow-menu3").style.display = "none";
    document.getElementById("arrow-menu4").style.display = "none";
}
function menu1(){
    document.getElementById("home").style.display = "none";
    document.getElementById("menu1").style.display = "block";
    document.getElementById("menu2").style.display = "none";
    document.getElementById("menu3").style.display = "none";
    document.getElementById("menu4").style.display = "none";

    document.getElementById("arrow-home").style.display = "none";
    document.getElementById("arrow-menu1").style.display = "inline-block";
    document.getElementById("arrow-menu2").style.display = "none";
    document.getElementById("arrow-menu3").style.display = "none";
    document.getElementById("arrow-menu4").style.display = "none";
}
function menu2(){
    document.getElementById("home").style.display = "none";
    document.getElementById("menu1").style.display = "none";
    document.getElementById("menu2").style.display = "block";
    document.getElementById("menu3").style.display = "none";
    document.getElementById("menu4").style.display = "none";

    document.getElementById("arrow-home").style.display = "none";
    document.getElementById("arrow-menu1").style.display = "none";
    document.getElementById("arrow-menu2").style.display = "inline-block";
    document.getElementById("arrow-menu3").style.display = "none";
    document.getElementById("arrow-menu4").style.display = "none";
}
function menu3(){
    document.getElementById("home").style.display = "none";
    document.getElementById("menu1").style.display = "none";
    document.getElementById("menu2").style.display = "none";
    document.getElementById("menu3").style.display = "block";
    document.getElementById("menu4").style.display = "none";

    document.getElementById("arrow-home").style.display = "none";
    document.getElementById("arrow-menu1").style.display = "none";
    document.getElementById("arrow-menu2").style.display = "none";
    document.getElementById("arrow-menu3").style.display = "inline-block";
    document.getElementById("arrow-menu4").style.display = "none";
}
function menu4(){
    document.getElementById("home").style.display = "none";
    document.getElementById("menu1").style.display = "none";
    document.getElementById("menu2").style.display = "none";
    document.getElementById("menu3").style.display = "none";
    document.getElementById("menu4").style.display = "block";

    document.getElementById("arrow-home").style.display = "none";
    document.getElementById("arrow-menu1").style.display = "none";
    document.getElementById("arrow-menu2").style.display = "none";
    document.getElementById("arrow-menu3").style.display = "none";
    document.getElementById("arrow-menu4").style.display = "inline-block";
}

function confirmDelete(s){
    alert("Do you want to cancel order:"+s+" ?");
}