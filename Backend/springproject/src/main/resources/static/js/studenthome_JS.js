

var load = {
    ready: function () {
        var uid = getUrlParam('param');

        $("h1#welcome_info").text("欢迎，"+uid);
        $("div.card-header").text("Not Set");

        var J_id = {id:parseInt(uid, 10)};
        $.ajax({
            type: 'POST',
            data: JSON.stringify(J_id),//json
            contentType: 'application/json',
            dataType: 'json',
            async:false,
            url: '/home_student',
            success: function (response) {

                reply = JSON.stringify(response);
                console.log(reply);

                //修改主页显示信息
                $("a#user_infor").text(response.name+','+uid);
                $("p#major_info").text(response.department+": "+response.major);


            },
            error: function (response) {
                alert("Error")
            }
        });
    }
};

function modifyCollect(list){
    row = Math.ceil(list.length/3);
    // for(var i = 0;i < row; i++)
    // {
    //
    // }

}
$(document).ready(load.ready);
// (window).onload = load.ready();