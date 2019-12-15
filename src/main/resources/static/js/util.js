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
