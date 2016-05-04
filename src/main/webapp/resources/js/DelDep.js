function DelDep(event) {
    var emplpoyee = new Employee();
    var dep = window.GlobDep;
    console.log(event);
     $.ajax({
        url: '/delDep',
        data : ({
            Id: event.target.name
        }),
        dataType : 'json',
        type: 'POST',
        success: function (data) {
            dep.viewDepartmentsList();

        }

    });
}



