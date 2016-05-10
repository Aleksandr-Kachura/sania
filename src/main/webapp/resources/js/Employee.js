/*function Employee(service) {
    this.service=service;

}*/
var Employee = function(service) {
      this.service=new Service();
};

Employee.prototype.viewEmployeeList = function (id) {

    var service = this.service;
    $.ajax({
        url: '/showAllEmpl',
        data: ({
            Id: id
        }),
        dataType: 'json',
        type: 'GET',
        success: function (data) {
            service.BuildEmpl(data, id);

        }

    });
};


Employee.prototype.saveEmployee = function (id) {
    var service = this.service;
    var name = document.getElementById("input_first").value;
    var secondName = document.getElementById("input_second").value;
    var birthday = document.getElementById("input_birthday").value;
    var email = document.getElementById("input_email").value;
    var id_empl = document.getElementById("input_emplid").value;
    var employeeObj = {
        "id": id_empl,
        "firstName": name,
        "secondName": secondName,
        "birthday": birthday,
        "email": email,
        "depId": id

    };
    $.ajax({
        type: 'POST',
        dataType: 'json',
        url: "/employeeSaveOrUpdate?depId=" + id,
        contentType: "application/json",
        data: (JSON.stringify(employeeObj)),
        success: function (data) {
            //
            if (data.status == "SUCCESS") {
                service.BuildEmpl(data.employee, id);
            } else {
                service.BuildOneEmpl(employeeObj, id, data.error);
            }

        }
    });
};

Employee.prototype.EmplDel = function (id) {
    //var service = new Service();
    var service = this.service;
    var depId = document.getElementById("input_depId").value;
    console.log(event);
    $.ajax({
        url: '/delEmpl',
        dataType: 'json',
        data: ({
            id: id,
            depId: depId
        }),
        type: 'POST',
        success: function (data) {
            service.BuildEmpl(data, depId);

        }

    });
};


Employee.prototype.EditOrSave = function (id) {
    //var service = new Service();
    var service = this.service;
    var depId = document.getElementById("input_depId").value;
    $.ajax({
        url: '/editOrAddEmpl',
        data: ({
            id: id
        }),
        dataType: 'json',
        type: 'POST',
        success: function (data) {
            service.BuildOneEmpl(data, depId)
        }
    });

}