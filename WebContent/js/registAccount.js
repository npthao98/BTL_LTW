/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
const button_submit = document.querySelector('#form_regist button'),
    form = document.querySelector('#form_regist'),
    err_username = document.querySelector('.error_username'),
    err_pass = document.querySelector('.error_password'),
    err_confirmpass = document.querySelector('.error_confirmpassword'),
    err_name = document.querySelector('.error_name'),
    err_addr = document.querySelector('.error_addr'),
    err_tele = document.querySelector('.error_tele'),
    err_email = document.querySelector('.error_email'),
    err_button = document.querySelector('#err_button_click');
    arr_check = [false, false, false, false, false, false, false];
    

function checkInfor(input, tag){
    switch (input) {
        case "username" :{
            let check = validateUsername(tag);
            if(check == true){
                err_username.innerHTML = "";
                arr_check[0] = true;
            }else{
                arr_check[0] = false;
            }
            break;
        }
        case "pass" :{
            let check = validatePass(tag);
            if(check == true){
                arr_check[1] = true;
                err_pass.innerHTML = "";
                let tag_confirm = document.querySelector('#confirm_password');
                if(tag.value != tag_confirm.value){
                    err_confirmpass.innerHTML = "Password does not match !!!";
                    arr_check[2] = false;
                }
            }else{
                arr_check[1] = false;
            }
            break;
        }
        case "confirm_pass" :{
            let pass = document.querySelector('#password');
            if(pass.value != tag.value){
                err_confirmpass.innerHTML = "Password does not match !!!";
                arr_check[2] = false;
            }else{
                err_confirmpass.innerHTML = "";
                arr_check[2] = true;
            }
            break;
        }
        case "fullname" :{
            let check = validateInfor(tag);
            if(check == false){
                err_name.innerHTML = "This would be atleast 10 characters !!!"
                arr_check[3] = false;
            }else{
                err_name.innerHTML = "";
                arr_check[3] = true;
            }
            break;
        }    
        case "address" :{
            let check = validateInfor(tag);
            if(check == false){
                err_addr.innerHTML = "This would be atleast 10 characters !!!";
                arr_check[4] = false;
            }else{
                arr_check[4] = true;
                err_addr.innerHTML = "";
            }
            break;
        }         
        case "phone" :{
            let check = validateTelephone(tag);
            if(check == false){
                err_tele.innerHTML = "Telephone is wrong !!!";
                arr_check[5] = false;
            }
            else{
                err_tele.innerHTML = "";
                arr_check[5] = true;
            }
            break;
        }
        case "email" :{
            if(!validateEmail(tag.value)){
                err_email.innerHTML = "Email wrong !!!";
                arr_check[6] = false;
            }else{
                arr_check[6] = true;
                err_email.innerHTML = "";
            }
            break;
        }
    }
}

function clearErr(input){
    switch (input) {
        case "username" :{
            err_username.innerHTML = "";
            break;
        }
        case "pass" :{
            err_pass.innerHTML = "";
            break;
        }
        case "confirm_pass" :{
            err_confirmpass.innerHTML = "";
            break;
        }
        case "fullname" :{
            err_name.innerHTML = "";
            break;
        }    
        case "address" :{
            err_addr.innerHTML = "";
            break;
        }         
        case "phone" :{
            err_tele.innerHTML = "";
            break;
        }
        case "email" :{
            err_email.innerHTML = "";
            break;
        }
    }
}

function validateUsername(username){
        /* allow letters, numbers, and underscores
         * min = 5, max = 15
         */
    var illegalChars = /\W/; 

    if (username.value == ""){
        err_username.innerHTML = "Username is a required filed !!!"
        return false;
    }
    if((username.value.length < 5) || (username.value.length > 15)){                
        err_username.innerHTML = "Username should be between 5 and 15 characters long !!!"                
        return false;

    }
    if(illegalChars.test(username.value)) {
        err_username.innerHTML = "Username just allow letters( a - z, A - Z ), numbers( 0 - 9 ), and underscores( _ ) !!!" 
        return false;
    }
    return true;
}

function validatePass(password){
        /* allow letters, numbers, and underscores
         * min = 5, max = 15
         */
    var illegalChars = /\W/; 

    if (password.value == ""){
        err_pass.innerHTML = "Password is a required filed !!!"
        return false;
    }
    if((password.value.length < 5) || (username.value.length > 15)){                
        err_pass.innerHTML = "Password should be between 5 and 15 characters long !!!"                
        return false;

    }
    if(illegalChars.test(password.value)) {
        err_pass.innerHTML = "Password just allow letters( a - z, A - Z ), numbers( 0 - 9 ), and underscores( _ ) !!!" 
        return false;
    }
    return true;
}

function validateEmail(email) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}

function validateInfor(infor){
    if(infor.value.length < 10){
        return false;
    }
    return true;
}

function validateTelephone(tele){
    var vnf_regex = /((09|03|07|08|05)+([0-9]{8})\b)/g;
    if(vnf_regex.test(tele.value)){
        return true;
    }else{
        return false;
    }
}

document.addEventListener('DOMContentLoaded', function() {
    button_submit.addEventListener('click', function(){
        for(let i = 0; i < 7; i++){
            if(arr_check[i] == false){
                err_button.innerHTML = "Please check all information in form !!!";
                return;
            }
        }
        form.submit();
    })
});


