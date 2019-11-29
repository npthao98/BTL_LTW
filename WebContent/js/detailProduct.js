function reduction(){
    let a= document.getElementById("quantity").value;
    if(a != 0) a= a - 1;
    document.getElementById("quantity").value = a;
}

function increase(){
    let a= document.getElementById("quantity").value;
    a= parseInt(a);
    a= a + 1;
    document.getElementById("quantity").value = a;
}