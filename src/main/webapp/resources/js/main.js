$( document ).ready(function() {

   var globalscope;

   var contr = new Main();
    contr.showHeader();


    var Ingredients = {
        DepAll: function(){return new DepAll(event)},
        DelDep:function(){return new DelDep(event)}

    };



    $('body').on("click",".listen", function(event){
        var value =  $(this).attr('value');
        Ingredients[value](event);
    });


});