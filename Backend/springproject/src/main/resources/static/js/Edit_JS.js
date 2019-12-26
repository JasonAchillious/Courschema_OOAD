collect_schema = [];

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
                    var id = Number(ui.draggable.prop('id'));
                    collect_schema.push(Number(id));
                    console.log(collect_schema);
                    $(this)
                        .removeClass()
                        .addClass("card border-info mb-3 droppable")
                        .find("h4").text(name)
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

    departmentMap: new Map(),

    ready: function () {


        $.ajax({
            type: 'POST',
            // data: data,//json
            contentType: 'application/json',
            dataType: 'json',
            async: false,
            url: '/allCourschemas',
            success: function (reply) {

                console.log(JSON.stringify(reply));

                for(var i = 0;i < reply.length;i++)
                {
                    console.log(reply[i].chineseName);
                    //todo append List, write a backend requirement.
                    load.appendDepartment(reply[i]);
                    load.appendMajor(reply[i]);
                }

            },
            error: function (response) {
                alert("Error")
            }
        });
        fillEdit();
    },

    appendMajor: function (major) {
        var name = major.chineseName;
        var major_id = major.courschema;
        var departmentID = load.departmentMap.get(major.department);
        var major_html = "<a href=\"#\" class=\"list-group-item list-group-item-action draggable\" id = \""+major_id+"\">"+name+"</a>"

        $('div#'+departmentID).append(major_html);
    },

    appendDepartment: function (major) {

        var department = major.department;

        if(!load.departmentMap.has(department))
        {
            load.departmentMap.set(department,load.departmentMap.size);

            departmentID = load.departmentMap.get(department);

            var div = "<div class=\"list-group col-md-12\" id = \""+departmentID+"\"></div>";

            var dep_html = "<a href=\"#\" class=\"list-group-item list-group-item-action active\">" +department + "</a>";

            $('#Major_List').append(div);
            $('div#'+departmentID).append(dep_html);
            //append
            console.log("append department:"+department);
        }


    }
};

function fillEdit(){
    var uid = Number(getUrlParam('param'));
    var J_id = {id:uid};
    $.ajax({
        type: 'POST',
        data: JSON.stringify(J_id),//json
        contentType: 'application/json',
        dataType: 'json',
        url: '/home_student',
        success: function (response) {

            reply = JSON.stringify(response);
            console.log(reply);
            var list = response.list;
            //修改定制信息
            console.log(list);
            for(var i = 0;i < list.length;i ++){
                alert(list[i].intro);
                $("#place"+i)
                    .find("h4").text(list[i].name);
                $("#place"+i).find("p").text(list[i].intro);
                collect_schema.push(list[i].cid);
            }


        },
        error: function (response) {
            alert("Error")
        }
    });
}

function save(){
    //upload
    var s_id = Number(getUrlParam('param'));
    var data = {'id':s_id,
            'list':collect_schema};
    var j_data = JSON.stringify(data);
    $.ajax({
        type: 'POST',
        data: j_data,//json
        contentType: 'application/json',
        dataType: 'json',
        url: '/exex/saveCollect',
        success: function (reply) {

            alert("success")

        },
        error: function (response) {
            alert("Error")
        }
    });
}
$(document).ready(load.ready);
$(document).ready(dragFrame.ready);
