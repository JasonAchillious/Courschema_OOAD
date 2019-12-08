var dragFrame = {

    ready: function () {

        $(".draggable").draggable({
            revert: "valid",
            helper: "clone",
            appendTo: "body"
        });

        $(".droppable")
            .droppable({

                drop: function (event, ui) {
                    //todo drop function

                    $(this).append();
                    return false;
                }
            });
    }
};
var loadcourse = {

    departmentMap: new Map(),

    load: function()
    {

        $.ajax({
            type: 'GET',
            // data: data,//json
            contentType: 'application/json',
            dataType: 'json',
            async: false,
            url: '/course/recordCourse',
            success: function (reply) {

                console.log(JSON.stringify(reply));

                for(var i = 0;i < reply.length;i++)
                {
                    console.log(reply[i].chineseName);
                    loadcourse.appendDepartment(reply[i]);
                    loadcourse.appendCourse(reply[i]);

                }

            },
            error: function (response) {
                alert("Error")
            }
        });
    },

    appendCourse: function (course) {
        var name = course.chineseName;
        var courseid = course.idCourse;
        var departmentID = load.departmentMap.get(course.);
        var major_html = "<a href=\"#\" class=\"list-group-item list-group-item-action draggable\" id = \""+courseid+"\">"+name+"</a>"

        $('div#'+departmentID).append(major_html);
    },


    appendDepartment: function (course) {

        var department = course.department;

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


$(document).ready(loadcourse.load);
$(document).ready(dragFrame.ready);