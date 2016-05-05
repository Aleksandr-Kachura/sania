
    function Employee()
    {
        Employee.prototype.viewEmployeeList = function(id)
        {

            var service = new Service();
            $.ajax({
                url: '/showAllEmpl',
                data : ({
                    Id: id
                }),
                dataType : 'json',
                type: 'GET',
                success: function (data) {
                    service.BuildEmpl(data,id);

                }

            });
        };


       Employee.prototype.saveEmployee = function (id) {

            var service = new Service();
            var name = document.getElementById("input_first").value;
            var secondName = document.getElementById("input_second").value;
            var birthday = document.getElementById("input_birthday").value;
            var email = document.getElementById("input_email").value;
            var id_empl = document.getElementById("input_emplid").value;
            var employeeObj = {
                "id": id_empl ,
                "firstName": name,
                "secondName": secondName,
                "birthday":birthday,
                "email": email,
                "depId":id

            };

           $.ajax({
                type: 'POST',
                dataType : 'json',
                url: "/employeeSaveOrUpdate?depId="+id,
                contentType: "application/json",

                data : (JSON.stringify(employeeObj)),

              /*    data : ({
                   depId: id
                }),*/
                success: function (data) {
                    service.BuildEmpl(data,id);
                }
            });
        };

        Employee.prototype.EmplDel=function(id)
        {
            var service = new Service();
            var depId = document.getElementById("input_depId").value;
            console.log(event);
            $.ajax({
                url: '/delEmpl',
                dataType : 'json',
                data : ({
                    id: id,
                    depId:depId
                }),
                type: 'POST',
                success: function (data) {
                    service.BuildEmpl(data,depId);

                }

            });
        }



        Employee.prototype.EditOrSave  = function (id) {
          alert("OK");
        };
    }

