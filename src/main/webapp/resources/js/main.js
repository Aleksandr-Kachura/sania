(function()
{
$(document).ready(function () {


    function Department() {

        Department.prototype.viewDepartmentsList = function () {
            $.ajax({
                url: '/DepAll',
                type: 'GET',
                success: function (data) {
                    service.BuildDep(data);
                }
            });
        };


        Department.prototype.viewDepartment = function (dep) {
           /* var name = '';
            var id = '';
            if (dep !== undefined) {
                name = dep.name || '';
                id = dep.id || '';
            }
            $('.container').html('');
            var col = $("<div class='col-md-6'/>");
            $('.container').html(col);
            var row1 = $("<div class='row'/>");
            var row2 = $("<div class='row'/>");
            var eTable = " ";
            eTable += "<p>Name: </p>";
            var input_name = $('<input />',
                {id: "input_name", type: 'text', value: name});
            var button = $('<input />',
                {
                    type: 'button', value: 'Add', class: 'btn btn-primary',
                    on: {
                        click: function () {
                            department.saveDepartment(id)
                        }
                    }
                });
            row1.append(eTable);
            row1.append(input_name);
            col.append(row1);
            row2.append(button);
            col.append(row2);*/

            $('.container').children().detach()
            var div = $('<div/>').appendTo($('.container'));
            var button = $('<input />',
                {
                    type: 'button', value: 'Add', class: 'btn btn-primary',
                    on: {
                        click: function () {
                            department.saveDepartment(dep.id)
                        }
                    }
                });
            var form = $('<form enctype="multipart/form-data" id="depForm"/>')
                .append($('<label/>').text("Name Department").append($('<br/>')))
                .append($('<input class="input-control text" type="text" id="name" name="name" placeholder="input you name"/>')
                    .val(dep != null ? dep.name : "")).append($('<br/>'))
                .append($('<input type="hidden" id="id" name="id"/>')
                    .val(dep != null ? dep.id : "")).append($('<br/>'))
                .append(button)
                .appendTo(div);

            $('#depForm').validate({
                rules: {
                    name: {
                        required: true,
                        minlength: 3,
                        maxlength: 16
                    /*    remote: {
                            url: "/unicDepName",
                            type: "POST",
                            data: {
                                id: function() {
                                    return $( "#id" ).val();
                                }
                            }
                        }*/
                    }
                },
                messages: {
                    name: {
                        remote: "Name already in use!"
                    }
                }
            });
        };

        Department.prototype.saveDepartment = function (id) {
            var name = document.getElementById("name").value;
            var depart = {"id": id, "name": name};
            console.log("department");
            $.ajax({
                type: 'POST',
                contentType: "application/json",
                url: "/depSaveOrUpdate",
                data: JSON.stringify(depart),
                success: function (data) {
                    //
                    if(data.status == "SUCCESS") {
                       // thisObj.showDepartments();
                        service.BuildDep(data.department);
                    } else {
                       /* var department = data.result;
                        thisObj.errorMessage = data.error.name;
                        var table = new FormDrawer(department,thisObj);
                        $('div.department').html(table);*/
                        service.viewDepartment(depart,data.error.name)
                    }
                }
            });
        };



        Department.prototype.EditOrSave = function (id) {
            $.ajax({
                url: '/editOrAddDep',
                data: ({
                    id: id
                }),
                dataType: 'json',
                type: 'POST',
                success: function (data) {
                    service.viewDepartment(data)
                }
            });

        };
    }
    var contr = new Main();
    contr.showHeader();

    var service = new Service();

    var department = new Department();
    window.GlobDep = department;

    var employee = new Employee();
    window.GlobEmpl = employee;
    department.viewDepartmentsList();


    var Ingredients = {
        DepAll: function () {
            return new DepAll(event)
        },
        DelDep: function () {
            return new DelDep(event)
        },
        AddDep: function () {
            service.viewDepartment();
        }

    };


    $('body').on("click", ".listen", function (event) {
        var value = $(this).attr('value');
        Ingredients[value](event);
    });


});
})(window, document);
