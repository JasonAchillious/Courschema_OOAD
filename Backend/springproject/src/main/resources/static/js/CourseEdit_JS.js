//todo get from URL, this just a test
course_id = 0;
schema_id = 0;

function course(data) {
    this.chinese_name = data.chinese_name;
    this.english_name = data.english_name;
    this.code = data.code;
    this.credit = data.credit;
    this.department = data.department;
    this.year = data.year;
    this.spring = data.spring=="是"?1:0;
    this.summer = data.summer=="是"?1:0;
    this.autumn = data.autumn=="是"?1:0;

}

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

                    //检查重复
                    if(hasAdded.has(course))
                        alert("此课程已被加入");
                    else {
                        //找到课程加入的是哪个表
                        var type = $(this).prop('id');
                        store_course(type,course);
                        $(this).find("tbody").append(makeHTML(course,type));
                        hasAdded.set(course,type);
                    }
                    return false;
                }
            });
    }
};

function relation(r_data,c_id,s_id) {
    this.course_id = c_id;
    this.schema_id = s_id;
    this.pre_course = r_data.pre_course;
    this.replace_course = r_data.replace_course;
}

function upload() {
    var data = util.serializeObject("#data");
    var r_data = util.serializeObject("#relationData");

    s_course = new course(data);
    r_relation = new relation(r_data);
    r_relation.course_id = course_id;
    r_relation.schema_id = schema_id;

    //test transmitInfo
    console.log(JSON.stringify(s_course));
    console.log(JSON.stringify(r_relation))
    //transmit
    transmitInfo(s_course);
    transmitRelation(r_relation);
}

function transmitInfo(s_course) {
    json = JSON.stringify(s_course);
    $.ajax({
        type: 'POST',
        data: json,//json
        contentType: 'application/json',
        dataType: 'json',
        //async: false,
        url: '/saveCourse',
        success: function (reply) {
            alert("success");
            location.reload();
        },
        error: function (response) {
            alert("Error")
        }
    });
}

function transmitRelation(relation) {
    $.ajax({
        type: 'POST',
        data: json,//json
        contentType: 'application/json',
        dataType: 'json',
        //async: false,
        url: '/saveCourse',
        success: function (reply) {
            alert("success");
            location.reload();
        },
        error: function (response) {
            alert("Error")
        }
    });
}

function initInfo()
{
    //todo init information
    //test
    data = {};
    data.chinese_name = "test";
    data.english_name = "daoisjd";
    data.code = "EE212";
    data.credit = "3";
    data.department = "asdoas";
    data.year = "大三";
    data.spring="是";
    data.summer="是";
    data.autumn="是";

    util.fillFormData("#data",data);

    //todo init relationship
}

$(document).ready(initInfo);