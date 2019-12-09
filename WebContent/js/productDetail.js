/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

document.addEventListener('DOMContentLoaded', function(){

});
function addToCart(ID, context){
    let input = document.querySelector('#quantity');

    let soluong = input.value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200) {
            window.location.href = context + "/shop";
        };
    }
    xhttp.open("GET", 
        context + "/addtocart?idCake=" + ID + "&soluong=" + soluong,
    false);
    xhttp.send();
}