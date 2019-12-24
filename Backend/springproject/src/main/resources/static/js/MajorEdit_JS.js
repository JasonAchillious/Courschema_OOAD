courseMap = new Map();// 保存 idCourse:course键值对
hasAdded = new Map();
schema_id = 0;
// idCourse:course

var schemaedit = {
    tongshi : [],//保存所有通识课
    ruxi: [],//同理
    bixiu: [],
    xuanxiu: [],
    political:[],
    id:0
};

function Schema(data) {

    this.schema_name = data.schema_name;//string
    this.major = data.major;//string
    this.department = data.department;//string
    this.major_elec = Number(data.major_elec);//int
    this.HU_elec = Number(data.HU_elec);//int
    this.SS_elec = Number(data.SS_elec);//int
    this.AR_elec = Number(data.AR_elec);//int
    this.year = Number(data.year);//int
    this.intro = data.intro;//string
    this.foreign = 0;//default 0 int
    this.one_plus3 = 0;//default 2+2 int


}

function store_course(type,course) {
    alert("store");
    switch (type) {
        case "ruxi":
            schemaedit.ruxi.push(course);
            break;
        case "tongshi":
            schemaedit.tongshi.push(course);
            break;
        case "bixiu":
            schemaedit.bixiu.push(course);
            break;
        case "xuanxiu":
            schemaedit.xuanxiu.push(course);
            break;
        case "political":
            schemaedit.political.push(course);
    }
}
function deleteCourse(type,course) {
    switch (type) {
        case "ruxi":
            schemaedit.ruxi.splice(schemaedit.ruxi.indexOf(course),1);
            break;
        case "tongshi":
            schemaedit.tongshi.splice(schemaedit.tongshi.indexOf(course),1);
            break;
        case "bixiu":
            schemaedit.bixiu.splice(schemaedit.bixiu.indexOf(course),1);
            break;
        case "xuanxiu":
            schemaedit.xuanxiu.splice(schemaedit.xuanxiu.indexOf(course),1);
            break;
        case "political":
            schemaedit.political.splice(schemaedit.political.indexOf(course),1);
    }
}
function edit(c_id,s_id) {
    return "/CourseEdit?courseid="+c_id+"&schemaid="+s_id;
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

    var del = "<a href='#' onclick='del("+course_id+",\""+ type + "\")'>删除</a>";
    var editlink = "<a href='"+edit(course_id,schema_id)+"'>编辑详情</a>";

    //make html

    var html = "<tr class=\""+course.idCourse+"\">\n" +
        "          <th scope=\"row\">"+code+"</th>\n" +
        "          <td>"+chinese_name+"|"+english_name+"</td>\n" +
        "          <td>"+credit+"</td>\n" +
        "          <td>"+season+"</td>\n" +
        "          <td>"+year+"</td>\n" +
        "          <td>"+department+"</td>\n" +
        "          <td>"+del+"</td>"+
        "          <td>"+editlink+"</td>"+
        "       </tr>";

    return html;

}
function del(id,type) {
    $('.'+id).remove();

    var course = courseMap.get(id);
    deleteCourse(type.toString(),course);

}



function makeForm(data) {
    // this.schema_name = data.schema_name;//string
    // this.major = data.major;//string
    // this.department = data.department;//string
    // this.major_elec = Number(data.major_elec);//int
    // this.HU_elec = Number(data.HU_elec);//int
    // this.SS_elec = Number(data.SS_elec);//int
    // this.AR_elec = Number(data.AR_elec);//int
    // this.year = Number(data.year);//int
    // this.intro = data.intro;//string
    // this.foreign = 0;//default 0 int
    // this.one_plus3 = 0;//default 2+2 int
    var form = {};
    form.schema_name = data.schema_name;
    form.major = data.major;
    form.department = data.department;
    form.major_elec = data.major_elec;
    form.HU_elec = data.HU_elec;
    form.SS_elec = data.SS_elec;
    form.AR_elec = data.AR_elec;

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
function upload() {
    // 按钮按下，上传更新后的培养方案
    var data = {};
    var value = $('#data').serializeArray();
    $.each(value, function (index, item) {
        data[item.name] = item.value;
    });
    var c_schema = new Schema(data);


    console.log(JSON.stringify(schemaedit));
    console.log(JSON.stringify(c_schema));

    transmitList();
    // transmitInfo();
}
function transmitList() {
    $.ajax(
        {
            type: 'POST',
            data: JSON.stringify(schemaedit),
            contentType: 'application/json',
            dataType: 'json',
            url: '/cla/editClassification',
            success:function (reply) {
                alert("保存成功");
            },
            error: function () {
                alert("error");
            }
        }
    )
}
function transmitInfo() {
    //todo transmitInfo
    $.ajax(
        {
            type: 'POST',
            data: data,//json
            contentType: 'application/json',
            dataType: 'json',
            // async: false,
            url: '/allcourse',
        }
    )
}
function initCourse() {
    schema_id = getUrlParam('id');

    schemaedit.id = Number(schema_id);
    //发id 接收所有的course 和 info
    var id_data = {id:schemaedit.id};

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

function loadInfo() {
    $.ajax(
        {
            type: 'POST',
            data: JSON.stringify(schemaedit.id),
            contentType: 'application/json',
            dataType: 'json',
            url: '/oneCourschemas',
            success:function (reply) {
                //reply 是 schemaedit 对象
                console.log(JSON.stringify(reply));

            },
            error: function () {
                alert("load info error");
            }
        }
    )

}

function initShow(list,type) {
    //type 代表插入到哪个表
    for(i = 0;i < list.length;i ++)
    {
        var course = list[i];
        $('#'+type).find("tbody").append(makeHTML(course,type));
    }
}
//-------------------------------------------------------

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
var loadcourse = {

    departmentMap: new Map(),

    load: function()
    {

        $.ajax({
            type: 'POST',
            // data: data,//json
            contentType: 'application/json',
            dataType: 'json',
            async: false,
            url: '/allcourse',
            success: function (reply) {

                console.log(JSON.stringify(reply));

                for(var i = 0;i < reply.length;i++)
                {
                    courseMap.set(reply[i].idCourse,reply[i]);

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



$(document).ready(initCourse);
$(document).ready(loadcourse.load);
$(document).ready(dragFrame.ready);
