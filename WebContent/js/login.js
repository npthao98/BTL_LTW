document.addEventListener('DOMContentLoaded', function(){
	var button = document.querySelector('#submit_form'),
		form = document.querySelector('form'),
		username = document.querySelector('#username'),
		password = document.querySelector('#password');
	
	function validateUsername(){
		/* allow letters, numbers, and underscores
		 * min = 5, max = 15
		 */
	    var illegalChars = /\W/; 
	    
	    if (username.value == ""){
	        return false;
	    }
	    if((username.value.length < 5) || (username.value.length > 15)){
			return false;
	 
	    }
	    if(illegalChars.test(username.value)) {
			return false;
	    }
	    return true;
	}
	
	button.addEventListener('click', function(){
		if(validateUsername() == true)
			form.submit();
	})
	
	
});
