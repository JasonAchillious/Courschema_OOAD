

var load = {
    ready: function () {
        var id = getUrlParam('param');

        $("h1#welcome_info").text("欢迎，"+id);

        var J_id = {};
        J_id.id = id;

        alert(JSON.stringify(J_id));

        $.ajax({
            type: 'GET',
            data: JSON.stringify(J_id),//json
            contentType: 'application/json',
            dataType: 'json',
            async:false,
            url: '/home_student',
            success: function (response) {
                reply = JSON.stringify(response);
                alert(reply);
            },
            error: function (response) {
                alert("Error")
            }
        });
    }
};

$(document).ready(load.ready);
// (window).onload = load.ready();