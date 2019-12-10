function schema(data) {

    this.sechema_name = data.schema_name;//string
    this.major = data.major;//string
    this.department = data.department;//string
    this.major_elec = data.major_elec;//int
    this.HU_elec = Number(data.HU_elec);//int
    this.SS_elec = Number(data.SS_elec);//int
    this.AR_elec = Number(data.AR_elec);//int
    this.year = Number(data.year);//int
    this.intro = data.intro;//string
    this.foreign = setforeign(data.foreign);//default 0 int
    this.one_plus3 = setOnePlus3(data.one_plus3);//default 2+2 int

    function setforeign(type) {
        if(type == "是")
            this.foreign=1;
        else
            this.foreign=0;
    }
    function setOnePlus3(type) {
        if(type == "1+3培养")
            this.one_plus3 = 1;
        else
            this.one_plus3 = 0;
    }
}

function newschema() {
    let data = {};
    let value = $('#data').serializeArray();
    $.each(value, function (index, item) {
        data[item.name] = item.value;
    });
    var c_schema = new schema(data);

    let json = JSON.stringify(c_schema);
    console.log('c_schema : ',json);
    console.log('data: ',JSON.stringify(data))

    $.ajax({
        type: 'POST',
        data: c_schema,//json
        contentType: 'application/json',
        dataType: 'json',
        async: false,
        url: '/saveCourschemas',
        success: function (reply) {
            alert("success")

        },
        error: function (response) {
            alert("Error")
        }
    });
}