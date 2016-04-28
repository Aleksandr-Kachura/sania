

function DepOne() {
       console.log("1");
       $("#content").empty();
       var innerHTML = "<p>Hello  Its DepOne</p>" +
            "<button class='other' value='1'>All departments</button> " + "<button class='other' value='2'>2</button> ";
        $("#content").html(innerHTML )
    $.ajax({
        url : '/page',
        type: 'GET',
        success: function (data) {

            var eTable="<div class='container'><table class='table table-sm' border='3'><thead><tr class='tabHead'> <th>Dep Id</th> <th>Name</th><th colspan='2'>Action</th></tr></thead><tbody>"
            for(var i=0; i<data.length;i++)
            {
                eTable += "<tr class='tabBody'>";
                eTable += "<td>"+data[i]['id']+"</td>";
                eTable += "<td>"+data[i]['name']+"</td>";
                var button ="<button class='other btn btn-danger ' value='DelDep' name="+data[i]['id']+" >Delete</button> ";
                var button2 ="<button class='other btn btn-success' value='EditDep' name="+data[i]['id']+" >Edit</button> ";
                eTable += "<td>"+button+ "</td>";
                eTable += "<td>"+button2+"</td>";
                eTable += "</tr>";
            }
            eTable +="</tbody></table></div>";
            $('#table').html(eTable);
            console.log(data);
        }
    });
      /*  var table = document.createElement('table');
        for (var i = 1; i < 4; i++){
            var tr = document.createElement('tr');

            var td1 = document.createElement('td');
            var td2 = document.createElement('td');

            var text1 = document.createTextNode('Text1');
            var text2 = document.createTextNode('Text2');

            td1.appendChild(text1);
            td2.appendChild(text2);
            tr.appendChild(td1);
            tr.appendChild(td2);

            table.appendChild(tr);
        }
        document.body.appendChild(table);*/
}



