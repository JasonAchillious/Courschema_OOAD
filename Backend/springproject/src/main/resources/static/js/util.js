/**
 *  此模块实现一些常用方法
 **/

//拼接显示可拖动课程信息
function joint(coursename)
{
    var head = "<a href=\"#\" class=\"list-group-item list-group-item-action draggable\">"
    var tail = "</a>";
    return head + coursename + tail;
}
// 提取url 传递的单值参数
function getUrlParam(name){
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r!=null) return unescape(r[2]); return null;
}
// 表单填充，获取工具
var util = {
    serializeObject: function(form) {
        var formEL = $(form);
        var o = {};
        var a = formEL.serializeArray();
        $.each(a, function() {
            if(o[this.name]) {
                if(!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    },

    fillFormData: function(form, obj, isStatus) {
        var formEL = $(form);
        $.each(obj, function(index, item) {
            formEL.find("[name=" + index + "]").val(item);
        });
    },
    empty: function(data) {
        if(null == data || "" == data) return true;
        else return false;
    },
    redirect: function (re_url,param) {

        var id = Number(getUrlParam(param));
        var url = re_url+'?param='+id;
        alert(url);
        window.location.replace("http://www.baidu.com");
        alert(window.location);
    }
};
