$( document ).ready(function() {
  // var contr = new Department();
   var contr = new Department();
    contr.showOther();


    var Ingredients = {
        1: function(){return new DepAll()},
        2: function(){return new DepOne()}

    };

    $("#content").on("click",".other", function(){
        var id =  $(this).attr('value');
        Ingredients[id]();
    });


  /*  $(".other").click(function() {
      var id =  $(this).attr('value');
      Ingredients[id]();

    });*/


});