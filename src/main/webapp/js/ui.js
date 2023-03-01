$(function() {
    var UI = {
        init : function(){
            UI.mainMotion();
        },

        mainMotion : function(){
           var $elem = $(".mainVisualBox ul li");
           var $textElem = $(".mainTextBox ul li");
           var currentIdx = 0;
           $elem.eq( currentIdx ).addClass("on");
           $textElem.eq( currentIdx ).addClass("on");
           var motion = function( value ){
               var $prevElem = $elem.eq( currentIdx).removeClass("on").addClass("off")
               $textElem.eq( currentIdx ).removeClass("on").addClass("off");
               currentIdx+= ( value ) ? value : 1;
               if( currentIdx === $elem.length ) {
                   currentIdx = 0;
               }
               if( currentIdx === -1 ){
                   currentIdx = $elem.length-1;
               }

               $elem.eq( currentIdx).removeClass("off").addClass("on");
               $textElem.eq( currentIdx ).removeClass("off").addClass("on");
               next();
           }

           var timer = null;
           var next = function(){
               clearTimeout(timer);
               timer = setTimeout(motion, 7000 );
           }

           next(0);


           $(".navigationArea .next").on("click", function(){
               motion(1);
           });


            $(".navigationArea .prev").on("click", function(){
                motion(-1);
            });


        }
    };

    UI.init();
});

// 스크롤 시 헤더에 그림자 효과
$(function() {
    var header = $("#header");

    $(window).scroll(function(e) {
        if (header.offset().top !== 0) {
            if (!header.hasClass("shadow")) {
                header.addClass("shadow");
            }
        } else {
            header.removeClass("shadow");
        }
    });
});
