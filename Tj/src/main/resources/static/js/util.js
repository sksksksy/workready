function RequestSend(method,send_data,url,fn) {
    console.log(method);
    $.ajax({
        url:url,
        type:method,
        data:send_data,
        success: function f(data) {
            fn.call(this,data);
        },
        error: function f(data) {
            alert("未知错误，请联系管理员！");
        }
    });
}