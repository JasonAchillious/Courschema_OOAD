
courseMap = new Map();

var dragFrame = {

    ready: function () {

        $(".draggable").draggable({
            revert: "valid",
            helper: "clone",
            appendTo: "body",
            drag: function (event,ui) {

            }
        });

        $(".droppable")
            .droppable({

                drop: function (event, ui) {
                    var id = Number(ui.draggable.prop('id'));
                    var course = courseMap.get(id);
                    console.log(JSON.stringify(course));

                    $(this).find("tbody").append(dragFrame.course_html(course));
                    return false;
                }
            });
    },

    course_html: function (course) {
        var chinese_name = course.chineseName;
        var credit = course.credit;
        var code = course.code;
        var year = course.year;
        var department = course.department;
        var english_name = course.englishName;
        var season = dragFrame.set_season(course);

        //make html

        var html = "<tr>\n" +
            "          <th scope=\"row\">"+code+"</th>\n" +
            "          <td>"+chinese_name+"|"+english_name+"</td>\n" +
            "          <td>"+credit+"</td>\n" +
            "          <td>"+season+"</td>\n" +
            "          <td>"+year+"</td>\n" +
            "          <td>"+department+"</td>\n" +
            "       </tr>";

        return html;

    },

    set_season: function (course) {
        var season_str = '';
        if(course.spring == 1)
        {
            season_str += "春季学期 "
        }
        else if(course.autume == 1)
        {
            season_str += "秋季学期 "
        }
        else if(course.summer == 1)
        {
            season_str += "夏季学期 "
        }

        return season_str;
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
                    courseMap.set(reply[i].idCourse,reply[i]);

                    loadcourse.appendDepartment(reply[i]);
                    loadcourse.appendCourse(reply[i]);
                }
                alert("Map size:"+courseMap.size);
                alert("reply size: "+reply.length);
            },
            error: function (response) {
                alert("Error")
            }
        });
    },

    appendCourse: function (course) {
        var name = course.chineseName;
        var courseid = course.idCourse;
        var departmentID = loadcourse.departmentMap.get(course.department);
        var major_html = "<a href=\"#\" class=\"list-group-item list-group-item-action draggable\" id = \""+courseid+"\">"+name+"</a>"

        $('div#'+departmentID).append(major_html);
    },


    appendDepartment: function (course) {

        var department = course.department;

        if(!loadcourse.departmentMap.has(department))
        {
            loadcourse.departmentMap.set(department,loadcourse.departmentMap.size);

            departmentID = loadcourse.departmentMap.get(department);

            var div = "<div class=\"list-group col-md-12\" id = \""+departmentID+"\"></div>";

            var dep_html = "<a href=\"#\" class=\"list-group-item list-group-item-action active\">" +department + "</a>";

            $('#Course_List').append(div);
            $('div#'+departmentID).append(dep_html);
            //append
            console.log("append department:"+department);
        }


    }
};


$(document).ready(loadcourse.load);
$(document).ready(dragFrame.ready);