var jsonContent="application/json;charset=UTF-8'";
datas=
        {
            pages:{//分页信息
                current:0,
                count:100,
                pageSize:10
            },
            tableHead:[],
            tableData: [{"name":"zzz","age":12,"addr":"chongq"}],//表数据
            vindex:0,//用于各个按钮的value的key
            currentUrl:""   //获取tableData当前的应该请求的url
        }       
        var v=new Vue({
            el:'#table',
            data:datas,
            methods:{
                vval:vval
            }
        });
        //点击最右侧编辑按钮后执行的函数
        function zclick(event){
          var zname=event.getAttribute("name");
          if(zname=="edit"){
            
          }else if(zname=="delete"){

          }else{

          }
          debugeShow(event.getAttribute("value"));
          // fn.call(this,zname);
        }
        //点击上一页，下一页后执行的函数
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
            debugeShow(v.$data.pages.current);
            sendData=pageDataJson();
            debugeShow(v.$data.currentUrl);
            zhttp(v.$data.currentUrl,"post",sendData,getInfoList);
        }
  //获取分页的回调函数
  function getInfoList(resp){
    v.$data.tableData=resp.tdata;
    // v.$data.tableHead=resp.thead;
  }
  //点击删除所选项后执行的函数
  function selectAll(){
    str="";
    $(":checkbox").each(function(){
      if(this.checked){
          str=str+"&"+this.getAttribute("value");
      }
    });
    data={
      "keys":str
    };
    console.log(str);
  }
  //item为{}型，获取item的第vindex个key的值
  function vval(item){
    return Object.values(item)[datas.vindex];
  }
  //通用的http函数
  function zhttp(hurl,hmethod,hdata,hfunction,hcontentType="application/x-www-form-urlencoded;charset=UTF-8'"){
    $.ajax({url:hurl,method:hmethod,contentType:hcontentType,data:hdata,
            success:function(resp){
              hfunction.call(this,resp);
              // v.$data.tableData=resp.tdata;
              // v.$data.tableHead=resp.thead;
              // data_rep=resp.tdata;
              debugeShow(resp.msg);
            },
            error:function(resp){
              alert(resp+"未知错误");
            }
          });
  }
  //编辑使用的回调函数，用于处理点击按钮后的响应
  function fangye(v){
    debugeShow("这是被调用的"+v);
  }
  //用于debug显示的辅助函数
  function debugeShow(msg){
    alert(msg);
  }
  function pageDataJson(){
    return {
      "pageNo":v.$data.pages.current,
      "pageSize":v.$data.pages.pageSize,
      "pageCount":v.$data.pages.count
    };
  }