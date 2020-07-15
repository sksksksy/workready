_init_data={
    name:"xx系统登录",
    error_tip:false,
    error_msg:"登录错误"
}
var vm=new Vue({
    el:"#ldiv",
    data:_init_data
});
function getData(){
    var data="";
    $("#ldiv").find("input").each(function(){
        data=data+"&"+this.name+"="+this.value;
    });
    return data.substring(1,data.length);
}
$("#login").on("click",()=>{
    $.ajax({
    url:"/test",
    method:"POST",
    data:getData(),
    beforeSend:function(){
        
        },
    success:function(resp){

        },
    error:function(resp){
            _init_data.error_tip=true;
        }
    })
});
$("#reset").on("click",()=>{
    $("#ldiv input").each(function(){
        this.value="";
    })
    _init_data.error_tip=false;
 });