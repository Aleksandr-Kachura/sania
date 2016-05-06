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


        /*Department.prototype.viewDepartment = function (dep) {

            var name = '';
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
            col.append(row2);
        };*/

        Department.prototype.saveDepartment = function (id) {
            var name = document.getElementById("input_name").value;
            var department = {"id": id, "name": name};
            console.log("department");
            $.ajax({
                type: 'POST',
                contentType: "application/json",
                url: "/depSaveOrUpdate",
                data: JSON.stringify(department),
                success: function (data) {
                    service.BuildDep(data);

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

        }
    }
    var contr = new Main();
    contr.showHeader();

    var service = new Service();

    var department = new Department();
    window.GlobDep = department;

    var employee = new Employee();

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
