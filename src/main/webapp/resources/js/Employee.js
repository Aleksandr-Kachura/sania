function Employee()
    {
        Employee.prototype.viewEmployeeList = function(id)
        {

            var service = new Service();

            console.log(event);
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
        }

        Employee.prototype.viewEmployee = function (empl) {


            var firstname = '';
            var secondname = '';
            var birthday = '';
            var email = '';
            if (empl !== undefined) {
                var  id = empl.id;
                firstname = empl.firstname;
                secondname = empl.secondname;
                birthday = empl.birthday;
                email = empl.email
            }
            $('.container').html('');
            var col = $("<div class='col-md-6'/>");
            $('.container').html(col);
            var row1 = $("<div class='row'/>");
            var row2 = $("<div class='row'/>");
            var row3 = $("<div class='row'/>");
            var row4 = $("<div class='row'/>");
            var eTable = " ";
            eTable += "<p>FirstName: </p>";
            var input_name = $('<input />',
                {id: "input_first", type: 'text', value: firstname});

            row1.append(eTable);
            row1.append(input_name);
            col.append(row1);
            eTable = " ";
            eTable += "<p>SecondName: </p>";
             input_name = $('<input />',
                {id: "input_second", type: 'text', value: secondname});

            row2.append(eTable);
            row2.append(input_name);
            col.append(row2);

            eTable = " ";
            eTable += "<p>Birtday: </p>";
            input_name = $('<input />',
                {id: "input_second", type: 'date', value: secondname});

            row3.append(eTable);
            row3.append(input_name);
            col.append(row3);



        }



    }
