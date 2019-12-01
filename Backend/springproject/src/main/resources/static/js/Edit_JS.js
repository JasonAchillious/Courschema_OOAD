
var dragFrame = {

    cssarray: ["card text-white bg-dark mb-3 droppable"
        , "card text-white bg-info mb-3 droppable"
        , "card text-white bg-warning mb-3 droppable"
        , "card text-white bg-danger mb-3 droppable"
        , "card text-white bg-success mb-3 droppable"
        , "card text-white bg-secondary mb-3 droppable"
        , "card text-white bg-primary mb-3 droppable"
    ],
    //todo store edited card list


    ready: function () {

        $(".droppable").find("div.card-header").text("Not Set");

        $(".draggable").draggable({
            revert: "valid",
            helper: "clone",
            appendTo: "body"
        });

        $(".droppable")
            .droppable({

                drop: function (event, ui) {
                    var name = ui.draggable.text();
                    $(this)
                        .removeClass()
                        .addClass("card border-info mb-3 droppable")
                        .find("h4").text(name);
                    $(this).find("div.card-header").text("SET");
                    // alert(text);

                    return false;
                }
            });
        //todo double click cleaning
        // .dblclick(
        //     function () {
        //
        //         alert(this.cssarray[Math.round(Math.random()*this.cssarray.length-1)]);
        //
        //         $(this)
        //             .removeClass()
        //             .addClass(this.cssarray[Math.round(Math.random()*this.cssarray.length-1)])
        //             .find("h4").text("培养方案名称");
        //
        //         $(this).find("div.card-header").text("Not Set");
        //     }
        // );
    }
};

var load = {
    ready: function () {


        $.ajax({
            type: 'GET',
            // data: data,//json
            contentType: 'application/json',
            dataType: 'json',
            async: false,
            url: '/exer/recordCourschemas',
            success: function (reply) {


                var str_reply = JSON.stringify(reply);

                var res_list = eval("("+str_reply+")");

                console.log(res_list);


                for(var i = 0;i < res_list.length;i ++)
                {
                    var courschema = res_list[i];
                    // 拼接后加入div
                    var content = joint(courschema.chineseName);
                    $('a.list-group-item list-group-item-action active').append(content)
                }
            },
            error: function (response) {
                alert("Error")
            }
        });

    }
};
$(window).onload = load.ready();
$(document).ready(dragFrame.ready);
