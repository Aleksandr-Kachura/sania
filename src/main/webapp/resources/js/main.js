$( document ).ready(function() {
  // var contr = new Department();
   var contr = new Department();
    contr.showOther();


    var Ingredients = {
        1: function(){return new DepAll()},
        2: function(){return new DepOne()},
    DelDep:function(){return new DelDep()}

    };

    $('body').on("click",".other", function(){
        console.log($(this).attr('value'));
        var id =  $(this).attr('value');
        Ingredients[id]();
    });


  /*  $(".other").click(function() {
      var id =  $(this).attr('value');
      Ingredients[id]();

    });*/


});