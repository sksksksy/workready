function ws(url,data) {
    //url:ws://localhost:80
    const socket=new WebSocket(url);
    socket.addEventListener('open',function (event) {
            socket.send(data);
    });
    socket.addEventListener('message',function (event) {
            console.log("message from server",event.data);
    });
    socket.addEventListener('close',function (event) {
        console.log(event.code+":"+event.reason);
    });
    socket.addEventListener('error',function (event) {
        console.log(event.AT_TARGET);
    });
}