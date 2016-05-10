function Service() {

    Service.prototype.BuildDep = function(data)
    {
        var employee = new Employee();
        var department = window.GlobDep;
        var service = new Service();

        $('.container').html('');
        var form = $('<from/>');
        $('.container').html(form);
        var table = $("<table class='table table-sm' border='3'/>");

        var tr1 = $("<tr class='tabHead'/>");
        tr1.append("<th>Dep Id</th>");
        tr1.append("<th>Name</th>");
        tr1.append("<th colspan='2'>Action</th>");
        table.append(tr1);

        for(var i=0; i<data.length;i++)
        {
            var id = data[i]['id'];
            var link = $( "<a/>", { html: data[i]['name'], id: id, href: "#", on:{  click:function()   { employee.viewEmployeeList(this.id) } } })
            var button ="<button class='listen btn btn-danger ' value='DelDep'  name="+data[i]['id']+">Delete</button> ";
            var button2 = $('<input />',
                {  type: 'button',value: 'EditDep',class: 'btn btn-success',id: id,
                    on:{  click:function()   { department.EditOrSave(this.id) } } });
            var row = $("<tr class='tabBody' />");
            row.append("<td>"+data[i]['id']+"</td>");
            var td1 = $("<td/>");
            td1.append(link);
            row.append(td1);
            var td2 = $("<td/>");
            td2.append(button);
            row.append(td2);
            var td3 = $("<td />");
            td3.append(button2);
            row.append(td3);
            row.appendTo(table);

        }
      //  var create ="<input class='listen btn btn-primary' type='submit' value='AddDep'/>"
        var create = $('<input />',
            {
                type: 'submit', value: 'Create', class: 'btn btn-primary',
                on: {
                    click: function () {
                        service.viewDepartment();
                    }
                }
            });
        table.append(row);
        form.append(table) ;
        form.append(create);

    }


    Service.prototype.BuildEmpl = function(data,depId)
    {
        var employee = new Employee();
        var department = window.GlobDep;
        var service = new Service();


        $('.container').html('');
        var form = $('<from/>');
        $('.container').html(form);
        var table = $("<table class='table table-sm' border='3'/>");

        var tr1 = $("<tr class='tabHead'/>");
        tr1.append("<th>Empl Id</th>");
        tr1.append("<th>firstName</th>");
        tr1.append("<th>secondName</th>");
        tr1.append("<th>birthday</th>");
        tr1.append("<th>Email</th>");
        tr1.append("<th colspan='2'>Action</th>");
        table.append(tr1);

        for(var i=0; i<data.length;i++)
        {
            var id = data[i]['id'];
            var button ="<button class='listen btn btn-danger' value='DelEmpl'  name="+data[i]['id']+">Delete</button> ";
            var button = $('<input />',
                {  type: 'button',value: 'DelEmpl',class: 'isten btn btn-danger',id: id,
                    on:{  click:function()   { employee.EmplDel(this.id) } } });
            var button2 = $('<input />',
                {  type: 'button',value: 'EditEmpl',class: 'btn btn-success',id: id,
                    on:{  click:function()   { employee.EditOrSave(this.id) } } });
            var row = $("<tr class='tabBody' />");
            row.append("<td>"+data[i]['id']+"</td>");
            row.append("<td>"+data[i]['firstName']+"</td>");
            row.append("<td>"+data[i]['secondName']+"</td>");
            row.append("<td>"+data[i]['birthday']+"</td>");
            row.append("<td>"+data[i]['email']+"</td>");
            var td2 = $("<td/>");
            td2.append(button);
            row.append(td2);
            var td3 = $("<td />");
            td3.append(button2);
            row.append(td3);
            row.appendTo(table);

        }
       var buf = $('<input />',
            {id: "input_depId", type: 'hidden', value:  depId});
        table.append(buf);
        var create = $('<input />',
            {  type: 'button',value: 'Create',class: 'btn btn-success',id: depId,
                on:{  click:function()   { service.BuildOneEmpl('',this.id) } } });
        table.append(row);
        form.append(table) ;
        form.append(create);
    };

    Service.prototype.viewDepartment = function (dep,e)
    {

        var depId = '';
        var name = '';
        //var e =null;
        if (dep !== undefined) {
            name = dep.name;
            depId = dep.id;
        }
        var department = window.GlobDep;
        $('.container').children().detach()
        var div = $('<div/>').appendTo($('.container'));
        var button = $('<input />',
            {
                type: 'submit', value: 'Add', class: 'btn btn-primary',
            });
        var form = $('<form enctype="multipart/form-data" id="depForm"/>')
            .append($('<label/>').text("Name Department").append($('<br/>')))
            .append($('<input class="input-control text" type="text" id="name" name="name" />')
                .val(dep != null ? dep.name : "")).append($("<span class='error'/>").text(e != null ? e : "")).append($('<br/>'))
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

                }
            },
            messages: {
                name: {
                    remote: "Name already in use!"
                }
            },submitHandler: function ()
            {
                department.saveDepartment(depId)
             }
        });
    };

    Service.prototype.BuildOneEmpl = function(empl,id,err)
    {
        var employee = new Employee();
        var department = window.GlobDep;
        var service = new Service();
        var firstname = null;
        var secondname = null;
        var birthday = null;
        var email = null;
        var emplId =null;
        if (empl !== undefined) {
            emplId = empl.id;
            firstname = empl.firstName;
            secondname = empl.secondName;
            birthday = empl.birthday;
            email = empl.email
        }

        var validatedRules = {
            rules: {
                input_first: {
                    required: true,
                    minlength: 3,
                    maxlength: 20
                },
                input_second: {
                    required: true,
                    minlength: 3,
                    maxlength: 20
                },
                input_email: {
                    required: true,
                    email: true
                },
                input_birthday: {
                    required: true,
                    date: true
                }

            }, messages: {
                input_first: {
                    minlength: "Min length is 3",
                    maxlength: "Min length is 20",
                    required: "This is required field"
                },
                input_second: {
                    minlength: "Min length is 3",
                    maxlength: "Min length is 20",
                    required: "This is required field"
                },
                input_email: {
                    required: "This is required field",
                    email: "Not valid email"
                },
                input_birthday: {
                    required: "This is required field"
                }
            },submitHandler: function () {
                employee.saveEmployee(id);
            }
        };

        $('.container').children().detach();
        var div = $('<div/>').appendTo($('.container'));
        var button = $('<input />',
            {
                type: 'submit', value: 'Add', class: 'btn btn-primary',
             });

        $('<form id="empForm"/>')
            .append($('<label/>').text("FirstName")).append('<br/>')
            .append($('<input class="input-control text" type="text" id="input_first" name="input_first"/>')
                .val(firstname)).append($("<span class='error'/>").text(err != null ? err.firstName : "")).append($('<br/>'))
            .append($('<label/>').text("SecondName")).append('<br/>')
            .append($('<input class="input-control text" type="text" id="input_second" name="input_second"/>')
                .val(secondname)).append($("<span class='error'/>").text(err != null ? err.secondName : "")).append($('<br/>'))
            .append($('<label/>').text("Email")).append('<br/>')
            .append($('<input class="input-control text" type="text" id="input_email" name="input_email"/>')
                .val(email)).append($("<span class='error'/>").text(err!= null ? err.email : "")).append($('<br/>'))
            .append($('<label/>').text("Birthday")).append('<br/>')
            .append($('<input class="input-control text" type="date" id="input_birthday" name="input_birthday"/>')
                .val(birthday)).append($("<span class='error'/>").text(err!= null ? err.birthday : "")).append($('<br/>'))
            .append($('<input type="hidden" id="input_emplid" name="emplId"/>').val(empl != null ? empl.id : ""))
            .append(button)
            .appendTo(div);
        $('#empForm').validate(validatedRules);


    };


}


