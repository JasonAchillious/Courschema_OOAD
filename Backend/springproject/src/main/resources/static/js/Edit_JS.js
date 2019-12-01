
var dragFrame = {

    cssarray: ["card text-white bg-dark mb-3 droppable"
                ,"card text-white bg-info mb-3 droppable"
                ,"card text-white bg-warning mb-3 droppable"
                ,"card text-white bg-danger mb-3 droppable"
                ,"card text-white bg-success mb-3 droppable"
                ,"card text-white bg-secondary mb-3 droppable"
                ,"card text-white bg-primary mb-3 droppable"
                ],
    //todo store edited card list


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
        //todo double click cleaning
            // .dblclick(
            //     function () {
            //
            //         alert(this.cssarray[Math.round(Math.random()*this.cssarray.length-1)]);
            //
            //         $(this)
            //             .removeClass()
            //             .addClass(this.cssarray[Math.round(Math.random()*this.cssarray.length-1)])
            //             .find("h4").text("培养方案名称");
            //
            //         $(this).find("div.card-header").text("Not Set");
            //     }
            // );
        alert("你可以拖动培养方案至收藏格中以定制Home界面，双击撤销")
    }
};

$(document).ready(dragFrame.ready);
