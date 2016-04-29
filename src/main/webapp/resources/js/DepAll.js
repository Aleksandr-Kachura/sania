

function DepAll() {

    $.ajax({
        url : '/DepAll',
        type: 'GET',
        success: function (data) {

            var eTable="<div class='container'><from><table class='table table-sm' border='3'><thead><tr class='tabHead'> <th>Dep Id</th> <th>Name</th><th colspan='2'>Action</th></tr></thead><tbody>"
            for(var i=0; i<data.length;i++)
            {
                eTable += "<tr class='tabBody'>";
                eTable += "<td>"+data[i]['id']+"</td>";
                eTable += "<td>"+data[i]['name']+"</td>";
                var button ="<button class='listen btn btn-danger ' value='DelDep'  name="+data[i]['id']+">Delete</button> ";
                var button2 ="<button class='listen btn btn-success' value='EditDep' name="+data[i]['id']+">Edit</button> ";
                eTable += "<td>"+button+ "</td>";
                eTable += "<td>"+button2+"</td>";
                eTable += "</tr>";
            }
            eTable +="</tbody></table>";
            eTable +="<input class='listen btn btn-primary' type='submit' value='AddDep'/></form></div>"
            $('#table').html(eTable);
            globalscope = data;
            data = null;
        }
    });
}





