window.onload(function requestData(){
    $.ajax({
        url: "/queryAllCarowners",
        type: "post",
        dataType: "json",
        success: function(data){
            /*这个方法里是ajax发送请求成功之后执行的代码*/
            showData(data);//我们仅做数据展示
        },
        error: function(msg){
            alert("ajax连接异常："+msg);
        }
    });
});

function showData(data) {
    var str = "";//定义用于拼接的字符串
    for (var i = 0; i < data.length; i++) {
        //拼接表格的行和列
        str = "<tr><td>" + data[i].name + "</td><td>" + data[i].password + "</td></tr>";
        //追加到table中
        $("#tab").append(str);         }
}