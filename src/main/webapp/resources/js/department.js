function Department() {
    this.showMain = function () {
        console.log("1");
        var container = document.getElementById("content");
        container.innerHTML = "<p>Hello Department2</p>"+
            "<button class='other' value='1'>1</button> " + "<button class='other' value='2'>2</button> ";
    }

    this.showOther = function () {
        console.log("2");
        var container = document.getElementById("content");
        container.innerHTML = "<p>Hello Department3</p>" +
            "<button class='other' value='1'>All departments</button> " + "<button class='other' value='2'>2</button> ";
    }
}


