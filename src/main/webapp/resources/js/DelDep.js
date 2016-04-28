function DelDep() {

  ///  this.speed = 0;
    var data = {}
    data["Id"] = this.id;
    console.log( this.id );

    $("#content").empty();
    var innerHTML = "<p>Hello  Its DepOne</p>" +
        "<button class='other' value='1'>All departments</button> " + "<button class='other' value='2'>2</button> ";
    $("#content").html(innerHTML);
    $.ajax({
        url: '/delDep',
        data : ({
            Id: this.id
        }),
        dataType : 'json',
        type: 'POST',
        success: function (data) {

            $('.container').html('');

            var eTable = "<div class='container'><table class='table table-sm' border='3'><thead><tr class='tabHead'> <th>Dep Id</th> <th>Name</th><th colspan='2'>Action</th></tr></thead><tbody>"
            for (var i = 0; i < data.length; i++) {
                eTable += "<tr class='tabBody'>";
                eTable += "<td>" + data[i]['id'] + "</td>";
                eTable += "<td>" + data[i]['name'] + "</td>";
                var button = "<button class='other btn btn-danger ' value='DelDep' name="+data[i]['id']+">Delete</button> ";
                var button2 = "<button class='other btn btn-success' value='EditDep' name="+data[i]['id']+">Edit</button> ";
                eTable += "<td>" + button + "</td>";
                eTable += "<td>" + button2 + "</td>";
                eTable += "</tr>";
            }
            eTable += "</tbody></table></div>";
            $('.container').append(eTable);


        }

    });
}


