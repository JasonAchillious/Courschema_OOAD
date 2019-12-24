data = [];
WATCH = 'watch';
EDIT = 'edit';
function item(_name, _year, _dept, _major, _foreign, _type, _id,_check){
    this.name = _name;
    this.year = _year;
    this.dept = _dept;
    this.major = _major;
    this.foreign = _foreign;
    this.type = _type;
    this.check = _check;
    this.id = _id;
}
function editURL(id,type) {
    var url = '';
    if(type == WATCH)
        url = '<a href="/courschemaEdit?id='+id+'&edit=false">查看</a>';
    else if(type == EDIT)
        url = '<a href="/courschemaEdit?id='+id+'&edit=true">编辑</a>';

    return url;
}

function getData()
{

    $.ajax(
        {
            type: 'GET',
            // data: data,//json
            contentType: 'application/json',
            dataType: 'json',
            async: false,
            url: '/allschema',
            success: function (reply) {
                console.log(JSON.stringify(reply));
                //reply[i]:{"major":"计算机科学与技术","year":2020,"name":"测试测试","dept":"计算机科学与工程系","type":"1+3培养","foreign":"是"}
                for(i = 0;i < reply.length;i ++) {
                    var ele = reply[i];
                    var temp = new item(ele.name,ele.year,ele.dept,ele.major,ele.foreign,ele.type,ele.id);
                    temp.check = editURL(ele.id,WATCH);
                    data.push(temp);
                }
            },
            error: function (reply) {
                alert("error")
            }
        }
    );
}

var loadtable = {
    columns : [{
        field: 'name',
        title: '培养方案名称'
    }, {
        field: 'year',
        title: '适用学年'
    }, {
        field: 'dept',
        title: '院系'
    },{
        field: 'major',
        title: '专业'
    },{
        field: 'foreign',
        title: 'foreign student'
    },{
        field: 'type',
        title: '培养类型'
    },{
        field: 'check',
        title: '查看详情'
    }
    ],


load: function () {
        getData();
        loadtable.generateTable(data);

    },
generateTable: function (data) {
    $('#schematable').bootstrapTable({
        columns: loadtable.columns,
        data: data,
        classes: "table table-bordered table-striped table-sm table-dark",
        //******前端分页设置****
        pagination:true,
        pageNumber:1,
        pageSize:10,
        pageList:"[10, 20, 50, 200]",
        paginationHAlign:"left",
        paginationDetailHAlign:"right"
        //******前端分页设置****
    });

}

};

function editPress(){
    var text = $('.edit').text();
    if(text == '编辑') {
        alert("编辑");
        for (var i = 0; i < data.length; i++) {
            data[i].check = editURL(data[i].id, EDIT);
        }
        console.log(data);
        loadtable.generateTable(data);
        // $('#schematable').bootstrapTable('refresh');
        $('#schematable').bootstrapTable('getOptions');
        $('.edit').text("查看")
    }
    else{
        alert("查看")
        for (var i = 0; i < data.length; i++) {
            data[i].check = editURL(data[i].id, WATCH);
        }
        console.log(data);
        loadtable.generateTable(data);
        // $('#schematable').bootstrapTable('refresh');
        $('#schematable').bootstrapTable('getOptions');
        $('.edit').text("编辑")
    }

}

$(document).ready(loadtable.load);