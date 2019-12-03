var container_ads_display = 1,
    feedback_current = 1;

document.addEventListener('DOMContentLoaded', function(){

    let element_ads = document.querySelector('container #container--banner_content_1');
    // offsetWidth 

    // TODO : aniation ads slide 
    const next_button = document.querySelector('container .container--banner_button_next > button'),
        prev_button = document.querySelector('container .container--banner_button_prev > button'),
        banner = document.querySelector('container .container--banner_ads'),

        container_feedback = document.querySelector('container .container--banner_feedback'),
        container_feedback_ele = document.querySelector('container .container--banner_feedback_ele');
 
    
    function StartedRender(){
        /* navbar ads*/
        let height = element_ads.offsetHeight,
            top = height + 21,
            width = container_feedback_ele.offsetWidth;

        banner.style.height = top + "px";

        /* feedback*/
        height = container_feedback_ele.offsetHeight;
        container_feedback.style.height = height + "px";

    }   

    StartedRender();

    function checkPosition1(){
        let ele = document.querySelector('container #baked_with_love');
        var positionFromTop = ele.getBoundingClientRect().top;
        let windowHeight = window.innerHeight;
        if (positionFromTop - windowHeight <= -300) {
            ele.classList.remove('hidden_scale');
            ele.classList.add('zoom');
        }
    }


    function checkPosition2(){
        let ele = document.querySelector('.container--our_process_content');
        var positionFromTop = ele.getBoundingClientRect().top;
        let windowHeight = window.innerHeight;
        if (positionFromTop - windowHeight <= -300) {
            let item = document.querySelectorAll('.container--our_process_eachitem');
//            .classList.add('.our_process_item_appear');
            
            item[0].classList.add('our_process_item_appear');
            setTimeout(function(){
                item[1].classList.add('our_process_item_appear');
                setTimeout(function(){
                    item[2].classList.add('our_process_item_appear');
                    setTimeout(function(){
                        item[3].classList.add('our_process_item_appear');
                    }, 350);
                }, 350);
            }, 350);
     
        }
    }

    window.addEventListener("scroll", function(){
        checkPosition1();
        checkPosition2();
    });
    window.addEventListener("resize", function(){
        StartedRender();
    });
   

    function hidden_ads(current){
        current.classList.remove('animation_apper');
        current.classList.add('animation_remov');
    }

    function show_ads(next){
        setTimeout(function(){
            next.classList.remove('animation_remov');
            next.classList.remove('hidden');
            next.classList.add('animation_apper');
        }, 199);
    }

    function autoSlideAds(){
        setInterval(() => {
            nextSlide(); }, 3500);
    }
    // autoSlideAds();

    function nextSlide(){
        let current = document.querySelector('container #container--banner_content_' + container_ads_display);
        if(container_ads_display >= 4)
            container_ads_display = 0;
        container_ads_display++;
        let next = document.querySelector('container #container--banner_content_' + container_ads_display);
        hidden_ads(current);
        show_ads(next);
    }
    function prevSlide(){
        let current = document.querySelector('container #container--banner_content_' + container_ads_display);
        if(container_ads_display <= 1)
            container_ads_display = 5;
        container_ads_display--;

        let next = document.querySelector('container #container--banner_content_' + container_ads_display);
        hidden_ads(current);
        show_ads(next);
    }

    next_button.addEventListener('click', function(){
        next_button.disabled = true;
        nextSlide();
        setTimeout(function(){
            next_button.disabled = false;
        }, 200);

    }, false);

    prev_button.addEventListener('click', function(){
        prev_button.disabled = true;
        prevSlide();
        setTimeout(function(){
            prev_button.disabled = false;
        }, 200);
    }, false);

    // TODO : animation feedback

    

});

function selectedFeedback(index){
    let button_selected = document.querySelector('container #select_feedback_' + index),
        button_old = document.querySelector('container #select_feedback_' + feedback_current);

    button_old.style.background = "#d1d1d1";
    button_selected.style.background = "black";

    let ele_current = document.querySelector('container #feedback_' + feedback_current),
        feedback_next = document.querySelector('container #feedback_' + index);

    ele_current.classList.remove('animation_apper_feedback');
    ele_current.classList.add('animation_remov_feedback');

    setTimeout(function(){
        feedback_next.classList.remove('animation_remov_feedback');
        feedback_next.classList.remove('hidden');
        feedback_next.classList.add('animation_apper_feedback');
    }, 199);
    
    feedback_current = index;
}



