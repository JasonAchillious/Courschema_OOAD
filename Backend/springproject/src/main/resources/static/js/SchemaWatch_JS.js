schema_id = 0;
function initCourse() {
    schema_id = Number(getUrlParam('id'));

    //发id 接收所有的course 和 info
    var id_data = {id:schema_id};

    $.ajax(
        {
            type: 'POST',
            data: JSON.stringify(id_data),
            contentType: 'application/json',
            dataType: 'json',
            url: '/cla/showClassification',
            success:function (reply) {
                //reply 是 schemaedit 对象
                console.log(JSON.stringify(reply));

                schemaedit = reply;
                initShow(reply.tongshi,"tongshi");
                initShow(reply.ruxi,"ruxi");
                initShow(reply.bixiu,"bixiu");
                initShow(reply.xuanxiu,"xuanxiu");
                initShow(reply.political,"political");
            },
            error: function () {
                alert("error");
            }
        }
    );
    loadInfo();
}

function watch(c_id,s_id) {
    return "/CourseWatch?courseid="+c_id+"&schemaid="+s_id;
}

function setSeason(course) {
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

function makeHTML(course,type) {
    //type 表的id

    var chinese_name = course.chineseName;
    var credit = course.credit;
    var code = course.BianHao;
    var year = course.year;
    var department = course.department;
    var english_name = course.englishName;
    var season = setSeason(course);
    var course_id = course.idCourse;

    var detail = "<a href='"+watch(course_id,schema_id)+"'>查看详情</a>";

    //make html

    var html = "<tr class=\""+course.idCourse+"\">\n" +
        "          <th scope=\"row\">"+code+"</th>\n" +
        "          <td>"+chinese_name+"|"+english_name+"</td>\n" +
        "          <td>"+credit+"</td>\n" +
        "          <td>"+season+"</td>\n" +
        "          <td>"+year+"</td>\n" +
        "          <td>"+department+"</td>\n" +
        "          <td>"+detail+"</td>"+
        "       </tr>";

    return html;

}

function back() {
    var uid = getUrlParam('uid');
    location.href="/AllSchema?param="+uid;
}

function initShow(list,type) {
    //type 代表插入到哪个表
    for(i = 0;i < list.length;i ++)
    {
        var course = list[i];
        $('#'+type).find("tbody").append(makeHTML(course,type));
    }
}
function loadInfo() {
    var info_data = {};
    $.ajax(
        {
            type: 'POST',
            data: JSON.stringify(schema_id),
            contentType: 'application/json',
            dataType: 'json',
            url: '/oneCourschemas',
            success:function (reply) {
                //reply 是 schemaedit 对象
                console.log(JSON.stringify(reply));
                info_data.schema_name = reply.chineseName;
                info_data.year = reply.year;
                info_data.department = reply.department;
                info_data.major = reply.major;
                info_data.HU_elec = reply.HU_elec;
                info_data.SS_elec = reply.SS_elec;
                info_data.AR_elec = reply.AR_elec;
                info_data.major_elec = reply.major_elec;
                info_data.foreign = reply.foreign==1?"是":"否";
                info_data.one_plus3 = reply.one_plus3==1?"1+3培养":"2+2培养";
                info_data.intro = reply.intro;
                util.fillFormData("#data",info_data)
            },
            error: function () {
                alert("load info error");
            }
        }
    )



}

var frame = {
    load : function () {
        initCourse();
    },

}
function download() {
    $.ajax(
        {
            type: 'POST',
            data: JSON.stringify(schema_id),
            contentType: 'application/json',
            dataType: 'json',
            url: '/downloadCourschemas',
            success:function (reply) {
                //reply 是 schemaedit 对象
                alert('success')
            },
            error: function () {
                alert("error");
            }
        }
    );

}

$(document).ready(frame.load);