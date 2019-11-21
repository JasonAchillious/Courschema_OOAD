
var dragFrame = {
    ready:function() {
        $(".droppable").find("div.card-header").text("Not Set");

        $(".draggable").draggable({
            revert: "valid",
            helper: "clone",
            appendTo: "body"
        });

        $(".droppable")
            .droppable({

            drop: function( event, ui ) {
                var name = ui.draggable.text();
                $( this )
                    .removeClass()
                    .addClass( "card border-info mb-3 droppable" )
                    .find("h4").text(name);
                $(this).find("div.card-header").text("SET");
                // alert(text);

                return false;
            }
        });

    }
    major_list: []
};

$(document).ready(dragFrame.ready);