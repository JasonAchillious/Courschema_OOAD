function setforeign(type) {
    if(type == "是")
        return 1;
    else
        return 0;
}
function setOnePlus3(type) {
    if(type == "1+3培养")
        return 1;
    else
        return 0;
}

function schema(data) {

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

function newschema() {
    var data = {};
    var value = $('#data').serializeArray();
    $.each(value, function (index, item) {
        data[item.name] = item.value;
    });
    var c_schema = new schema(data);
    c_schema.foreign = setforeign(data.foreign);
    c_schema.one_plus3 = setOnePlus3(data.one_plus3);

    var json = JSON.stringify(c_schema);
    console.log('c_schema : ',json);
    console.log('data: ',JSON.stringify(data));

    $.ajax({
        type: 'POST',
        data: json,//json
        contentType: 'application/json',
        dataType: 'json',
        //async: false,
        url: '/saveCou',
        success: function (reply) {
            alert("success");
            location.reload();
        },
        error: function (response) {
            alert("Error")
        }
    });

}
