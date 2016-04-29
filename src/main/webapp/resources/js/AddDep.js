function AddDep(event) {
    $('.container').html('');
    var eTable="<div class='container'><div class='listen col-md-6'><from>"
    eTable += "<div class='row'>";
    eTable += "<p>Name: </p>";
    eTable +="<input type='text' name='name' value=' ' /><br/>"
    eTable +="</div><br/><div class='row'><input class='btn btn-primary'  type='submit' value='SaveDep'/></div></form></div></div>"
    $('.container').append(eTable);
}


