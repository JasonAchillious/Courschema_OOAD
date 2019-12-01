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
