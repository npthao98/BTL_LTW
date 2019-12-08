/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var list_product = document.querySelectorAll("each_product");
var ID_CAKE = [], NUMBER = [];

function renderPrice(){
    var total = 0;

    var prices = document.querySelectorAll('.price_format'),
        product_price = document.querySelectorAll('.product_price');
        quantity_product = document.querySelectorAll('.quantity_product');
        product_total = document.querySelectorAll('.total_price_product');
    for(let i = 0; i < product_price.length; i++){
        let each_price = product_price[i].innerHTML;
        let price_int = each_price.replace(",","");
        let price = quantity_product[i].value * price_int;
        total += price;
        product_total[i].innerHTML = price;
    }
    
    var total_order = document.querySelector('.cart_total .price_format');
    if(total == null || total == 0)
        total = "0";
    total_order.innerHTML = total;
    
    for(let i = 0; i < prices.length; i++){
        let price = prices[i].innerHTML;
        prices[i].innerHTML = formatNumber(price);
    }
}


function formatNumber(num) {
    return num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,')
}
function giamSL(ele, idCake){
    let next = ele.nextElementSibling;
    let number = next.value;
    if(number  > 1)
        number--;
    next.value = number;
    for(let i = 0; i < ID_CAKE.length; i++){
        if(ID_CAKE[i] == idCake){
            NUMBER[i] = number;
            return;
        }
    }
    ID_CAKE.push(idCake);
    NUMBER.push(number);
   
}
function tangSL(ele, idCake){
    let check = 0;
    let prev = ele.previousElementSibling;
    let number = prev.value;
    number++;
    prev.value = number;
    for(let i = 0; i < ID_CAKE.length; i++){
        if(ID_CAKE[i] == idCake){
            NUMBER[i] = number;
            return;
        }
    }
    ID_CAKE.push(idCake);
    NUMBER.push(number);
}

function deleteProduct(ID, context){
    var ele = document.querySelector("#product_" + ID),
        xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200) {
            ele.innerHTML = "";
            renderPrice();
        };
    }
    xhttp.open("GET", context + "/delete_from_cart?idCake=" + ID, true);
    xhttp.send();
}

document.addEventListener('DOMContentLoaded', function(){
    renderPrice();
   
    var button_update = document.querySelector("#update_cart");
   button_update.addEventListener('click', function(){
       for(let i = 0; i < ID_CAKE.length; i++){
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function(){
                if (this.readyState == 4 && this.status == 200) {
                    
                };
            }
            xhttp.open("GET", "/update_to_cart?idCake=" + ID_CAKE[i] + "&number=" + NUMBER[i], true);
            xhttp.send();
       }
       renderPrice();
   });
});