function set_context(Context, event){
    input_search = document.querySelector('#search_cake_query');
    if (event.keyCode === 13) {
          var value = input_search.value;
          window.location.href = Context + "/shop?cakename="+value;
      }
}
document.addEventListener('DOMContentLoaded', function() {
    const button_open = document.querySelector('.header--navbar_open_icon');
    const button_close = document.querySelector('.header--navbar_close_icon');
    const navbar = document.querySelector('.header--navbar');
    var search_cake = document.querySelector('.search_cake');
    button_open.addEventListener('click', function(){
        navbar.classList.toggle('nav-active');
    });
    button_close.addEventListener('click', function(){
        navbar.classList.toggle('nav-active');
    });
    
    var search_icon_button = document.querySelector('#search_icon_button');
    search_icon_button.addEventListener('click', function(){
        search_cake.classList.toggle('undisplay');
    });
});
