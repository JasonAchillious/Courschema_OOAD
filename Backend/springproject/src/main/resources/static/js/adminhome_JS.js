function load() {
    var uid = getUrlParam('param');

    $("h1#welcome_info").text("欢迎，" + uid);
    $("div.card-header").text("Not Set");

    var J_id = {id: parseInt(uid, 10)};
    $("a#user_infor").text(uid);

}

$(document).ready(load);