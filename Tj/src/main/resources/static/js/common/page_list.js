datas={
    pages:{
      current:0,
      count:100,
      pageSize:10
    },
    tableData: [],
  }       
  var v=new Vue({
    el:'#table',
    data:datas
  });
  function zclick(event){
    alert(event.getAttribute("value"));
  }
  function changePage(event){
    var sgin=event.getAttribute("sgin");
    switch(sgin){
      case "previous":
        if(v.$data.pages.current>0){
          v.$data.pages.current--;
        }else{
          v.$data.pages.current=0;
        };break;
      case "next":
         if(v.$data.pages.current<(v.$data.pages.count/v.$data.pages.pageSize)){
          v.$data.pages.current++;
         }else{
          v.$data.pages.current=(v.$data.pages.count/v.$data.pages.pageSize);
         };break;
      default:
         alert("no value");break;
    }
    alert(v.$data.pages.current);
    // getInfoList(v.$data.pages.current,v.$data.pages.pageSize,v.$data.pages.count);
  }
  function getInfoList(vpageNo,vpageSize,vpageCount){
      var data_rep;
      sendData={
        pageNo:vpageNo,
        pageSize:vpageSize,
        pageCount:vpageCount
      };
      $.ajax({
        url:"",
        method:"",
        data:sendData,
        success:function(resp){
          v.$data.tableData=resp.vdata;
          data_rep=resp.vdata;
          alert(resp.msg);
        },
        error:function(resp){
          alert(resp);
        }
      })
  }
  function del(){
    str="";
    $(":checkbox").each(function(){
      if(this.checked){
          str=str+"&"+this.getAttribute("value");
      }
    });
    console.log(str);
  }