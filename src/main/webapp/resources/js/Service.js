function Service() {


    var ValRules = {
        rules: {
            input_name: {
                required: true,
                minlength: 2
            }
        }, messages: {
            input_name: {
                minlength: "Min length 2",
                required: "Its requery"
            }
        }
    };

    Service.prototype.BuildDep = function(data)
    {
        var employee = new Employee();
        var department = window.GlobDep;


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
        var create ="<input class='listen btn btn-primary' type='submit' value='AddDep'/>"
        table.append(row);
        form.append(table) ;
        form.append(create);

    }


    Service.prototype.BuildEmpl = function(data,depId)
    {
        var employee = new Employee();
        var department = window.GlobDep;
        var service = new Service()


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

    Service.prototype.viewDepartment = function (dep) {
        var department = window.GlobDep;
        var name = '';
        var id = '';
        if (dep !== undefined) {
            name = dep.name || '';
            id = dep.id || '';
        }
        $('.container').html('');
        var form = $('<from id="depForm"/>');
        $('.container').html(form);
        var col = $("<div class='col-md-6'/>");
        form.append(col);
        var row1 = $("<div class='row'/>");
        var row2 = $("<div class='row'/>");
        var eTable = " ";
        eTable += "<p>Name: </p>";
        var input_name = $('<input />',
            {id: "input_name",name:"input_name", type: 'text', value: name});
        //console.log(ValRules);
        var button = $('<input />',
            {
                type: 'submit', value: 'Add', class: 'btn btn-primary',
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

    };


    Service.prototype.BuildOneEmpl = function(empl,id)
    {
        var employee = new Employee();
        var department = window.GlobDep;
        var service = new Service();
        var firstname = '';
        var secondname = '';
        var birthday = '';
        var email = '';
        var emplId ='';
        if (empl !== undefined) {
            emplId = empl.id;
            firstname = empl.firstName;
            secondname = empl.secondName;
            birthday = empl.birthday;
            email = empl.email
        }
        $('.container').html('');
        var form = $("<form class='form-inline' />");
        $('.container').html(form);
        var col = $("<div class=' col-md-6'/>");
        var row1 = $("<div class='row'/>");
        var row2 = $("<div class='row'/>");
        var row3 = $("<div class='row'/>");
        var row4 = $("<div class='row'/>");
        var row5 = $("<br/><div class='row'/>");
        var eTable = " ";
        eTable += "<p>FirstName: </p>";
        var buf = $('<input />',
            {id: "input_first", class:"in_text", type: 'text', value: firstname});

        row1.append(eTable);
        row1.append(buf);
        col.append(row1);
        eTable = " ";
        eTable += "<p>SecondName: </p>";
        buf = $('<input />',
            {id: "input_second", class:"in_text",type: 'text', value: secondname});

        row2.append(eTable);
        row2.append(buf);
        col.append(row2);

        eTable = " ";
        eTable += "<p>Birthday: </p>";
        buf = $('<input />',
            {id: "input_birthday", type: 'date', value: birthday});

        row3.append(eTable);
        row3.append(buf);
        col.append(row3);


        eTable = " ";
        eTable += "<p>Email: </p>";
        buf = $('<input />',
            {id: "input_email", class:"in_text", type: 'text', value: email});

        row4.append(eTable);
        row4.append(buf);
        col.append(row4);
        buf = $('<input />',
            {id: "input_emplid", type: 'hidden', value:  emplId});
        col.append(buf);
        var button = $('<input />',
            {
                type: 'button', value: 'Add', class: 'btn btn-primary',
                on: {
                    click: function () {
                         employee.saveEmployee(id)

                    }
                }
            });
        row5.append(button);
        col.append(row5);
        form.append(col);
    }

}


