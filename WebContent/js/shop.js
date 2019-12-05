/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
document.addEventListener('DOMContentLoaded', function(){
    var each_product = document.querySelector('.each_product'),
      
         products_img = document.querySelectorAll('.product_img');

    function setHeightProduct(){
        let width = each_product.offsetWidth;
        for(let i = 0; i < products_img.length; i++){
            products_img[i].style.height = width + "px";
            console.log(width);
        } 
    }
    
    setHeightProduct();
    
    window.addEventListener("resize", function(){
        setHeightProduct();
    });
});