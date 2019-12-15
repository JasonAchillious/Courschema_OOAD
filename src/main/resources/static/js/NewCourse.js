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


function newCourse() {
    var data = {};
    var value = $('#data').serializeArray();
    $.each(value, function (index, item) {
        data[item.name] = item.value;
    });
}