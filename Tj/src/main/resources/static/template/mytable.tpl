<style>
      .table-list{
          /* color:black; */
          border-collapse:collapse;
          border:1px black solid;
      }
      .table-list tr{
        border: 1px gray solid;
        table-layout: fixed;
      }
      .table-list tr td{
        border: 1px gray solid;
      }
</style>
<div id="table">
                  <table class="table-list" cellpadding="10">
                    <tr v-for="item in tableData" :key="item.id">
                      <td><input type="checkbox" :name="item.name" :value="item.id"/></td>
                      <td v-for="(v,k,i) in item" v-if="k!='id'">{{v}}</td>
                      <!-- <td>{{item.date}}</td>
                      <td>{{item.name}}</td>
                      <td>{{item.address}}</td> -->
                      <td><button :id="item.id" :value="item.id" onclick="zclick(this)">edit</button></td>
                      <td><button :id="item.id" :value="item.id" onclick="zclick(this)">delete</button></td>
                      </tr>
                  </table>
                  <input type="button" value="上一页"><input type="button" value="下一页">
</div>
<script>
      datas={tableData:[{},{}]
    }       
      var v=new Vue({
        el:'#table',
        data:datas
      });
      function zclick(event){
        alert(event.getAttribute("value"));
      }
    </script>