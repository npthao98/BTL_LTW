/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var isButtonClick = 0;

document.addEventListener('DOMContentLoaded', function(){
    var each_product = document.querySelector('.each_product'),
        price_product = document.querySelectorAll('.price_product');
        products_img = document.querySelectorAll('.product_img');

    function FormatPrice(){
        for(let i = 0; i < price_product.length; i++){
            var price = price_product[i].innerHTML;
            let PRICE = formatNumber(price);
            price_product[i].innerHTML = formatNumber(price) + " VNĐ";
        }
    }
    
    FormatPrice();
    function updateRender(){
        let width = each_product.offsetWidth;
        for(let i = 0; i < products_img.length; i++){
            products_img[i].style.height = width + "px";
        } 
        
    }
    function formatNumber(num) {
        return num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,')
    }

    updateRender();
    
    window.addEventListener("resize", function(){
        updateRender();
    });
});

function addCart(ele, id_cake, context_path){
    isButtonClick = 1;
    console.log(id_cake);
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

function show(link){
    if(isButtonClick == 0)
        window.location.href = link;
    else
        isButtonClick = 0;
}
function redirectSort(link){
    var next = link.value;
    if(next != null){
        window.location.href = next;
    }
}