
function Main() {
    this.showHeader = function () {
        console.log("1");
        var container = document.getElementById("content");
        container.innerHTML = "<p>Hello JS SPA</p>" +
            "<button class='listen' value='DepAll'>All Department</button>";
    }
}