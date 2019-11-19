
var dragFrame = {
    ready:function() {
        $(".draggable").draggable({
            revert: "valid",
            helper: "clone",
            appendTo: "body"
        });

        $(".droppable").droppable({
            hoverClass: "card border-primary mb-3",
            drop: function( event, ui ) {
                $( this )
                    .removeClass()
                    .addClass( "card border-info mb-3 droppable" )
                    .find("p").html("set!")
                return false;
            }
        })

    }
};

$(document).ready(dragFrame.ready)