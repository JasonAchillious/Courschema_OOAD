$(document).ready(
    function () {
        alert('ready')
        $('button').click(function ($e) {
            //生成json
            var list = [];
            //实际情况中，json对象的值可通过document.getElementByName()来获取用户输入
            for (var i = 1; i < 5; i++) {
                var j = {};
                j.name = "name";
                j.cars = "22";
                j.obj = i;
                list.push(j);
            }
            var J_list = JSON.stringify(list);
            var data = JSON.stringify({ 'list': J_list });

            alert(J_list);
            alert(data);//json
            //传递到后台
            $.ajax({
                type: 'POST',
                data: data,//json
                contentType: 'application/json',
                dataType: 'json',
                async:false,
                url: '/TransmitTestList',
                success: function (response) {
                    reply = JSON.stringify(response);
                    alert(reply);
                },
                error: function (response) {
                    alert("Error")
                }
            });
        })
    });
