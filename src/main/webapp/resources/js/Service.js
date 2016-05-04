function Service() {


    Service.prototype.BuildDep = function(data)
    {
       var employee = new Employee();
        var department = window.GlobDep;

        $('.container').html('');
        var form = $('<from>');
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


    Service.prototype.BuildEmpl = function(data,id)
    {
        var employee = new Employee();
        var department = window.GlobDep;

        $('.container').html('');
        var form = $('<from>');
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
            var link = $( "<a/>", { html: data[i]['name'], id: id, href: "#", on:{  click:function()   { employee.viewEmployeeList(this.id) } } })
            var button ="<button class='listen btn btn-danger' value='DelEmpl'  name="+data[i]['id']+">Delete</button> ";
            var button2 = $('<input />',
                {  type: 'button',value: 'EditEmpl',class: 'btn btn-success',id: id,
                    on:{  click:function()   { department.EditOrSave(this.id) } } });
            var row = $("<tr class='tabBody' />");
            row.append("<td>"+data[i]['id']+"</td>");
            row.append("<td>"+data[i]['firstName']+"</td>");
            row.append("<td>"+data[i]['secondName']+"</td>");
            row.append("<td>"+data[i]['birthday']+"</td>");
            row.append("<td>"+data[i]['Email']+"</td>");
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
        var create ="<input class='listen btn btn-primary' type='submit' value='AddEmpl'/>"
        table.append(row);
        form.append(table) ;
        form.append(create);
    }
}


