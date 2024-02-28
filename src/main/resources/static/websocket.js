var ws;

function connect() {
    var username = document.getElementById("username").value;
    var host = document.location.host;
    console.log("username", "ws://" + host + "/chat/" + username)
    // ws = new WebSocket("ws://localhost:8080/websocket-server/chat");
    // ws = new WebSocket("ws://" + host + "/chat/" + username);

    ws = new WebSocket("ws://localhost:8080/chat");

    // firing onopen function
    ws.onopen = function (event) {
        console.log(event.data);
        var log = document.getElementById("log");
        log.innerHTML = "connected to server";
    }


    ws.onmessage = function (event) {
        var log = document.getElementById("log");
        console.log(event.data);
        var message = JSON.parse(event.data);
        log.innerHTML += message.from + " : " + message.content + "\n";
    }
}

function send() {
    var content = document.getElementById("msg").value;
    var json = JSON.stringify({
        "content": content
    });

    ws.send(json);
}
