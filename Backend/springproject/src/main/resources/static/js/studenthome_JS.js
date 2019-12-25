

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
                modifyCollect(response.list)


            },
            error: function (response) {
                alert("Error")
            }
        });
    }
};

function makeRow(place) {
    $('#collection').append('<tr id="'+place+'"></tr>');
}

function makeHTML(name,intro,cid) {
    var breifIntro = intro;
    // if (intro.length > 30){
    //     breifIntro = intro.substring(0,30);
    // }
    var uid=getUrlParam('param');

    var template = "<td>\n" +
                   "  <div class=\"card text-white bg-primary mb-3 major\" style=\"max-width: 20rem;\">\n" +
                   "    <div class=\"card-header\">\n" +
                   "      <a href='courschemaWatch?id="+cid+"&uid="+uid+"'>查看详情</a>\n"+
                   "    </div>\n" +
                   "    <div class=\"card-body\">\n" +
                   "       <h4 class=\"card-title\">"+name+"</h4>\n" +
                   "       <p class=\"card-text\">"+breifIntro+"</p>\n" +
                   "    </div>\n" +
                   "  </div>\n" +
                   "</td>";

    return template

}

function addColoum(row,content) {

    var url = 'todo';

    console.log(content.name);
    console.log(content.intro);
    console.log(content.cid);
    var html_content = makeHTML(content.name,content.intro,content.cid);
    $('#'+row).append(html_content);
    console.log("append on row:"+row+"\n"+html_content);

}

function modifyCollect(list){

    var rows = Math.ceil(list.length/3);
    for(var i = 1;i <= rows;i ++)
        makeRow(i);

    for(var i = 0;i<list.length; i++)
    {
        row = Math.ceil((i+1)/3);
        addColoum(row,list[i]);

    }

}
$(document).ready(load.ready);
// (window).onload = load.ready();