(function () {
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
                        if (data.status == "SUCCESS") {
                            service.BuildDep(data.department);
                        } else {
                            service.viewDepartment(depart, data.error.name)
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

            Department.prototype.DelDep=function(event)
            {
                $.ajax({
                    url: '/delDep',
                    data: ({
                        Id: event.target.name
                    }),
                    dataType: 'json',
                    type: 'POST',
                    success: function () {
                        department.viewDepartmentsList();

                    }

                });
            }

        }

        var contr = new Main();
        contr.showHeader();

        var service = new Service();

        var department = new Department();
        window.GlobDep = department;

         department.viewDepartmentsList();


        var Ingredients = {
            DepAll: function () {
                department.viewDepartmentsList();
            },
            DelDep: function () {
               department.DelDep(event)
            },
            AddDep: function () {
                department.viewDepartment();
            }

        };


        $('body').on("click", ".listen", function (event) {
            var value = $(this).attr('value');
            Ingredients[value](event);
        });


    });
})(window, document);
