/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var list_product = document.querySelectorAll("each_product");
function Cake(id_Cake, so_luong){
    this.idCake = id_Cake;
    this.SL = so_luong;
}
document.addEventListener('DOMContentLoaded', function(){
    var prices = document.querySelectorAll('.price_text'),
        product_price = document.querySelectorAll('.product_price');
        quantity_product = document.querySelectorAll('.quantity_product');
        product_total = document.querySelectorAll('.total_price_product');
    var total = 0;
    for(let i = 0; i < product_price.length; i++){
        let price = quantity_product[i].value * product_price[i].innerHTML;
        total += price;
        product_total[i].innerHTML = price + " VNĐ";
    }
    var total_order = document.querySelector('.cart_total .price_text');
    total_order.innerHTML = total + " VNĐ";
    for(let i = 0; i < prices.length; i++){
        let price = prices[i].innerHTML;
        prices[i].innerHTML = formatNumber(price);
    }
    
});

function formatNumber(num) {
    return num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,')
}
function giamSL(ele){
    let next = ele.nextElementSibling;
    let number = next.value;
    if(number  > 1)
        number--;
    next.value = number;
}
function tangSL(ele){
    let prev = ele.previousElementSibling;
    let number = prev.value;
    number++;
    prev.value = number;
}

function deleteProduct(ele){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
            ele.innerHTML = '<i class="fas fa-shopping-cart"></i>' + 'HAVE IN CART !';
        };
    }
    xhttp.open("GET", "/addtocart?idCake=" + id_cake, false);
    ele.innerHTML = '<i class="fas fa-shopping-cart"></i>'+'ADDING TO CART...';
    xhttp.send();
}