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

function relation(r_data,c_id,s_id) {
    this.course_id = c_id;
    this.schema_id = s_id;
    this.pre_course = r_data.pre_course;
    this.replace_course = r_data.replace_course;
}

function upload() {
    var data = {};
    var value = $('#data').serializeArray();
    $.each(value, function (index, item) {
        data[item.name] = item.value;
    });
    var r_data = {};
    var value = $('#relationData').serializeArray();
    $.each(value, function (index, item) {
        r_data[item.name] = item.value;
    });


    s_course = new course(data);
    r_relation = new relation(r_data);

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