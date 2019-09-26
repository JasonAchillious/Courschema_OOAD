var delaytime = 5;
var WIDTH_START = 300;
var HEIGHT_START = Math.round(WIDTH_START*1.5);
var WIDTH_END = 400,HEIGHT_END = Math.round(WIDTH_END*1.5);

var width = WIDTH_START;
var height = HEIGHT_START;

while(true)
{
    setTimeout(updateSize(width,height,1),delaytime);
}

function updateSize(width,height,state) {
    if(state == 1)
    {
        width += 1;
        height = Math.round(width * 1.5);
        if(width == WIDTH_END)
            state = 0;
    }
    else
    {
        width -= 1;
        height = Math.round(width*1.5);
        if(width == WIDTH_START)
            state = 1;
    }
}