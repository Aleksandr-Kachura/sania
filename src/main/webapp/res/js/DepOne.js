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

            var eTable="<table border='3'><thead><tr><th colspan='3'>Created by for loop</th></tr><tr><th>ID</th><th>Name</th><th>Action</th></tr></thead><tbody>"
            for(var i=0; i<data.length;i++)
            {
                eTable += "<tr>";
                eTable += "<td>"+data[i]['id']+"</td>";
                eTable += "<td>"+data[i]['name']+"</td>";
                eTable += "<td> </td>";
                eTable += "</tr>";
            }
            eTable +="</tbody></table>";
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



