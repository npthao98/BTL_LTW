/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
document.addEventListener('DOMContentLoaded', function(){
    var each_product = document.querySelector('.each_product'),
        price_product = document.querySelectorAll('.price_product');
        products_img = document.querySelectorAll('.product_img');

    function FormatPrice(){
        for(let i = 0; i < price_product.length; i++){
            var price = price_product[i].innerHTML;
            let PRICE = formatNumber(price);
            console.log(PRICE);
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