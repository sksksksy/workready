function RequestSend(method,send_data,url) {
    console.log(method);
    $.ajax({
        url:url,
        type:method,
        data:send_data,
        success: function f(data) {
            alert(data);
        },
        error: function f(data) {
            alert("error");
        }
    });
}