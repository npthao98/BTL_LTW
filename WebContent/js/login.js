document.addEventListener('DOMContentLoaded', function(){
	var button = document.querySelector('#submit_form'),
            form = document.querySelector('form'),
            username = document.querySelector('#username'),
            password = document.querySelector('#password'),
            err_username = document.getElementById('error_message'),
            err_pass = document.getElementById('password_error_message');
        
        
	function validateUsername(){
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
        
        function validatePass(){
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
	
        username.addEventListener('input', function(){
           err_username.innerHTML = ""; 
        });
        password.addEventListener('input', function(){
           err_pass.innerHTML = "";
        });
        
	button.addEventListener('click', function(){
            let user_val = validateUsername(),
                pass_val = validatePass();
            if(user_val == true && pass_val == true)
                form.submit();
	})
	
	
});
