

var load = {
    ready: function () {
        var uid = getUrlParam('param');

        $("h1#welcome_info").text("欢迎，"+uid);
        $("div.card-header").text("Not Set");

        var J_id = {id:parseInt(uid, 10)};
        alert(JSON.stringify(J_id));


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
                var name = response.name;

                $("a#user_infor").text(name+','+uid);

            },
            error: function (response) {
                alert("Error")
            }
        });
    }
};

$(document).ready(load.ready);
// (window).onload = load.ready();